//Main app
public class App {
	//Main metoda
	public static void main(String[] args) {
		//Instanciramo controler
		Controler oper = new Controler();
		Dog pas = new Dog("Roxy");
		Dog pas2 = new Dog("Zoki");
		/*Tiger tigar = new Tiger("Tigric");
		Robot robot = new Robot("SDS707");
		Frog zaba = new Frog("Princ");*/
		//--------------------------------------------
		pas.printStatus();
		//Pritisnemo izvrsi
		oper.executeCommand(new CommandToMove(), pas);

		//Pritisnemo undo
		oper.undoCommand();
		//Opet pritisnemo undo
		oper.undoCommand();
		//oper.executeCommand(new CommandToMove(), pas);
		//Pritisnemo redo
		oper.redoCommand();
		//oper.undoCommand();
		//oper.executeCommand(new CommandToMove(), pas);
		//SAMO ZA PRIMJER
		//Pritisnemo redo
		oper.redoCommand();
		//Nema se sto izvrsiti
		oper.redoCommand();
		//oper.executeCommand(new CommandToMove(), pas2);
		//oper.undoCommand();
		
	
	}
}
