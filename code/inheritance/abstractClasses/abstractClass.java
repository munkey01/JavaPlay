class RealObject {

	public static void test() {
		System.out.println("This is a test from RealObject");
	}

}

/* Superclass _can_ have abstract subclass.  */
abstract class AbstractObject extends RealObject {

	//abstract public static void home();		<-- compilation error, abstract methods cannot have static designation
	abstract public void home();

	/* abstract classes cannot have concrete methods */
	public static void imposssible() {
		System.out.println("impossible() in abstract class is running");
	}

	/* abstract classes cannot have a method body */
	//abstract public void impossible2() {};		<-- compilation fail

}

class Main {

	public static void main(String[] stuff) {

		System.out.println("Running main()");
		RealObject real = new RealObject();
		real.test();
		//AbstractObject abs = new AbstractObject();	<--	compilation fail, due to attempt to instantiated abstract object

		//AbstractObject.impossible();		<-- compilation fail, cannot find method or class

	}

}
