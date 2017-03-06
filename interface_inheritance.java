interface Animal {			//note: interfaces are implicitly public because they represent what can be seen from outside of the class

	public void speak();
	public void move();
	public void eat();

}

interface Fish extends Animal {

	public void makeBubbles();

}

class Guppy implements Fish {		//Guppy has to implement each method from both interfaces since Fish extends (think of it as being combined together into one interface)

	public void makeBubbles() {
		System.out.println("Making guppy bubbles.");
	}

	public void speak() {
		System.out.println("Blurp, blurp...");
	}

	public void move() {
		System.out.println("Swimming.");
	}

	public void eat() {
		System.out.println("Slurp, slurp");
	}

}

class Main {

	public static void main(String[] args) {

		Guppy g = new Guppy();
		g.makeBubbles();

	}

}
