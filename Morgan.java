package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Morgan {

	public static void main(String[] args) {

		//maximumStreak();
		//System.out.println(SearchingChallenge());

		//System.out.println(threePalindromicSubstrings("fydnlgyuskhcafpgitdhvyiheeyltjeargkqstbuxiwwqdqizdchcdziqdqwwixubtsqkgraejtlyeehiyvhdtigpfachksuyglndyfddddddddnejivojiopqwbbwqpoijovijen").toString());

		List<Integer> used = new ArrayList<>();
		used.add(1);
		used.add(2);
		used.add(3);

		List<Integer> total = new ArrayList<>();
		total.add(3);
		total.add(3);
		total.add(3);
		minPartitions(used,total);
		/*List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(1);
		l1.add(2);
		l1.add(3);

		List<Integer> l2 = new ArrayList<>();
		l2.add(2);
		l2.add(3);
		l2.add(3);
		l2.add(4);

		maxPresentations(l1, l2);*/

		Integer[] ary = //{0,0,0,1,0,0};
				{0, 0, 1, 0, 0, 1, 0};
		List<Integer> intAry = Arrays.asList(ary);

		//sockMerchant(intAry);

		//countingValleys(8, "UDDDUDUU");
		//jumpingOnClouds(intAry);

//		repeatedString("ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt",685118368975l);

	}

	public static void minPartitions(List<Integer> used, List<Integer> totalCapacity) {
		Collections.sort(totalCapacity);
		int sum = 0;
		int result =0;
		for(int i=0;i<used.size();i++){
			sum+=used.get(i);
		}
		for(int i=used.size()-1;i>=0;i--){
			sum=sum-totalCapacity.get(i);
			result++;
			if(result==0){
				break;
			}
		}
	System.out.println(result);

	}

	public static List<String> threePalindromicSubstrings(String word) {
		List<String> list = new ArrayList<>();
		list.clear();
		for(int i=0;i<word.length();i++){
			StringBuilder temp=new StringBuilder(String.valueOf(word.charAt(i)));
			for(int j=i+1;j<word.length();j++){
				temp.append(word.charAt(j));
				if(isPalindrome(temp.toString()) && !temp.toString().equals(word)){
					int len =list.size()-1;
					if(len>0 && list.get(len).contains(temp)){
						String temp1=list.get(len);
						list.remove(len);
						list.add(len,temp1+temp);
					}else {
						list.add(temp.toString());
					}
					i=j;
					break;
				}
			}
		}

		if(list.isEmpty()){
			list.add("Impossible");
		}

		return list;

	}

	static boolean isPalindrome(String word){
		for(int i=0;i<word.length()/2;i++){
			if(word.charAt(i)!=word.charAt(word.length()-i-1)){
				return false;
			}
		}
		return true;
	}


	public static int ArrayChallenge(int[] arr) {

		Arrays.sort(arr);
		int toSubs=arr.length-1;
		return arr[arr.length-1]-arr[0]-toSubs;

	}

	public static String SearchingChallenge() {
		// code goes here
		String input ="2aabbacbaa";
		String str = input.substring(1,input.length());;
		int i = Integer.parseInt(String.valueOf(input.charAt(0)));
		int temp =0;
		int[] count = new int[256];

		for(int m=0;m<str.length();m++){
			if(count[str.charAt(m)]-'a'==0){
				temp++;
			}
			count[str.charAt(i)-'a']++;
		}

		int initial =0;
		int finish =0;

		int large =1;
		int large_initial=0;

		for(int a=0;a<count.length;a++){
			count[a]=0;
		}

		count[str.charAt(0)-'a']++;

		for(int n=1;n<str.length();n++){
			count[str.charAt(n)-'a']++;
			finish++;

			while (!isUnique(count,i)){
				count[str.charAt(initial)-'a']--;
				initial++;
			}
			if(finish-initial+1>large){
				large=finish-initial+1;
				large_initial =initial;
			}
		}
		return str.substring(large_initial,large_initial+large);
	}

	static boolean isUnique(int count[], int first){
		int temp=0;
		for(int i=0;i<26;i++){
			if(count[i]>0){
				temp++;
			}
		}

		return first>=temp;
	}

	public static void maximumStreak() {
		String str = "13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,";
		if( str.charAt(str.length()-1) == ','){
			System.out.println(0);
			return;
		}

		if(str.contains(",,")){
			System.out.println(0);
			return;
		}
		String[] StrArray = str.split(",");
		int max = 0;
		boolean allnegative =true;
		for(String i: StrArray){
			try {
				int te=getInt(i);
				if(te>=0){
					allnegative =false;
					break;
				}
			}catch (NumberFormatException e){
				System.out.println(0);
				return;
			}


		}

		if(allnegative){
			System.out.println(max);
		}

		for (int i = 0; i < StrArray.length; i++) {
			int temp = getInt(StrArray[i]);
			for (int j = i + 1; j < StrArray.length; j++) {
				temp +=  getInt(StrArray[j]);

			}

			if(temp>max){

				max=temp;
			}
		}

		System.out.println(max);


	}

	static int getInt(String input) {
		return Integer.parseInt(input);
	}

	public static int minimumMoves(List<Integer> arr1, List<Integer> arr2) {
		int arr1Length = arr1.size();
		int count = 0;
		for (int i = 0; i < arr1.size(); i++) {
			String arr1Str = String.valueOf(arr1.get(i));
			String arr2Str = String.valueOf(arr2.get(i));
			for (int j = 0; j < arr1Str.length(); j++) {
				int arr1Temp = Integer.parseInt(Character.toString(arr1Str.charAt(j)));
				int arr2Temp = Integer.parseInt(Character.toString(arr2Str.charAt(j)));
				count += Math.abs(arr1Temp - arr2Temp);
			}
		}

		return count;

	}

	static void max() {
		String str = "hello world";
		str = str.replace(" ", "");
		String[] strArray = str.split("");
		Map<String, Integer> map = new LinkedHashMap<>();
		int max = 0;
		for (int i = 0; i < strArray.length; i++) {
			if (!map.containsKey(strArray[i])) {
				map.put(strArray[i], 0);
			}
			int temp = map.get(strArray[i]);

			map.put(strArray[i], ++temp);
			if (temp > max) {
				max = temp;
			}
		}
		for (Map.Entry<String, Integer> temp : map.entrySet()) {
			if (temp.getValue() == max) {
				System.out.println(temp.getKey().charAt(0));
				break;
			}

		}
	}

	public static void repeatedString(String s, long n) {
		int len = s.length();
		Long count = Arrays.stream(s.split("")).filter(a -> a.equalsIgnoreCase("a")).count();
		if (count == 0) {
			System.out.println(0);
			return;
		}
		Long result = (count * n / len);
		long remainder = n % len;
		long remCount = 0l;
		int i = 0;
		for (String temp : s.split("")) {
			if (i++ <= remainder - 1 && temp.equals("a")) {
				remCount++;
			}
		}
		long rem = Arrays.stream(s.split("")).limit(remainder).filter(temp -> temp.equals("a")).count();

		System.out.println(result + remCount);
	}


	public static void jumpingOnClouds(List<Integer> c) {
		int i = 0;
		int jump = 0;
		while (i < c.size() - 1) {
			if (i <= c.size() - 3 && c.get(i + 2) == 0) {
				jump++;
				i += 2;
			} else {
				jump++;
				i++;
			}
		}

		System.out.println(jump);

	}

	public static void countingValleys(int steps, String path) {
		int i = 0;
		int numberOfVallies = 0;
		int vally = 0;

		while (i < steps) {
			boolean isNegative = numberOfVallies < 0;
			numberOfVallies += getPath(path.charAt(i));
			if (numberOfVallies == 0 && isNegative) {
				vally++;
			}
			i++;
		}
		System.out.println(vally);
	}

	public static int getPath(char s) {
		if (s == 'U') {
			return 1;
		} else {
			return -1;
		}
	}

	public static void sockMerchant(List<Integer> ar) {
		Collections.sort(ar);

		int pairs = 0;
		int i = 0;
		while (i < ar.size()) {
			if (i < ar.size() - 1 && ar.get(i) == ar.get(i + 1)) {
				pairs++;
				i += 2;
			} else {
				i += 1;
			}
		}
		System.out.println(pairs);

	}

	public static int maxPresentations(List<Integer> scheduleStart, List<Integer> scheduleEnd) {
		List<Schedule> list = new ArrayList<>();
		for (int i = 0; i < scheduleStart.size(); i++) {
			list.add(new Schedule(scheduleStart.get(i), scheduleEnd.get(i)));
		}
		list.sort(Comparator.comparingInt(s -> s.end));

		List<Schedule> result = new ArrayList<>();
		result.add(list.get(0));
		Schedule temp = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).end > temp.end && list.get(i).start >= temp.end) {
				result.add(list.get(i));
				temp = list.get(i);

			}

		}
		return result.size();
	}

}

class Schedule {
	int start;
	int end;

	public Schedule(int start, int end) {
		this.start = start;
		this.end = end;
	}

}


