
public class Removewhitespace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String str = "the%$#@!best thing ";
String str1 = str.replaceAll(" ", "");
String str2 = str.replaceAll("[-+^]*", "");
System.out.println("new string: " +str1);
System.out.println("new string: " +str2);
	}

}
