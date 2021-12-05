package adventofcode;

import java.util.ArrayList;
import java.util.List;
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





}
