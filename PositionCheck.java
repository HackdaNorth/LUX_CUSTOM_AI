import lux.Cell;
import lux.CityTile;
import lux.Direction;
import lux.Unit;

import java.util.ArrayList;

public class PositionCheck {


    private Cell closestResourceTile;
    private double closestDist;
    private CityTile closestCityTile;


    public PositionCheck() {

    }

    public Cell getClosestResourceTile() {
        return closestResourceTile;
    }

    public void setClosestResourceTile(Cell closestResourceTile) {
        this.closestResourceTile = closestResourceTile;
    }

    public double getClosestDist() {
        return closestDist;
    }

    public void setClosestDist(double closestDist) {
        this.closestDist = closestDist;
    }

    public CityTile getClosestCityTile() {
        return closestCityTile;
    }

    public void setClosestCityTile(CityTile closestCityTile) {
        this.closestCityTile = closestCityTile;
    }

}