package org.nailedtothex.janken.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class JankenStreaksManager {
    int highScore;
    int straightWins;
    final Object highScoreLock = new Object();
    final Object straightWinsLock = new Object();

    public int getHighScore() {
        synchronized (highScoreLock) {
            return highScore;
        }
    }

    public void updateHighScoreIfReach(int score) {
        synchronized (highScoreLock) {
            if (highScore < score) {
                highScore = score;
            }
        }
    }

    public int getStraightWins() {
        synchronized (straightWinsLock) {
            return straightWins;
        }
    }

    public void updateStraightWinsIfReach(int wins) {
        synchronized (straightWinsLock) {
            if (straightWins < wins) {
                straightWins = wins;
            }
        }
    }
}
