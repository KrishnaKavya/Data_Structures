public class OneAway {

	public boolean validate(String one, String two) {
		return false;
	}

	public boolean insert(String one, String two) {
		int index1=0;
		int index2=0;
		
		return false;
	}

	public boolean remove(String one, String two) {
		if ((one.length() - two.length()) == 1) {
			return true;
		}
		return false;
	}

	public boolean replace(String one, String two) {
		boolean found = false;
		for (int i = 0; i < one.length(); i++) {
			if (one.charAt(i) != two.charAt(i)) {
				if (found == true) {
					return false;
				}
				found = true;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		OneAway obj = new OneAway();
		System.out.println(obj.insert("one", "ones"));
		System.out.println(obj.remove("one", "on"));
	}
}
