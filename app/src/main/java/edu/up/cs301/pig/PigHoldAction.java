package edu.up.cs301.pig;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import android.util.Log;

public class PigHoldAction extends GameAction{
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */

    public PigHoldAction(GamePlayer player) {
        super(player);
//        log
        Log.d("PigHoldAction", "PigHoldAction constructor called");
    }
}
