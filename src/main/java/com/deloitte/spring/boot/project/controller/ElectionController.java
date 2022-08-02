package com.deloitte.spring.boot.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.spring.boot.project.model.Election;
import com.deloitte.spring.boot.project.service.ElectionService;

@RestController
@RequestMapping("/elec")
public class ElectionController {

	@Autowired
	private ElectionService elecService;

	@RequestMapping(path = "/get-all-elecs", method = RequestMethod.GET)
	public ResponseEntity<List<Election>> getAllElecs() {
		System.out.println("get-all-elections");
		List<Election> elecList = elecService.getAllElections();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of all Elections displayed successfully!");
		ResponseEntity<List<Election>> response = new ResponseEntity<>(elecList, headers, status);
		return response;
	}

	@RequestMapping(path = "/add-elec", method = RequestMethod.POST)
	public ResponseEntity<Election> addEmp(@RequestBody Election election) {
		HttpStatus status = HttpStatus.CREATED;
		Election elec = elecService.addElection(election);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Election with election id" + election.getElectionId() + " is added successfully!");
		ResponseEntity<Election> response = new ResponseEntity<>(elec, headers, status);
		return response;
	}

	@RequestMapping(path = "/update-elec", method = RequestMethod.PUT)
	public ResponseEntity<Election> updateElec(@RequestBody Election election) {

		Election elec = elecService.updateElection(election);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Election with electionId " + election.getElectionId() + " is updated successfully!");
		ResponseEntity<Election> response = new ResponseEntity<>(elec, headers, status);
		return response;
	}

	@RequestMapping(path = "/delete-elec/{eid}", method = RequestMethod.DELETE)
	public ResponseEntity<Election> deleteEmp(@PathVariable(name = "eid") long electionId) {
		Election elec = elecService.deleteElection(electionId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Election with electionId " + electionId + " is deleted successfully!");
		ResponseEntity<Election> response = new ResponseEntity<>(elec, headers, status);
		return response;
	}

	@RequestMapping(path = "/get-elec-by-id/{eid}", method = RequestMethod.GET)
	public ResponseEntity<Election> getEmpById(@PathVariable(name = "eid") long electionId) {
		System.out.println(electionId);
		Election elec = elecService.getElectionById(electionId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Election with electionId " + electionId + " is found successfully!");
		ResponseEntity<Election> response = new ResponseEntity<>(elec, headers, status);
		return response;
	}
}
