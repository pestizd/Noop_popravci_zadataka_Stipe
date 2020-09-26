//Java imports
import java.util.Random;
//Klasa za psa
public class Dog extends AbsEntity {
	//Varijable
	private String b;
	//Konstruktor
	public Dog(String name) {
		
		this.name = name;
		this.description = "Pas";
		num++;
		this.id = num;
		//Treba nam random
		Random r = new Random();
		double a = r.nextDouble();
		String str = String.valueOf(a);
		this.setPosition(str);

	}

	@Override
	public void moving() {
		//Metoda za kretnju
		System.out.println("( " + this.getClass().getSimpleName() + " " + this.name + " )");
		System.out.println("Starting position =. " + this.getPosition());
		System.out.println("Stopped");
		//Treba nam random
		Random r = new Random();
		double c = r.nextDouble();
		b = String.valueOf(c);
		System.out.println("Final position after stoping -> " + b);
		this.setPosition(b);
		System.out.println();
	}

	@Override
	public void renew() {
		System.out.println("Only if you have something good to eat!");
}
	@Override
	public void avoidObstacle() {
		System.out.println("Jumping over the obstacle");
}

	@Override
	public void saySomething() {
		System.out.println("Woof-Woof");
}
	@Override
	public void stop() {
		System.out.println("Stopped running");
}
	@Override
	public void printStatus() {
		System.out.println("-------");
		System.out.println(this.getClass().getSimpleName() + " IME => " + this.name + " OPIS => " + this.description + " ID => " + this.id);
		System.out.println("Final position: " + this.getPosition());
		System.out.println("-------");
	}
}