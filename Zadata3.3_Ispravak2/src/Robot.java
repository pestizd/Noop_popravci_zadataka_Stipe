//Java imports
import java.util.Random;
//Klasa za robota
public class Robot extends AbsEntity {
	//Varijable
	public double energy;
	public double chargedEnergy;
	
	public Robot(String name) {

		this.name = name;
		this.description = "Robot";
		num++;
		this.id = num;
		Random r = new Random();
		double a = r.nextDouble();
		String str = String.valueOf(a);
		this.setPosition(str);

	}

	@Override
	public void moving() {
		System.out.println("I am a robot and i am moving");
}
	@Override
	public void renew() {	
		energy = 25 + (int)(Math.random() * ((55 - 25) + 1));
		System.out.println("Battery at " + energy + "% connecting to a charger ");		
}
	@Override
	public void avoidObstacle() {
		System.out.println("Avoiding the obstacles ");	
}
	@Override
	public void saySomething() {
		System.out.println("My name is SDS707 and i am a robot ");	
}
	@Override
	public void stop() {
		chargedEnergy = 60 + (int)(Math.random() * ((100 - 60) + 1));
		System.out.println("Stopped! My battery is at " + chargedEnergy + " %");
}
	@Override
	public void printStatus() {
		System.out.println("-------");
		System.out.println(this.getClass().getSimpleName() + " IME => " + this.name + " OPIS => " + this.description + " ID => " + this.id);
		System.out.println("Final position: " + this.getPosition());
		System.out.println("-------");
	}

}
