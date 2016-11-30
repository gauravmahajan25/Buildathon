package com.chooseacab.repository;

import com.chooseacab.model.Location;

import java.util.List;

/**
 * A repository for Locations entity.
 */
public interface LocationJpaRepository extends JpaRepository<Location> {

  /**
   * Get All available locations.
   * @return list of locations
   */
  List<Location> getAllLocations();
}
