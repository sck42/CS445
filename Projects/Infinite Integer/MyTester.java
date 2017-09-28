public class MyTester
{
	public static void main(String[] args)
	{
		InfiniteIntegerInterface gd5 = new LInfiniteInteger(-496);
		InfiniteIntegerInterface gd6 = new LInfiniteInteger(-500);
		System.out.println("isNegative == " + gd5.isNegative()); 
		System.out.println("numberOfDigits == " + gd5.getNumberOfDigits()); 
		System.out.println("toString " + gd5.toString()); 
		System.out.println(gd5.compareTo(gd6));
		System.out.println("");
		System.out.println(gd5.plus(gd6));
		System.out.println(gd5.minus(gd6)); 
		System.out.println("");
		System.out.println(gd5.multiply(gd6)); 
	}
}