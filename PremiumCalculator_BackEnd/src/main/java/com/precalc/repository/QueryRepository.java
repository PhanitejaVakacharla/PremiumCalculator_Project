package com.precalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.precalc.model.QueryModel;

@Repository
public interface QueryRepository extends JpaRepository<QueryModel, Integer> {

	QueryModel findByQueryId(int queryId);

}
