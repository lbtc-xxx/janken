package org.nailedtothex.janken.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class JankenGameManager {

    /**
     * taken from http://staku.designbits.jp/check-janken/
     */
    JankenResult judge(JankenHand hand1, JankenHand hand2) {
        int a = hand1.ordinal();
        int b = hand2.ordinal();
        return JankenResult.values()[(a - b + 3) % 3];
    }

    JankenHand randomHand() {
        return JankenHand.values()[(int) (Math.random() * 3)];
    }

    public enum JankenHand {
        ROCK("ぐー"), SCISSORS("ちょき"), PAPER("ぱー");

        private String label;

        JankenHand(String label) {
            this.label = label;
        }
        public String getLabel() {
            return label;
        }
    }

    public enum JankenResult {
        DRAW("引き分け"), LOSE("あなたの負け"), WIN("あなたの勝ち");

        private String label;

        JankenResult(String label) {
            this.label = label;
        }
        public String getLabel() {
            return label;
        }
    }
}
