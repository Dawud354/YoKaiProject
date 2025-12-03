package com.github.Dawud354.BattleLogic;

import com.github.Dawud354.YoKaiCode.Move;
import com.github.Dawud354.YoKaiCode.YoKai;

public class SwitchAction extends BattleAction {
    private YoKai benched;
    
    public SwitchAction(YoKai user, YoKai benched) {
        super(user, 0);
        this.benched = benched;
    }

    @Override
    public void calculatePriority() {
        setPriority(0);
    }

    @Override
    public BattleResult execute(BattleContext battleContext) {
        // Implementation for executing the switch action
        boolean result = battleContext.getPlayerTeam().swap(getUser(), benched);
        String message;
        if (result ==  true) {
            message = "switched out ";
        }else{
            message = "switch out failed";
        }
        return new SwitchResult(super.getUser().getName(), benched.getName(), result);
    }
}
