//Java imports
import java.util.Random;
//Klasa za tigra
public class Tiger extends AbsEntity {
	
	public Tiger(String name) {

		this.name = name;
		this.description = "Tiger";
		num++;
		this.id = num;
		Random r = new Random();
		double a = r.nextDouble();
		String str = String.valueOf(a);
		this.setPosition(str);

	}
	@Override
	public void moving() {
		System.out.println("Only if you give me some meat");
	}
	@Override
	public void renew() {
		System.out.println("Eating meat ");	
}
	@Override
	public void avoidObstacle() {
		System.out.println("Avoiding the obstacles ");	
}
	@Override
	public void saySomething() {
		System.out.println("Rarrrr ");
}
	@Override
	public void stop() {
		System.out.println("Stopped moving");	
}
	@Override
	public void printStatus() {
		System.out.println("-------");
		System.out.println(this.getClass().getSimpleName() + " IME => " + this.name + " OPIS => " + this.description + " ID => " + this.id);
		System.out.println("Final position: " + this.getPosition());
		System.out.println("-------");
	}

}