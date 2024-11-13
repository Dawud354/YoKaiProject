public class YoKai extends BaseTextProgram {
    private String name;
    private int hp;
    static final int MAX_HP = 999;
    static final int MIN_HP = 0;
    private int strength;
    private int friendshipValue;
    private String favouriteFoodType;
    private String dislikedFoodType;

    // Constructor
    //
    YoKai(String name, int hp, int strength,String favouriteFoodType, String dislikedFoodType) {
        setName(name);
        setHp(hp);
        setStrength(strength);
        setFriendshipValue(friendshipValue);
        setFavouriteFoodType(favouriteFoodType);
        setDislikedFoodType(dislikedFoodType);

    }

    public void setName(String name){
        if (isAlphanumeric(name)){
            this.name = name;
        }
    }

    private void setHp(int hp){
        if (hp > MIN_HP && hp < MAX_HP){
            this.hp = hp;
        }
    }

    private void setStrength(int strength){
        if(strength>0 && strength<=100){
            this.strength = strength;
        }
    }

    private void setFriendshipValue(int friendshipValue){
        if(friendshipValue>0 && friendshipValue<=90){
            this.friendshipValue = friendshipValue;
        }
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
        if (this.hp < MIN_HP) {
            this.hp = MIN_HP;
        }
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
        if (this.hp > MAX_HP) {
            this.hp = MAX_HP;
        }
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
    }//END addToStrength

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        String text = "My name is "+this.name+" I like to eat: "+this.favouriteFoodType+" and I do not like: "+this.dislikedFoodType;
        return text;
    }

    // Takes in string array and record and sets the yo kais favourite food to this array
    //
    private void setFavouriteFoodType(String foodType) {
        if (isAlphanumeric(foodType)&& isStringInArray(Food.foodTypes, foodType)) {
            favouriteFoodType = foodType;
        }
        else {
            print("Not a valid food type");
        }
    } // END setFavouriteFood

    // Takes in string array and record and sets the yo kais disliked food to this array
    //
    private void setDislikedFoodType(String foodType) {
        if (isAlphanumeric(foodType)&& isStringInArray(Food.foodTypes, foodType)) {
            dislikedFoodType = foodType;
        }
        else {
            print("Not a valid food type.");
        }
    } // END setDislikedFood

    public void Feed (Food food) {
        int healing=food.getHealingPoints();
        if (food.getFoodType().equals(favouriteFoodType)) {
            print(this.name+" loved that");
            healing = (int) (healing*1.2);
        }
        else if (food.getFoodType().equals(dislikedFoodType)) {
            print(this.name+" did not love that");
            healing = (int) (healing*0.8);
        }
        addHealthToYoKai(healing);
    }

}
