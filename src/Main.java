
import FileManagement.FileIOManager;
import FileManagement.JsonUtil;
import GeneralMethods.BaseTextProgram;
import Items.*;
import Inventory.*;
import YoKaiCode.YoKai;
import java.util.HashMap;
import java.util.Map;

/* ***************************************
  @author    Dawud Hussain
  @SID       240062901
  @date      09 November 2024
  @version   6

    A Mythical Creature program, here they are called Yo
    Kai. At this level it  does the whole game. It lasts
    7 "days".
    It uses a record to store the yo kai.
    The user can feed, play and train the yo kai.
    At the end of each day they fight another yo kai.
    It then saves the users progress to a csv.
    The aim is to survive 7 days.
   ****************************************/


public class Main extends BaseTextProgram {
    // calls other methods
    public static void main(String[] args)  {
        FileIOManager<Equipment> fileIOManager = new FileIOManager<>();
        Equipment shield = fileIOManager.load("shield", Equipment.class);
        Equipment sword = fileIOManager.load("sword", Equipment.class);
        print(shield.toString());
        print(sword.toString());
    }

}