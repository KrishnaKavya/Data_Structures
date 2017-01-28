/**
 * 
 * @author M Krishna Kavya
 *
 */
public class Pattern {
	
	public void one(){
		for(int i=1;i<6;i++){
			for(int j=0;j<i;j++){
				System.out.print("*");
			}
			System.out.println();
			
		}
	}
	

	public static void main(String args[]){
		Pattern obj=new Pattern();
		obj.one();
	}
}
