/**
 * This class is used to feed the YoKai
 * @version 1.0
 * @since 19/11/2024
 * @see YoKai
 * @see Food
 * @author dawud
 */
public class FoodPreferences extends BaseTextProgram {
    private FoodTypes favouriteFood;
    private FoodTypes dislikedFood;

    /**
     * @since 1.0
     * Constructor for the class
     * @param favouriteFood the favourite food of the YoKai
     * @param leastFavouriteFood the least favourite food of the YoKai
     */
    FoodPreferences(FoodTypes favouriteFood, FoodTypes leastFavouriteFood){
        setFavouriteFoodType(favouriteFood);
        setDislikedFoodType(leastFavouriteFood);
    } // END FoodPreferences

    /**
     * @since 1.0
     * @return the favouriteFood
     */
    public FoodTypes getFavouriteFood() {
        return favouriteFood;
    } // END getFavouriteFood

    /**
     * @since 1.0
     * @return the dislikedFood
     */
    public FoodTypes getDislikedFood() {
        return dislikedFood;
    } // END getDislikedFood

    /**
     * @since 1.0
     * Checks if the food type passed in is the same as the favourite food
     * @param foodType the food type to check
     * @return true if the food type is the same as the favourite food
     */
    public boolean likesFood(FoodTypes foodType){
        return favouriteFood == foodType;
    } // END likesFood

    /**
     * @since 1.0
     * Checks if the food type passed in is the same as the disliked food
     * @param foodType the food type to check
     * @return true if the food type is the same as the disliked food
     */
    public boolean dislikesFood(FoodTypes foodType){
        return dislikedFood == foodType;
    } // END dislikesFood

    /**
     * @since 1.0
     * Checks if food passed in is null before setting
     * @throws IllegalArgumentException if foodType is null
     * @param foodType what food type Yo Kai likes
     */
    private void setFavouriteFoodType(FoodTypes foodType) {
        if (foodType == null) {
            throw new IllegalArgumentException("Not a valid food type.");
        }
        favouriteFood = foodType;
    } // END setFavouriteFood

    /**
     * @since 1.0
     * Checks if food passed in is null before setting
     * @throws IllegalArgumentException if foodType is null
     * @param foodType what food the yo kai dislikes
     */
    private void setDislikedFoodType(FoodTypes foodType) {
        if (foodType == null) {
            throw new IllegalArgumentException("Not a valid food type.");
        }
        dislikedFood = foodType;
    } // END setDislikedFood

}
