import iterator.*;
public class IteratorMain {
    public static void main(String[] args){
        ChatServer chatServer = new ChatServer();
        User kevin = new User("Kevin", chatServer);
        User james = new User("James", chatServer);
        User philip = new User("Philip", chatServer);

        kevin.sendMessage(new String[]{"James, Philip"}, "Hi");
        kevin.sendMessage(new String[]{"James, Philip"}, "Hi How are you");
        kevin.sendMessage(new String[]{"James, Philip"}, "Hi Im doing good");
        kevin.sendMessage(new String[]{"James, Philip"}, "Hi what are you doing");
        kevin.sendMessage(new String[]{"James, Philip"}, "Hi want to meet today");
        kevin.sendMessage(new String[]{"James, Philip"}, "Hi I got something to tell you");
        kevin.sendMessage(new String[]{"James, Philip"}, "Hi It's really good");

        kevin.viewChatHistory();
    }
}
