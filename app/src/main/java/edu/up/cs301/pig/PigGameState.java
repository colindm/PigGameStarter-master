package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

//extend the GameState class in edu.up.cs301.game.infoMsg package
public class PigGameState extends GameState {
        //instance variables
        private int playerID;
        private int player0Score;
        private int player1Score;
        private int runningTotal;
        private int dieValue;

        //constructor
        public PigGameState() {
            playerID = 0;
            player0Score = 0;
            player1Score = 0;
            runningTotal = 0;
            dieValue = 1;
        }

        //copy constructor
        public PigGameState(PigGameState pgs) {
            playerID = pgs.playerID;
            player0Score = pgs.player0Score;
            player1Score = pgs.player1Score;
            runningTotal = pgs.runningTotal;
            dieValue = pgs.dieValue;
        }

        //getters
        public int getPlayerID() {
            return playerID;
        }

        public int getPlayer0Score() {
            return player0Score;
        }

        public int getPlayer1Score() {
            return player1Score;
        }

        public int getRunningTotal() {
            return runningTotal;
        }

        public int getDieValue() {
            return dieValue;
        }

        //setters
        public void setPlayerID(int playerID) {
            this.playerID = playerID;
        }

        public void setPlayer0Score(int player0Score) {
            this.player0Score = player0Score;
        }

        public void setPlayer1Score(int player1Score) {
            this.player1Score = player1Score;
        }

        public void setRunningTotal(int runningTotal) {
            this.runningTotal = runningTotal;
        }

        public void setDieValue(int dieValue) {
            this.dieValue = dieValue;
        }
}