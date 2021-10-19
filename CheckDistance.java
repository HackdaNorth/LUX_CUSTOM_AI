import lux.Cell;
import lux.CityTile;
import lux.Direction;
import lux.Unit;

import java.util.ArrayList;

public class CheckDistance {

     public static Cell closestResourceTile = null;
     public static double closestDist = 999999;
     public static CityTile closestCityTile = null;

    public CheckDistance(double dist, Cell closestDist, CityTile tempTile) {
        this.closestDist = dist;
        this.closestResourceTile = closestDist;
        this.closestCityTile = tempTile;
    }

    public ArrayList<String> closestCellDetection(Unit unit,
                                           ArrayList<String> actionsList,
                                           Cell tempCell) {
        //if the tile is not null, move to it
        if (tempCell != null) {
            Direction dir = unit.pos.directionTo(tempCell.pos);
            actionsList.add(unit.move(dir));
        }
        return actionsList;
    }
    public ArrayList<String> closestTileDetection(Unit unit,
                                                  ArrayList<String> actionsList,
                                                  CityTile tempTile) {
        //if the tile is not null, move to it
        if (tempTile != null) {
            Direction dir = unit.pos.directionTo(tempTile.pos);
            actionsList.add(unit.move(dir));
        }
        return actionsList;
    }
}
