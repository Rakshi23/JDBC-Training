package java8;


//block lambda expressions
@FunctionalInterface
interface MyString{
	String myStringFunction(String str);
}
public class LambdaDemo2 {

public static void main(String[] args)

{
	
	MyString reverseStr=(str) ->{

		String result="";

		

		for(int i=str.length()-1;i>=0;i--)

			result+=str.charAt(i);

		return result;

	};

	

	System.out.println(reverseStr.myStringFunction("Lamda Demo"));

}

}