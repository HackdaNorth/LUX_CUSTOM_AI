import lux.*;

import java.util.ArrayList;

public class PositionCheck {


    private Cell closestResourceTile;
    private double closestDist;
    private CityTile closestCityTile;


    public PositionCheck() {

    }

    public CityTile getCloseCity(Player player, PositionCheck ps, Unit unit) {

        if (player.cities.size() > 0) {

            City city = player.cities.values().iterator().next();

            ps.setClosestDist(999999);
            ps.setClosestCityTile(null);

            for (CityTile citytile : city.citytiles) {

                double dist = citytile.pos.distanceTo(unit.pos);
                if (dist < ps.getClosestDist()) {
                    ps.setClosestCityTile(citytile);
                    ps.setClosestDist(dist);
                }
            }
        }

        return ps.getClosestCityTile();
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