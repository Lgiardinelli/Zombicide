package zombicide;

public class MiniCityMain {

	public static void main(String[] args) {
		 City aCity = new City(5,5);
		 
		 int width = aCity.getWidth();
		 int height = aCity.getHeight();

		 for(int i = 0 ; i < width ; i++) {
			 for(int j = 0 ; j < height ; i++) {
				 Room r = new Room(i,j);
				 r.addAllDoors();		 
			 }
		 }
		 aCity.display();
	}
}
