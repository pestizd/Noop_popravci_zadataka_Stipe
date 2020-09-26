package def;
//Abstraktna klasa
public abstract class AbsGuiElm implements BasicGuiElm {
	
	//Ints
	int sizes;
	int big;
	int small;
	//Strings
	static String rnd;
	//Enumi
	static ColorEnum clr;
	static TranspEnum tns;
	//Abstraktne metode
	protected abstract void setGuiElementSize(int sz);
	protected abstract void createElement();
	protected abstract void showGuiElement(boolean show);
}//--