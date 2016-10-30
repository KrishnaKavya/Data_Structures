import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author M Krishna Kavya 1. split every into substrings. every
 */
public class ScrambledSentence {
	
	public String wordExists(String s,Set<String> dictionary,int i,int j){
		if(i==j){
			if(dictionary.contains(s)){
				return s;
			}
		}else{
			for(int current=i;current<j;current++){
			String found=wordExists(swap(s,i,current),dictionary,i+1,j)	;
			if(dictionary.contains(found)){
				return found;
			}
			}
		}
		return "";
	}

	public String swap(String s, int i, int j) {
		char arr[]=s.toCharArray();
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
		return (new String(arr));
	}

	public String makeScentence(String s, Set<String> dictionary, String res) {
		if (s.isEmpty()) {
			return res;
		} else {
			for (int i = 1; i <= s.length(); i++) {
				String first=s.substring(0,i);
				String second=s.substring(i);
				String wordFound=wordExists(first,dictionary,0,i);
				if(!wordFound.isEmpty()){
					String sentence=makeScentence(second,dictionary,res+wordFound+" ");
					if(!sentence.isEmpty()){
						return sentence;
					}
				}
			}
		}

		return "";
	}

	public static void main(String args[]) {
		Set<String> d = new HashSet<String>();
		d.add("hello");
		d.add("to");
		d.add("the");
		d.add("world");

		ScrambledSentence obj = new ScrambledSentence();
		System.out.println(obj.makeScentence("elhloothtedrowl", d, ""));
	}

}