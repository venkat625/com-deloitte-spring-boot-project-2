package com.deloitte.spring.boot.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.spring.boot.project.model.ElectionParty;
import com.deloitte.spring.boot.project.service.ElectionPartyService;
@RestController
@RequestMapping("/elec")
public class ElectionPartyController {
	@Autowired
	private ElectionPartyService partyService;
	
	@RequestMapping(path = "/get-all-parties", method = RequestMethod.GET)
	public ResponseEntity<List<ElectionParty>> getAllParty() {
		System.out.println("get-all-parties");
		List<ElectionParty> epartyList = partyService.getAllParties();
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of all Parties displayed successfully!");
		ResponseEntity<List<ElectionParty>> response = new ResponseEntity<>(epartyList, headers, status);
		return response;
	}

	@RequestMapping(path = "/add-party", method = RequestMethod.POST)
	public ResponseEntity<ElectionParty> addEmp(@RequestBody ElectionParty electionParty) {
		HttpStatus status = HttpStatus.CREATED;
		ElectionParty eparty = partyService.addElectionParty(electionParty);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Party with party id" + electionParty.getPartyId() + " is added successfully!");
		ResponseEntity<ElectionParty> response = new ResponseEntity<>(eparty, headers, status);
		return response;
	}

	@RequestMapping(path = "/update-party", method = RequestMethod.PUT)
	public ResponseEntity<ElectionParty> updateElec(@RequestBody ElectionParty electionParty) {

		ElectionParty eparty = partyService.updateElectionParty(electionParty);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Party with partyId " + electionParty.getPartyId() + " is updated successfully!");
		ResponseEntity<ElectionParty> response = new ResponseEntity<>(eparty, headers, status);
		return response;
	}

	@RequestMapping(path = "/delete-party/{pid}", method = RequestMethod.DELETE)
	public ResponseEntity<ElectionParty> deleteElectionParty(@PathVariable(name = "pid") long partyId) {
		ElectionParty eparty = partyService.deleteElectionParty(partyId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Election with electionId " + partyId + " is deleted successfully!");
		ResponseEntity<ElectionParty> response = new ResponseEntity<>(eparty, headers, status);
		return response;
	}

	@RequestMapping(path = "/get-party-by-id/{pid}", method = RequestMethod.GET)
	public ResponseEntity<ElectionParty> getPartById(@PathVariable(name = "pid") long partyId) {
		System.out.println(partyId);
		ElectionParty eparty = partyService.getPartyById(partyId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Party with partyId " + partyId + " is found successfully!");
		ResponseEntity<ElectionParty> response = new ResponseEntity<>(eparty, headers, status);
		return response;
	}
 
}
