package org.nailedtothex.janken.cdi;

import org.nailedtothex.janken.cdi.JankenGameManager.JankenHand;
import org.nailedtothex.janken.cdi.JankenGameManager.JankenResult;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class JankenRequest {

    @Inject
    JankenGameManager game;
    @Inject
    JankenView viewBean;
    @Inject
    JankenStreaksManager streaks;

    public void deal(JankenHand playerHand) {
        final JankenHand opponent = game.randomHand();
        final JankenResult result = game.judge(playerHand, opponent);
        viewBean.setPlayerHand(playerHand);
        viewBean.setOpponentHand(opponent);
        viewBean.setResult(result);

        switch (result) {
            case WIN:
                viewBean.setScore(viewBean.getScore() + 10);
                streaks.updateHighScoreIfReach(viewBean.getScore());

                viewBean.setStraightWins(viewBean.getStraightWins() + 1);
                streaks.updateStraightWinsIfReach(viewBean.getStraightWins());

                viewBean.setWins(viewBean.getWins() + 1);
                return;
            case LOSE:
                viewBean.setLosses(viewBean.getLosses() + 1);
                break;
            case DRAW:
                viewBean.setDraws(viewBean.getDraws() + 1);
                break;
        }

        viewBean.setStraightWins(0);
    }
}
