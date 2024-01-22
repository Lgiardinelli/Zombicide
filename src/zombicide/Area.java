package zombicide;

public abstract class Area {
	
	private int posX;
	private int posY;
	private List<Survivor> survivors;
	private List<Zombie> zombies;
	private int noise;
	
	/**
	 * Constructor of area
	 * @param posX - int - the position X of this Cell
	 * @param posY - int - the position Y of this Cell
	 */
	public Area(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.survivors = new ArrayList<Survivor>();
		this.zombies = new Arraylist<Zombie>();
		this.noise = 0;
	}
	
	/**
	 * Get the position X
	 * @return int 
	 */
	public int getX() {
		return this.getX();
	}
	
	/**
	 * Get the position Y
	 * @return int 
	 */
	public int getY() {
		return this.getY();
	}
	
	/**
	 * the cell accepts the fight or not
	 * @return true if there can be a fight no otherwise
	 */
	public boolean canFight() {
		return true;
	}
	
}
