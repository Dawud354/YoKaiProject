package com.github.Dawud354.BattleLogic;

import com.github.Dawud354.YoKaiCode.*;

/**
 * This class represents the next move to be executed in the battle
 * @author dawud
 * @version 1.0
 * @since 03/12/2024
 */
public class NextMove extends BattleAction  {
    private final Move move;
    private YoKai target;
    

    /**
     * Constructor for the class
     * @param user the YoKai that will use the move
     * @param move the move to be used
     * @param target the YoKai that will be targeted
     * @throws IllegalArgumentException if user, move or target is null
     */
    public NextMove(YoKai user, Move move, YoKai target) {
        super(user, user.getSpeed());
        if (move == null || target == null) {
            throw new IllegalArgumentException("User, move and target cannot be null.");
        }
        this.move = move;
        this.target = target;
    } // END NextMove

    /**
     * Calculates the priority of the move based on the user's speed
     */
    @Override
    public void calculatePriority() {
        setPriority(getUser().getSpeed());
    } // END calculatePriority

    /**
     * @return the move
     */
    public Move getMove() {
        return move;
    } // END getMove

    /**
     * @return the target
     */
    public YoKai getTarget() {
        return target;
    } // END getTarget

    /**
     *  allows target to be changed
     */
    public void changeTarget(YoKai target) {
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null.");
        }
        this.target = target;
    } // END setTarget

    @Override
    public MoveResult execute() {
        // Implementation for executing the move
        MoveResult r = new MoveResult("this","is","not done",1,1);
        return r;
    }

    @Override
    public String toString() {
        return getUser().getName() + " will use " + move.getName() + " on " + target.getName();
    } // END toString

}
