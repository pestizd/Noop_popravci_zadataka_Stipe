package view;
//Java imports
import java.util.EventObject;
//Package imports
import model.ExperienceEnum;
import model.GameEnum;
import model.Player;
import model.TurnamentEnum;
//Event handler klasa
public class DpEvent extends EventObject {

	private int id;
	private String name;
	private String sname;
	private GameEnum play;
	private ExperienceEnum exp;
	private TurnamentEnum turn;
	private String wrTme;
	private String spnsr;
	private String notice;//--
	
	public DpEvent(Object source, Player plyr) {
		super(source);
		
		id = plyr.getId();
		name = plyr.getName();
		sname = plyr.getSname();
		play = plyr.getPlay();
		exp = plyr.getExp();
		turn = plyr.getTurn();
		wrTme = plyr.getWrTme();
		spnsr = plyr.getSpnsr();
		notice = plyr.getNotice();
	}
	
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

	
}


