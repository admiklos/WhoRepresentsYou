package com.tts.civics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CongressPerson {
	
	public enum ChamberEnum {
		HOUSE,
		SENATE
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String memberId;
	private String theName;
	private String dob;
	private String theState;
	private String aPhoto;
	private ChamberEnum whichChamber;
	private String whichParty;
	private String url;
	private Boolean isNewMember;
	private Boolean isLeavingOffice;
	private Integer numYearsInOffice;
	private Integer numBillsSponsored;
	private Double votesWithPartyPercent;
	private Double missedVotesPercent;
	private Double travelExpenses;
	private Double officeExpenses;
	private String twitter;
	private String facebook;
	private String youtube;
	
	public CongressPerson() {}

	public CongressPerson(String memberId, String theName, String dob, String theState, String aPhoto,
			ChamberEnum whichChamber, String whichParty, String url, Boolean isNewMember, Boolean isLeavingOffice,
			Integer numYearsInOffice, Integer numBillsSponsored, Double votesWithPartyPercent,
			Double missedVotesPercent, Double travelExpenses, Double officeExpenses, String twitter, String facebook,
			String youtube) {
		this.memberId = memberId;
		this.theName = theName;
		this.dob = dob;
		this.theState = theState;
		this.aPhoto = aPhoto;
		this.whichChamber = whichChamber;
		this.whichParty = whichParty;
		this.url = url;
		this.isNewMember = isNewMember;
		this.isLeavingOffice = isLeavingOffice;
		this.numYearsInOffice = numYearsInOffice;
		this.numBillsSponsored = numBillsSponsored;
		this.votesWithPartyPercent = votesWithPartyPercent;
		this.missedVotesPercent = missedVotesPercent;
		this.travelExpenses = travelExpenses;
		this.officeExpenses = officeExpenses;
		this.twitter = twitter;
		this.facebook = facebook;
		this.youtube = youtube;
	}

	public Long getId() {
		return id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getTheName() {
		return theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getTheState() {
		return theState;
	}

	public void setTheState(String theState) {
		this.theState = theState;
	}

	public String getaPhoto() {
		return aPhoto;
	}

	public void setaPhoto(String aPhoto) {
		this.aPhoto = aPhoto;
	}

	public ChamberEnum getWhichChamber() {
		return whichChamber;
	}

	public void setWhichChamber(ChamberEnum whichChamber) {
		this.whichChamber = whichChamber;
	}

	public String getWhichParty() {
		return whichParty;
	}

	public void setWhichParty(String whichParty) {
		this.whichParty = whichParty;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getIsNewMember() {
		return isNewMember;
	}

	public void setIsNewMember(Boolean isNewMember) {
		this.isNewMember = isNewMember;
	}

	public Boolean getIsLeavingOffice() {
		return isLeavingOffice;
	}

	public void setIsLeavingOffice(Boolean isLeavingOffice) {
		this.isLeavingOffice = isLeavingOffice;
	}

	public Integer getNumYearsInOffice() {
		return numYearsInOffice;
	}

	public void setNumYearsInOffice(Integer numYearsInOffice) {
		this.numYearsInOffice = numYearsInOffice;
	}

	public Integer getNumBillsSponsored() {
		return numBillsSponsored;
	}

	public void setNumBillsSponsored(Integer numBillsSponsored) {
		this.numBillsSponsored = numBillsSponsored;
	}

	public Double getVotesWithPartyPercent() {
		return votesWithPartyPercent;
	}

	public void setVotesWithPartyPercent(Double votesWithPartyPercent) {
		this.votesWithPartyPercent = votesWithPartyPercent;
	}

	public Double getMissedVotesPercent() {
		return missedVotesPercent;
	}

	public void setMissedVotesPercent(Double missedVotesPercent) {
		this.missedVotesPercent = missedVotesPercent;
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

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	@Override
	public String toString() {
		return "CongressPerson [id=" + id + ", memberId=" + memberId + ", theName=" + theName + ", dob=" + dob
				+ ", theState=" + theState + ", aPhoto=" + aPhoto + ", whichChamber=" + whichChamber + ", whichParty="
				+ whichParty + ", url=" + url + ", isNewMember=" + isNewMember + ", isLeavingOffice=" + isLeavingOffice
				+ ", numYearsInOffice=" + numYearsInOffice + ", numBillsSponsored=" + numBillsSponsored
				+ ", votesWithPartyPercent=" + votesWithPartyPercent + ", missedVotesPercent=" + missedVotesPercent
				+ ", travelExpenses=" + travelExpenses + ", officeExpenses=" + officeExpenses + ", twitter=" + twitter
				+ ", facebook=" + facebook + ", youtube=" + youtube + "]";
	}
	

}
