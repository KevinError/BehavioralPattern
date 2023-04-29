package memento.mediator;

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
        this.sentMessages = new ArrayList<>();;
        chatServer.register(this);
    }

    public void sendMessage(String[] recipients, String content) {
        Message message = new Message(name, recipients, content);
        chatServer.sendMessage(this, message);
        lastSentMessage = message;
        chatHistory.addMessage(message);
    }

    public void receiveMessage(Message message) {
        chatHistory.addMessage(message);
        System.out.println("[" + message.getTimestamp() + "] " + message.getSender() + ": " + message.getContent());
    }

    public void viewChatHistory() {
        List<Message> messages = chatHistory.getMessages();
        for (Message message : messages) {
            System.out.println(message.getTimestamp() + " " + message.getSender() + ": " + message.getContent());
        }
    }

    public void undoLastMessage() {
        if (sentMessages.size() > 0) {
            MessageMemento lastMemento = sentMessages.get(sentMessages.size() - 1);
            String lastMessageContent = lastMemento.getContent();
            String lastMessageTimestamp = lastMemento.getTimestamp();
            Message lastMessage = new Message(this.username, new String[0], lastMessageContent, lastMessageTimestamp);
            chatServer.sendMessage(this, lastMessage);
            sentMessages.remove(sentMessages.size() - 1);
        } else {
            System.out.println("No messages to undo");
        }
    }

    public void blockUser(User user) {
        chatServer.blockUser(this, user);
    }

    public void unblockUser(User user) {
        chatServer.unblockUser(this, user);
    }

    public String getName() {
        return name;
    }
}
