/*
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 */
package net.sf.gazpachoquest.domain.core;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Lob;

import net.sf.gazpachoquest.domain.support.AbstractPersistable;
import net.sf.gazpachoquest.jpa.converter.LocalDateTimeConverter;

@SuppressWarnings("serial")
@Entity
public class MailMessage extends AbstractPersistable {

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private String toAddress;

    @Column(nullable = false)
    private String fromAddress;

    @Column(nullable = false)
    private String replyTo;

    @Lob
    @Column(nullable = false)
    private String body;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime sentDate;

    private Integer deliveryAttempts;

    public MailMessage() {
        super();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String to) {
        toAddress = to;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String from) {
        fromAddress = from;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String text) {
        body = text;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
    }

    public Integer getDeliveryAttempts() {
        return deliveryAttempts;
    }

    public void setDeliveryAttempts(Integer deliveryAttempts) {
        this.deliveryAttempts = deliveryAttempts;
    }

    public static Builder with() {
        return new Builder();
    }
    
    /**
     * @hidden 
     */
    public static class Builder {
        private String subject;
        private String to;
        private String from;
        private String replyTo;
        private String text;
        private LocalDateTime sentDate;
        private Integer deliveryAttempts;

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder to(String to) {
            this.to = to;
            return this;
        }

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder replyTo(String replyTo) {
            this.replyTo = replyTo;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder sentDate(LocalDateTime sentDate) {
            this.sentDate = sentDate;
            return this;
        }

        public Builder deliveryAttempts(Integer deliveryAttempts) {
            this.deliveryAttempts = deliveryAttempts;
            return this;
        }

        public MailMessage build() {
            MailMessage mailMessage = new MailMessage();
            mailMessage.subject = subject;
            mailMessage.toAddress = to;
            mailMessage.fromAddress = from;
            mailMessage.replyTo = replyTo;
            mailMessage.body = text;
            mailMessage.sentDate = sentDate;
            mailMessage.deliveryAttempts = deliveryAttempts;
            return mailMessage;
        }
    }
}
