package com.virtusa.precalc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.precalc.dto.QueryModelDto;
import com.virtusa.precalc.exception.QueryNotFoundException;

import com.virtusa.precalc.model.QueryModel;
import com.virtusa.precalc.service.QueryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/query")
public class QueryController {

	private static final String MESSAGE = "Query Not found with policy Id as: ";

	@Autowired
	private QueryService queryService;

	@PostMapping("/addQuery")
	public QueryModel createQuery(@RequestBody QueryModelDto querydto) {
		QueryModel q = new QueryModel();
		q.setCustomerName(querydto.getCname());
		q.setEmail(querydto.getEmail());
		q.setPhone(querydto.getPhone());
		q.setQueryDescription(querydto.getDescription());

		return queryService.saveQuery(q);
	}

	@GetMapping("/getQueries")
	public List<QueryModel> getQueries() {
		return queryService.findAllQueries();
	}

	@GetMapping("/viewQuery/{queryId}")
	public ResponseEntity<QueryModel> getQueryById(@PathVariable int queryId) {
		QueryModel qm = queryService.findQueryById(queryId);
		if (qm != null)
			return ResponseEntity.ok(qm);
		else
			throw new QueryNotFoundException(MESSAGE + queryId);
	}

	@PutMapping("/updateQuery/{queryId}")
	public ResponseEntity<QueryModel> updateQuery(@PathVariable int queryId,
			@RequestBody QueryModelDto queryDetailsDto) {
		QueryModel qm = queryService.findQueryById(queryId);
		if (qm != null) {
			qm.setQueryDescription(queryDetailsDto.getDescription());
			QueryModel updateQuery = queryService.saveUpdatedQuery(qm);
			return ResponseEntity.ok(updateQuery);
		} else
			throw new QueryNotFoundException(MESSAGE + queryId);
	}

	@DeleteMapping("/deleteQuery/{queryId}")
	public String deletePolicy(@PathVariable int queryId) {

		QueryModel qm = queryService.findQueryById(queryId);
		if (qm != null) {
			queryService.deletePolicy(qm);
			return "Query has been deleted";
		} else
			throw new QueryNotFoundException(MESSAGE + queryId);
	}
	

}
