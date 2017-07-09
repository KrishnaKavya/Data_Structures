import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Testing {

	public static void main(String args[]){
		List<String> li=new ArrayList<String>();
		List<String> res= new ArrayList<String>();
		
		
		li.add("krishna");
		
		Iterator<String> itr= li.iterator();
		
		while(itr.hasNext()){
			StringBuilder temp=new StringBuilder(itr.next());
			res.add(temp.reverse().toString());
		}
		
		
		System.out.println(res.get(0));
	}
}
