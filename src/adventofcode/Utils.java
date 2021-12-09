package adventofcode;

import java.util.List;

public class Utils {

	
	public static String calculateMostCommonValue(List<String> input, int position) {

		int oneCounter = 0; 
		int zeroCounter = 0;


		for(String bit : input) {

			if(bit.charAt(position) == '1')
				oneCounter ++;
			else
				zeroCounter++;

		}
		
		if(oneCounter == zeroCounter)
			return "1";
		
		return oneCounter > zeroCounter ? "1" : "0";
	}

	public static String calculateLeastCommonValue(List<String> input, int position) {

		int oneCounter = 0; 
		int zeroCounter = 0;


		for(String bit : input) {

			if(bit.charAt(position) == '1')
				oneCounter ++;
			else
				zeroCounter++;

		}
		
		if(oneCounter == zeroCounter)
			return "0";
		
		return oneCounter < zeroCounter ? "1" : "0";
	}
	
	public static int getBoardUnsignedNumbersSum(int[][] winnerBoard) {
		int counter = 0;

		for (int i = 0; i < winnerBoard.length; i++) {
			for (int j = 0; j < winnerBoard[0].length; j++) {
				if(winnerBoard[i][j] != -1)
					counter = counter + winnerBoard[i][j];
			}
		}
		return counter;
	}

	public static boolean boardIsWinner(int[][] board) {
		//righe
		for(int i = 0; i < board.length; i++) {
			if(allElementsAreSigned(board[i])) {
				return true;
			}
		}
		//colonne
		for(int j = 0; j < board[0].length; j++) {
			if(allElementsAreSigned(board, j)) {
				return true;
			}
		}

		return false;
	}

	private static boolean allElementsAreSigned(int[][] board, int j) {

		for(int i = 0; i < board.length; i++)
			if(board[i][j] != -1)
				return false;

		return true;

	}

	private static boolean allElementsAreSigned(int[] row) {
		int counter = 0;
		for(int i = 0; i < row.length; i++)
			if(row[i] == -1)
				counter++;

		return (counter == row.length);
	}
}
