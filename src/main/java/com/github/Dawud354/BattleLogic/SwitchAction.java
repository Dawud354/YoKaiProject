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
    public MoveResult execute(BattleContext battleContext) {
        // Implementation for executing the switch action
        boolean result = battleContext.getPlayerTeam().swap(getUser(), benched);
        MoveResult moveResult;
        if (result ==  true) {
            moveResult = new MoveResult(getUser().getName(), benched.getName(), "Switch", 0, 0);
        }else{
            moveResult = new MoveResult(getUser().getName(), benched.getName(), "Switch Failed", 0, 0);
        }
        return moveResult;  
    }
}
