import java.util.Scanner;
public class TestPallindrome {
	
	 
	 public static void main(String[] args) {
	 
	  Scanner scanner = new Scanner(System.in);
	  System.out.print("Enter string : ");
	 
	  String str = scanner.nextLine();
	  String reverseStr = "";
	 
	  for(int i = str.length() - 1; i >= 0; i--){
	   reverseStr = reverseStr + str.charAt(i);
	  }
	 
	  if(str.equals(reverseStr)){
	   System.out.println("String is palindrome");
	  } else {
	   System.out.println("String is not palindrome");
	  }
	 }
	}

