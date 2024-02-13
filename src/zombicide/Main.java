package zombicide;

public class Main {

	public static void main(String[] args) {

		City trainCity = new City(5, 5);
		
		if (args.length == 0) {
			City aCity = new City(10, 10);
			
			aCity.getAreas()[0][0].getDoor(DoorDirection.DOWN).open();
			aCity.getAreas()[0][1].getDoor(DoorDirection.DOWN).open();
			aCity.getAreas()[0][1].getDoor(DoorDirection.LEFT).open();
			
			aCity.display();
		}
		else {
			int x = Integer.parseInt(args[0]);
			int y = Integer.parseInt(args[1]);
			City aCity = new City(x, y);
			
			aCity.display();
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("Plateau d'entrainement :");
		
		trainCity.getAreas()[0][0].getDoor(DoorDirection.DOWN).open();
		trainCity.getAreas()[0][1].getDoor(DoorDirection.DOWN).open();
		trainCity.getAreas()[0][1].getDoor(DoorDirection.LEFT).open();
		
		trainCity.display();
		System.out.println("");
		System.out.println(trainCity.getAreas()[2][2]);
		System.out.println(trainCity.getAreas()[0][2]);
		System.out.print(trainCity.getAreas()[2][1]);
		
		
	}

}
