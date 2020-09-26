package view;
//Java import
import java.util.EventListener;
//Interface listener
public interface DpListener extends EventListener {

	public void dataPanelEventOccured(DpEvent dpe);
	
}
