package def;
//Klasa za panel
public class PanelGuiElm  extends AbsGuiElm {


	@Override
	protected void showGuiElement(boolean show) {
		
		if (show == true) {
			System.out.println("Panel is visible and created");
			this.tns = TranspEnum.NOTRANSP;
			this.clr = ColorEnum.Default;
			this.rnd = " Round = false";
			System.out.println("Basic params --- " + show);
			}
			else {
				System.out.println("Basic params --- " + show);
				System.out.println("Element we are decorating!!!");
			}
			System.out.println("<< (PANEL) Color = " + this.clr.toString() + ", Transparency = " + this.tns.toString() +
					" , " + this.rnd.toString() + ", State = " + show + " >>" );
	}


	@Override
	public void description() {
		System.out.println("Starting >>>>>>> Panel");
		
	}

	@Override
	public void setDefaultParameters(boolean state) {
		
			System.out.println("Defaults --- " + state);			
	}

	@Override
	protected void setGuiElementSize(int sz) {
		System.out.println("Changing the size to a new size --- " + sz);
	}
	//Initialize
	@Override
	protected void createElement() {
		System.out.println("Creating!!!!!!!");		
	}


}//--