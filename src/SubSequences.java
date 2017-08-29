import java.util.Scanner;


public class SubSequences {
	
	public void print(String prefix, String remaining, int k){
		if(k==0){
			System.out.println(prefix);
			return;
		}
		if(remaining.length()==0){
			return;
		}
		
		print(prefix+remaining.charAt(0), remaining.substring(1), k-1);
		print(prefix, remaining.substring(1),k);
	}
	public static void main(String[] args) {
		SubSequences obj=new SubSequences();
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter");
		
		String str=sc.nextLine();
		System.out.println(str.substring(0,1));
		System.out.println(str.substring(0));
		for(int k=3; k>=1; k--){
		//obj.print("",str,k );
		}
		
		sc.close();
		
	}

}
