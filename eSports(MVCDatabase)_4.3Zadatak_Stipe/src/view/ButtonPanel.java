package view;
//Java imports
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
//Swing imports
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
//Package imports
import model.ExperienceEnum;
import model.GameEnum;
import model.Player;
import model.TurnamentEnum;


public class ButtonPanel extends JPanel {
	//Varijable
	private JButton next, previous, first, last, reset;
	private ReadPanel readPanel;
	private DpListener dpl;
	
	public ButtonPanel () {
		
		//setLayout(new BorderLayout());
		Dimension dim = getPreferredSize();
		dim.height = 77;
		setPreferredSize(dim);
		setBorders2Panel();
		initButton();
		add(previous);
		add(first);
		add(last);
		add(next);
		//ListenForButton lForButton = new ListenForButton();
		//add(reset);
		/*add(next, BorderLayout.WEST);
		add(previous, BorderLayout.EAST);
		add(first, BorderLayout.NORTH);
		add(last, BorderLayout.SOUTH);
		*/

		
	}
	//Metoda za listener
	public void setDataPanelListener(DpListener lst) {
		this.dpl = lst;
	}	
	
	private void initButton() {
	next = new JButton("NEXT");

	//next.setSize(10, 20);
	previous = new JButton("PREVIOUS");
	first = new JButton("FIRST");
	last = new JButton("LAST");
	Color letters = new Color(252, 114, 121);
	next.setBackground(Color.DARK_GRAY);
	next.setForeground(Color.WHITE);
	next.setToolTipText("Next participant");
	//next.addActionListener(lForButton);
	previous.setBackground(Color.DARK_GRAY);
	previous.setForeground(Color.WHITE);
	previous.setToolTipText("Previous participant");
	first.setBackground(Color.GRAY);
	first.setForeground(Color.WHITE);
	first.setToolTipText("First participant");
	last.setBackground(Color.GRAY);
	last.setForeground(Color.WHITE);
	last.setToolTipText("Last participant");
	//reset = new JButton("RESET");
	
	/*private class ListenForButton implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == next) {
				readPanel.setTextTo();
				
			}else {
				System.out.println("");
			}	
		}
		
		
		
	}*/
	
	
	/*next.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(dpl != null) {
				readPanel.getArea().setText("");;

			}


		}

});*/
	
	
	}
	
	
	
	private void setBorders2Panel() {
		Border inner = BorderFactory.createTitledBorder("<Use buttons to navigate>");
		Border outter = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border brd = BorderFactory.createCompoundBorder(outter, inner);
		setBorder(brd);
	}	




}

