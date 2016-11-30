package com.chooseacab.repository;

import com.chooseacab.model.Operator;

import java.util.List;

/**
 * A repository for Operator entity.
 */
public interface OperatorJpaRepository extends JpaRepository<Operator> {

  /**
   * Get All available Operator.
   * @return list of operators
   */
  List<Operator> getOperators();
}
