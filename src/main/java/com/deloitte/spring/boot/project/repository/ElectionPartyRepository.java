package com.deloitte.spring.boot.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.spring.boot.project.model.ElectionParty;

@Repository
public interface ElectionPartyRepository extends JpaRepository<ElectionParty, Long> {
	

}
