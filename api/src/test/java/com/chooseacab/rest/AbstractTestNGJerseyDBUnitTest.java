package com.chooseacab.rest;

import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.CompositeOperation;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.operation.TransactionOperation;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.ws.rs.core.Application;
import java.io.IOException;

public abstract class AbstractTestNGJerseyDBUnitTest extends JerseyTestNg.ContainerPerClassTest{

  private ApplicationContext context;
  private IDatabaseTester dbTester;

  @BeforeClass
  public void setUp() throws Exception {
    super.setUp();
  }

  @AfterClass
  public void tearDown() throws Exception {
    super.tearDown();
  }

  @BeforeMethod
  public void beforeMethod() throws Exception {
    dbTester.setSetUpOperation(new TransactionOperation(
        new CompositeOperation(DatabaseOperation.DELETE_ALL, DatabaseOperation.INSERT)));
    dbTester.setDataSet(getDataSet());

    dbTester.onSetup();
  }

  @AfterMethod
  public void afterMethod() throws Exception {
    dbTester.onTearDown();
  }

  /**
   * Returns dbUnit DataSet file name.
   *
   * @return DataSet file name to load.
   */
  public abstract String getDataSetFileName();

  /**
   * Resource classes to be registered with Jersey.
   *
   * @return An array of Resource Classes.
   */
  protected abstract Class[] resourcesToRegister();

  /**
   * Spring context files to be loaded into the Jersey application.
   *
   * @return Spring application context file name.
   */
  protected String loadSpringContextFile(){
      return "integration-test-application-context.xml";
  }

  @Override
  public Application configure() {
    context = getApplicationContext();

    this.dbTester = new DataSourceDatabaseTester((DataSource)context.getBean("dataSource"), "Public") {
      @Override
      public IDatabaseConnection getConnection() throws Exception {
        IDatabaseConnection connection = super.getConnection();
        connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());
        return connection;
      }
    };

    try {
      this.beforeMethod();
    } catch (Exception e) {
      throw new RuntimeException("Could not load the HSQL database data!", e);
    }

    //The property placeholders are not inheritable from parent context to child context. But here needed few properties while autowiring beans from
    //api-context.xml file. The new integration-test-api-context.xml file is to load properties into spring context.

    final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

    return new ResourceConfig()
              .registerClasses(resourcesToRegister())
              .register(new AbstractBinder() {
                @Override
                protected void configure() {
                  bind(request).to(HttpServletRequest.class);
                }
              })
              .property("contextConfig", new ClassPathXmlApplicationContext(new String[]{"integration-test-api-context.xml"}, context));
  }

  protected ApplicationContext getApplicationContext(){
    return new ClassPathXmlApplicationContext(loadSpringContextFile());
  }

  private IDataSet getDataSet() throws IOException, DataSetException {
    final FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
    builder.setColumnSensing(true);
    final IDataSet dataSet =
        builder.build(Thread.currentThread().getContextClassLoader().getResourceAsStream(this.getDataSetFileName()));


    final ReplacementDataSet replacementDataSet = new ReplacementDataSet(dataSet);
    replacementDataSet.addReplacementObject("[NULL]", null);

    return replacementDataSet;
  }

  public ITable performQuery(final String table, final String query) throws Exception {
     return this.dbTester.getConnection().createQueryTable(table, query);
  }

}
