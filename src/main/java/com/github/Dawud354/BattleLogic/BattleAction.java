package com.github.Dawud354.BattleLogic;

import com.github.Dawud354.YoKaiCode.YoKai;

public abstract class BattleAction implements Comparable<BattleAction> {
    private YoKai user;
    private int priority;

    public BattleAction(YoKai user) {
        this.user = user;
    }

    public YoKai getUser() {
        return user;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(BattleAction action) {
        return Integer.compare(action.priority, this.priority);
    } // END compareTo

    public abstract void execute();

}