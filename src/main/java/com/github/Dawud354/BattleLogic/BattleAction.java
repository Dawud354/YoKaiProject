package com.github.Dawud354.BattleLogic;

import com.github.Dawud354.YoKaiCode.YoKai;

public abstract class BattleAction {
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

    public abstract void execute();
}