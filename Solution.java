import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Solution {

	/*
	 * Complete the 'segment' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER x
	 *  2. INTEGER_ARRAY space
	 */

	public static int segment(int x, List<Integer> space) {
		int min=0;
		if(space.size()==1){
			return space.get(0);
		}
		for(int i=0;i<space.size()-x;i++){
			List<Integer> temp = space.subList(i,i+x);
			Collections.sort(temp);
			if(temp.get(0)>min){
				min = temp.get(0);
			}
		}

		return min;

	}

}