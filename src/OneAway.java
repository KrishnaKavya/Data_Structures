public class OneAway {

	public boolean validate(String one, String two) {
		return false;
	}

	public boolean insert(String one, String two) {
		int index1 = 0;
		int index2 = 0;

		while (index1 < one.length() && index2 < two.length()) {
			if (one.charAt(index1) != two.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
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
		obj.insert("one", "two");
	}
}
