import lux.Cell;
import lux.Player;
import lux.Unit;

import java.util.ArrayList;

public class Worker {

    public void workerLogic(Player player, ArrayList<String> actions,
                              CheckDistance checkDistance) {

        // for each worker
        for (int i = 0; i < player.units.size(); i++) {
            //for each worker in units, get it
            Unit unit = player.units.get(i);
            //if unit is a worker, and its not busy continue
            if (unit.isWorker() && unit.canAct()) {
                //if the worker isn't completely full, and has space left continue
                if (unit.getCargoSpaceLeft() > 0) {
                    // if the unit is a worker and we have space in cargo,
                    // lets find the nearest resource tile and try to mine it

                    Cell tempCell = null;

                    tempCell = map.searchForResource(player,unit);

                    actions = checkDistance.closestCellDetection(
                            unit, actions, tempCell);

                } else {
                    // if unit is a worker and there is no cargo space left,
                    // and we have cities, lets return to them
                    map.checkForCityActions(player, unit, actions, checkDistance);
                }
            }
        }
    }
}
