import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author M Krishna Kavya
 * 
 *         The class UniqueCharactersInString implements to check if there are
 *         unique characters in the String given.
 */
public class UniqueCharactersInString {
	/**
	 * Approach 1: 
	 * @param string
	 * @return
	 */
	public boolean validate(String string){
		if(string==null){
			return false;
		}
		List <Character> list=new ArrayList<Character>();
		char[] charArray=string.toCharArray();
		for(int i=0;i<charArray.length;i++){
			if(list.contains(charArray[i])){
				return false;
			}else{
				list.add(charArray[i]);
			}
		}
		
	return true;
	}

	public static void main(String[] args) {
		UniqueCharactersInString obj=new UniqueCharactersInString();
		Scanner sc=new Scanner(System.in);
		System.out.println("Please give an input string to validate if the string has unique characters");
		boolean result=obj.validate(sc.next());
		if(result){
			System.out.println("The String has unique characters");
		}else{
			System.out.println("The input is empty/The String does not have unique characters");
		}
		
		sc.close();
	}

}
