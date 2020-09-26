package view;
//Java imports
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
//Swing imports
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
//Package imports
import controller.Controller;
import model.ExperienceEnum;
import model.GameEnum;
import model.Player;
import model.TurnamentEnum;
import model.DataBase;
import view.ReadPanel;
import view.ViewFrame;
//Main frame
public class Frame extends JFrame {
	//Varijable
	private DataPanel dataPanel;
	private PresentationPanel presPanel;
	//private ReadPanel readPanel;
	private TxtPanel txtPanel;
	private Controller controller;
	private DataBase db;
	private JMenuBar menuBar;
	private JFileChooser fileChooser;	
	private ViewFrame viewFrame;
	//Konstruktor
	public Frame() {
		super("eSports");
		setLayout(new BorderLayout());
		setSize(1500, 1000);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		initAll();
		layoutAll();
		activateApp();
	}	
	//Pozicioniranje
	private void layoutAll() {
		add(dataPanel, BorderLayout.SOUTH);
		add(presPanel, BorderLayout.CENTER);

	}	
	//Gornji menu bar
	private JMenuBar createMenuBar() {
		JMenuBar mb = new JMenuBar();
		//Pocetne opcije File/Server/View
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_1);
		JMenu serverMenu = new JMenu("Server");
		serverMenu.setMnemonic(KeyEvent.VK_2);
		JMenu viewMenu = new JMenu("View");
		viewMenu.setMnemonic(KeyEvent.VK_3);
		
		//Dodatne opcije za file
		JMenuItem saveData = new JMenuItem("Save as");
		saveData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		JMenuItem openData = new JMenuItem("Import file");
		openData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		JMenuItem exit = new JMenuItem("Exit");
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		//Dodatne opcije za server
		JMenuItem uploadData = new JMenuItem("Save to a server");
		uploadData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		JMenuItem downloadData = new JMenuItem("Import from a server");
		downloadData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		JMenuItem disconnect = new JMenuItem("Diconnect");
		disconnect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		
		//Dodatne opcije za view
		JMenuItem showView = new JMenuItem("Show text panel view");
		showView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		JMenuItem resetView = new JMenuItem("Reset view");
		resetView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		JMenuItem closeView = new JMenuItem("Close view panel");
		closeView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		
		//Dodavanje opcija za file
		fileMenu.add(saveData);
		fileMenu.add(openData);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		// exit menu item
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int val = JOptionPane.showConfirmDialog(Frame.this, "Do you really want to exit this app?", "Exit dialog",
						JOptionPane.OK_CANCEL_OPTION);
				if (val == JOptionPane.OK_OPTION) {
					System.exit(0);
				} else {
					System.out.println("Exit canceled by user...");
				}

			}
		});
		// save data menu item
		saveData.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int val = fileChooser.showSaveDialog(Frame.this);

				if (val == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try {
						controller.saveData2File(file);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(Frame.this, "Unable to save data into the file!", "Save error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});

		//open menu item
		openData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int val = fileChooser.showOpenDialog(Frame.this);

				if (val == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					try {
						controller.importData4File(file);
						controller.showPlayerData(presPanel);
						controller.showImportedDataInTxtPanel(presPanel);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(Frame.this, "Unable to read data from the file!", "Open error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		//Dodavanje opcija za server
		serverMenu.add(uploadData);
		serverMenu.add(downloadData);
		serverMenu.addSeparator();
		serverMenu.add(disconnect);
		
		// upload data 2 DB
		uploadData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.connect2DB();
					controller.save2DB();
					controller.disconnect4DB();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(Frame.this, "Some Database server connection error!!!", "Save Database error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		downloadData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.connect2DB();
				} catch (SQLException e3) {
					JOptionPane.showMessageDialog(Frame.this, "Unable to connect to a Database server!!!", "Connection Database error",
							JOptionPane.ERROR_MESSAGE);
				}
				try {
					controller.load4DB();
					controller.showImportedDataInTxtPanel(presPanel);
					controller.showPlayerData(presPanel);
				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(Frame.this, "Unable to load data from a Database server!!!", "Load Database error",
							JOptionPane.ERROR_MESSAGE);
				}
				try {
					controller.disconnect4DB();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(Frame.this, "Unable to disconnect from a Database server!!!", "Disconnect Database error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		disconnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					controller.disconnect4DB();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(Frame.this, "Unable to disconnect from a Database server!!!", "Disconnect Database error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		//Dodavanje opcija za view
		viewMenu.add(showView);
		viewMenu.add(resetView);
		viewMenu.addSeparator();
		viewMenu.add(closeView);
		
		
		showView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtPanel = new TxtPanel();
				txtPanel.showAllPlayers(controller.getAllPlayers());
			
				
				//viewFrame = new ViewFrame();
				//readPanel.showAllPlayers(controller.getAllPlayers());
				/*	try {
						controller.connect2DB();
					} catch (SQLException e3) {
						JOptionPane.showMessageDialog(vf, "Unable to connect to a Database server!!!", "Connection Database error",
								JOptionPane.ERROR_MESSAGE);
					}
					try {
						controller.load4DB();
						controller.showImportedDataInTxtPanelRead(readPanel);
						controller.showPlayerDataRead(readPanel);
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(vf, "Unable to load data from a Database server!!!", "Load Database error",
								JOptionPane.ERROR_MESSAGE);
					}
					try {
						controller.disconnect4DB();
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(vf, "Unable to disconnect from a Database server!!!", "Disconnect Database error",
								JOptionPane.ERROR_MESSAGE);
					}*/
					
				}
			});
		
		resetView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(txtPanel!=null) {
					txtPanel.resetView();
					txtPanel.toFront();
					txtPanel.requestFocus();
				}
				
				//readPanel.clearTxt();
				//controller.setTxt(readPanel);
				
				/*int val = JOptionPane.showConfirmDialog(viewFrame, "Clear text area", "Exit dialog",
						JOptionPane.OK_CANCEL_OPTION);
				if (val == JOptionPane.OK_OPTION) {
					controller.setTxt(readPanel);
					System.out.println("Provjera");
				} else {
					System.out.println("Clear was canceled!");
				}*/
					
			}
		});

		closeView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				txtPanel.dispose();
				
				/*
				//Ovo radi jako dobro
				int val = JOptionPane.showConfirmDialog(viewFrame, "Close viewframe", "Exit dialog",
						JOptionPane.OK_CANCEL_OPTION);
				if (val == JOptionPane.OK_OPTION) {
					viewFrame.dispose();
				} else {
					System.out.println("Exit was canceled!");
				}*/

			}
		});
					/*viewFrame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent e) {
							// Dispose the window after the close button is clicked.
								dispose();
					}
				});*/
				//controller.closeVF(viewFrame);
				
				//viewFrame.close();

				/*int val2 = JOptionPane.showConfirmDialog(viewFrame, "Do you realy want to exit app", "Exit dialog",
						JOptionPane.OK_CANCEL_OPTION);
				if (val2 == JOptionPane.OK_OPTION) {
					System.exit(0);
					
				} else {
					System.out.println("Exit canceled by user...");
				}*/


		
		mb.add(fileMenu);
		mb.add(serverMenu);
		mb.add(viewMenu);
		//Menu bar
		return mb;
	}	

	private void initAll() {
		dataPanel = new DataPanel();
		presPanel = new PresentationPanel();
		//readPanel = new ReadPanel();
		controller = new Controller();
		controller.setData4Table(presPanel);
		menuBar = createMenuBar();
		setJMenuBar(menuBar);
		fileChooser = new JFileChooser();
		setFileExtension();
	}
	
	private void setFileExtension() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Programmer files (*.prgm)", "prgm");
		fileChooser.setFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
	}

	private void activateApp() {

		dataPanel.setDataPanelListener(new DpListener() {

			@Override
			public void dataPanelEventOccured(DpEvent dpe) {
				int id = dpe.getId();
				String name = dpe.getName();
				String sname = dpe.getSname();
				GameEnum play = dpe.getPlay();
				ExperienceEnum exp = dpe.getExp();
				TurnamentEnum turn = dpe.getTurn();
				String wrTme = dpe.getWrTme();
				String spnsr = dpe.getSpnsr();
				String notice = dpe.getNotice();

				Player plyr = dataPanel.getPlayer();
				controller.addPlayer2DB(plyr);
				controller.showOnPresPanel(plyr, presPanel);
				controller.showPlayerData(presPanel);
				//controller.setTxt(readPanel);
			}
		});
	}	
}
