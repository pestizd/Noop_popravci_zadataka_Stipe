package controller;
//Java imports
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
//Package imports
import model.DataBase;
import model.Player;
import view.PresentationPanel;
import view.ReadPanel;
import view.TxtPanel;
import view.ViewFrame;

public class Controller {
	
	private DataBase db;
	
	public Controller() {
		db = new DataBase();
	}
	
	public void addPlayer2DB(Player player) {
		db.setPlayer2DB(player);
	}
	
	public List<Player> getAllPlayers() {
		return db.getAll4DB();
	}	
	
	public void showOnPresPanel(Player plyr, PresentationPanel presPanel) {
		presPanel.showOnPresPanel(plyr);
	}	
	
	public void setData4Table(PresentationPanel panel) {
		panel.setDBData(db);
	}	
	
	public void showPlayerData(PresentationPanel panel) {
		panel.showDataOnTable();
	}	
	
	/*public void showPlayerDataRead(ReadPanel readPanel) {
		readPanel.showDataOnTable();
	}*/
	
	public void saveData2File(File file) throws IOException {
		db.saveDB2File(file);
	}	
	
	public void importData4File(File file) throws IOException {
		db.readData4File(file);
		int num = db.getAll4DB().get(db.getAll4DB().size()-1).getId();
		Player.setCounter(num+1);
	}	
	
	public void showImportedDataInTxtPanel(PresentationPanel presPanel) {
		presPanel.showImportedDataInTxtPanel(db.getAll4DB());
	}
	
	/*public void showImportedDataInTxtPanelRead(ReadPanel readPanel) {//--
		readPanel.showImportedDataInTxtPanelRead(db.getAll4DB());
	}*/
	
	public void connect2DB() throws SQLException {
		db.connect();
	}
	public void disconnect4DB() throws SQLException {
		db.disconnect();
	}
	
	public void save2DB() throws SQLException {
		db.save2DB();
	}
	
	public void load4DB() throws SQLException {
		db.load4DataBase();
	}	
	
	/*public void setTxt(ReadPanel readPanel) {
		readPanel.clearTxt();
	}*/
	/*public void setTxt(TxtPanel txtPanel) {
		//txtPanel.clearTxt();
	
	
	}*/
	
	
	

}
