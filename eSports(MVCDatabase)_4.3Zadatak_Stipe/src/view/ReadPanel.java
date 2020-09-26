package view;
//Java imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
//Swing imports
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


//Package imports
import controller.Controller;
import model.DataBase;
import model.Player;

public class ReadPanel extends JPanel {
	//Varijable
	private JTextPane inspection; 
	private JTextArea readArea;//--
	private JScrollPane readScroll, readScrolll;
	private StyledDocument docu;
	private JTable table;
	private SimpleAttributeSet attrib;
	private AbstractTableModel tableModel;
	private List<Player> players;
	private DataBase db;
	private Controller controller;
	private static int end;
	//Konstruktor
	public ReadPanel() {
		
		setLayout(new BorderLayout());
		//initPanel();
		//add(scTablePanel, BorderLayout.CENTER);
		initTextArea();
		add(readArea, BorderLayout.CENTER);
		clearTxt();
		//add(inspection, BorderLayout.CENTER);
		//AddPlayers();
	}
	
	public void setDBData(DataBase db) {
		players = db.getAll4DB();
	}
	
	public void clearTxt() {
		
		//readArea.selectAll();
		//--
		//readArea.replaceSelection("daddadadadadad");
		//readArea.setText("Test");
		//db.listAll4DB();
		
	}
	
  /*  private void activate() {
        first.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resetView();
                if(allUsers != null && !allUsers.isEmpty()){
                    position = 0;
                    txtPane.setText(allUsers.get(0).toString());
                }
            }
        });*/
	/*public void AddPlayers() {
		for(Player a : players){
			readArea.append(players);
			}
	}*/
	
	//Mozda treba textArea
	private void initTextArea() {
		readArea = new JTextArea();//--
		//readArea.setSize(200, 300);
		readArea.setWrapStyleWord(true);
		readArea.setAutoscrolls(true);
		readArea.setLineWrap(true);
		readArea.setEditable(true);
		readArea.setToolTipText("(Data from the server)");
		Color bckgrnd = new Color(205, 209, 254);
		readArea.setBackground(bckgrnd);
	    //txtArea.setText("(Optional)");
	    Dimension dman = readArea.getPreferredSize();
	    dman.width = 150;
	    dman.height = 50;
	    readArea.setPreferredSize(dman);
		readScroll = new JScrollPane(readArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
		
	}
	
	public JTextArea getArea() {
		
		return readArea;
	}
	
    public void showAllPlayers(List<Player> players) {
        this.players = players;
        end = players.size() -1;
        players.forEach( (usr) -> inspection.setText( inspection.getText() + usr.toString() + "\n\n"));
    }
	
	/*private void initPanel() {
	 	
		inspection = new JTextPane();
		inspection.setEditable(true);//STAVITI FALSE
		inspection.setToolTipText("Participants");
		//doc = read.getStyledDocument();
		Color readclr = new Color(98, 203, 161);
		inspection.setBackground(readclr);
		Dimension dm = inspection.getPreferredSize();
		dm.width = 150;
		dm.height = 50;
		inspection.setPreferredSize(dm);
		//atrbts = new SimpleAttributeSet();
		//StyleConstants.setFontFamily(atrbts, "Consolas");
		//StyleConstants.setFontSize(atrbts, 14);
		//atrbts.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.TRUE);
		readScrolll = new JScrollPane(inspection, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
	}*/


	

	/*
	public void showOnReadPanel(Player player) {
		//inspection.s(t);
		try {
			docu.insertString(docu.getLength(), player.toString() +"\n\n", attrib);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showDataOnTable() {
		tableModel.fireTableDataChanged();
	}

	public void showImportedDataInTxtPanelRead(List<Player> all4db) {
		for(Player plr : all4db) {
			showOnReadPanel(plr);
		}
		
	}	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
