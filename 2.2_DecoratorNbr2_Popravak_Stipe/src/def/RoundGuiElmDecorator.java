package def;
//Klasa za zaobljeni dekorator
public class RoundGuiElmDecorator extends GuiElmDecorator {	
	
	//Konstruktor
	public RoundGuiElmDecorator() {	
	}
	
	public RoundGuiElmDecorator(AbsGuiElm gElem) {
		this.Abstract = gElem;		
	}
	public RoundGuiElmDecorator(AbsGuiElm gElem, String round) {
		this.Abstract = gElem;
		AbsGuiElm.rnd = round;	
	}

	@Override
	protected void setGuiElementSize(int sz) {
		this.Abstract.setGuiElementSize(sz);	
	}

	@Override
	protected void createElement() {
		this.Abstract.createElement();
	}

	@Override
	protected void showGuiElement(boolean show) {
		this.Abstract.showGuiElement(show);
	}
	
	@Override
	public void description() {
		System.out.println("Is it rounded? = " + AbsGuiElm.rnd);	
	}

	@Override
	public void setDefaultParameters(boolean state) {
	}

	@Override
	public void setGUIElement2Decorate(AbsGuiElm guiElement) {
		this.Abstract = guiElement;
		AbsGuiElm.rnd = "Corners are showing";	
	}

	@Override
	public void setParam() {	
		//Nepotrebno
	}//--
}