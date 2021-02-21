package com.sunkl.hometoolsserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@SpringBootTest
public class EmailTest {
    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void text1() {
//      第一种
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("934926112@qq.com");//发送者
        msg.setTo("934926112@qq.com");//接收者
        msg.setSubject("邮箱标题");//标题
        msg.setText("<html><body><h1>hello email</h1></body></html>");//内容
        javaMailSender.send(msg);
    }

    @Test
    public void test2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom("934926112@qq.com");//发送人
        helper.setTo("t_cyan@139.com");//接收人
        helper.setSubject("股票预警");//标题
        String tbale = com.sunkl.hometoolsserver.dao.email.html.Test.testStr();
        helper.setText("<html><body><h1>公司公告<h1><hr/><h1>股东信息<h1><hr/>" + tbale + "</body></html>", true);//发送的内容
        javaMailSender.send(mimeMessage);
    }
}
