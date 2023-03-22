package edu.up.cs301.pig;

import android.util.Log;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        Random rand = new Random();
        PigGameState stateCopy = new PigGameState((PigGameState)info); // Copy Game State for Comp Player

        if(stateCopy.getPlayerID() != this.playerNum){
            return;
        }
        else{
            Log.i("PigComputerPlayer", "Computer Player Turn");
            int points = stateCopy.getRunningTotal();
            if(points < 20){
                PigRollAction action = new PigRollAction(this);
                this.game.sendAction(action);
            }
            else{
                PigHoldAction action = new PigHoldAction(this);
                this.game.sendAction(action);
            }

//            int actionNum = rand.nextInt(2);
//            if(actionNum == 0){ // 0 -> Roll Action
//                PigRollAction action = new PigRollAction(this);
//                super.game.sendAction(action);
//            }
//            else{ // 1 -> Hold Action
//                PigHoldAction action = new PigHoldAction(this);
//                super.game.sendAction(action);
//            }
        }
    }//receiveInfo

}
