package com.precalc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.precalc.model.QueryModel;
import com.precalc.repository.QueryRepository;

@Service
public class QueryService {
	
	@Autowired
	private QueryRepository queryRepository;

	public QueryModel saveQuery(QueryModel query) {
		return queryRepository.save(query);
	}

	public List<QueryModel> findAllQueries() {
		return queryRepository.findAll();
	}

	public QueryModel findQueryById(int queryId) {
		return queryRepository.findByQueryId(queryId);
	}

	public QueryModel saveUpdatedQuery(QueryModel qm) {
		return queryRepository.save(qm);
	}

	public void deletePolicy(QueryModel qm) {
		queryRepository.delete(qm);
	}

}
