import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FirstUnique {

	public void firstUnique(String params) {

		char[] charArray = params.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Deque<Character> queue=new ArrayDeque<Character>();
		for(int i=0;i<charArray.length;i++){
			if(!map.containsKey(charArray[i])){
				map.put(charArray[i], 1);
			}else{
				map.put(charArray[i], (map.get(charArray[i])+1));
			}
		}
		
		Iterator<Entry<Character, Integer>> itr=map.entrySet().iterator();
		
		while(itr.hasNext()){
			Map.Entry<Character,Integer> entry = (Map.Entry<Character,Integer>) itr.next();
			System.out.println("Key : " + entry.getKey() + " Value :" + entry.getValue());
		}
		
	}
	//System.out.println(i+" "+charArray[i]);
	public static void main(String[] args) {
		FirstUnique obj = new FirstUnique();
		obj.firstUnique("kavyak");
	}

}
