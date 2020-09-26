package view;
//Swing import
import javax.swing.SwingUtilities;
//Main klasa
public class App {
//Main metoda
public static void main(String[] args) {
	
	SwingUtilities.invokeLater(new Runnable() {
			
		@Override
		public void run() {
			new Frame();
				
			}
	});
}

}
