package lab;

public class NonRepeatedCharInString {
	public static void main(String[] args) {

		firstNonRepeatedCharInString("abzddab".toCharArray(),"abzddab".length());



	}

	static void firstNonRepeatedCharInString(char[] str, int len){
		int i;
		int[] count = new int[256];
		for(i=0;i<len;i++){
			count[i]=0;
		}

		for(i=0;i<len;++i){
			count[str[i]]++;
		}

		for(i=0; i<len;++i){
			if(count[str[i]]==1){
				System.out.println(str[i]);
			}
		}

	}

}
