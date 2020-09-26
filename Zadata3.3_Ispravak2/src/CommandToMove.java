//Enkapsulirana komanda
public class CommandToMove implements ControlerCmnd {
	//Varijable
	private AbsEntity ent; //Instanciranje abstraktnog entiteta
	private String position;
	private String positionRedo;
	//1-Execute
	@Override
	public void execute(AbsEntity ent) {
		this.ent = ent;
		
		this.position = ent.getPosition();
		
		ent.moving();
	}
	//2-Undo
	@Override
	public void undo() {
		positionRedo = ent.getPosition();
		
		ent.setPosition(position);
		
		this.position = ent.getPosition();	
	}
	//3-Redo
	@Override
	public void redo() {
		
		this.position = positionRedo;
		
		ent.setPosition(positionRedo);
	}
}
