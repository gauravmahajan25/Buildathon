package com.chooseacab.repository;

import com.chooseacab.model.Type;

import java.util.List;

/**
 * A repository for Type entity.
 */
public interface TypeJpaRepository extends JpaRepository<Type> {

  /**
   * Get All available Types
   * @return list of locations
   */
  List<Type> getTypes();
}
