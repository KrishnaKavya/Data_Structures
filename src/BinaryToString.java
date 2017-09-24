
public class BinaryToString {
	
	public String binaryToString(double num){
		
		if(num <=0 || num >=1){
			return "Error";
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append(".");
		
		while(num>0){
			if(sb.length()>=32){
				return "Error";
			}
			
			double r=num* 2;
			if(r>=1){
				sb.append("1");
				num=r-1;
			}else{
				sb.append("0");
				num=r;
			}
				
		}	
		return sb.toString();
	}
	public static void main(String[] args) {
		BinaryToString obj=new BinaryToString();
		System.out.println(obj.binaryToString(0.10));

	}

}
