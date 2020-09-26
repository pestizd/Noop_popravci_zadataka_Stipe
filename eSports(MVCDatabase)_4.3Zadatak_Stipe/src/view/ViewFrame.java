package view;
//Java imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
//Swing imports
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
//Package imports
import controller.Controller;
import model.ExperienceEnum;
import model.GameEnum;
import model.Player;
import model.TurnamentEnum;
//Citanje podataka
public class ViewFrame extends JFrame {
	//Varijable
	private ReadPanel readPanel;
	private ButtonPanel btnPanel;
	private Controller controller;
	//Konstruktor
	public ViewFrame() {
		
		super("Reading view");
		setLayout(new BorderLayout());
		setSize(1000, 620);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		initAll();
		layoutAll();
	}
	

	private void layoutAll() {
		add(btnPanel, BorderLayout.SOUTH);
		add(readPanel, BorderLayout.CENTER);


	}
	private void initAll() {
		readPanel = new ReadPanel();
		btnPanel = new ButtonPanel();
		
		//controller = new Controller();
		//controller.setData4Table(presPanel);
		//menuBar = createMenuBar();
		//setJMenuBar(menuBar);
		//fileChooser = new JFileChooser();
		//setFileExtension();
	}	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
