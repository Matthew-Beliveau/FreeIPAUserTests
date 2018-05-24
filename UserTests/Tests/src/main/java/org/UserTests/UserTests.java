package org.UserTests;

import java.io.*;
import java.lang.*;
//import java.util.Map;

public class UserTests{

    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public UserTests() throws IOException, InterruptedException {
        username = "testuser";
        password = "PASSWORD";

        createUser();
    }

    public UserTests(String u, String f, String l, String p) throws IOException, InterruptedException {
        username = u;
        password = p;
        firstName = f;
        lastName = l;
        createUser(u, f, l, p);
    }

    public UserTests(String u, String f, String l) throws IOException, InterruptedException {
        username = u;
        firstName = f;
        lastName = l;
        createUser(u, f, l);
    }

    public void createKeytab() throws IOException, InterruptedException {
        String[] cmd = {
                "/bin/sh",
                "-c",
                "ipa-getkeytab -p $USER@$IPA_REALM -k $HOME/client.keytab -s $IPA_SERVER"
        };

        Runtime rt = Runtime.getRuntime();

        Process p = rt.exec(cmd);

        showOutPut(p);
    }


    /*
     *
     * Have to use gssproxy or be a admin user to make the next couple of methods to work
     *
     */
    private void createUser(String username, String first, String last, String password) throws IOException, InterruptedException {

        String[] cmd = {
                "/bin/sh",
                "-c",
                "echo " + password + " | ipa user-add " + username + " --first=" + first + " --last=" + last + " --password"
        };

        Runtime rt = Runtime.getRuntime();

        Process p = rt.exec(cmd);
        showOutPut(p);

    }

    private void createUser(String username, String first, String last) throws IOException, InterruptedException {

        String[] cmd = {
                "/bin/sh",
                "-c",
                "ipa user-add " + username + " --first=" + first + " --last=" + last
        };

        Runtime rt = Runtime.getRuntime();

        Process p = rt.exec(cmd);
        showOutPut(p);

    }

    private void createUser() throws IOException, InterruptedException {

        String[] cmd = {
                "/bin/sh",
                "-c",
                "echo PASSWORD | ipa user-add " + username + " --first=" + firstName + " --last=" + lastName + " --password"
        };

        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec(cmd);

        showOutPut(p);

    }

    private void deleteUser(String username) throws IOException, InterruptedException {

        String[] cmd = {
                "/bin/sh",
                "-c",
                "ipa user-del " + username
        };

        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec(cmd);

        showOutPut(p);

    }


    public void deleteUser() throws IOException, InterruptedException {

        String[] cmd = {
                "/bin/sh",
                "-c",
                "ipa user-del " + getUsername()
        };

        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec(cmd);

        showOutPut(p);

    }

    public void showUser() throws IOException, InterruptedException {
        String[] cmd = {
                "bin/sh",
                "-c",
                "ipa user-show" + getUsername()
        };

        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec(cmd);

        showOutPut(p);
    }

    public void storeShowUserInFile(File file) throws IOException, InterruptedException {
        String[] cmd = {
                "bin/sh",
                "-c",
                "ipa user-show " + getUsername() + " >>" + file.getName()
        };

        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec(cmd);

    }

    private static void showOutPut(Process p) throws IOException, InterruptedException {
        p.waitFor();
        InputStream is = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String s = null;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
        is.close();

    }

    public String getUsername(){ return username; }
    private void setUsername(String u) { username = u; }
    public String getFirstName(){ return firstName; }
    private void setFirstName(String f) { firstName = f; }
    public String getLastName(){ return lastName; }
    private void setLastName(String l){ lastName = l; }


}