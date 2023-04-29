package memento.mediator;

public class MessageMemento {
    private String content;
    private String timestamp;

    public MessageMemento(String content, String timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
