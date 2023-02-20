package day1;

/*
class SeeWhatHappens {
	public void useD() {
		base z = new base();
		System.out.println("base says, " + z.Method());
	}
}

protected class base {
	String Method() {
		return "Wow";
	}
}
*/

class SeeWhatHappens {
	public static void useD(String[] args) {
		base z = new base();
		System.out.println("base says, " + z.Method());
	}
}

class base {
	String Method() {
		return "Wow";
	}
}
