//Java imports
import java.util.Random;
//Klasa za zabu
public class Frog extends AbsEntity {
	
	
	public Frog(String name) {

		this.name = name;
		this.description = "Frog";
		num++;
		this.id = num;
		Random r = new Random();
		double a = r.nextDouble();
		String str = String.valueOf(a);
		this.setPosition(str);

	}

	@Override
	public void moving() {
		System.out.println("Jumping!");
	}

	@Override
	public void renew() {
		System.out.println("Eating Flies ");
}
	@Override
	public void avoidObstacle() {
		System.out.println("Avoiding the obstacles ");
}
	@Override
	public void saySomething() {
		System.out.println("I am a frog ");	
}
	@Override
	public void stop() {
		System.out.println("Stopped jumping");
}
	@Override
	public void printStatus() {
		System.out.println("-------");
		System.out.println(this.getClass().getSimpleName() + " IME => " + this.name + " OPIS => " + this.description + " ID => " + this.id);
		System.out.println("Final position: " + this.getPosition());
		System.out.println("-------");
	}
}
