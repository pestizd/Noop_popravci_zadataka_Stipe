package view;
//Java imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
//Swing imports
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
//Package imports
import model.DataBase;
import model.Player;
//Prikaz podataka
public class PresentationPanel extends JPanel {
	//Varijable
	private JTextPane txtPane;
	private JScrollPane scPanel;
	private StyledDocument doc;
	private SimpleAttributeSet attributes;
	private JTable table;
	private List<Player> players;
	private JScrollPane scTablePanel;
	private AbstractTableModel tabModel;
	
	//Konstruktor
	public PresentationPanel() {
		
		setLayout(new BorderLayout());
		//setBackground(Color.LIGHT_GRAY);
		initAll();
		add(scTablePanel, BorderLayout.CENTER);
		add(scPanel, BorderLayout.SOUTH);
	}
	
	public void setDBData(DataBase db) {
		players = db.getAll4DB();
	}	
	
	private void initAll() {
		txtPane = new JTextPane();
		txtPane.setEditable(false);
		txtPane.setToolTipText("Output");
		doc = txtPane.getStyledDocument();
		Color bckgclr = new Color(205, 209, 254);
		Color fontclr = new Color(66, 70, 71);
		txtPane.setBackground(bckgclr);
		txtPane.setForeground(fontclr);
		Dimension tdim = txtPane.getPreferredSize();
		tdim.height = 150;
		txtPane.setPreferredSize(tdim);
		attributes = new SimpleAttributeSet();
		StyleConstants.setFontFamily(attributes, "Courier");
		StyleConstants.setFontSize(attributes, 14);
	    attributes.addAttribute(StyleConstants.CharacterConstants.Bold, Boolean.TRUE);
		scPanel = new JScrollPane(txtPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.table = setTable();
		scTablePanel = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//scTablePanel.setBackground(bckgclr);
	}	
	
	private JTable setTable() {
		Color clrtab = new Color(252, 114, 121);
		JTable table = new JTable();
		table.setBackground(clrtab);
		table.setToolTipText("Table of content");
		
			tabModel = new AbstractTableModel() {
			
			String[] colNames = {"id", "name", "surname", "gaming in", "experience", "turnament", "working time", "sponsor", "notice"};
			
			
			@Override
			public String getColumnName(int column) {
				return colNames[column];
			}

			@Override
			public Object getValueAt(int row, int col) {
//DODATI NOVI CASE___________________________________________________________________________________//				
				Player player = players.get(row);
				switch (col) {
				case 0: return player.getId();
				case 1: return player.getName();
				case 2: return player.getSname();
				case 3: return player.getPlay();
				case 4: return player.getExp();
				case 5: return player.getTurn();
				case 6: return player.getWrTme();
				case 7: return player.getSpnsr();
				case 8: return player.getNotice();
//DODATI NOVI CASE___________________________________________________________________________________//
				default:
					throw new IllegalArgumentException("There is no such value for the input data!!!");
				}
			}
			
			@Override
			public int getRowCount() {
				return players.size();
			}
			
			@Override
			public int getColumnCount() {
				Player plyr = new Player();
				return plyr.getClass().getDeclaredFields().length-1;
			}
		};
		
		table.setModel(tabModel);
		return table;
	}	
	
	
	public void showOnPresPanel(Player player) {
		try {
			doc.insertString(doc.getLength(), player.toString() +"\n\n", attributes);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void showDataOnTable() {
		tabModel.fireTableDataChanged();
	}

	public void showImportedDataInTxtPanel(List<Player> all4db) {
		for(Player plr : all4db) {
			showOnPresPanel(plr);
		}
		
	}	

	
}
