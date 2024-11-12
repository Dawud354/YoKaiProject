import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class YoKaiFileIO extends BaseFileIOTextProgram{
/*    // opens file and loads the data to a yo kai record
    //
    public static YoKai loadYoKai(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        // first line contains name, hp, strength, friendship value and day
        String line = reader.readLine();
        String[] yoKaiData = line.split(",");
        YoKai yoKai = new YoKai(yoKaiData[0],Integer.parseInt(yoKaiData[1]),Integer.parseInt(yoKaiData[2]));
        reader.close();
        return yoKai;
    } // END loadYoKai

    // saves users yo kai to file
    //
    public static boolean saveYoKai(YoKai yoKai,int day,String filePath) throws IOException {
        // creates string for data to write
        String lineOne = yoKai.getName() +","+ yoKai.getHp() +","+ yoKai.getStrength() +","+ yoKai.getFriendshipValue() +","+day;


        PrintWriter pw = new PrintWriter( new PrintWriter(filePath));
        pw.println(lineOne);

        pw.close();
        return true;
    } // END saveYoKai

    // Represents one day in the game
    //
    public static YoKai day(YoKai yoKai, int day) throws IOException {
        print("***********************************");
        print("It is day " + day + ".");
        displayOptions();

        // Calls relevant functions depending on the choice
        for (int i = 1; i <= 3; i++) {
            int choice = getOption();
            if (choice == 1) {
                yoKai = feed(yoKai);
                displayHealth(yoKai);
            } else if (choice == 2) {
                yoKai = train(yoKai);
                displayStrength(yoKai);
            } else if (choice == 3) {
                yoKai = play(yoKai);
            } else {
                print("Not a valid option");
            }
        }

        // Starts fight at end of day
        print("**********************");
        yoKai = fight(yoKai);
        displayHealth(yoKai);
        return yoKai;
    } // END day
*/
}
