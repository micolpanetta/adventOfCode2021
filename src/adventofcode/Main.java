package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main( String[] args ) throws IOException{

		String path = "inputs/input1.txt";
		BufferedReader reader;

		List<Integer> numbers = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			while (line != null) {
				numbers.add(Integer.parseInt(line));
				line = reader.readLine();
			}
			reader.close();

			System.out.print(exercise1b(numbers));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static int exercise1a(List<Integer> numbers) {
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

	private static int exercise1b(List<Integer> numbers) {

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


}
