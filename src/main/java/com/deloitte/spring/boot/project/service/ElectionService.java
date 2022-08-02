package com.deloitte.spring.boot.project.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deloitte.spring.boot.project.exception.ElectionNotFoundException;
import com.deloitte.spring.boot.project.model.Election;
import com.deloitte.spring.boot.project.repository.ElectionRepository;

@Service
public class ElectionService {
	@Autowired
	private ElectionRepository elecRepository;
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	public List<Election> getAllElections() {
		return elecRepository.findAll();
	}

	public Election getElectionById(long electionId) {
		LOG.info(Long.toString(electionId));
		Optional<Election> elecOptional = elecRepository.findById(electionId);
		if (elecOptional.isPresent())
			return elecOptional.get();
		else {
			String errorMessage = "Election with eid " + electionId + " not found";
			LOG.warn(errorMessage);
			throw new ElectionNotFoundException(errorMessage);
		}
	}

	public Election addElection(Election election) {
		LOG.info(election.toString());
		return elecRepository.save(election);
	}

	public Election updateElection(Election election) {
		LOG.info(election.toString());
		Election elec = this.getElectionById(election.getElectionId());
		elec = elecRepository.save(election);
		return elec;
	}

	public Election deleteElection(long electionId) {
		LOG.info(Long.toString(electionId));
		Election elec = this.getElectionById(electionId);
		if (elec != null) {
			elecRepository.deleteById(electionId);
		}
		return elec;
	}

}
