package com.github.Dawud354.BattleLogic;

public class ActionFactory {
    public BattleAction getAction(IntentMessage intentMessage) {
        return switch (intentMessage) {
            case AttackIntentMessage a -> new NextMove(a.user(), a.move(), a.target());
            case SwitchIntentMessage s -> new SwitchAction(s.active(), s.benched());
        };
    }
}
