package adventofcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Excercises {

	public static int exercise1a(List<Integer> numbers) {
		int counter = 0;

		for(int i = 1; i < numbers.size(); i++)
			if(numbers.get(i) > numbers.get(i-1)) //{
				counter++;
		//				System.out.println(numbers.get(i) + " INCREASED");
		//			} else if(numbers.get(i) < numbers.get(i-1)) {
		//				System.out.println(numbers.get(i) + " DECREASED");
		//			} else {
		//				System.out.println(numbers.get(i) + " EQUALS");
		//			}

		return counter;
	}

	public static int exercise1b(List<Integer> numbers) {

		List<Integer> sums = new ArrayList<>();

		for(int i = 0; i < numbers.size(); i++) {

			if(i == numbers.size() - 2)
				break;

			int y = numbers.get(i);
			int j = numbers.get(i + 1);
			int z = numbers.get(i + 2);

			int sum = y + j + z;
			//System.out.println(y + " + " + j + " + " + z + " = " + sum);

			sums.add(sum);
		}

		return exercise1a(sums);

	}

	public static int exercise2a(List<String> positions) {

		int depth = 0;
		int horizontalPosition = 0;

		for(String position : positions) {

			if(position.contains("up")) {
				depth = depth - Integer.valueOf(position.substring(position.length() -1));
			} else if(position.contains("down")) {
				depth = depth + Integer.valueOf(position.substring(position.length() -1));
			} else {
				horizontalPosition = horizontalPosition + Integer.valueOf(position.substring(position.length() -1));
			}
		}

		return horizontalPosition * depth;

	}

	public static int exercise2b(List<String> positions) {

		int depth = 0;
		int horizontalPosition = 0;
		int aim = 0;

		for(String position : positions) {

			Integer x = Integer.valueOf(position.substring(position.length() -1));

			if(position.contains("up")) {
				aim = aim - x;
			} else if(position.contains("down")) {
				aim = aim + x;
			} else {
				horizontalPosition = horizontalPosition + x;
				depth = depth + (aim * x);
			}
		}

		return horizontalPosition * depth;

	}

	public static int exercise3a(List<String> input) {

		int numberOfColumns = input.get(0).length();
		String gammaRate = "";
		String epsilonRate = "";

		for(int i = 0; i < numberOfColumns; i++) {

			gammaRate += Utils.calculateMostCommonValue(input, i);
			epsilonRate += Utils.calculateLeastCommonValue(input, i);

		}

		return Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2);
	}

	public static int exercise3b(List<String> input) {

		int oxygenRating = 0;
		int co2Rating = 0;
		int position = 0;
		List<String> oxygenRatingCandidates = input;
		List<String> co2RatingCandidates = input;

		while(oxygenRatingCandidates.size() > 1) {

			String mostCommonValue = Utils.calculateMostCommonValue(oxygenRatingCandidates, position);

			final int x = position;
			oxygenRatingCandidates = oxygenRatingCandidates.stream().filter(s -> String.valueOf(s.charAt(x)).equals(mostCommonValue)).collect(Collectors.toList());

			position++;
		}

		position = 0;

		while(co2RatingCandidates.size() > 1) {

			String leastCommonValue = Utils.calculateLeastCommonValue(co2RatingCandidates, position);

			final int x = position;
			co2RatingCandidates = co2RatingCandidates.stream().filter(s -> String.valueOf(s.charAt(x)).equals(leastCommonValue)).collect(Collectors.toList());

			position++;
		}

		oxygenRating = Integer.parseInt(oxygenRatingCandidates.get(0), 2);
		co2Rating = Integer.parseInt(co2RatingCandidates.get(0), 2);

		return oxygenRating * co2Rating;
	}


	public static int exercise4a(String numbers, Map<String, List<String>> inputBoards, int boardsNumber, int rowsNumber, int colsNumber) {

		int [][][] boards  = new int[boardsNumber][rowsNumber][colsNumber];

		for(int board = 0; board < boardsNumber; board++) 
			for(int row = 0; row < rowsNumber; row++)
				for(int col = 0; col < colsNumber; col++) 					boards[board][row][col] = Integer.valueOf(inputBoards.get(String.valueOf(board)).get(row).replaceAll("( +)"," ").trim().split(" ")[col]);
		for(String number : numbers.split(",")) {

			int extracted = Integer.parseInt(number);

			for(int board = 0; board < boardsNumber; board++) {
				for(int row = 0; row < rowsNumber; row++) {
					for(int col = 0; col < colsNumber; col++) {

						if(boards[board][row][col] == extracted) 
							boards[board][row][col] = - 1;
					}
				}

				if(Utils.boardIsWinner(boards[board]))
					return Utils.getBoardUnsignedNumbersSum(boards[board]) * extracted;
			}
		}
		return 0;
	}

	public static int exercise4b(String numbers, Map<String, List<String>> inputBoards, int boardsNumber, int rowsNumber, int colsNumber) {

		List<int[][]> boardsList = new ArrayList<>();

		int [][][] boards = new int[boardsNumber][rowsNumber][colsNumber];

		for(int board = 0; board < boardsNumber; board++) 
			for(int row = 0; row < rowsNumber; row++)
				for(int col = 0; col < colsNumber; col++) 
					boards[board][row][col] = Integer.valueOf(inputBoards.get(String.valueOf(board)).get(row).replaceAll("( +)"," ").trim().split(" ")[col]);

		for(int board = 0; board < boardsNumber; board++) 
			Collections.addAll(boardsList, boards[board]);

		List<int[][]> controlList = new ArrayList<>(boardsList);

		for(String number : numbers.split(",")) {

			int extracted = Integer.parseInt(number);

			for(int i = 0; i < boardsList.size(); i++) {
				for(int row = 0; row < rowsNumber; row++) {
					for(int col = 0; col < colsNumber; col++) {

						if(boardsList.get(i)[row][col] == extracted) 
							boardsList.get(i)[row][col] = - 1;
					}

					int[][] lastBoard = boardsList.get(i);

					if(Utils.boardIsWinner(lastBoard)) {
						controlList.remove(lastBoard);

						if(controlList.isEmpty())
							return Utils.getBoardUnsignedNumbersSum(lastBoard) * extracted;
					}
				}
			}
		}

		return 0;
	}

	public static int exercise5a(List<List<Integer>> coordinatesList) {

		List<Integer> ascisse = new ArrayList<>();
		List<Integer> ordinate = new ArrayList<>();

		for(List<Integer> coordinates : coordinatesList) {

			Integer x1 = coordinates.get(0);
			Integer y1 = coordinates.get(1);
			Integer x2 = coordinates.get(2);
			Integer y2 = coordinates.get(3);

			ascisse.add(x1);
			ascisse.add(x2);
			ordinate.add(y1);
			ordinate.add(y2);
		}


		int maxX = getMax(ascisse) + 1;
		int maxY = getMax(ordinate) + 1;

		int[][] matrix = new int[maxY][maxX];
		
		
		for(List<Integer> coordinates : coordinatesList) {

			Integer x1 = coordinates.get(0);
			Integer y1 = coordinates.get(1);
			Integer x2 = coordinates.get(2);
			Integer y2 = coordinates.get(3);
		
			if(x1.equals(x2)) {
				
				int from = y1 < y2 ? y1 : y2;
				int to = y1 > y2 ? y1 : y2;
			
				for(int y = from; y <= to; y++)
					matrix[y][x1] ++;

			}
			
			if(y1.equals(y2)) {
				
				int from = x1 < x2 ? x1 : x2;
				int to = x1 > x2 ? x1 : x2;
			
				for(int x = from; x <= to; x++)
					matrix[y1][x] ++;

			}
			
		}
		
		int counter = 0;
		
		for(int i = 0; i < matrix.length; i ++)
			for(int j = 0; j < matrix[i].length; j++)
				if(matrix[i][j] > 1)
					counter++;

//		for(int i = 0; i < matrix.length; i ++) {
//			
//			for(int j = 0; j < matrix[i].length; j++) {
//			
//				System.out.print(matrix[i][j] + " ");
//			
//			}
//			System.out.println();
//			
//		}
//		
		return counter;
	}


	private static int getMax(List<Integer> coordinates) {
		Integer found = 0;

		for(Integer i : coordinates)
			if(i > found)
				found = i;

		return found;
	}

}
