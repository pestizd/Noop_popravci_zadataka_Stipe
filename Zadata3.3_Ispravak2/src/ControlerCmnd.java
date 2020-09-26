//Interface
public interface ControlerCmnd {

	//Execute komanda
	public void execute(AbsEntity ent);
	//Undo komanda
	public void undo();
	//Redo komanda
	public void redo();
}
