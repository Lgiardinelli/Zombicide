package zombicide;

import java.util.ArrayList;
import java.util.List;

public class City{


    private int width;
    private int height;
    private List<Street> streets;
    private List<Building> buildings;
    private List<Area> areas;
    
    public City(int width,int height){
		this.width=width;
		this.height=height;
		this.streets= new ArrayList<>();
		this.buildings= new ArrayList<>();
		this.areas = new ArrayList<>();
		initCity();
	}

	

	
    
}