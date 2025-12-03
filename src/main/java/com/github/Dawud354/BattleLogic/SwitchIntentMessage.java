package com.github.Dawud354.BattleLogic;

import com.github.Dawud354.YoKaiCode.YoKai;

public record SwitchIntentMessage(YoKai active, YoKai benched) implements IntentMessage {}
