package iterator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class User implements Iterable<Message> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public Iterator<Message> iterator() {
        return chatHistory.iterator(this);
    }
}
