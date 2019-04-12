package com.zsx.mail;


import java.net.InetAddress;
import java.net.UnknownHostException;

import com.zsx.utils.ConfigUtil;

/**
 * Created by lenovo on 2015/7/31.
 */
public class MailSendUtil {
    private static String hostName = "";
    private static String hostIP = "";

    static {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            hostName = localHost.getHostName();
            hostIP = localHost.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    public  static void sendMail(String errorMessage){
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost(ConfigUtil.getAttribute("mail_host"));
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName(ConfigUtil.getAttribute("mail_user"));
        mailInfo.setPassword(ConfigUtil.getAttribute("mail_pass"));//您的邮箱密码
        mailInfo.setFromAddress(ConfigUtil.getAttribute("mail_user"));
        mailInfo.setToAddress(ConfigUtil.getAttribute("to_address"));
        mailInfo.setSubject(ConfigUtil.getAttribute("mail_subject") + "【" + hostName + ":" + hostIP+"】");
        mailInfo.setContent(errorMessage);
        //这个类主要来发送邮件
        SimpleMailSender sms = new SimpleMailSender();
//        sms.sendTextMail(mailInfo);//发送文体格式
        sms.sendHtmlMail(mailInfo);
    }
}
