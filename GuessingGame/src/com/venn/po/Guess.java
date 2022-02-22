package com.venn.po;

public class Guess {
	
	private Player player;
	
	private Integer playerGuess;
	
	private Round round;
	
	private Boolean isBingo =false;
	
	public Guess(Player player, Integer playerGuess, Round round) {
		this.player = player;
		this.playerGuess = playerGuess;
		this.round = round;
		if(round != null && playerGuess !=null && playerGuess == round.getTarget()) {
			this.isBingo = true;
		}
	}


	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getPlayerGuess() {
		return playerGuess;
	}

	public void setPlayerGuess(Integer playerGuess) {
		this.playerGuess = playerGuess;
	}

	public Boolean getIsBingo() {
		return isBingo;
	}

	public void setIsBingo(Boolean isBingo) {
		this.isBingo = isBingo;
	}


	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}
	
}
