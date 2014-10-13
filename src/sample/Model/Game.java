package sample.Model;

import sample.Model.Action.Move;

/**
 * Created by Alexander on 10/13/2014.
 */
public class Game {
    //region Singleton
    private Game(){

        players = new Player[2];
    }
    private static Game gameSingleton;
    private static Game getGame()
    {
        if (gameSingleton == null)
            gameSingleton = new Game();
        return gameSingleton;
    }
    //endregion

    Player[] players;

    private Move currentMove;
    private void setMove(Move move)
    {
        this.currentMove = move;
    }

    private void evaluateMove()
    {

    }



}
