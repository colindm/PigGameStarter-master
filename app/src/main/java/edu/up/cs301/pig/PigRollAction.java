package edu.up.cs301.pig;

import android.annotation.SuppressLint;
import android.util.Log;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;


public class PigRollAction extends GameAction {
    public PigRollAction(GamePlayer player){
        super(player);
        Log.d("PigRollAction", "PigRollAction constructor called");
    }

}
