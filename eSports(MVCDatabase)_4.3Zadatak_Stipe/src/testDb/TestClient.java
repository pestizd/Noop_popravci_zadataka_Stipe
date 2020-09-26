package testDb;
//Java imports
import java.sql.SQLException;
//Package imports
import model.DataBase;
import model.ExperienceEnum;
import model.GameEnum;
import model.Player;
import model.TurnamentEnum;
//Klasa za testiranje baze
public class TestClient {
	//Main metoda
	public static void main(String[] args) {
		
		DataBase db = new DataBase();
		Player gamer1 = new Player("Stipe", "Stipic", GameEnum.WoW, ExperienceEnum.Profesional, TurnamentEnum.IntelExtremeMasters, "8hours a day", "Redbull", "Need 144hz monitor");
		Player gamer2 = new Player("Steven", "Luigi", GameEnum.SuperMario, ExperienceEnum.Veteran, TurnamentEnum.Dreamhack, "8hours a day", "AMD", "Need accommodation");
		Player gamer3 = new Player("Mirage", "Octane", GameEnum.ApexLegends, ExperienceEnum.Rookie, TurnamentEnum.eSportsWorldConvention, "4hours a day", "Samsung" , "Need a mechanical keyboard");
		Player gamer4 = new Player("Ivan", "Drago", GameEnum.SpaceInvaders, ExperienceEnum.Veteran, TurnamentEnum.EvolutionChampionshipSeries, "4hours a day", "AMD", "Need a pair of gaming glasses");
		
		/*Player gamer4 = new Player("Stipe", "Stipic", GameEnum.WoW, ExperienceEnum.Profesional, TurnamentEnum.IntelExtremeMasters, "8hours a day", "Redbull", "Need 144hz monitor");
		Player gamer3 = new Player("Steven", "Luigi", GameEnum.SuperMario, ExperienceEnum.Veteran, TurnamentEnum.Dreamhack, "8hours a day", "AMD", "Need accommodation");
		Player gamer2 = new Player("Mirage", "Octane", GameEnum.ApexLegends, ExperienceEnum.Rookie, TurnamentEnum.eSportsWorldConvention, "4hours a day", "Samsung" , "Need a mechanical keyboard");
		Player gamer1 = new Player("Ivan", "Drago", GameEnum.SpaceInvaders, ExperienceEnum.Veteran, TurnamentEnum.EvolutionChampionshipSeries, "4hours a day", "AMD", "Need a pair of gaming glasses");
		*/
		db.setPlayer2DB(gamer4);
		db.setPlayer2DB(gamer3);
		db.setPlayer2DB(gamer2);
		db.setPlayer2DB(gamer1);
		
		try {
			db.connect();
			db.save2DB();
			db.load4DataBase();
			db.listAll4DB();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			db.disconnect();
			System.out.println("Disconnected!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
