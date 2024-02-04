package zombicide;

public class MiniCityMain {

	public static void main(String[] args) {
		 City aCity = new City(10,10);
		 Room r = (Room) aCity.getAreas()[0][0];
		 r.getDoor(DoorDirection.DOWN).open();
		 Room r1 = (Room) aCity.getAreas()[0][5];
		 r1.getDoor(DoorDirection.DOWN).open();
		 Room r2 = (Room) aCity.getAreas()[2][6];
		 r2.getDoor(DoorDirection.DOWN).open();
		 aCity.display();
	}
}
