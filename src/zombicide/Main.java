package zombicide;

public class Main {

	public static void main(String[] args) {

		City trainCity = new City(5, 5);
		
		if (args.length == 0) {
			City aCity = new City(5, 10);
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
		System.out.println("Plateau 'entrainement :");
		trainCity.display();
		System.out.println("");
		
		
		
	}

}
