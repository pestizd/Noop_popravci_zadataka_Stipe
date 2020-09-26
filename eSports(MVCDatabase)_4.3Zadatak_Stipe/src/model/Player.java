package model;

import model.ExperienceEnum;
//import Model.Override;
import model.GameEnum;
//Java import
import java.io.Serializable;
//Klasa igraca
public class Player implements Serializable {

	private static int cnt = 1;
	private int id;
	private String name;
	private String sname;
	private GameEnum play;
	private ExperienceEnum exp;
	private TurnamentEnum turn;
	private String wrTme;
	private String spnsr;
	private String notice;//--
	
	//Konstruktor
	public Player() {
		// TODO Auto-generated constructor stub
	}
	//1
	public Player(String name, String sname, GameEnum play, ExperienceEnum exp, TurnamentEnum turn, String time, String spnsr, String notice) {

		this.id = cnt;
		this.name = name;
		this.sname = sname;
		this.play = play;
		this.exp = exp;
		this.turn = turn;
		this.wrTme = time;
		this.spnsr = spnsr;
		this.notice = notice;
		cnt++;
	}	
	//2
	public Player(int id, String name, String sname,GameEnum play, ExperienceEnum exp, TurnamentEnum turn, String time, String spnsr, String notice) {
		this.id = id;
		this.name = name;
		this.sname = sname;
		this.play = play;
		this.exp = exp;
		this.turn = turn;
		this.wrTme = time;
		this.spnsr = spnsr;
		this.notice = notice;
		cnt = id+1;
	}	
	//Getteri
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSname() {
		return sname;
	}

	public GameEnum getPlay() {
		return play;
	}

	public ExperienceEnum getExp() {
		return exp;
	}
	
	public TurnamentEnum getTurn() {
		return turn;
	}

	public String getWrTme() {
		return wrTme;
	}

	public String getSpnsr() {
		return spnsr;
	}
	
	public String getNotice() {
		return notice;
	}
	
	//ToString metoda
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", sname=" + sname + ", play=" + play + ", exp=" + exp +
				", turn=" + turn + ", wrTme=" + wrTme + ", spnsr=" + spnsr + ", notice=" + notice + "]";
	}	
	//Metoda za opis
	public void description() {
		System.out.println(toString());
	}

	public static void setCounter(int i) {
		cnt = i;
		
	}	
}
