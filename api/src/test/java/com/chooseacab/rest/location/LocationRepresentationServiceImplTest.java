package com.chooseacab.rest.location;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import com.chooseacab.model.Location;
import com.chooseacab.service.LocationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.when;

/**
 * A test class for Location Representation.
 */
public class LocationRepresentationServiceImplTest {

	@Mock
	private LocationService locationService;

	private LocationRepresentationService locationRepresentationService;

	@BeforeClass
	public void beforeTest() {
		MockitoAnnotations.initMocks(this);
		locationRepresentationService = new LocationRepresentationServiceImpl();
		ReflectionTestUtils.setField(locationRepresentationService, "locationService", locationService);
	}

	/**
	 * A test to test the Location retrieval.
	 */
	@Test
	public void getTypesTest() {

		final Location location = new Location();
		location.setName("Hyderabad");
		location.setZipCode("500001");

		final List<Location> locations = new ArrayList<>();
		locations.add(location);

		final Collection<LocationRepresentation> actual = LocationRepresentation.toRepresentations(locations);

		when(locationService.getAllLocations()).thenReturn(locations);
		final Collection<LocationRepresentation> expected = locationRepresentationService.getAllLocations();
		Assert.assertEquals(actual.size(), expected.size());

	}

}