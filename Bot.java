import java.util.ArrayList;

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

      //create a new resource tile
      CheckDistance checkDistance = new CheckDistance(
              99999, null, null);

      Player player = gameState.players[gameState.id];
      Player opponent = gameState.players[(gameState.id + 1) % 2];
      GameMap gameMap = gameState.map;

      map.generateMap(gameMap);

      Worker newWorker = new Worker();
      newWorker.workerLogic(player, actions, checkDistance);


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
