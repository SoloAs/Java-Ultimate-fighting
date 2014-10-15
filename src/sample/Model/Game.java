package sample.model;

import sample.enums.AttackResult;
import sample.enums.GameState;
import sample.enums.Status;
import sample.other.MoveResult;

import java.util.Random;
public class Game {
    //region Singleton
    private Game(){
        players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();
        gameState = GameState.MainMenu;
        random = new Random();
        currentPlayer = 0;
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
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
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

    private Random random;

    public void setCurrentPlayer()
    {
        currentPlayer = random.nextInt(2);
    }

    public int anotherPlayer()
    {
        if (currentPlayer == 0)
            return 1;
        else
            return 0;
    }

    public MoveResult[] evaluateMove()
    {
       // setCurrentPlayer(); //random person making first move
        MoveResult[] results = new MoveResult[]{new MoveResult(), new MoveResult()};
        boolean hit = false;
        boolean enemyStunned = false;
        int dmg = 0;
        AttackResult attackResult;//.. = AttackResult.Missed;

        for (int i = 0; i < players.length; i++) {
            if (players[currentPlayer].getStatus() == Status.Active) {

                //hit trial
                hit =  players[currentPlayer].getMove().getAttack().getAttackTarget() != players[anotherPlayer()].getMove().getDefense().getDefenseTarget();
                if (!hit)
                    attackResult = AttackResult.Blocked;
                else {
                    hit = random.nextInt(100) > players[currentPlayer].getMove().getAttack().getMissChance();
                    if (!hit)
                        attackResult = AttackResult.Missed;
                    else
                        attackResult = AttackResult.Succeeded;
                }

                if (hit) {
                    //damage counting
                    dmg = players[currentPlayer].getMove().getAttack().getApproximateDamage() * (4 + random.nextInt(4)) / 10;
                    players[anotherPlayer()].changeHp(-dmg);

                    //stun trial
                    enemyStunned = random.nextInt(100) < players[currentPlayer].getMove().getAttack().getStunChance();
                    if (enemyStunned)
                        players[anotherPlayer()].setStatus(Status.Stunned);

                }

            }
            else {
                //changing status from stunned to active
                players[currentPlayer].setStatus(Status.Active);
                attackResult = AttackResult.Not_realised;
            }
            //forming visualising info
      //      if (players[i].getHp() > 0)
               results[i] = new MoveResult(attackResult, enemyStunned, dmg, players[currentPlayer].getName());
            if (players[0].getHp() <= 0 || players[1].getHp() <= 0) {
                if (players[0].getHp() > 0)  //at last, current player is winner
                    currentPlayer = 0;
                else
                    currentPlayer = 1;
                gameState = GameState.Ending;
                break;
            }
            else
                currentPlayer = anotherPlayer();

        }
       // if (gameState == GameState.Ending)
       //     results[currentPlayer].setDamage(-1);
        return results;



    }



}

