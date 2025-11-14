package com.github.Dawud354.YoKaiCode;

public enum SecondaryEffect {
    NONE,
    BURN,
    POISON,
    PARALYZE,
    FREEZE,
    SLEEP,
    CONFUSE,
    FLINCH,
    SLOW,
    HEAL,
    BOOST_STAT,
    LOWER_STAT;

    // Optionally, you can add additional properties or methods to handle behavior
    private String description;

    static {
        NONE.description = "No secondary effect.";
        BURN.description = "Inflicts burn, reducing HP each turn.";
        POISON.description = "Inflicts poison, reducing HP each turn.";
        PARALYZE.description = "May prevent the target from acting.";
        FREEZE.description = "Freezes the target, preventing action.";
        SLEEP.description = "Puts the target to sleep for several turns.";
        CONFUSE.description = "May cause the target to hurt itself.";
        FLINCH.description = "Prevents the target from acting this turn.";
        SLOW.description = "Lowers the target's speed.";
        HEAL.description = "Restores HP.";
        BOOST_STAT.description = "Raises one or more stats.";
        LOWER_STAT.description = "Lowers one or more stats.";
    }

    public String getDescription() {
        return description;
    }
}
