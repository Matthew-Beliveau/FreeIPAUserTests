package org.UserTests;
import org.UserTests.UserTests;

public class Test {
    private static final int ARRAY_SIZE = 5;
    public static void main(String args[]) throws java.io.IOException, java.lang.InterruptedException {
        System.out.println("Testing Building and executing using Maven\n------------------------------------------");
        UserTests[] userArray = new UserTests[ARRAY_SIZE];
        for(int i = 0; i < ARRAY_SIZE; i++){
            userArray[i] = new UserTests("testuser"+i, "test", "user", "PASSWORD");
        }
        for(int i = 0; i < ARRAY_SIZE; i++){
            userArray[i].deleteUser();
        }
    }
}
