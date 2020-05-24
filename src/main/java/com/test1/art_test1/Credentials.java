package com.test1.art_test1;

/**
 * Property of CODIX SA
 * Date: 4/15/2020 Time: 9:40 PM
 * <p>
 * TODO: WRITE THE DESCRIPTION HERE
 *
 * @author lparvov
 */
public class Credentials {
    /**
     * The user name
     */
    private String userName;

    /**
     * The user password
     */
    private String userPass;

    public Credentials() {
    }

    public Credentials(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
