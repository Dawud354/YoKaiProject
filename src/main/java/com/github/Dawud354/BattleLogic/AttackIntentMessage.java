package com.github.Dawud354.BattleLogic;

import com.github.Dawud354.YoKaiCode.Move;
import com.github.Dawud354.YoKaiCode.YoKai;

public record AttackIntentMessage(YoKai user, Move move, YoKai target) implements IntentMessage {}
