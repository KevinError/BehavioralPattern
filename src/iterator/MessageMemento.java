package iterator;

public class MessageMemento {
    private String content;
    private String timestamp;

    private String[] recepients;

    public MessageMemento(String content, String timestamp, String[] recepients) {
        this.content = content;
        this.timestamp = timestamp;
        this.recepients = recepients;
    }

    public void setContent(String content, String getTimeStamp, String[] recepients){
        this.content = content;
        this.timestamp = getTimeStamp;
        this.recepients = recepients;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String[] getRecepients() {
        return recepients;
    }
}
