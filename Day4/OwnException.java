package day4;

public class OwnException {
	public static void main(String[] args) {
		try {
			throw new CustomException("Something went Wrong");
		}
		catch(CustomException e){
			System.out.println("Here is the exception: " + e.getMessage());
		}
	}
}

class CustomException extends Exception {
	public CustomException (String msg) {
		super(msg);
	}
}