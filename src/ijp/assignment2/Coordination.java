package ijp.assignment2;

public enum Coordination {	
	 
	NORTH(0, 1),
    EAST(1, 0),
    SOUTH(0, -1),
    WEST(-1, 0);
    
 
    private Coordination(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }
 
    public int getXCoordinate() {
        return xCoordinate;
    }
 
    public int getYCoordinate() {
        return yCoordinate;
    }
    private int xCoordinate;
    private int yCoordinate;
}
