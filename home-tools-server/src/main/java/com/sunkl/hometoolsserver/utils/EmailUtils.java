package com.sunkl.hometoolsserver.utils;

import com.sunkl.hometoolsserver.dao.EmailMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailUtils {
    @Autowired
    JavaMailSender javaMailSender;

    public Boolean send(EmailMsg emailMsg) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(emailMsg.getSrcAddress());//发送人
            helper.setTo(emailMsg.getTargetAddress());//接收人
            helper.setSubject(emailMsg.getEmailObject());//标题
            helper.setText(emailMsg.getEmailMsg(), true);//发送的内容
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
