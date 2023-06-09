package memento.mediator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private ChatServer chatServer;
    private ChatHistory chatHistory;
    private List<MessageMemento> sentMessages;

    public User(String name, ChatServer chatServer) {
        this.name = name;
        this.chatServer = chatServer;
        this.chatHistory = new ChatHistory();
        this.sentMessages = new ArrayList<>();
        chatServer.register(this);
    }

    public void sendMessage(String[] recipients, String content) {
        Message message = new Message(this.name, recipients, content);
        chatServer.sendMessage(this, message);
        chatHistory.addMessage(message);
        sentMessages.add(new MessageMemento(content, LocalDateTime.now().toString(), recipients));
    }

    public void receiveMessage(Message message) {
        chatHistory.addMessage(message);
        System.out.println("[" + message.getTimestamp() + "] " + message.getSender() + ": " + message.getContent() + " to " + this.getName());
    }

    public void viewChatHistory() {
        Message message = chatHistory.getLastMessage();
        System.out.println("[" + message.getTimestamp() + "]" + "Sender: " + message.getSender() + ": " + message.getContent());
    }

    public void undoLastMessage() {
        MessageMemento memento = sentMessages.get(sentMessages.size() - 2);
        Message message = new Message(this.name, memento.getRecepients(), memento.getContent(), memento.getTimestamp());
        chatServer.sendMessage(this, message);
        chatHistory.addMessage(message);
        sentMessages.remove(sentMessages.size() - 1);
    }

    public void blockUser(User user) {
        chatServer.blockUser(this, user);
    }

    public String getName() {
        return name;
    }
}
