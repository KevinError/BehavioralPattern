package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class ChatHistory implements IterableByUser{
    private ArrayList<Message> history;

    public ChatHistory() {
        this.history = new ArrayList<Message>();
    }

    public void addMessage(Message message) {
        this.history.add(message);
    }

    public Message getLastMessage() {
        return this.history.get(this.history.size() - 1);
    }
    public void removeLastMessage() {
        if (history.size() > 0) {
            history.remove(history.size() - 1);
        }
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return new MessageIterator(userToSearchWith);
    }

    private class MessageIterator implements Iterator<Message> {

        private User userToSearchWith;
        private int currentIndex;

        public MessageIterator(User userToSearchWith) {
            this.userToSearchWith = userToSearchWith;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            while (currentIndex < history.size()) {
                Message message = history.get(currentIndex);
                if (message.getSender().equals(userToSearchWith) || message.getRecipients().equals(userToSearchWith)) {
                    return true;
                }
                currentIndex++;
            }
            return false;
        }

        @Override
        public Message next() {
            if (!hasNext()) {
                return null;
            }
            Message message = history.get(currentIndex);
            currentIndex++;
            return message;
        }
    }
}
