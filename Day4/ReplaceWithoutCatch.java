package day4;

/*
public class ReplaceWithoutCatch {
	public static void main(String[] args) throws CustomException{
		Throw replace = new Throw(); 
		replace.newCustomException();
	}
}

class Throw{
	public void newCustomException() throws CustomException{
		throw new CustomException("Something went Wrong");
	}
}
*/

public class ReplaceWithoutCatch {
	public static void main(String[] args) throws CustomException {
		Custom custom = new Custom();
		custom.throwException();
 	}
}

class Custom extends Exception {
	public void throwException() throws CustomException {
		throw new CustomException("SOMETHING WENT WRONG.....");
	}
}
