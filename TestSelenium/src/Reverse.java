import java.util.Scanner;


public class Reverse {

	public static void main(String[] args) {
		

		  //Scanner scanner = new Scanner(System.in);
		  //System.out.print("Enter string : ");
		 
		  //String str = scanner.nextLine();
		String str = "tester";
		String rev = "";
		for (int i = str.length()-1 ; i >=0 ; i--)
		{
			rev = rev + str.charAt(i);
			
		}
		System.out.println("reverse string is : "+rev);	

	}

}
