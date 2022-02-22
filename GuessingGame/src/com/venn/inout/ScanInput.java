package com.venn.inout;

import java.util.Scanner;

public class ScanInput {

	@SuppressWarnings("resource")
	public static String getScanIn() {
		Scanner sc = new Scanner(System.in);
	    String input = sc.nextLine();
//	    sc.close();
	    return input;
	}
	
	public static Integer getScanIntegerIn() throws Exception {
		String tmp= getScanIn();
		Integer playerGuess = Integer.valueOf(tmp);
		return playerGuess;
	}
	
}
