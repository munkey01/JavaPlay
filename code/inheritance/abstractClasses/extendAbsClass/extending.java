/* Questions to address:
*	1) What happens when you extend an abstract class?
		~If extending to another abstract class then nothing really, all can stay the same, or you can override super methods (concrete or abstract).
		~If extending to concrete class then you must override all abstract methods from super. You can access nonabstract methods found in the abstract superclass.
*	2) Why do we have abstract classes?
		~When multiple subclasses may perform the same type of task differently then an abstract method can be useful. Example: abstract superclass EntryWayIntoHome is extended by class Door and class Window.
		Both doors and windows can open, but they do it differently (handle, latch, slide, etc). So super class requires that they open, but doesn't say how it should be done.
*	3) Difference between abstract class and interface?
		~Interfaces require certain implementations to occur, but cannot specifically describe method bodies. So if Animal interface was implemented by Cow and Dog then they would be have to implement each method
		listed in interface Animal. However, dogs and cows both do some of the same things in the same ways, so you would have redundant code by using an interface. 
		~Abstract classes, on the other hand, allow you to specifically describe method bodies for things that will be the same across all child classes while also forcing the extending classes to implement 
		specific methods in their own way.
*/


abstract class Organism {

	abstract public void noise(String noise);		//remember: abstract methods cannot have a body, methods without body must be labeled abstract

	public void activity(String activity) {
		System.out.println("Organism is " + activity + "ing");
	}

	abstract protected void poop();

	//abstract private void pee();		<-- compilation error since private  methods are not inherited, and therefore this abstract method cannot be implemented by subclass
	/* General idea: It is a compile time error to declare an abstract method as private, static, final, synchronized, native, or strictfp  */

}

class Dog extends Organism {	//Dog has to be abstract or override abstract methods in super

	public void noise(String bark) {
		System.out.println("Bark sound: " + bark);
	}

	public void poop() {			// <-- note that Dog implements poop() as public when abstract super has it as protected. General idea: You may expand access to abstract method, cannot reduce.
		System.out.println("Dogs poop in public");
	}

	//abstract public void pee();		<-- note that Dog _must be abstract_ in order to have an abstract method, this line causes comilation error

}

/* Abstract classes can extend concrete classes (and vice versa of course).  */
abstract class DogBreed extends Dog {

	int yearOfOrigin;
	String mostCloselyRelatedTo;
	String breedName;

	abstract public void  howToDevelop();

	public void develop() {
		System.out.println("Developing dog of breed: " + breedName);
	}

}


/* Abstract classes can have abstract or concrete methods. */
/* If extending abstract class with abstract class then abstract method override (from super) _is not_ necessary.*/
/* If extending abstract class with concrete class then abstract method override (from super) _is_ necessary. */
abstract class Cat extends Organism {				//note that abstract classes can exist without having abstract methods, these ideas are separate
								// ^^cont'd: abstract class means that class cannot be instantiated, abstract method means that it will be implemented by a subclass
	//protected void noise(String noise) {			<-- note that method is overriding noise() in super; 'protected' here is more restrictive than 'public' described in super, therefore, compilation fails
	public void noise(String noise) {
		System.out.println(noise);			//General idea: you must provide same or more access to overriden superclass method
	}
}

class Main {

	public static void main(String[] args) {

		Dog rex = new Dog();
		rex.noise("Arf, arf!");
		rex.activity("smell");
		rex.poop();
		//Cat tabby = new Cat();		<-- Cat is abstract and cannot be instantiated
		//tabby.noise("Meow!");

	}

}
