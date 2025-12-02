package com.github.Dawud354.BattleLogic;

import com.github.Dawud354.YoKaiCode.Move;
import com.github.Dawud354.YoKaiCode.YoKai;

public abstract class BattleAction implements Comparable<BattleAction> {
    private YoKai user;
    private int priority;

    public BattleAction(YoKai user, int priority) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        this.user = user;
        this.priority = priority;
    }

    public YoKai getUser() {
        return user;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(BattleAction action) {
        return Integer.compare(action.priority, this.priority);
    } // END compareTo

    public abstract MoveResult execute(BattleContext battleContext);
    public abstract void calculatePriority();
}