/**
 * 
 * @author M Krishna Kavya
 *
 */
public class InsertionSort {
	
	public int[] insertionSort(int[] a){
		int i=1;
		while(i<a.length){
			int temp= a[i];
			int j=i-1;
			while(j>=0 && a[j]>temp){
				a[j+1]=a[j];
				j=j-1;
			}
			a[j+1]=temp;
			i=i+1;
		}
	return a;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort obj= new InsertionSort();
		int arr[]={32,41,58,24,40,47};
		int res[]=obj.insertionSort(arr);
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
		

	}

}
