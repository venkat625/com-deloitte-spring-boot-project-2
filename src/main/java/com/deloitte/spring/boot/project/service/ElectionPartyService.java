package com.deloitte.spring.boot.project.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.project.exception.ElectionPartyNotFoundException;
import com.deloitte.spring.boot.project.model.ElectionParty;
import com.deloitte.spring.boot.project.repository.ElectionPartyRepository;

@Service
public class ElectionPartyService {
	@Autowired
	private ElectionPartyRepository partyRepository;
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	public List<ElectionParty> getAllParties() {
		return partyRepository.findAll();
	}
    
	public ElectionParty getPartyById(long partyId) {
		LOG.info(Long.toString(partyId));
		Optional<ElectionParty> partyOptional = partyRepository.findById(partyId);
		if (partyOptional.isPresent())
			return partyOptional.get();
		else {
			String errorMessage = "Election with eid " + partyId + " not found";
			LOG.warn(errorMessage);
			throw new ElectionPartyNotFoundException(errorMessage);
		}
	}
	public ElectionParty addElectionParty(ElectionParty electionParty) {
		LOG.info(electionParty.toString());
		return partyRepository.save(electionParty);
	}
	public ElectionParty updateElectionParty(ElectionParty electionParty) {
		LOG.info(electionParty.toString());
		ElectionParty eparty = this.getPartyById(electionParty.getPartyId());
		eparty = partyRepository.save(electionParty);
		return eparty;
	}
	
	public ElectionParty deleteElectionParty(long partyId) {
		LOG.info(Long.toString(partyId));
		ElectionParty eparty = this.getPartyById(partyId);
		if (eparty != null) {
			partyRepository.deleteById(partyId);
		}
		return eparty;
	}
	

}
