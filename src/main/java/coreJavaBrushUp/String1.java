package coreJavaBrushUp;

public class String1 {

	public static void main(String[] args) {
		
		String str="Payments $100 Paid";
		System.out.println(str.indexOf("$"));
		System.out.println(str.charAt(9));
		System.out.println(str.substring(9, 14));
		System.out.println(str.substring(9));
		
		
		
		for(int i=str.length()-1;i>=0;i--)
		{
			System.out.print(str.charAt(i));			
		}

	}

}
