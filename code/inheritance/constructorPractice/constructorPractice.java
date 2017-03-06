class Animal {

	int aInt = 4;
	static int bInt = 30;
	private static int cInt = 100;

	Animal() {
		System.out.println("Animal constructor is running.");
	}

	Animal(String name) {
		System.out.println("Overloaded Animal constructor is running: " + name); 
	}

}

class Mammal extends Animal {}

class Fish extends Animal {

	Fish() {
		System.out.println("Fish constructor is running.");
	}

	Fish(int age) {
		//this("JoeFish");		//cannot call super() and this() in a constructor because first line must be either or -> breaks flow of constructing
		super("JoeAnimal");

		System.out.println("Here is the fish's age when it was born: " + age);
	}

	Fish(String name) {
		super(name);
		System.out.println("Overloaded Fish constructor is running: " + name);		//calls default constructor unless told to call overloaded super()
		//super(name);  --> compilation fails since call to super() must be first statement
	}

}

class Marlin extends Fish {

	Marlin() {
		System.out.println("Marlin constructor is running.");
	}

}

class Main {

	public static void main(String[] args) {

		Animal a = new Animal();		//prints "Animal constructor is running"
		Mammal m = new Mammal();		//prints "Animal constructor is running"

		Fish f = new Fish();			//prints "Animal constructor is running" "Fish constructor is running."
							//because f is a fish and an animal
							//therefore Fish() must have an implicit call to super()

		Marlin mar = new Marlin();		//prediction: will run animal(), fish(), then marlin()

		a.aInt = 6;

		System.out.println(a.aInt);		//outputs 6
		System.out.println(m.aInt);		//rest output 4, because they have their own copy of the aInt instance variable
		System.out.println(f.aInt);
		System.out.println(mar.aInt);

		System.out.println(a.bInt);
		a.bInt = 35;
		System.out.println(f.bInt);		//has access to static in superclass and displays changes made to it through object a since static creates a shared class variable

		//System.out.println(a.cInt);		//cannot access since cInt is private-> can only be accessed inside of its class (Animal)

		Fish babyFish = new Fish("Dorry");

		Fish ageFish = new Fish(50);

	} 

}
