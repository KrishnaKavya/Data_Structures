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
		obj.print("",str,3 );
		obj.print("", str,1);
		sc.close();
		
	}

}
