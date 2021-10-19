import lux.*;

import java.util.ArrayList;

public class Resource {
    private ArrayList<String> localActions;

    public Resource() {
    }

    public void mineResource(ArrayList<String> localActions,
                                          PositionCheck ps, Player player,
                                          map map, Unit unit) {


        for (Cell cell : map.getResourceTiles()) {

            if (cell.resource.type.equals(GameConstants.RESOURCE_TYPES.COAL) && !player.researchedCoal()) continue;
            if (cell.resource.type.equals(GameConstants.RESOURCE_TYPES.URANIUM) && !player.researchedUranium()) continue;

            if (cell.resource.type.equals(GameConstants.RESOURCE_TYPES.WOOD)) {
                goToResource(localActions, ps, cell, unit);
            }

        }



    }
    public void goToResource(ArrayList<String> localActions, PositionCheck ps,
                              Cell cell, Unit unit) {
        double dist = cell.pos.distanceTo(unit.pos);
        //distance to resource

        //if the distance from cell to the unit position is less then
        // the closest distance, then set our current distance and set
        // the closest resource cell
        if (dist < ps.getClosestDist()) {
            ps.setClosestDist(dist);
            ps.setClosestResourceTile(cell);
        }
        if (ps.getClosestResourceTile() != null) {
            //get the direction too the closest resource tile position
            Direction dir = unit.pos.directionTo(ps.getClosestResourceTile().pos);
            // move the unit in the direction towards the closest resource tile's position.
            localActions.add(unit.move(dir));
        }

    }
}
