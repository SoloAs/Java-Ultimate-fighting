package sample;

import sample.enums.AttackResult;
import sample.enums.GameState;
import sample.enums.Status;
import sample.model.Game;
import sample.model.Player;
import sample.model.action.Attack;
import sample.model.action.Defense;
import sample.model.action.Move;
import sample.other.MoveAttributes;
import sample.other.MoveResult;

public class Controller {

    //region Singleton
    private Controller(){
        game = Game.getGame();
        visualiser = Visualiser.getVisualiser();
     //   this.moveResult = new MoveResult();
    }
    private static Controller cntrlSingleton;
    public static Controller getContrlr()
    {
        if (cntrlSingleton == null)
            cntrlSingleton = new Controller();
        return cntrlSingleton;
    }
    //endregion
    private Game game;
    private Visualiser visualiser;
 //   private MoveResult moveResult;



    public void Play() {
        while (game.getGameState() != GameState.Ending) {
            switch (game.getGameState()) {

                case MainMenu:
                    visualiser.sayHello();
                    String[] names = visualiser.getNames();
                    game.getPlayers()[0].setName(names[0]);
                    game.getPlayers()[1].setName(names[1]);
                    game.setGameState(GameState.Fight);
                    break;

                case Fight:
                    MoveAttributes ma;// = new MoveAttributes();
                    while ((game.getPlayers()[0].getHp() > 0) && (game.getPlayers()[1].getHp() > 0)) {
                        game.setCurrentPlayer();

                        //get player parameters and visualise
                        if (game.getPlayers()[game.getCurrentPlayer()].getStatus() != Status.Stunned) {
                            visualiser.printWhiteSpaces(2);

                            visualiser.outStatus(game.getPlayers()[game.getCurrentPlayer()], game.getPlayers()[game.anotherPlayer()]);
                            //setting move parameteres
                            ma = visualiser.getMove();
                            game.getPlayers()[game.getCurrentPlayer()].setMove(new Move(new Defense(ma.getDefenseTarget()),
                                                         new Attack(ma.getAttackTarget(), ma.getAttackType())));
                            visualiser.printWhiteSpaces(2);
                        }
                        if (game.getPlayers()[game.anotherPlayer()].getStatus() != Status.Stunned) {

                            visualiser.outStatus(game.getPlayers()[game.anotherPlayer()], game.getPlayers()[game.getCurrentPlayer()]);

                            ma = visualiser.getMove();
                            game.getPlayers()[game.anotherPlayer()].setMove(new Move(new Defense(ma.getDefenseTarget()),
                                                         new Attack(ma.getAttackTarget(), ma.getAttackType())));
                            visualiser.printWhiteSpaces(2);
                        }

                        //process move and visualise it
                        visualiser.outMoveResult(game.evaluateMove());


                    }
                    game.setGameState(GameState.Ending);
                    break;

                case Ending:
                    break;
            }
        }
        visualiser.printWhiteSpaces(2);
        visualiser.outWinner(game.getPlayers()[game.getCurrentPlayer()].getName());
    }




}
