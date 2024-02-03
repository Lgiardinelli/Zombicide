package zombicide;

public class MiniCityMain {

	public static void main(String[] args) {
		 City aCity = new City(5,5);
		 
		 int width = aCity.getWidth();
		 int height = aCity.getHeight();

		 for(int i = 0 ; i < height ; i++) {
			 for(int j = 0 ; j < width ; j++) {
				 Room r = new Room(i,j);
			 }
		 }
		 aCity.display();
	}
}
