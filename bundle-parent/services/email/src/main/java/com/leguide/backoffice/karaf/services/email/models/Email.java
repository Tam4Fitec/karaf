package com.leguide.backoffice.karaf.services.email.models;

import java.util.Arrays;
import java.util.List;

/**
 * Email definition
 *
 * @author Manuel Darcemont
 *
 */
public class Email {

	private String host;

	private String sender;

	private List<EmailRecipient> recipients;

	private String subject;

	private String body;

	private Integer port;

	public static class Builder {
		private String host;

		private String sender;

		private List<EmailRecipient> recipients;

		private String subject;

		private String body;

		private Integer port;

		public Builder(String host, String sender, List<EmailRecipient> recipients) {
			this.host = host;
			this.sender = sender;
			this.recipients = recipients;
		}

		public Builder(String host, Integer port, String sender, List<EmailRecipient> recipients) {
			this.host = host;
			this.port = port;
			this.sender = sender;
			this.recipients = recipients;
		}

		public Builder subject(String subject) {
			this.subject = subject;
			return this;
		}

		public Builder body(String body) {
			this.body = body;
			return this;
		}

		public Email build() {
            return new Email(this);
        }
	}

	private Email(Builder b) {
		this.host = b.host;
		this.sender = b.sender;
		this.recipients = b.recipients;
		this.subject = b.subject;
		this.body = b.body;
		this.port = b.port;
	}

	public String getHost() {
		return host;
	}

	public String getSender() {
		return sender;
	}

	public List<EmailRecipient> getRecipients() {
		return recipients;
	}

	public String getSubject() {
		return subject;
	}

	public String getBody() {
		return body;
	}

	public Integer getPort() {
		return port;
	}

}