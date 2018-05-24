package org.UserTests;

import java.io.File;
import java.io.IOException;

public class Test {
    private static final int ARRAY_SIZE = 5;
    public static void main(String args[]) throws java.io.IOException, java.lang.InterruptedException {
        System.out.println("Testing Building and executing using Maven\n" +
                           "------------------------------------------");

        System.out.println("Testing making and deleting users");
        UserTests[] userArray = new UserTests[ARRAY_SIZE];
        for(int i = 0; i < ARRAY_SIZE; i++){
            userArray[i] = new UserTests("testuser"+i, "test", "user", "PASSWORD");
        }
        for(int i = 0; i < ARRAY_SIZE; i++){
            userArray[i].deleteUser();
        }

        System.out.println("Testing showing user\n" +
                           "--------------------");
        UserTests user = new UserTests("testuser", "test", "user", "PASSWORD");
        user.showUser();


        System.out.println("Testing showing user in a file\n" +
                           "------------------------------");
        try{
            File file = new File("users.txt");
            boolean fvar = file.createNewFile();
            if(fvar){
                System.out.println("File has been with users has been created");
            }
            else{
                System.out.println("File already present at te specified location");
            }
        } catch(IOException e){
            System.out.println("Exception Occurred");
            e.printStackTrace();
        }
    }
}
