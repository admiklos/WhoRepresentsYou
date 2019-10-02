package com.tts.civics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	
	public enum ChamberEnum {
		HOUSE,
		SENATE
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String photo;
	private ChamberEnum whichChamber;
	private String state;
	private Boolean isNewMember;
	private Boolean isLeavingOffice;
	private Integer numYearsInOffice;
	private String statements;
	private String billsIntroduced;
	private Double travelExpenses;
	private Double officeExpenses;
	
	public Member() {}
	

	public Member(String name, String photo, ChamberEnum whichChamber, String state, Boolean isNewMember,
			Boolean isLeavingOffice, Integer numYearsInOffice, String statements, String billsIntroduced,
			Double travelExpenses, Double officeExpenses) {
		this.name = name;
		this.photo = photo;
		this.whichChamber = whichChamber;
		this.state = state;
		this.isNewMember = isNewMember;
		this.isLeavingOffice = isLeavingOffice;
		this.numYearsInOffice = numYearsInOffice;
		this.statements = statements.length() > 255 ? statements.substring(0,254) : statements;
		this.billsIntroduced = billsIntroduced.length() > 255 ? billsIntroduced.substring(0,254) : billsIntroduced;
		this.travelExpenses = travelExpenses;
		this.officeExpenses = officeExpenses;
	}


	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getNumYearsInOffice() {
		return numYearsInOffice;
	}

	public void setNumYearsInOffice(Integer numYearsInOffice) {
		this.numYearsInOffice = numYearsInOffice;
	}

	public String getStatements() {
		return statements;
	}

	public void setStatements(String statements) {
		// TODO: an entry can only accept 255 characters - fix when
		//       this becomes a one to many relationship
		this.statements = statements.length() > 255 ? statements.substring(0, 255) : statements;
	}

	public ChamberEnum getWhichChamber() {
		return whichChamber;
	}

	public void setWhichChamber(ChamberEnum whichChamber) {
		this.whichChamber = whichChamber;
	}

	public String getBillsIntroduced() {
		return billsIntroduced;
	}

	public void setBillsIntroduced(String billsIntroduced) {
		this.billsIntroduced = billsIntroduced;
		// TODO: an entry can only accept 255 characters - fix when
		//       this becomes a one to many relationship
	}

	public Double getTravelExpenses() {
		return travelExpenses;
	}

	public void setTravelExpenses(Double travelExpenses) {
		this.travelExpenses = travelExpenses;
	}

	public Double getOfficeExpenses() {
		return officeExpenses;
	}

	public void setOfficeExpenses(Double officeExpenses) {
		this.officeExpenses = officeExpenses;
	}

	public Boolean getIsLeavingOffice() {
		return isLeavingOffice;
	}

	public void setIsLeavingOffice(Boolean isLeavingOffice) {
		this.isLeavingOffice = isLeavingOffice;
	}

	public Boolean getIsNewMember() {
		return isNewMember;
	}

	public void setIsNewMember(Boolean isNewMember) {
		this.isNewMember = isNewMember;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", photo=" + photo + ", whichChamber=" + whichChamber
				+ ", state=" + state + ", isNewMember=" + isNewMember + ", isLeavingOffice=" + isLeavingOffice
				+ ", numYearsInOffice=" + numYearsInOffice + ", statements=" + statements + ", billsIntroduced="
				+ billsIntroduced + ", travelExpenses=" + travelExpenses + ", officeExpenses=" + officeExpenses + "]";
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	


}
