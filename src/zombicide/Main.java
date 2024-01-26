package zombicide;

public class Main {

	public static void main(String[] args) {
		
		City aCity = new City(7,7);
		
		aCity.display();
		
		System.out.println(aCity.getSpawnStreet().getX()+" "+aCity.getSpawnStreet().getY());
	}

}
