package com.deloitte.spring.boot.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "election_party_table")
public class ElectionParty {

	@Id
	@GenericGenerator(name = "party_seq", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party.seq")
	@Column(name = "party_id")
	private long partyId;
	@Column(name = "party_name")
	private String partyName; 
	@Column(name = "party_leader")
	private String partyLeader;
	@Column(name = "party_symbol")
	private String partySymbol;
	
	public ElectionParty()
	{
		super();
	}

	
	public ElectionParty(long partyId, String partyName, String partyLeader, String partySymbol) {
		super();
		this.partyId = partyId;
		this.partyName = partyName;
		this.partyLeader = partyLeader;
		this.partySymbol = partySymbol;
	}
	


	public ElectionParty(String partyName, String partyLeader, String partySymbol) {
		super();
		this.partyName = partyName;
		this.partyLeader = partyLeader;
		this.partySymbol = partySymbol;
	}


	public long getPartyId() {
		return partyId;
	}

	public void setPartyId(long partyId) {
		this.partyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPartyLeader() {
		return partyLeader;
	}

	public void setPartyLeader(String partyLeader) {
		this.partyLeader = partyLeader;
	}

	public String getPartySymbol() {
		return partySymbol;
	}

	public void setPartySymbol(String partySymbol) {
		this.partySymbol = partySymbol;
	}

	@Override
	public String toString() {
		return "ElectionParty [partyId=" + partyId + ", partyName=" + partyName + ", partyLeader=" + partyLeader
				+ ", partySymbol=" + partySymbol + "]";
	}	
	
	

}
