package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState state;

    /**
     * This ctor creates a new game state
     */


    public PigLocalGame() {
        state = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(playerIdx == state.getPlayerID()){return true;}
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        // Pic Hold Action
        if(action instanceof PigHoldAction){
            if(state.getPlayerID() == 0) { // IF Player 0
                state.setPlayer0Score(state.getPlayer0Score() + state.getRunningTotal());
                state.setRunningTotal(0);
                state.setPlayerID(1);
                return true;
            }
            else{                          // IF Player 1
                state.setPlayer1Score(state.getPlayer1Score() + state.getRunningTotal());
                state.setRunningTotal(0);
                state.setPlayerID(0);
                return true;
            }

        }
        // Pig Roll Action
        if(action instanceof PigRollAction){
            Random rand = new Random();
            int roll = rand.nextInt(6) + 1;
            state.setDieValue(roll);

            if(state.getDieValue() != 1){ // IF Die is 1
                state.setRunningTotal(state.getRunningTotal() + roll);
            }
            else{                         // IF Die is not 1
                state.setRunningTotal(0);

                if(state.getPlayerID() == 0){state.setPlayerID(1);}
                else{state.setPlayerID(0);}
            }
            return true;
        }

        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
//        copy game state
        PigGameState copy = new PigGameState(state);
//        send copy to player
        p.sendInfo(copy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(state.getPlayer0Score() >= 50) {
//            get player name
//            String name = super.players[state.getPlayerID()].name;
            return "Player 0 wins! score: " + state.getPlayer0Score();
        } else if(state.getPlayer1Score() >= 50) {
            return "Player 1 wins! score: " + state.getPlayer1Score();
        } else {
            return null;
        }
    }

}// class PigLocalGame
