package BattleLogic;

import YoKaiCode.*;

/**
 * This class represents the next move to be executed in the battle
 * @author dawud
 * @version 1.0
 * @since 03/12/2024
 */
public class NextMove implements Comparable<NextMove> {
    private final YoKai user;
    private final BaseMove move;
    private YoKai target;
    private final int turnCount;
    private int damageForUserOutput;


    /**
     * Constructor for the class
     * @param user the YoKai that will use the move
     * @param move the move to be used
     * @param target the YoKai that will be targeted
     * @throws IllegalArgumentException if user, move or target is null
     */
    public NextMove(YoKai user, BaseMove move, YoKai target,int turnCount) {
        if (user == null || move == null || target == null) {
            throw new IllegalArgumentException("User, move and target cannot be null.");
        }
        this.user = user;
        this.move = move;
        this.target = target;
        this.turnCount = turnCount;
    } // END NextMove

    /**
     * @return the user
     */
    public YoKai getUser() {
        return user;
    } // END getUser

    /**
     * @return the move
     */
    public BaseMove getMove() {
        return move;
    } // END getMove

    /**
     * @return the target
     */
    public YoKai getTarget() {
        return target;
    } // END getTarget

    // this is to help battle front end know how much damage the move did
    public int getDamageForUserOutput() {
        return damageForUserOutput;
    }

    public void setDamageForUserOutput(int damageForUserOutput) {
        this.damageForUserOutput = damageForUserOutput;
    }

    /**
     *  allows target to be changed
     *
     */
    public void changeTarget(YoKai target) {
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null.");
        }
        this.target = target;
    } // END setTarget

    @Override
    public int compareTo(NextMove nextMove) {
        if (this.turnCount != nextMove.turnCount) {
            return Integer.compare(this.turnCount, nextMove.turnCount); // Lower turn count comes first
        }
        else {
            return Integer.compare(nextMove.user.getSpeed(),this.user.getSpeed()); // Higher speed comes first
        }
    } // END compareTo

    @Override
    public String toString() {
        return user.getName() + " will use " + move.getName() + " on " + target.getName();
    } // END toString

}
