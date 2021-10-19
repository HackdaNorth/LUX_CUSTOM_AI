import lux.*;

import java.util.ArrayList;

public class map {


    private ArrayList<Cell> resourceTiles = new ArrayList<>();

    public map() {

    }

    public void generateResources(GameMap gameMap) {
        for (int y = 0; y < gameMap.height; y++) {
            for (int x = 0; x < gameMap.width; x++) {
                Cell cell = gameMap.getCell(x, y);
                if (cell.hasResource()) {
                    resourceTiles.add(cell);
                }
            }
        }
    }

    public ArrayList<String> checkForCityActions(Worker worker) {
        return null;
    }

    public ArrayList<Cell> getResourceTiles() {
        return resourceTiles;
    }

    public void setResourceTiles(ArrayList<Cell> resourceTiles) {
        this.resourceTiles = resourceTiles;
    }


}
