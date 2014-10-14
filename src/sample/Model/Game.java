package sample.model;

import sample.enums.GameState;
import sample.enums.Status;

import java.util.Random;

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
    public static Game getGame()
    {
        if (gameSingleton == null)
            gameSingleton = new Game();
        return gameSingleton;
    }
    //endregion

    private GameState gameState;
    public GameState getGameState()
    {
        return gameState;
    }

    private Player[] players;
    public Player[] getPlayers()
    {
        return players;
    }
    public void setPlayer(Player[] ps )
    {
        this.players = ps;
    }

    private int currentPlayer;
    public int getCurrentPlayer()
    {
        return currentPlayer;
    }

    private int anotherPlayer()
    {
        if (currentPlayer == 0)
            return 1;
        else
            return 0;
    }
/*
    private void Play()
    {

        switch (gameState)
        {
            case MainMenu:
                //Visualiser.sayHello(); - приветствие и установка имен
                break;
            case Fight:
                while ((players[0].getHp() >= 0) && (players[1].getHp() >= 0))
                {
                    //получить параметры хода и рассчитать
                    evaluateMove();
                }
                break;
            case Ending:
                //выиграл игрок players[currentPlayer].getName();
                break;
        }
    }
*/
    public void evaluateMove()
    {
        Random random = new Random();
        currentPlayer = random.nextInt(2);
        for (int i = 0; i < players.length - 1; i++) {
            if (players[currentPlayer].getStatus() == Status.Active) {
                //hit trial
                boolean hit = random.nextInt(100) > players[currentPlayer].getMove().getAttack().getMissChance() &&
                        players[currentPlayer].getMove().getAttack().getAttackTarget() != players[anotherPlayer()].getMove().getAttack().getAttackTarget();
                if (hit) {
                    //damage
                    int dmg = players[currentPlayer].getMove().getAttack().getApproximateDamage() * (4 + random.nextInt(4)) / 10;
                    players[anotherPlayer()].changeHp(dmg);
                    //stun trial
                    boolean enemyStunned = random.nextInt(100) < players[currentPlayer].getMove().getAttack().getStunChance();
                    if (enemyStunned)
                        players[anotherPlayer()].setStatus(Status.Stunned);
                }

            }
            else players[currentPlayer].setStatus(Status.Active);
            if (players[0].getHp() <= 0 || players[1].getHp() <= 0) {
                gameState = GameState.Ending;
                break;
            }
            else
                currentPlayer = anotherPlayer();

        }

    }



}

