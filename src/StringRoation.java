/**
 * 
 * @author M Krishna Kavya
 * 
 *         Question: Assume you have a method isSubstring which checks if one
 *         word is a substring of another. Given two strings, si and s2, write
 *         code to check Ifs2 is a rotation of si using only
 *         onecalltoisSubstring (e.g., "waterbottLe" is a rotation of
 *         "erbottLewat").
 * 
 *
 */
public class StringRoation {

	/**
	 * 
	 * The is rotation method finds if the second is a rotation of a String.
	 * example: water -> aterw, terwa,erwat.....rwate is a rotation.
	 * 
	 * The String waterwater(global) always contains all the rotations possible
	 * in a String. if the second string is a substring of global, then it
	 * implies that it is a rotation of the original. example aterw is a
	 * substring of waterwater.
	 * 
	 * 
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isRotation(String s1, String s2) {
		int len = s1.length();
		if (len == s2.length() && len > 0) {
			String global = s1 + s1;
			return isSubstring(global, s2);
		}
		return false;
	}
	/**
	 * method to to compute substring.
	 * @param string
	 * @param sub
	 * @return
	 */
	public boolean isSubstring(String string, String sub) {
		if (string.contains(sub)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		StringRoation obj = new StringRoation();
		if (obj.isRotation("water", "aterw")) {
			System.out.println("exists");
		} else {
			System.out.println("not exists");
		}

	}

}
