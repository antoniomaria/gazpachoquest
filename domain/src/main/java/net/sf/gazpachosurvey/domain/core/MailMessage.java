package net.sf.gazpachosurvey.domain.core;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Lob;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

import org.joda.time.DateTime;
import org.joda.time.contrib.jpa.DateTimeConverter;

@Entity
public class MailMessage extends AbstractPersistable<Integer> {

    private static final long serialVersionUID = 2597367892321945501L;

    private String subject;

    private String to;

    private String from;

    private String replyTo;

    @Lob
    private String text;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime sentDate;

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

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public DateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(DateTime sentDate) {
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

    public static class Builder {
        private String subject;
        private String to;
        private String from;
        private String replyTo;
        private String text;
        private DateTime sentDate;
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

        public Builder sentDate(DateTime sentDate) {
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
            mailMessage.to = to;
            mailMessage.from = from;
            mailMessage.replyTo = replyTo;
            mailMessage.text = text;
            mailMessage.sentDate = sentDate;
            mailMessage.deliveryAttempts = deliveryAttempts;
            return mailMessage;
        }
    }
}
