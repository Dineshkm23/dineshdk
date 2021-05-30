
public class Sample3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("program start from here");
		int res = sample();
		System.out.println("result is " + res);
		System.out.println("++++++++++");
		int res1 = sample();
		System.out.println("result is " + res1);
		System.out.println("program ends");
		
	}
	static int sample()
	{
		int a;
		int b;
		a = 28;
		b = 2334;
		System.out.println("progrm enters into method");
		System.out.println("the value of a is " +a);
		System.out.println("the value of b is " +b);
		int sum = a+b;
		return sum;
		
	}

}
