package com.venn.po;

public class Player {
	
	private String playerName;
	
	private String playerId;
	
	
	public Player(String playerName, String playerId) {
		this.playerName = playerName;
		this.playerId = playerId;
	}


	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	
	@Override
	public int hashCode() {
		return this.playerId.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

}
