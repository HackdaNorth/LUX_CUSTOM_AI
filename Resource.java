import lux.*;

import java.util.ArrayList;

public class Resource {


    public Resource() {
    }

    public Cell getCloseResource(Unit unit, map map, Player player, PositionCheck ps) {
        ps.setClosestResourceTile(null);
        ps.setClosestDist(9999999);

        for (Cell cell : map.getResourceTiles()) {

            if (cell.resource.type.equals(GameConstants.RESOURCE_TYPES.COAL) && !player.researchedCoal()) continue;
            if (cell.resource.type.equals(GameConstants.RESOURCE_TYPES.URANIUM) && !player.researchedUranium()) continue;

            double dist = cell.pos.distanceTo(unit.pos);

            if (dist < ps.getClosestDist()) {
                ps.setClosestDist(dist);
                ps.setClosestResourceTile(cell);
            }
        }
        return ps.getClosestResourceTile();
    }



}
