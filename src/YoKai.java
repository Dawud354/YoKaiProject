/*
 * This is the Yo Kai class for my program
 * @author dawud
 * @version 1.1
 * @since 16/11/2024
 */
public class YoKai extends BaseTextProgram {
    private String name;
    static final int BASE_MAX_HP = 999;
    static final int BASE_MIN_HP = 0;
    private int maxHP;
    private int currentHP;
    private int strength;
    private int friendshipValue;
    private FoodTypes favouriteFoodType;
    private FoodTypes dislikedFoodType;
    private YoKaiTribes tribe;

    /**
     * @since 1.0
     * Constructor for the class
     * @param name name of the Yo Kai
     * @param maxHP max hp of Yo Kai
     * @param currentHP how much hp Yo Kai has, must be less than or equal to  maxHP
     * @param strength how much hit power Yo Kai has
     * @param favouriteFoodType what type of food it likes
     * @param dislikedFoodType what type of food it dislikes
     */
    YoKai(String name, int maxHP, int currentHP,int strength,FoodTypes favouriteFoodType, FoodTypes dislikedFoodType,YoKaiTribes tribe){
        setName(name);
        setMaxHP(maxHP);
        setCurrentHP(currentHP);
        setStrength(strength);
        setFriendshipValue(friendshipValue);
        setFavouriteFoodType(favouriteFoodType);
        setDislikedFoodType(dislikedFoodType);
        setTribe(tribe);
    } // END YoKai

    /**
     * @since 1.0
     * Set the name of the Yo Kai. Checks if it is alphanumeric
     * @param name new name of Yo Kai
     */
    private void setName(String name){
        if (isAlphanumeric(name)){
            this.name = name;
        }
    } // END setName

    /**
     * @since 1.0
     * @return name of Yo Kai
     */
    public String getName() {return name;} // END getName

    /**
     * @since 1.0
     * Checks if hp is between max and min before setting
     * @param hp hp of YoKai
     */
    private void setMaxHP(int hp){
        if (hp > BASE_MIN_HP && hp < BASE_MAX_HP){
            this.maxHP = hp;
        }
    } // END setMaxHP

    /**
     * @since 1.0
     * checks if hp is less than or equal to maxHP before setting
     * @param hp current hp of Yo Kai
     */
    private void setCurrentHP(int hp){
        if (hp>=0 && hp <=maxHP){
            this.currentHP = hp;
        }
    } // END setCurrentHP

    /**
     * @since 1.0
     * @return max hp of Yo Kai
     */
    public int getMaxHP() {return maxHP;} //END getMaxHP

    /**
     * @since 1.0
     * @return current hp of Yo Kai
     */
    public int getCurrentHP() {return currentHP;}//END getCurrentHP


    /**
     * @since 1.0
     * Checks if damage is positive. If negative does nothing to HP
     * If health becomes negative from damage makes it 0
     * @param damageAmount amount of damage
     */
    public void deductHealthFromYoKai(int damageAmount) {
        // checks if numbers are valid
        // if not then does not subtract number from health
        if (damageAmount <= 0) {
            print("That is not a valid damage amount. You cannot have negative damage.");
        }
        else {
            int newHealth = currentHP - damageAmount;
            // makes health 0 if negative
            if (newHealth <= 0) {
                newHealth = 0;
            }
            setCurrentHP(newHealth);
        }


    }//END deductFromHealth

    /**
     * Adds hp to Yo Kai. Checks if healing amount is positive
     * When healing is done checks if above maxHP and if so caps currentHP
     * @since 1.0
     * @param healingAmount amount of healing, checks if positive
     */
    public void addHealthToYoKai(int healingAmount) {
        // checks if numbers are valid
        // if not then does not add number to health
        if (healingAmount <= 0) {
            print("That is not a valid healing amount. You cannot have negative healing.");
        }
        else {
            int newHealth = currentHP + healingAmount;
            if (newHealth > maxHP) {
                newHealth = maxHP;
            }
            setCurrentHP(newHealth);
        }
    }//END addToHealth

    /**
     * @since 1.0
     * Makes sure strength is more than 0 before setting
     * @param strength strength of Yo Kai
     */
    private void setStrength(int strength){
        if(strength>0){
            this.strength = strength;
        }
    } // END setStrength

    /**
     * @since 1.0
     * @return strength of Yo Kai
     */
    public int getStrength() {return strength;} //END displayStrength


    /**
     * @since 1.0
     * Makes sure friendshipValue is between 0 and 90. This helps users to avoid abusing it
     * @param friendshipValue current friendship value of Yo Kai
     */
    private void setFriendshipValue(int friendshipValue){
        if(friendshipValue>0 && friendshipValue<=90){
            this.friendshipValue = friendshipValue;
        }
    } // END setFriendshipValue

    /**
     * @since 1.0
     * checks if increase is positive before adding
     * @param increaseAmount how much to increase friendship value by, checks if positive
     */
    public void increaseFriendshipValue(int increaseAmount) {
        // checks if numbers are positive
        // if not it does not add amount to strength
        if (increaseAmount <= 0) {
            print("That is not a valid amount. You cannot have negative friendship");
        }
        else {
            setFriendshipValue(friendshipValue + increaseAmount);
        }
    }//END increaseFriendshipValue

    /**
     * @since 1.0
     * checks if increase amount is positive before adding
     * @param strengthIncrease how much to increase strength value by, checks if positive
     */
    public void addStrengthToYoKai(int strengthIncrease) {
        // checks if numbers are positive
        // if not it does not add amount to strength
        if (strengthIncrease <= 0) {
            print("That is not a valid damage amount. You cannot have negative strength or decrease strength.");
        }
        else {
            setStrength(strength + strengthIncrease);
        }
    }//END addToStrength

    /**
     * @since 1.0
     * Returns name, likes food and disliked food
     * @return Yo Kai as a string
     */
    @Override
    public String toString() {
        String text = "My name is "+this.name+" I like to eat: "+this.favouriteFoodType+" and I do not like: "+this.dislikedFoodType;
        return text;
    } // End toString

    /**
     * @since 1.0
     * Checks if food passed in is in valid food types
     * @param foodType what food type Yo Kai likes
     */
    private void setFavouriteFoodType(FoodTypes foodType) {
        if (foodType != null) {
            favouriteFoodType = foodType;
        }
        else {
            print("Not a valid food type");
        }

    } // END setFavouriteFood

    /**
     * @since 1.0
     * Checks if food passed in is in valid food types
     * @param foodType what food the yo kai dislikes
     */
    private void setDislikedFoodType(FoodTypes foodType) {
        if (foodType != null) {
            dislikedFoodType = foodType;
        }
        else {
            print("Not a valid food type.");
        }
    } // END setDislikedFood

    /**
     * @since 1.0
     * Changes healing amount depending on whether Yo Kai likes the food or not
     * @param food Food object to pass in
     */
    public void feed (Food food) {
        int healing=food.getHealingPoints();
        if (food.getFoodType() == favouriteFoodType) {
            print(this.name+" loved that");
            healing = (int) (healing*1.2);
        }
        else if (food.getFoodType() ==  dislikedFoodType) {
            print(this.name+" did not like that");
            healing = (int) (healing*0.8);
        }
        else {
            print(this.name+" found the food o.k");
        }
        addHealthToYoKai(healing);
    }// END Feed

    /**
     * @since 1.0
     * @return what tribe the Yo Kai is in
     */
    public String getTribe() {
        return tribe.toString();
    } // END getTribe

    /**
     * @since 1.0
     * Checks if the tribe passed in is a valid tribe before setting
     * @param tribe type of tribe
     */
    public void setTribe(YoKaiTribes tribe) {
        if (tribe != null ) {
            this.tribe = tribe;
        }
    } // END setTribe
}
