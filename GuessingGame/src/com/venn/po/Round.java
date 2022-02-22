package com.venn.po;

public class Round {
	
	private Integer roundId;
	
	private String roundName;
	
	private Integer target;
	
	public Round(String roundName, Integer target, Integer roundId) {
		this.roundName = roundName;
		this.target = target;
		this.roundId = roundId;
	}

	

	public Integer getRoundId() {
		return roundId;
	}

	public void setRoundId(Integer roundId) {
		this.roundId = roundId;
	}

	public String getRoundName() {
		return roundName;
	}

	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}

	public Integer getTarget() {
		return target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	@Override
	public int hashCode() {
		return this.roundId.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() ==obj.hashCode();
	}

}