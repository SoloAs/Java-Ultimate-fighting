package sample;

import sample.enums.GameState;
import sample.model.Game;
import sample.model.Player;
import sample.model.action.Attack;
import sample.model.action.Defense;
import sample.model.action.Move;
import sample.other.MoveAttributes;

public class Controller {

    //region Singleton
    private Controller(){
        game = Game.getGame();
        visualiser = Visualiser.getVisualiser();
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

    public void Play()
    {

        switch (game.getGameState())
        {
            case MainMenu:
                visualiser.sayHello();
                String[] names = visualiser.getNames();
                game.getPlayers()[0].setName(names[0]);
                game.getPlayers()[1].setName(names[1]);
                game.setGameState(GameState.Fight);
                break;

            case Fight:
                MoveAttributes ma = new MoveAttributes();
                game.setCurrentPlayer();
                while ((game.getPlayers()[0].getHp() >= 0) && (game.getPlayers()[1].getHp() >= 0))
                {

                    //получить параметры хода и рассчитать
                    visualiser.outStatus(game.getPlayers()[game.getCurrentPlayer()]);
                    ma = visualiser.getMove();
                    game.getPlayers()[0].setMove(new Move(new Defense(ma.getDefenseTarget()),
                                                          new Attack(ma.getAttackTarget(), ma.getAttackType())));

                    visualiser.outStatus(game.getPlayers()[game.anotherPlayer()]);
                    ma = visualiser.getMove();
                    game.getPlayers()[1].setMove(new Move(new Defense(ma.getDefenseTarget()),
                                                          new Attack(ma.getAttackTarget(), ma.getAttackType())));


                    game.evaluateMove();

                }
                game.setGameState(GameState.Ending);
                break;

            case Ending:
                visualiser.writeWinner(game.getPlayers()[game.getCurrentPlayer()].getName());
                break;
        }
    }

}
