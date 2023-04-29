package iterator;

import java.time.LocalDateTime;

public class Message {
    private String sender;
    private String[] recipients;
    private String timestamp;
    private String content;

    public Message(String sender, String[] recipients, String content) {
        this.sender = sender;
        this.recipients = recipients;
        this.timestamp = LocalDateTime.now().toString();
        this.content = content;
    }

    public Message(String sender, String[] recipients, String content, String time) {
        this.sender = sender;
        this.recipients = recipients;
        this.timestamp = time;
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public String[] getRecipients() {
        return recipients;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }
}
