package zombicide;

public class MiniCityMain {

	public static void main(String[] args) {
		 City aCity = new City(5, 5);
		 Area r = aCity.getAreas()[0][0];
		 r.getDoor(DoorDirection.RIGHT).open();
		 Area r1 = aCity.getAreas()[0][0];
		 r1.getDoor(DoorDirection.DOWN).open();
		 Area r3 = aCity.getAreas()[0][1];
		 r3.getDoor(DoorDirection.DOWN).open();
		 aCity.display();
	}
}

