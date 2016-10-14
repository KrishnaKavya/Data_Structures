import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author M Krishna Kavya
 *
 */
public class PermutationOfString {
	
	public void permute(String inputString){
		char[] input=inputString.toCharArray();
		Map<Character, Integer> countMap=new TreeMap<>();
		for(char ch: input){
			if(countMap.containsKey(ch)){
				 countMap.put(ch, countMap.get(ch)+1);
			}else{
				countMap.put(ch, 1);
			}
		}
		
		/*Iterator itr=countMap.entrySet().iterator();
		while(itr.hasNext()){
			pair=(countMap)itr.next();
		}
		*/
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
