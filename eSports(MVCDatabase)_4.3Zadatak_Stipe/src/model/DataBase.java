package model;
//Java imports
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.filechooser.FileNameExtensionFilter;

public class DataBase {
	//Varijable
	private List<Player> players;
	private Connection con;
	//Konstruktor
	public DataBase() {
		players = new LinkedList<Player>();
		con = null;
	}
	
	public void setPlayer2DB(Player player) {
		
		players.add(player);
		
	}	
	
	public List<Player> getAll4DB(){
		return players;
	}
	//Save baze u file
	public void saveDB2File(File file) throws IOException {
		
		Player[] plyrs = players.toArray(new Player[players.size()]);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(plyrs); // need to be Serializable base Class Player
		oos.close();
	}	
	//Citanje podataka iz file-a
	public void readData4File(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		//FileNameExtensionFilter filter = new FileNameExtensionFilter("Doc file","doc");
		
		
		try {
			Player[] plyrs = (Player[]) ois.readObject();
			players.clear();
			players.addAll(Arrays.asList(plyrs));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ois.close();
	}	
	//Konekcija
	public void connect() throws SQLException {
		System.out.println("Connecting to the Database!");
		
		try {
			//Load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Obtain connection
			String url = "jdbc:mysql://db4free.net:3306/esportsplayers"; // your database
/*Username*/String user = "testpesti";
/*Pass*/	String password = "test98tst"; 
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to -> " + con.toString());
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load driver!!!");
		}
		
	}	
	//Diskonekcija
	public void disconnect() throws SQLException {
		con.close();
		System.out.println("Disconnected!");
	}	
	
	public void save2DB() throws SQLException {
		
		//Assume that connection is successfully established
		if(con != null) {
			// SQL queries
			String cntSql = "select count(*) as count from esportsplayers where id = ?";
			String insSql = "insert into esportsplayers (id, name, sname, gaming, experience, turnament, workingTime, sponsor, notice) values (?,?,?,?,?,?,?,?,?)";////--
			String updSql = "update esportsplayers set name = ?, sname = ?, gaming = ?, experience = ?, turnament = ?, workingTime = ?, sponsor = ?, notice = ? where id = ?";//--
			//Statements
			PreparedStatement cntStm = con.prepareStatement(cntSql);
			PreparedStatement insrStm = con.prepareStatement(insSql);
			PreparedStatement updStm = con.prepareStatement(updSql);
			
			//Checking all players
			for(Player plr: players) {
				int id = plr.getId();
				String name = plr.getName();
				String sname = plr.getSname();
				GameEnum play = plr.getPlay();
				ExperienceEnum exp = plr.getExp();
				TurnamentEnum turn = plr.getTurn();
				String time = plr.getWrTme();
				String spnsr = plr.getSpnsr();//--
				String notice = plr.getNotice();//--
				
				cntStm.setInt(1, id);
				ResultSet result = cntStm.executeQuery();
				result.next();
				
				int cnt = result.getInt(1);
				System.out.println("Cnt -> " + cnt);
				
				if(cnt == 0) {
					System.out.println("Inserting new player -> " + id);
					// insert commands
					int col = 1;
					insrStm.setInt(col++, id);
					insrStm.setString(col++, name);
					insrStm.setString(col++, sname);
					insrStm.setString(col++, play.name());
					insrStm.setString(col++, exp.name());
					insrStm.setString(col++, turn.name());
					insrStm.setString(col++, time);
					insrStm.setString(col++, spnsr);//--
					insrStm.setString(col++, notice);//--
					
					insrStm.executeUpdate();
					
				} else {
					System.out.println("Updating player -> " + id);
					// update commands
					int col = 1;
					updStm.setString(col++, name);
					updStm.setString(col++, sname);
					updStm.setString(col++, play.name());
					updStm.setString(col++, exp.name());
					updStm.setString(col++, turn.name());
					updStm.setString(col++, time);
					updStm.setString(col++, spnsr);//--
					updStm.setString(col++, notice);//--
					updStm.setInt(col++, id);
					
					updStm.executeUpdate();
				}
			}
			
			cntStm.close();
			insrStm.close();
			updStm.close();


		}
		
	}	
	//Ucitaj iz baze
	public void load4DataBase() throws SQLException {
		if(con != null) {
			System.out.println("Importing the Database...");
			String slctSQL = "select id, name, sname, gaming, experience, turnament, workingTime, sponsor, notice from esportsplayers order by name ";//--
			PreparedStatement slcStm = con.prepareStatement(slctSQL);
			
			ResultSet slcResult = slcStm.executeQuery();
			players.clear();
			while(slcResult.next()) {
				int id = slcResult.getInt(1);
				String name = slcResult.getString(2);
				String sname = slcResult.getString(3);
				GameEnum play = GameEnum.valueOf(slcResult.getString(4));
				ExperienceEnum exp = ExperienceEnum.valueOf(slcResult.getString(5));
				TurnamentEnum turn = TurnamentEnum.valueOf(slcResult.getString(6));
				String time = slcResult.getString(7);
				String spnsr = slcResult.getString(8);//--
				String notice = slcResult.getString(9);
				Player player = new Player(id, name, sname, play, exp, turn, time, spnsr, notice);//--
				players.add(player);
			}
			
			slcResult.close();
			slcStm.close();
		}
	}
	
	public void listAll4DB() {
		System.out.println("->->->->->->-> Writing from the database finised");
		for(Player plyr : players) {
			plyr.description();
		}
	}	
	
}
