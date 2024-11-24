
import java.io.IOException;

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


public class YoKaiCreature extends BaseTextProgram {
    // calls other methods
    public static void main(String[] args)  {
        yoKaiCreature7();
    }

    // calls relevant methods for program to work
    //
    public static void yoKaiCreature7() {

        YoKai jibanyan = YoKaiManager.loadYoKai("jibanyan.json");
        print(jibanyan.toString());
        //startGame();
    } // END yoKaiCreature7
/*
    // checks if the save file exists
    //
    public static boolean checkIfSaveFileExists(String filePath) throws IOException {
        File file = new File(filePath);
        return file.exists();
    } // END checkIfSaveFileExists



    // Loads what day the user is on
    //
    public static int loadDay(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        String[] yoKaiData = line.split(",");
        final int day = Integer.parseInt( yoKaiData[4]);
        return day;
    }// END loadDay

    // Asks user if they want to load their save file and returns true or false
    //
    public static boolean askUserToLoad(String filePath) throws IOException {
        boolean load=false;
        String choice = "";
        // checks if files exists and user enters a valid choice
        while (checkIfSaveFileExists(filePath) && !(choice.equals("y") || choice.equals("n"))) {
            print("Would you like to load your save? Please enter y or n");
            choice = inputString();
        }
        if (choice.equals("y")) {
            load= true;
        }
        return load;
    } // END askUserToLoad


    // calls the methods for the full game
    //
    public static void startGame() throws IOException {
        explainProgramToUser();
        String filePath = "src/userYoKai.csv";
        int day =1;
        YoKai yoKai;
        // checks if save file exists and asks user if they want to load it
        if (askUserToLoad(filePath)) {
            yoKai = loadYoKai(filePath);
            day = loadDay(filePath);

        }
        else{
            yoKai = getUserInputToMakeYoKai();
        }

        print(yoKai.toString());

        // loops 7 times at max
        // Can end early if user dies
        boolean isDead = false;
        while (day <= 7 && !isDead) {
            yoKai = day(yoKai, day);
            isDead = checkIfLost(yoKai.hp);

            // only increments and saves if not dead. Helps avoid printing errors
            if (!isDead) {
                saveYoKai(yoKai, day, filePath);
                day++;
            }
        }
        endGame(isDead, day);
    } // End startGame

    // gets user input to create yo kai record
    public static YoKai getUserInputToMakeYoKai() {
        String name;
        int hp = 100;
        int strength = 10;

        // sets yo kais details
        name = askName();
        YoKai yoKai = createYoKai(name, hp, strength);
        yoKai = FavouriteFood(yoKai);
        yoKai = DislikedFood(yoKai);
        return yoKai;
    } //  END getUserInputToMakeYoKai

    // tells user if they won or lost
    //
    public static void endGame(boolean isDead, int day) {
        print("******************************************");
        if (isDead) {
            print("You lost!");
            print("You lasted " + day + " days");
        } else {
            print("You won!");
        }
    } // END endGame

    // checks if the Yo Kai's hp is below
    //
    public static boolean checkIfLost(int hp) {
        if (hp <= 0) {
            return true;
        } else {
            return false;
        }
    }// END checkIfLost

    // This is to show the user their options
    //
    public static void displayOptions() {
        print("-----------------------------");
        print("Please pick one of the following options:");
        print("1 - Feed        2 - Train        3 - Play");
        return;
    }// END displayOptions

    // Gets the users choice
    //
    public static int getOption() {
        int[] validOptions = {1, 2, 3};

        print("******************************************");
        print("Please enter your option from the list. Please enter it as a number");
        int option = inputPositiveInt();

        // checks users choice is valid
        while (!isIntegerInArray(validOptions, option)) {
            print("Please enter a valid option");
            option = inputPositiveInt();
        }
        print("******************************************");
        return option;
    } // END getOptions


    // explain the rules of the program to the user
    //
    public static void explainProgramToUser() {
        print("******************************************");
        print("This is a program to look after mythical creatures called Yo Kai.");
        print("The game will last 7 day and you will be able to do 3 actions a day.");
        print("At the end of each day you will fight another Yo Kai");
        print("This game auto saves at the end of each day feel free to quit whenever you want");
        print("Make sure to train up your Yo Kai so you can survive all 7 days.");
        print("Enjoy and have fun!");
        print("******************************************\n");
        return;
    } //END explainProgramToUser



    // asks the user what to call the Yo Kai
    //
    public static String askName() {
        print("What is the Yo Kai's name?");
        final String name = inputString();
        return name;
    } //END askName


    // Takes in record and asks user what food the Yo Kai likes
    //
    public static YoKai FavouriteFood(YoKai yoKai) {
        final String name = getYoKaiName(yoKai);
        String[] favouriteFood = new String[3];
        print("What food does " + name + " like? Please enter 3");

        for (int i = 0; i < 3; i++) {
            print("Please enter food " + (i + 1));
            favouriteFood[i] = inputString();
        }
        yoKai = setFavouriteFood(yoKai, favouriteFood);
        return yoKai;
    }// END setFavouriteFood

    // Takes in record and asks user what food the Yo Kai does not like
    //
    public static YoKai DislikedFood(YoKai yoKai) {
        final String name = getYoKaiName(yoKai);
        String[] dislikedFood = new String[3];
        print("What food does " + name + " not like? Please enter 3");

        for (int i = 0; i < 3; i++) {
            print("Please enter food " + (i + 1));
            dislikedFood[i] = inputString();
        }
        yoKai = setDislikedFood(yoKai, dislikedFood);
        return yoKai;
    }// END setDislikedFood


    } //END yoKaiAsString

    // allows user to heal the Yo Kai
    //
    public static YoKai feed(YoKai yoKai) {
        print("What will you feed " + yoKai.name + "?");
        String food = inputString();

        // checks if food is liked or disliked
        if (isStringInArray(yoKai.favouriteFood, food)) {
            print(yoKai.name + " loved that");
            yoKai = addHealthToYoKai(yoKai, 40);
        } else if (isStringInArray(yoKai.dislikedFood, food)) {
            print(yoKai.name + " did not enjoy eating that");
            yoKai = addHealthToYoKai(yoKai, 10);
        } else {
            print(yoKai.name + " found the food o.k");
            yoKai = addHealthToYoKai(yoKai, 20);
        }

        return yoKai;
    } //END feed

    // allows user to fight other Yo Kai
    //
    public static YoKai fight(YoKai yoKai) throws IOException {
        // opens csv file and loads enemy yo kais
        YoKai[] yoKais = loadEnemyYoKai();

        // gets random yo kai to fight
        final int randomElement = randomInt(0, yoKais.length);
        yoKai = twoYoKaiFight(yoKai, yoKais[randomElement]);
        return yoKai;
    } //END fight

    // loads enemy yo kai from csv file
    //
    public static YoKai[] loadEnemyYoKai() throws IOException {
        // open file and create array
        String path = "src/yoKai.csv";
        BufferedReader br = new BufferedReader(new FileReader(path));
        int yoKaiNumber=rowsInCSV(path);
        YoKai[] yoKais = new YoKai[yoKaiNumber];

        // loads data from csv passing to create yo kai method
        String line = br.readLine();
        for (int i = 0; i < yoKaiNumber; i++) {
            String[] data = line.split(",");
            yoKais[i] = createYoKai(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            line = br.readLine();
        }
        return yoKais;
    }




    // allows user to train their Yo Kai
    //
    public static YoKai train(YoKai yoKai) {
        print(yoKai.name + " is doing 10 laps");
        print(yoKai.name + " increased their strength by 3");
        yoKai = addStrengthToYoKai(yoKai, 3);
        return yoKai;
    } //END fight


    // allows user to play with their Yo Kai
    //
    public static YoKai play(YoKai yoKai) {
        print("You took " + yoKai.name + " to the park.");
        print(yoKai.name + " seemed to look at you with more affection");
        yoKai = increaseFriendshipValue(yoKai, 3);
        return yoKai;
    } //END play


    // takes in two yo kai records and makes them fight
    //
    public void twoYoKaiFight(YoKai enemy) {
        print(this.name + " is now fighting " + enemy.name);

        while (this.hp > 0 && enemy.hp > 0) {
            // adds probability of yo kai dodging attack
            final int dodgeChance = randomInt(0, 100);
            // if dodge no damage
            if (this.friendshipValue > dodgeChance) {
                print(this.name + " dodged the attack");
            } else {
                print(this.name + " got hit by a shot and took " + enemy.strength + " damage.");
                final int damage = enemy.strength;
                deductHealthFromYoKai(damage);
            }
            print(this.name + " punched back and did " + this.strength + " damage.");

            enemy.deductHealthFromYoKai(this.strength);
        }

        if (this.hp > 0) {
            print(this.name + " defeated " + enemy.name);
        } else {
            print(this.name + " lost");
        }

        return;
    } // END twoYoKaiFight


*/




}