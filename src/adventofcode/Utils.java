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
	
	public static int getMax(List<Integer> coordinates) {
		Integer found = 0;

		for(Integer i : coordinates)
			if(i > found)
				found = i;

		return found;
	}
	
	public static boolean isMainDiagonal(Integer x1, Integer x2, Integer y1, Integer y2) {

		return (x1 > x2 && y1 > y2) || (x1 < x2 && y1 < y2);
	}

	public static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i ++) {
			for(int j = 0; j < matrix[i].length; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}

	}
}
