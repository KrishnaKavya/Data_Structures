import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author M Krishna Kavya
 *
 */
public class IntersectionUnion {

	/**
	 * Intersection of Two Lists.
	 * @param l1
	 * @param l2
	 * @return
	 */
	public List<Integer> insersection(List<Integer> l1, List<Integer> l2){
		List<Integer> res=new ArrayList<Integer>();
		
		for(Integer i: l1){
			if(l2.contains(i)){
				res.add(i);
			}
		}
		return res;
	}
	
	/**
	 * Union of two Lists
	 * @param l1
	 * @param l2
	 * @return
	 */
	public List<Integer> union(List<Integer> l1, List<Integer> l2){
		Set<Integer> set=new HashSet<Integer>();
		set.addAll(l1);
		set.addAll(l2);
		return new ArrayList<Integer>(set);
		
	}
	
	
	public static void main(String[] args) {
		IntersectionUnion obj=new IntersectionUnion();
		
		
		List<Integer> l1= new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		List<Integer> l2= new ArrayList<Integer>(Arrays.asList(1,2,3,5));
		//Intersection
		List<Integer> intersectionList= obj.insersection(l1, l2);
		System.out.println(intersectionList.toString());
		//Union
		List<Integer> union= obj.union(l1, l2);
		System.out.println(union.toString());
	}
	

}
