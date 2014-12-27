package org.nailedtothex.janken.cdi;

import org.junit.Test;
import org.nailedtothex.janken.cdi.JankenGameManager.JankenHand;
import org.nailedtothex.janken.cdi.JankenGameManager.JankenResult;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JankenGameManagerTest {

    JankenGameManager instance = new JankenGameManager();

    @Test
    public void testSCISSORS_SCISSORS() throws Exception {
        assertThat(instance.judge(JankenHand.SCISSORS, JankenHand.SCISSORS), is(JankenResult.DRAW));
    }

    @Test
    public void testSCISSORS_ROCK() throws Exception {
        assertThat(instance.judge(JankenHand.SCISSORS, JankenHand.ROCK), is(JankenResult.LOSE));
    }

    @Test
    public void testSCISSORS_PAPER() throws Exception {
        assertThat(instance.judge(JankenHand.SCISSORS, JankenHand.PAPER), is(JankenResult.WIN));
    }

    @Test
    public void testROCK_SCISSORS() throws Exception {
        assertThat(instance.judge(JankenHand.ROCK, JankenHand.SCISSORS), is(JankenResult.WIN));
    }

    @Test
    public void testROCK_ROCK() throws Exception {
        assertThat(instance.judge(JankenHand.ROCK, JankenHand.ROCK), is(JankenResult.DRAW));
    }

    @Test
    public void testROCK_PAPER() throws Exception {
        assertThat(instance.judge(JankenHand.ROCK, JankenHand.PAPER), is(JankenResult.LOSE));
    }


    @Test
    public void testPAPER_SCISSORS() throws Exception {
        assertThat(instance.judge(JankenHand.PAPER, JankenHand.SCISSORS), is(JankenResult.LOSE));
    }

    @Test
    public void testPAPER_ROCK() throws Exception {
        assertThat(instance.judge(JankenHand.PAPER, JankenHand.ROCK), is(JankenResult.WIN));
    }

    @Test
    public void testPAPER_PAPER() throws Exception {
        assertThat(instance.judge(JankenHand.PAPER, JankenHand.PAPER), is(JankenResult.DRAW));
    }
}