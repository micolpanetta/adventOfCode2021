package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main( String[] args ) throws IOException{

		String path = "inputs/input4.txt";
		BufferedReader reader;

		List<String> numbers = new ArrayList<>();
		Map<String, List<String>> boards = new HashMap<>();
		

		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
			numbers.add(line);
			
			System.out.println(numbers);
			
			reader.readLine();
			line = reader.readLine();
			
			int i = 0;
			
			while (line != null) {
				List<String> rows = new ArrayList<>();
				
				while(!"-".equals(line)) {
					rows.add(line);
					line = reader.readLine();
				}
				boards.put(String.valueOf(i), rows);
				
				System.out.println(i + " " + boards.get(String.valueOf(i)).toString());
				i++;
				
				line = reader.readLine();
				
			}
			
			reader.close();

			System.out.print(Excercises.exercise4a(numbers, boards));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
