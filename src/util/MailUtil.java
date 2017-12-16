package util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil
{
    private static String user;    //登录用户名
    private static String pass;    //登录密码
    private static Properties prop;

    static
    {
        user = PropertiesUtil.getProperty("mail.user", "");
        pass = PropertiesUtil.getProperty("mail.pass", "");
        String host = PropertiesUtil.getProperty("mail.host", "smtp.qq.com");
        String port = PropertiesUtil.getProperty("mail.port", "465");
        String protocol = PropertiesUtil.getProperty("mail.protocol", "smtp");
        prop = new Properties();
        prop.setProperty("mail.transport.protocol", protocol);
        prop.setProperty("mail.smtp.host", host);
        prop.setProperty("mail.smtp.port", port);
        prop.setProperty("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
    }

    static class MyAuthenticator extends Authenticator
    {
        String u = null;
        String p = null;

        public MyAuthenticator(String u, String p)
        {
            this.u = u;
            this.p = p;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(u, p);
        }
    }

    //发送Html邮件
    public static boolean sendHtmlMail(String to, String subject, String content)
    {
        return sendMail(to, subject, content, 1);
    }

    //发送普通文本邮件
    public static boolean sendTextMail(String to, String subject, String text)
    {
        return sendMail(to, subject, text, 0);
    }

    private static boolean sendMail(String to, String subject, String text, int type)
    {
        Session session = Session.getDefaultInstance(prop, new MyAuthenticator(user, pass));
        session.setDebug(true);
        try
        {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(user, "iTest")); //发件人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); //收件人
            message.setSubject(subject);  //主题

            //内容
            if (type == 0)
            {
                message.setText(text);
            }
            else if (type == 1)
            {
                message.setContent(text, "text/html");
            }

            Transport.send(message);   // 发送消息
            return true;
        }
        catch (MessagingException | UnsupportedEncodingException e)
        {
            System.out.println("Mail Exception: " + e);
        }
        return false;
    }

    public static void main(String[] args)
    {
        sendHtmlMail("550361254@qq.com", "aaa", "bbb");
    }
}
