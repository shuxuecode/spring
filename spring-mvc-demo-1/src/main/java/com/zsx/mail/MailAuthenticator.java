package com.zsx.mail;

/**
 * Created by lenovo on 2015/7/31.
 */

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator {
    String userName=null;
    String password=null;

    public MailAuthenticator(){
    }
    public MailAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(userName, password);
    }

}
