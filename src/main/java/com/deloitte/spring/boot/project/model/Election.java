package com.deloitte.spring.boot.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "election_table")
public class Election {

	@Id
	@GenericGenerator(name = "elec_seq", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elec.seq")
	@Column(name = "election_id")
	private long electionId;
	@Column(name = "election_name")
	private String electionName;
	@Column(name = "election_type")
	private String electionType;
	@Column(name = "election_date")
	private String electionDate;

	public Election() {
		super();
	}

	public Election(long electonId, String electionName, String electionType, String electionDate) {
		super();
		this.electionId = electonId;
		this.electionName = electionName;
		this.electionType = electionType;
		this.electionDate = electionDate;
	}

	public Election(String electionName, String electionType, String electionDate) {
		super();
		this.electionName = electionName;
		this.electionType = electionType;
		this.electionDate = electionDate;
	}

	public long getElectionId() {
		return electionId;
	}

	public void setElectionId(long electonId) {
		this.electionId = electonId;
	}

	public String getElectionName() {
		return electionName;
	}

	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}

	public String getElectionType() {
		return electionType;
	}

	public void setElectionType(String electionType) {
		this.electionType = electionType;
	}

	public String getElectionDate() {
		return electionDate;
	}

	public void setElectionDate(String electionDate) {
		this.electionDate = electionDate;
	}

	@Override
	public String toString() {
		return "Election [electionId=" + electionId + ", electionName=" + electionName + ", electionType=" + electionType
				+ ", electionDate=" + electionDate + "]";
	}

}
