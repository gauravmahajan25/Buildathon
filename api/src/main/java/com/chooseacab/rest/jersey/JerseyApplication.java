package com.chooseacab.rest.jersey;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyApplication extends ResourceConfig {
  public JerseyApplication(){
    super(JacksonFeature.class);
    this.register(ChooseACabObjectMapperProvider.class);
  }
}