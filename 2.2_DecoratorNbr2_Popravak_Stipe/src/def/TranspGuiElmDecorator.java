package def;
//Imports
import java.util.Random;
//Klasa dekoratora vidljivosti
public class TranspGuiElmDecorator extends GuiElmDecorator{	
	//Konstruktor
	public TranspGuiElmDecorator() {
		//Prazno biti
	}
	
	public TranspGuiElmDecorator(AbsGuiElm gElem) {
		this.Abstract = gElem;
	}

	public TranspGuiElmDecorator(AbsGuiElm gElem, TranspEnum tns) {
		
		this.Abstract = gElem;
		this.Abstract.tns = tns;			
	}

	@Override
	public void setParam() {
		//Nepotrebno
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
		System.out.println("Its now decorated with transpararency percent " + this.Abstract.tns);
		
	}

	@Override
	public void setDefaultParameters(boolean state) {
	}

	@Override
	public void setGUIElement2Decorate(AbsGuiElm guiElement) {
		this.Abstract = guiElement;
		//Random odabir
		this.Abstract.tns = TranspEnum.values()[new Random().nextInt(TranspEnum.values().length)];
	}//--
}