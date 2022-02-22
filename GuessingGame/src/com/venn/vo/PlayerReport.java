package com.venn.vo;

import java.util.List;

import com.venn.po.Guess;
import com.venn.po.Player;

public class PlayerReport {
	
	private Player player;
	
	private List<Guess> guesses;
	
	public PlayerReport(Player player, List<Guess> guesses) {
		this.player = player;
		this.guesses = guesses;
	}
	
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Guess> getGuesses() {
		return guesses;
	}

	public void setGuesses(List<Guess> guesses) {
		this.guesses = guesses;
	}

	@Override
	public int hashCode() {
		return this.getPlayer().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Player name:" + this.getPlayer().getPlayerName());
		sb.append("\n");
		if(this.getGuesses().isEmpty()) {
			sb.append("No Guess\n");
		}else {
			for(Guess guess : this.getGuesses()) {
				sb.append(guess.getRound().getRoundName()+" Guess Value:" + guess.getPlayerGuess() 
				+ " Correct Value: "+ guess.getRound().getTarget()+"\n");
			}
		}
		return sb.toString();
	}
		
}
