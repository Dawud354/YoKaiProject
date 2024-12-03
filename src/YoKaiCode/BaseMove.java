package YoKaiCode;
import GeneralMethods.BaseTextProgram;

/**
 * This is the base class for all moves yo kai can use
 */
public abstract class BaseMove {
    String name;
    String description;
    int power;
    int accuracy;
    MoveCategory category;


    public BaseMove(String name,String description, int power, int accuracy, MoveCategory category) {
        setName(name);
        setPower(power);
        setAccuracy(accuracy);
        setDescription(description);
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public MoveCategory getCategory() {
        return category;
    }

    private void setName(String name) {
        if (BaseTextProgram.isAlphanumeric(name)) {
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("Name must be alphanumeric");
        }
    }

    private void setPower(int power) {
        if (power >= 0 && power <= 100) {
            this.power = power;
        }
        else {
            throw new IllegalArgumentException("Power must be between 0 and 100");
        }
    }

    private void setAccuracy(int accuracy) {
        if (accuracy >= 0 && accuracy <= 100) {
            this.accuracy = accuracy;
        }
        else {
            throw new IllegalArgumentException("Accuracy must be between 0 and 100");
        }
    }

    /**
     * @since 1.0
     * Checks if the parameter is alphanumeric and less than 200 characters
     * @throws IllegalArgumentException if not in range
     * @param description description of the food
     */
    private void setDescription(String description) {
        if (!BaseTextProgram.isValidSentence(description) && description.length() > 200) {
            throw new IllegalArgumentException("Description must be alphanumeric and less than 200 characters");
        }
        this.description = description;
    } // end setDescription

}
