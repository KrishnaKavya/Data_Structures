
public class Spaces {
	
	public char[] spaces(String input){
		char[] charArray=input.toCharArray();
		for(int i=0;i<charArray.length;i++){
			if(charArray[i]==' '){
				charArray[i]='%';
			}else{
				continue;
			}
		}
		
		return charArray;
		
	}
	public static void main(String[] args) {
		Spaces obj=new Spaces();
		char[] result=obj.spaces("The Scentance has spaces");
		System.out.println(new String(result));

	}

}
