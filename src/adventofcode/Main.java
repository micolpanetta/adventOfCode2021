package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main( String[] args ) throws IOException{

		String path = "inputs/input5.txt";
		BufferedReader reader;

		List<List<Integer>> coordinatesList = new ArrayList<>();
		List<Integer> coordinates = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
		
			while (line != null) {
				
				String[] row = line.split(",");
				
				for(String c : row)
					coordinates.add(Integer.parseInt(c));
					
				coordinatesList.add(coordinates);
				
				coordinates = new ArrayList<>();
				line = reader.readLine();
						
			}
			
			reader.close();

			System.out.println(Excercises.exercise5a(coordinatesList));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
