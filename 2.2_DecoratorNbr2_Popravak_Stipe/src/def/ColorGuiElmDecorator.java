package def;
//Imports
import java.util.Random;
//Klasa color dekoratora
public class ColorGuiElmDecorator extends GuiElmDecorator {	
	//Konstruktor
	public ColorGuiElmDecorator() {
		//Prazno biti
	}	
	
	public ColorGuiElmDecorator(AbsGuiElm gElem) {
		this.Abstract = gElem;
	}
	
	public ColorGuiElmDecorator(AbsGuiElm gElem, ColorEnum color) {
		this.Abstract = gElem;
		this.Abstract.clr = color;		
	}

	@Override
	public void setParam() {	
	}
	//Nepotrebno
	@Override
	protected void setGuiElementSize(int sz) {	
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
		System.out.println("Its now decorated in color: " + this.Abstract.clr);		
	}

	@Override
	public void setDefaultParameters(boolean state) {
		//Basic parametri	
	}

	@Override
	public void setGUIElement2Decorate(AbsGuiElm guiElement) {
		
		this.Abstract = guiElement;
		
		this.Abstract.clr = ColorEnum.values()[new Random().nextInt(ColorEnum.values().length)];
		
	}//--
}