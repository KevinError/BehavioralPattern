package memento.mediator;

import java.util.ArrayList;

public class ChatHistory {
    private ArrayList<Message> history;

    public ChatHistory() {
        this.history = new ArrayList<Message>();
    }

    public void addMessage(Message message) {
        this.history.add(message);
    }

    public Message getLastMessage() {
        if (this.history.isEmpty()) {
            return null;
        } else {
            return this.history.get(this.history.size() - 1);
        }
    }
}
