package com.open.springqianbailu.service.impl.mail;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.open.springqianbailu.model.bean.mail.MailMessageBean;
import com.open.springqianbailu.service.mail.MailService;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.io.File;

@Component
@Service(interfaceClass = MailService.class) //dubbo的service，注入接口
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private VelocityEngine velocityEngine;
    public  String TAG = getClass().getSimpleName();
    public Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    @Override
    public void sendSimpleMail(MailMessageBean messageBean) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(messageBean.getFrom());
        message.setTo(messageBean.getTo());
        message.setSubject(messageBean.getSubject());
        message.setText(messageBean.getText());

        mailSender.send(message);

        Gson gson = new Gson();
        logger.info(TAG+"sendSimpleMail--->"+gson.toJson(message));
    }

    @Override
    public void sendAttachmentsMail(MailMessageBean messageBean) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(messageBean.getFrom());
        helper.setTo(messageBean.getTo());
        helper.setSubject(messageBean.getSubject());
        helper.setText(messageBean.getText());

        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(mimeMessage);

        Gson gson = new Gson();
        logger.info(TAG+"sendAttachmentsMail--->"+gson.toJson(messageBean));
    }

    @Override
    public void sendInlineMail(MailMessageBean messageBean) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(messageBean.getFrom());
        helper.setTo(messageBean.getTo());
        helper.setSubject(messageBean.getSubject());
        helper.setText(messageBean.getText());

        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addInline("weixin", file);

        mailSender.send(mimeMessage);

        Gson gson = new Gson();
        logger.info(TAG+"sendInlineMail--->"+gson.toJson(messageBean));
    }

    @Override
    public void sendTemplateMail(MailMessageBean messageBean) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(messageBean.getFrom());
        helper.setTo(messageBean.getTo());
        helper.setSubject(messageBean.getSubject());

        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, "template.vm", "UTF-8", messageBean.getModel());
        helper.setText(text, true);

        mailSender.send(mimeMessage);

        Gson gson = new Gson();
        logger.info(TAG+"sendTemplateMail--->"+gson.toJson(messageBean));
    }
}
