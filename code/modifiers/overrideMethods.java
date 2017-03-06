/* Note: from most restrictive to least restrictive:
	~private: only current class access
	~default: package-private: only package access
	~protected--> allows subclasses, same package, and members of class access
	~public--> anything goes
*/

class OverloadPractice {

	public void test() { System.out.println(1); }
	protected void test(int a) { System.out.println(a); }	//can reduce access within class
	void test(double d) { System.out.println(d); }		//can reduce access within class

	protected void test2() { System.out.println("test2 protected"); }
	public void test2(int a) { System.out.println("test2 public: " + a); }		//can increase access within class

	protected void test3() { System.out.println("Test3 in super, protected"); }

	protected void test4() { System.out.println("Test4 in super, protected."); }

}

class OverloadPracticeExtender extends OverloadPractice {

	protected void test3(int a) { System.out.println("Test3 in sub, protected: " + a); }
	public void test3(double d) { System.out.println("Test3 in sub, public: " + d); }

}

class OverridePractice extends OverloadPractice {

	public void test3() { System.out.println("Test3() in OverridePractice."); }		//this is an override of test3 in super. When overriding, you must use the same access level or less restrictive. 
	//void test4() { System.out.println("Test4() in OverridePractice."); }			//Access modifiers cannot be more restrictive than original when overriding methods.
	public void test4() { System.out.println("Test4() in OverridePractice"); }		//Access modifiers can be equally or less restrictive though. (public here, protected in super)

}

class Main {

	public static void main(String...args) {

		OverloadPractice op = new OverloadPractice();
		op.test();
		op.test(2);
		op.test(2.0d);

		op.test2();
		op.test2(3);

		OverloadPracticeExtender ope = new OverloadPracticeExtender();
		ope.test3();
		ope.test3(2);
		ope.test3(3.0d);

		OverridePractice rideP = new OverridePractice();
		rideP.test4();
		rideP.super(test4());

	}

}
