import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author M Krishna Kavya
 *	
 * The class computes the permutations of a string using recursion.
 */
public class RecursivePermutation {

	List<String> result = new ArrayList<String>();

	public String swap(String str, int i, int j) {
		char arr[] = str.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return (new String(arr));
	}

	public void permutation(String str, int start, int end) {
		
		if(start==end-1){
			if(!result.contains(str)){
				System.out.println(str);
				result.add(str);
			}	
		}else{
			for(int k=start; k<end;k++){
				permutation(swap(str,k,start),start+1,end);
			}
		}
		
	}

	public static void main(String[] args) {

		RecursivePermutation obj = new RecursivePermutation();
		obj.permutation("abc", 0, 3);
	}

}
