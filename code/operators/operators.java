class Main {

	public static void main(String[] args) {

	int a = 2;
	int b = 4;
	boolean test = (a == 3) | (b++ == 4);		//evaluates both sides, so b is incremented
	boolean test1$ = (a == 2) || (a++ == 4);	//only evaluates left side since it is true, a is not incremented

	System.out.println("test is " + test);
	System.out.println("b equals (should be 5): " + b);
	System.out.println("a equals (should be 2): " + a);

	}

}
