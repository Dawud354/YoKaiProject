package com.TextBasedInterface;

import com.github.Dawud354.GeneralMethods.BaseTextProgram;

public class HomeScreen extends BaseTextProgram {

    public HomeScreen() {
        showOptions();
        int choice = getOptions();
        goToChoice(choice);
    }


    private void showOptions(){
        print("What would you like to do?");
        print("1. Battle");
        print("2. Manage Inventory");
        print("3. Train Yo Kai");
        print("4. Exit");
        print("Please enter your choice (1-4):");
    }

    private int getOptions(){
        int choice =  inputPositiveInt();
        while (choice < 1 || choice > 4) {
            print("Invalid choice. Please enter a number between 1 and 4:");
            choice = inputPositiveInt();
        }
        return choice;
    }

    private void goToChoice(int choice){
        try {
            switch (choice) {
                case 1:
                    SceneManager.goBattle();
                case 2:
                    SceneManager.goInventory();
                case 3:
                    SceneManager.goTrain();
                case 4:
                    SceneManager.goExit();
                default:
                    SceneManager.goHome();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        // message for user
    public void Welcomemessage(){
        print("Welcome to YoKai Battle!");
        print("This is a pre alpha version of the game.");
        print("Please report any bugs to the developer.");
        print("Here you will be able to pick 3 YoKai to battle against 3 enemy YoKai.");
        print("The game will end when either your team or the enemy team is defeated.");
        print("Good luck!");
        print("--------------------");
    }
}
