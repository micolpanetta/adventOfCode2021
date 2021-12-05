package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main( String[] args ) throws IOException{

		String path = "inputs/input3.txt";
		BufferedReader reader;

		List<String> input = new ArrayList<>();

		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			while (line != null) {
				input.add(line);
				line = reader.readLine();
			}
			reader.close();

			System.out.print(Excercises.exercise3b(input));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
