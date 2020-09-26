//Za operacije
public class Controler {
	//Varijable
	private ControlerCmnd command;
	public  String position;
	private AbsEntity entity;
	private int Uncount = 0;
	private int Recount = 0;
	//Konstruktor
	public Controler() {
		//-------
	}
	//1
	public void executeCommand(ControlerCmnd command, AbsEntity entity) {
		//Execute pokrecemo
		this.entity = entity;
		this.command = command;
		command.execute(entity);
		Uncount++;
		
		System.out.println("EXECUTE");
		System.out.println("Undo => " + Uncount);
		System.out.println("Redo => " + Recount);
		System.out.println("These are choices");
		//System.out.println("");
		System.out.println("########################################");
	}
	//2
	public void undoCommand() {
		//if-else koristiti
		if (Uncount <= 0) {
			System.out.println("Undo is not able to be executed");
			System.out.println("-------");
			System.out.println();

		} else {
			this.command.undo();
			Uncount--;
			Recount++;
			
			System.out.println("UNDO COMMAND");
			System.out.println();
			System.out.println(entity.getClass().getSimpleName() + " IME => " + entity.name + " OPIS => " + entity.description + " ID => " + entity.id);
			System.out.println("Final position: " + entity.getPosition());
			System.out.println("-------");
			System.out.println("");
		}
	}
	//3
	public void redoCommand() {
		if (Recount <= 0) {
			//if-else 
			System.out.println("Redo is not able to be executed");
			System.out.println("-------");
			System.out.println();

		} else {
			this.command.redo();
			
			Uncount++;
			Recount--;
			
			System.out.println("REDO COMMAND");
			System.out.println();
			System.out.println(entity.getClass().getSimpleName() + " IME => " + entity.name + " OPIS => " + entity.description + " ID => " + entity.id);
			System.out.println("Final position: " + entity.getPosition());	
			System.out.println("-------");
			System.out.println();
		}
	}
}