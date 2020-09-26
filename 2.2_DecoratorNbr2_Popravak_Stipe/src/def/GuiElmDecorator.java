package def;
//Abstraktna klasa
public abstract class GuiElmDecorator extends AbsGuiElm {
	//Varijabla
	AbsGuiElm Abstract;
	//Abstraktne metode
	public abstract void setGUIElement2Decorate(AbsGuiElm guiElement);
	//Param
	public abstract void setParam();
}//--