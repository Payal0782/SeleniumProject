
public class Sample {

	public static void main(String[] args) {
		int i, count = 0;
		String str = "the best thing";
		for (i =0 ; i < str.length()-1; i++)
		{
			char ch = str.charAt(i);
			 if(ch== ' ')  
		   			count++;
		}
	System.out.println("count ="+count);
	}
}
