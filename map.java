import lux.*;

import java.util.ArrayList;

public class map {
    public static ArrayList<Cell> resourceTiles = new ArrayList<>();

    public static ArrayList<Cell> generateMap(GameMap gameMap) {
        for (int y = 0; y < gameMap.height; y++) {
            for (int x = 0; x < gameMap.width; x++) {
                Cell cell = gameMap.getCell(x, y);
                if (cell.hasResource()) {
                    resourceTiles.add(cell);
                }
            }
        }
        return resourceTiles;
    }

    public static Cell searchForResource(Player player, Unit unit) {
        for (Cell cell : map.resourceTiles) {
            //for each cell in the resourceTile map,
            // search for specific resources
            if (cell.resource.type
                    .equals(GameConstants.RESOURCE_TYPES.COAL)
                    && !player.researchedCoal()) continue;

            if (cell.resource.type
                    .equals(GameConstants.RESOURCE_TYPES.URANIUM)
                    && !player.researchedUranium()) continue;

            //check the distance of the cell closest
            double dist = cell.pos.distanceTo(unit.pos);

            // if the dist is within closest distance, equal it.
            if (dist < CheckDistance.closestDist) {
                CheckDistance.closestDist = dist;
                CheckDistance.closestResourceTile = cell;
            }
        }
        return CheckDistance.closestResourceTile;
    }
    public static ArrayList<String> checkForCityActions(Player player,
                                                       Unit unit ,
                               ArrayList<String> actions,
                               CheckDistance checkDistance) {

        //check if we have cities
        if (player.cities.size() > 0) {
            // get the players number of cities
            City city = player.cities.values().iterator().next();

            //for each city tile in our list of city tiles, get each distance
            for (CityTile citytile : city.citytiles) {
                double dist = citytile.pos.distanceTo(unit.pos);
                //decide which one is the closest city, and move to it
                if (dist < CheckDistance.closestDist) {
                    CheckDistance.closestCityTile = citytile;
                    CheckDistance.closestDist = dist;
                }
            }

            // if its not null, move to the city.
            actions = checkDistance.closestTileDetection(
                    unit, actions, CheckDistance.closestCityTile);

        }
        return actions;
    }

}
