import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author M Krishna Kavya
 *
 */
public class AnagramSubStringSearch {

	public List<Integer> search(String text, String pattern){
		List<Integer> res= new ArrayList<Integer>();
		
		int[] countP=new int[256];
		int[] countT=new int[256];
		
		int patternLength=pattern.length();
		int textLength=text.length();
		
		//populating both arrays equal to the length of the pattern. 
		for(int i=0;i<patternLength;i++){
			countP[pattern.charAt(i)]++;
			countT[text.charAt(i)]++;
		}
		int i=patternLength;
		for(i=patternLength; i<textLength;i++){
			if(compare(countP, countT)){
				System.out.println("Anagram found at Index"+(i-patternLength));
				res.add(i);
			}
				//Remove the first character of previous pattern
				countT[text.charAt(i-patternLength)]--;
				//Add next character to the current pattern
				countT[text.charAt(i)]++;
			
		}
		if(compare(countP, countT)){
			System.out.println("Anagram found at Index"+(i-patternLength));
			res.add(i);
		}
		return res;
	}
	
	public boolean compare(int[] a, int[] b){
		for(int i=0;i<a.length;i++){
			if(a[i]!=b[i]){
				return false;
			}
		}
	return true;
	}
	public static void main(String[] args) {
		String text=new String("abhitejhiba");
		String pattern=new String("abhi");
		
		AnagramSubStringSearch obj=new AnagramSubStringSearch();
		obj.search(text, pattern);
		

	}

}
