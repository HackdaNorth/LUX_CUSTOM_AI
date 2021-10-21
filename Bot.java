import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import lux.*;

public class Bot {
  public static void main(final String[] args) throws Exception {
    Agent agent = new Agent();
    // initialize
    agent.initialize();
    while (true) {
      /** Do not edit! **/
      // wait for updates
      agent.update();

      ArrayList<String> actions = new ArrayList<>();
      GameState gameState = agent.gameState;
      /** AI Code Goes Below! **/

      Player player = gameState.players[gameState.id];
      Player opponent = gameState.players[(gameState.id + 1) % 2];
      GameMap gameMap = gameState.map;

      map map = new map();
      //generate all resources on the map
      map.generateResources(gameMap);

      //construct new classes
      PositionCheck ps = new PositionCheck();
      Resource rs = new Resource();
      Worker wk = new Worker();


      // we iterate over all our units and do something with them
      wk.workerLogic(player, map, ps, rs, actions, gameState);


      // you can add debug annotations using the static methods of the Annotate class.
      //actions.add(Annotate.circle(0, 0));

      /** AI Code Goes Above! **/

      /** Do not edit! **/
      StringBuilder commandBuilder = new StringBuilder("");
      for (int i = 0; i < actions.size(); i++) {
        if (i != 0) {
          commandBuilder.append(",");
        }
        commandBuilder.append(actions.get(i));
      }
      System.out.println(commandBuilder.toString());
      // end turn
      agent.endTurn();

    }
  }
}
