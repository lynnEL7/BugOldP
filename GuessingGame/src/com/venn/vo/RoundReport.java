package com.venn.vo;

import java.util.List;

import com.venn.po.Guess;
import com.venn.po.Round;

public class RoundReport {
	
	private Round round;
	
	private List<Guess> guesses;
	
	public RoundReport(Round round, List<Guess> guesses){
		this.round = round;
		this.guesses = guesses;
	}
	
	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	
	public List<Guess> getGuesses() {
		return guesses;
	}

	public void setGuesses(List<Guess> guesses) {
		this.guesses = guesses;
	}

	@Override
	public int hashCode() {
		return this.getRound().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Guess Number for " + this.getRound().getRoundName()+":"+ this.getRound().getTarget());
		sb.append("\n");
		if(this.getGuesses().isEmpty()) {
			sb.append("No winner\n");
		}else {
			sb.append("Winner/s:\n");
			for(Guess guess : this.getGuesses()) {
				sb.append("Player: "+ guess.getPlayer().getPlayerName()+"\n");
			}
		}
		return sb.toString();
	}
}
