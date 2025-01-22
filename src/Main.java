
import FileManagement.*;
import GeneralMethods.BaseTextProgram;
import YoKaiCode.*;
import BattleLogic.*;


/* ***************************************
  @author    Dawud Hussain
   ****************************************/


public class Main extends BaseTextProgram {
    // calls other methods
    public static void main(String[] args) throws InterruptedException {
        message();
        startGame();

    }

    // message for user
    public static void message(){
        print("Welcome to YoKai Battle!");
        print("This is a pre alpha version of the game.");
        print("Please report any bugs to the developer.");
        print("Here you will be able to pick 3 YoKai to battle against 3 enemy YoKai.");
        print("The game will end when either your team or the enemy team is defeated.");
        print("Good luck!");
        print("--------------------");
    }

    public static void startGame() throws InterruptedException {
        Team playerTeam = getPlayerTeam();
        Team enemyTeam = getEnemyTeam();
        BattleFrontEnd battleFrontEnd = new BattleFrontEnd(playerTeam, enemyTeam);
    }

    public static YoKai loadYoKai(String yoKaiFile) {
        FileIOManager<YoKai> yoKaiFileIOManager = new FileIOManager<>();
        return yoKaiFileIOManager.load(yoKaiFile, YoKai.class);
    }

    public static String[] getYoKaiFileNames(){
        String[] yoKaiList=FileIOManager.getAllFileNames("YoKai");
        for (int i = 0; i < yoKaiList.length; i++) {
            yoKaiList[i] = yoKaiList[i].replaceFirst("[.][^.]+$", "");
        }
        return yoKaiList;
    }

    public static Team getPlayerTeam(){
        String[] yoKaiList=getYoKaiFileNames();
        print("Pick 3 YoKai to start the game");
        for (int i = 0; i < yoKaiList.length; i++) {
            print(i+1 + ". " + yoKaiList[i]);
        }
        YoKai[] yoKaiArray = new YoKai[3];
        print("Enter the number of first YoKai you want to pick");
        yoKaiArray[0] = askPlayerToPickYoKai(yoKaiList);
        print("Enter the number of second YoKai you want to pick");
        yoKaiArray[1] = askPlayerToPickYoKai(yoKaiList);
        print("Enter the number of third YoKai you want to pick");
        yoKaiArray[2] = askPlayerToPickYoKai(yoKaiList);
        return new Team(yoKaiArray);
    }

    public static YoKai askPlayerToPickYoKai(String[] yoKaiList){
        int yoKai = inputPositiveInt();
        while (yoKai < 0 || yoKai >= yoKaiList.length) {
            print("Invalid input. Please enter a number between 1 and " + (yoKaiList.length - 1));
            yoKai = inputPositiveInt();
        }
        return loadYoKai(yoKaiList[yoKai-1]);
    }

    public static Team getEnemyTeam(){
        String[] yoKaiList=getYoKaiFileNames();
        YoKai[] yoKaiArray = new YoKai[3];
        for (int i = 0; i < 3; i++) {
            int randomIndex = randomInt(0, yoKaiList.length);
            yoKaiArray[i] = loadYoKai(yoKaiList[randomIndex]);
        }
        return new Team(yoKaiArray);
    }
}