package adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main( String[] args ) throws IOException{

		String path = "inputs/input6.txt";
		BufferedReader reader;

		List<Integer> timerList = new ArrayList<>();
		try {
			reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
		
			while (line != null) {
				
				String[] row = line.split(",");
				
				for(String c : row)
					timerList.add(Integer.parseInt(c));
					
				line = reader.readLine();
						
			}
			
			reader.close();

			System.out.println(Excercises.exercise6a(timerList));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
