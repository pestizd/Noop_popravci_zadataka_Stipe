//Abstraktna klasa
public abstract class AbsEntity {
	//Strings
	protected String name;
	protected String description;
	//Numbers
	protected static int num;
	protected int id;
	private double speed;
	//Strings
	private String position;
	private String directon;

	
	//Konstruktor
	public AbsEntity() {
		//-------
	}
	//Abstraktne metode
	public abstract void moving();
	public abstract void renew();
	//get-set
	public void setPosition(String position) {
		this.position = position;
	}
	public void setDirection(String direction) {
		this.directon = direction;
	}
	public double getSpeed() {
		return speed;
	}
	public void setMovingSpeed(double speed) {
		this.speed = speed;
	}
	public String getPosition() {
		return position;
	}
	public String getDirecton() {
		return directon;
	}
	//------- Za implementaciju
	public abstract void  avoidObstacle();
	public abstract void saySomething();
	public abstract void stop();
	public abstract void printStatus();
	//------- Za implementaciju
}
