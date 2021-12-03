package adventofcode;

import java.util.ArrayList;
import java.util.List;

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


}
