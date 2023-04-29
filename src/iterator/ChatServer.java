package iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {
    private Map<String, User> users;
    private Map<User, List<User>> blockedUsers;

    public ChatServer() {
        this.users = new HashMap<>();
        this.blockedUsers = new HashMap<>();
    }

    public void register(User user) {
        users.put(user.getName(), user);
        blockedUsers.put(user, new ArrayList<>());
    }

    public void unregister(User user) {
        users.remove(user.getName());
        blockedUsers.remove(user);
    }

    public void sendMessage(User sender, Message message) {
        String[] recipients = message.getRecipients();
        for (String recipient : recipients) {
            User user = users.get(recipient);
            if (!blockedUsers.get(user).contains(sender)) {
                user.receiveMessage(message);
            } else {
                System.out.println("The message has been blocked by" + recipient);
            }
        }
    }

    public void blockUser(User blocker, User blockedPerson) {
        blockedUsers.get(blocker).add(blockedPerson);
    }

}
