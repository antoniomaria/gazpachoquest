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

    private String toAddress;

    private String fromAddress;

    @Lob
    private String body;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime sentDate;

    private Integer deliveryAttempts;

    public MailMessage() {
        super();
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String destination) {
        this.fromAddress = destination;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String content) {
        this.body = content;
    }

    public Integer getDeliveryAttempts() {
        return deliveryAttempts;
    }

    public void setDeliveryAttempts(Integer deliveryAttempts) {
        this.deliveryAttempts = deliveryAttempts;
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

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public DateTime getSentDate() {
        return sentDate;
    }

    public void setSentDate(DateTime sentDate) {
        this.sentDate = sentDate;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String subject;
        private String toAddress;
        private String fromAddress;
        private String body;
        private DateTime sentDate;
        private Integer deliveryAttempts;

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder toAddress(String toAddress) {
            this.toAddress = toAddress;
            return this;
        }

        public Builder fromAddress(String fromAddress) {
            this.fromAddress = fromAddress;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
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
            mailMessage.toAddress = toAddress;
            mailMessage.fromAddress = fromAddress;
            mailMessage.body = body;
            mailMessage.sentDate = sentDate;
            mailMessage.deliveryAttempts = deliveryAttempts;
            return mailMessage;
        }
    }
}
