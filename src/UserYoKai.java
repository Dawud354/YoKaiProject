public class UserYoKai extends YoKai{

    final int MAX_NUMBER_FAVOURITE_FOOD = 3;
    final int MAX_NUMBER_DISLIKED_FOOD = 3;

    private String[] favouriteFood = new String[MAX_NUMBER_FAVOURITE_FOOD];
    private String[] dislikedFood = new String[MAX_NUMBER_DISLIKED_FOOD];

    UserYoKai(String name, int hp, int strength,String[] favouriteFood, String[] dislikedFood){
        super(name, hp, strength);
        setFavouriteFood(favouriteFood);
        setDislikedFood(dislikedFood);
    }

    //Allows Yo Kai to be printed as a string

    public void yoKaiAsString() {
        print("***********************************");
        print("My name is " + this.getName());

        print("I like to eat:");
        for (int i = 0; i < this.MAX_NUMBER_FAVOURITE_FOOD; i++) {
            print("- " + this.favouriteFood[i]);
        }

        print("I do not like to eat");
        for (int i = 0; i < this.MAX_NUMBER_DISLIKED_FOOD; i++) {
            print("- " + this.dislikedFood[i]);
        }

        print("***********************************");
    }

    // Takes in string array and record and sets the yo kais favourite food to this array
    //
    public void setFavouriteFood(String[] favouriteFood) {
        if (this.favouriteFood.length == favouriteFood.length) {
            for (int i = 0; i < this.favouriteFood.length; i++) {
                this.favouriteFood[i] = favouriteFood[i];
            }
        }
        else {
            print("Arrays are not the same length");
        }
        return;
    } // END setFavouriteFood

    // Takes in string array and record and sets the yo kais disliked food to this array
    //
    public void setDislikedFood(String[] dislikedFood) {
        if (this.dislikedFood.length == dislikedFood.length) {
            for (int i = 0; i < this.favouriteFood.length; i++) {
                this.dislikedFood[i] = dislikedFood[i];
            }
        }
        else {
            print("Arrays are not the same length");
        }
        return ;
    } // END setDislikedFood


}
