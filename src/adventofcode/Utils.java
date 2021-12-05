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
}
