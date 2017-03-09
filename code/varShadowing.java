class Shadower {

	static int a = 5;

	public static void main(String[] args) {

		System.out.println("Shadower.a = " + Shadower.a);     //a = 5

		a = 10;

		System.out.println("Shadower.a = " + Shadower.a);     //a = 10

		int a = 0;

		System.out.println("Shadower.a = " + Shadower.a);
		System.out.println("a = " + a);       //a = 0 -> the local variable "covers" the class variable

	}

}
