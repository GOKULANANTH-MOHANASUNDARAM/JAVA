package exercise7;

import java.util.Scanner;

public class CountTheNumberOfCharacters {
	public static void main(String[] args) {
		
		int count = 0;
		
		try(Scanner scanner = new Scanner(System.in)) {

			while(scanner.hasNext()) {
				String input = scanner.nextLine();
				char[] ch = input.toCharArray();
				for(char character : ch) {
					count++;
				}
			}
		} 
		
		catch(Exception e){
			System.out.print(e);
			e.printStackTrace();
		}
		
		finally {
			System.out.println("Total count of Characters is: " + count);
		}
	}
}
