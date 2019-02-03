package com.open.springqianbailu.service.mail;

import com.open.springqianbailu.model.bean.mail.MailMessageBean;

public interface MailService {

    /**
     * 简单邮件
     *
     * @param messageBean
     * @throws Exception
     */
    void sendSimpleMail(MailMessageBean messageBean) throws Exception;


    /**
     * 有附件
     *
     * @param messageBean
     * @throws Exception
     */
    void sendAttachmentsMail(MailMessageBean messageBean) throws Exception;


    /**
     * 嵌入静态资源
     *
     * @param messageBean
     * @throws Exception
     */
    void sendInlineMail(MailMessageBean messageBean) throws Exception;


    /**
     * 模板邮件
     *
     * @param messageBean
     * @throws Exception
     */
    void sendTemplateMail(MailMessageBean messageBean) throws Exception;
}
