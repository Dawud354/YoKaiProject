package com.TextBasedInterface;

import com.github.Dawud354.GeneralMethods.BaseTextProgram;

public class ExitScreen extends BaseTextProgram {

    public ExitScreen(){
        showExitMessage();
    }

    private void showExitMessage(){
        System.err.println("Please implement the save stuff");
        print("Thank you for playing YoKai Battle!");
        print("Goodbye!");
    }
}
