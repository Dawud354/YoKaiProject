public class YoKai extends BaseTextProgram {
    private String name;
    private int hp;
    final int MAX_HP = 999;
    final int MIN_HP = 0;
    private int strength;
    private int friendshipValue;

    // Constructor
    //
    YoKai(String name, int hp, int strength) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.friendshipValue = 5;

    }

    // shows the Yo Kai's current HP
    //
    public int getStrength() {
        return strength;
    } //END displayHealth

    // shows the Yo Kai's current strength
    //
    public int getHealth() {
        return hp;
    } //END displayStrength

    // adds friendship amount to user's Yo Kai
    //
    public void increaseFriendshipValue(int increaseAmount) {
        // checks if numbers are positive
        // if not it does not add amount to strength
        if (this.friendshipValue < 0 || increaseAmount <= 0) {
            print("That is not a valid amount. You cannot have negative friendship");
            increaseAmount = 0;
        }

        this.friendshipValue = this.friendshipValue + increaseAmount;
        return;
    }//END increaseFriendshipValue

    // deducts amount to hp
    //
    public void deductHealthFromYoKai( int damageAmount) {
        // checks if numbers are valid
        // if not then does not subtract number from health
        if (this.hp < 0 || damageAmount <= 0) {
            print("That is not a valid damage amount. You cannot have negative health or negative damage.");
            damageAmount = 0;
        }

        this.hp = this.hp - damageAmount;
        // ensures health is not below min
        if (this.hp < this.MIN_HP) {
            this.hp = this.MIN_HP;
        }
        return ;
    }//END deductFromHealth

    // Adds amount to hp
    //
    public void addHealthToYoKai(int healingAmount) {
        // checks if numbers are valid
        // if not then does not add number to health
        if (this.hp < 0 || healingAmount <= 0) {
            print("That is not a valid healing amount. You cannot have negative health or have negative healing.");
            healingAmount = 0;
        }

        this.hp = this.hp + healingAmount;
        // ensures health is not over max
        if (this.hp > this.MAX_HP) {
            this.hp = this.MAX_HP;
        }
        return;
    }//END addToHealth

    // adds strength to user's Yo Kai
    //
    public void addStrengthToYoKai(int strengthIncrease) {
        // checks if numbers are positive
        // if not it does not add amount to strength
        if (this.strength < 0 || strengthIncrease <= 0) {
            print("That is not a valid damage amount. You cannot have negative strength or decrease strength.");
            strengthIncrease = 0;
        }

        this.strength = this.strength + strengthIncrease;
        return ;
    }//END addToStrength

    public String getName() {
        return name;
    }
}
