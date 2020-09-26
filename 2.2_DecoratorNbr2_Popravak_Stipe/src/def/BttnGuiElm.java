package def;
//Botun klasa
public class BttnGuiElm extends AbsGuiElm{
	

	@Override
	protected void showGuiElement(boolean show) {
		
		if (show == true) {
			System.out.println("Button is visible and created");
			AbsGuiElm.tns = TranspEnum.NOTRANSP;
			AbsGuiElm.clr = ColorEnum.Default;
			AbsGuiElm.rnd = " Round = false";
			System.out.println("Basic params --- " + show);
			}
			else {
				System.out.println("Basic params --- " + show);
				System.out.println("Element we are decorating!!!");
				
			}
		System.out.println( "<< (BUTTON) Color = " + AbsGuiElm.clr.toString() + ", Transparency = " + AbsGuiElm.tns.toString() + 
				" , " +  AbsGuiElm.rnd.toString() + ", State = " + show + " >>" );			
		
	}

	@Override
	public void description() {
		System.out.println("Starting >>>>>>> Button");
		
	}

	@Override
	public void setDefaultParameters(boolean state) {
		
		System.out.println("Defaults --- " + state);
		
	}
	
	@Override
	protected void setGuiElementSize(int sz) {
		System.out.println("Changing the size to a new size --- " + sz);
		
	}

	@Override
	protected void createElement() {
		System.out.println("Creating!!!!!!!");
		
	}


	
	

}