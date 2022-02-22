package com.venn.starter;

import java.util.ArrayList;
import java.util.List;
import com.venn.inout.ScanInput;
import com.venn.inout.ScreenOutput;
import com.venn.po.Guess;
import com.venn.po.Player;
import com.venn.po.Round;
import com.venn.util.MsgConstants;
import com.venn.vo.PlayerReport;
import com.venn.vo.RoundReport;

public class GameStarter {
	
	public static List<Round> rounds = new ArrayList<Round>();
	public static List<Player> players = new ArrayList<Player>();
	public static List<Guess> guesses = new ArrayList<Guess>();
	
	public static List<RoundReport> roundReports = new ArrayList<RoundReport>();
	public static List<PlayerReport> playerReports = new ArrayList<PlayerReport>();
	
	public static final Integer ROUND_CNT = 5;
	public static final Integer PLAYER_CNT = 5;
	
	public static final Integer MIN_GUESS = 0;
	public static final Integer MAX_GUESS = 10;

	
	public static void main(String[] args) {
		
		ScreenOutput.actionPrintln(MsgConstants.GAME_START);
		//Set Player List
		initPlayers();
		
		ScreenOutput.actionPrintln("*************************************");
		//SetRounds
		initRounds();
		
		ScreenOutput.actionPrintln("*************************************");
		//GetAllGuesses
		initGuesses();
		
		ScreenOutput.actionPrintln("*************************************");
		//show the result
		ScreenOutput.actionPrintln(roundReports.toString());	
		
		ScreenOutput.actionPrintln("*************************************");
		ScreenOutput.actionPrintln(playerReports.toString());	
		
		
	}

	public static void initPlayers() {
		for(int j = 1; j<=5; j++) {
			ScreenOutput.actionPrint(MsgConstants.PLAYER_HINT + MsgConstants.COLON);
			String playerName = ScanInput.getScanIn();
			Player player = new Player(playerName, playerName+j);
			players.add(player);
		}	
	}
	
	public static void initRounds() {
		for(int j = 1; j<=ROUND_CNT; j++) {
			int target= (int)(Math.random()*(MAX_GUESS-MIN_GUESS)+1);
			Round round = new Round(MsgConstants.ROUND+j, target, j+1 );
			rounds.add(round);
		}	
	}
	
	public static Guess getPlayerGuessesPerRound(Player player, Round round) {
		Integer playerGuess = null;
		for(int j = 1; j<=2; j++) {
			if(null == playerGuess) {
				try {
					ScreenOutput.actionPrint(MsgConstants.GUESS_HINT +player.getPlayerName()+MsgConstants.COLON);
					playerGuess = ScanInput.getScanIntegerIn();
				}catch(Exception e) {
					playerGuess = null;
					ScreenOutput.actionPrintln(MsgConstants.INVALID_INPUT_HINT);
				}
			}
		}	
		return new Guess(player, playerGuess, round);
		
	}	
	
	public static void initGuesses() {
		for(Round round : rounds) {
			ScreenOutput.actionPrintln(round.getRoundName());
			for(Player player :players) {
				Guess guess = getPlayerGuessesPerRound(player, round);
				guesses.add(guess);
				collectData(guess);
			}
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static void collectData(Guess guess) {
		if(roundReports.contains(guess.getRound())) {
			if(guess.getIsBingo()) {
				int idx = roundReports.indexOf(guess.getRound());
				roundReports.get(idx).getGuesses().add(guess);
			}
		}else {
			List<Guess> guesses = new ArrayList<Guess>();
			RoundReport roundReport = new RoundReport(guess.getRound(), guesses);
			if(guess.getIsBingo()) {
				roundReport.getGuesses().add(guess);
			}
			roundReports.add(roundReport);
		}
		
		if(playerReports.contains(guess.getPlayer())) {
			int idx = playerReports.indexOf(guess.getPlayer());
			playerReports.get(idx).getGuesses().add(guess);
		}else {
			List<Guess> guesses = new ArrayList<Guess>();
			guesses.add(guess);
			PlayerReport playerReport = new PlayerReport(guess.getPlayer(), guesses);
			playerReports.add(playerReport);
		}
	}
}
