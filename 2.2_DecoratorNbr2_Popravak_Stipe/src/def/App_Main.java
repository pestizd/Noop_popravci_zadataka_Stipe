package def;
//Stipe_Dekorator
//Main klasa
public class App_Main {
	//Main metoda
	public static void main(String[] args) {
		//Normalno
		System.out.println("**********************************************");
		System.out.println("With no wrapping");
		System.out.println("**********************************************");
		System.out.println();
		
		//FRAME                            //BOTUN                           //PANEL
		AbsGuiElm frm = new FrameGuiElm(); AbsGuiElm btn = new BttnGuiElm(); AbsGuiElm pnl = new PanelGuiElm();

		btn.setDefaultParameters(true);
		
		btn.description();
		
		btn.createElement();
		
		btn.showGuiElement(true);

		btn.showGuiElement(true);	
		
		System.out.println();
		//--
		GuiElmDecorator ged = new TranspGuiElmDecorator();
		
		ged.setGUIElement2Decorate(btn);
		
		ged.description();
		//--
		GuiElmDecorator ged2 = new ColorGuiElmDecorator();	
		
		ged2.setGUIElement2Decorate(ged);
		
		ged2.description();
		//--
		GuiElmDecorator ged3 = new RoundGuiElmDecorator();
		
		ged3.setGUIElement2Decorate(ged2);
		
		ged3.description();
		
		System.out.println();	
		
		btn.showGuiElement(false);	
		System.out.println();
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		
		System.out.println();
		System.out.println("//////////////////////////////////////////////");
		System.out.println("Now to wrap all in one");
		System.out.println("//////////////////////////////////////////////");
		System.out.println();
		
		frm.setDefaultParameters(true);
		
		frm.description();
		
		frm.createElement();
		
		frm.showGuiElement(true);
		//All in one wrap!!!
		AbsGuiElm aino1 = new TranspGuiElmDecorator(new ColorGuiElmDecorator(new RoundGuiElmDecorator(frm, "Round corners"), ColorEnum.Cyan), TranspEnum.PERC70TRANSP);
		//---------------------------------------------------------------------------------------------------------------------------------------------------------//
		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("Now the change the basic");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println();	
		System.out.println("New decoration --- Its now decorated with transpararency percent  " + aino1.tns +
				" , Its now decorated in color: " + aino1.clr + " , Is it rounded? = " + aino1.rnd);	
		aino1.showGuiElement(false);
		System.out.println(",,,,,,,PANEL,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		pnl.setDefaultParameters(true);
		
		pnl.description();
		
		pnl.createElement();
		
		pnl.showGuiElement(true);
		
		AbsGuiElm aino2 = new TranspGuiElmDecorator(new ColorGuiElmDecorator(new RoundGuiElmDecorator(pnl, "Round corners"), ColorEnum.Turquise), TranspEnum.PERC30TRANSP);
		System.out.println();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("Now the change the basic");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println();
		System.out.println("New decoration --- Its now decorated with transpararency percent  " + aino2.tns +
				" , Its now decorated in color: " + aino2.clr + " , Is it rounded? = " + aino2.rnd);	
		aino2.showGuiElement(false);
		System.out.println("//////////////////////////////////////////////");

		

		
		
	
	}

}