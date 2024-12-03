package YoKaiCode;

public class PhysicalMove extends BaseMove {
    public PhysicalMove(String name,String description, int power, int accuracy) {
        super(name,description, power, accuracy, MoveCategory.PHYSICAL);
    }
}
