package org.nailedtothex.janken.cdi;

import org.nailedtothex.janken.cdi.JankenGameManager.JankenHand;
import org.nailedtothex.janken.cdi.JankenGameManager.JankenResult;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class JankenView implements Serializable {

    JankenHand opponentHand;
    JankenHand playerHand;
    JankenResult result;
    int wins;
    int losses;
    int draws;
    int score;
    int straightWins;

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public JankenHand getOpponentHand() {
        return opponentHand;
    }

    public JankenHand getPlayerHand() {
        return playerHand;
    }

    public JankenResult getResult() {
        return result;
    }

    public void setOpponentHand(JankenHand opponentHand) {
        this.opponentHand = opponentHand;
    }

    public void setPlayerHand(JankenHand playerHand) {
        this.playerHand = playerHand;
    }

    public void setResult(JankenResult result) {
        this.result = result;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getStraightWins() {
        return straightWins;
    }

    public void setStraightWins(int straightWins) {
        this.straightWins = straightWins;
    }
}
