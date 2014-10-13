package sample.Model;

import sample.Enums.GameState;
import sample.Enums.Status;
import sample.Model.Action.Move;

/**
 * Created by Alexander on 10/13/2014.
 */
public class Game {
    //region Singleton
    private Game(){
        players = new Player[2];
        gameState = GameState.MainMenu;
    }
    private static Game gameSingleton;
    private static Game getGame()
    {
        if (gameSingleton == null)
            gameSingleton = new Game();
        return gameSingleton;
    }
    //endregion

    private GameState gameState;

    Player[] players;

    private Move currentMove;
    private void setMove(Move move)
    {
        this.currentMove = move;
    }

    private int anotherPlayer(int current)
    {
        if (current == 0)
            return 1;
        else
            return 0;
    }

    private void evaluateMove()
    {
        int playerNum = currentMove.getPlayer();
        if (players[playerNum].getStatus() == Status.Active)
        {
            //hit trial
            players[anotherPlayer(playerNum)].changeHp(-currentMove.getAttack().getApproximateDamage());
            //stun trial
            //....
        };
    }



}

}