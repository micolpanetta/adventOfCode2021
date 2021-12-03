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

			System.out.print(Excercises.exercise1b(numbers));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
