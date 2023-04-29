import memento.mediator.*;
public class MementoMain {

    public static void main(String[] args){
        ChatServer chatServer = new ChatServer();
        User james = new User("James", chatServer);
        User philip = new User("Philip", chatServer);
        User kevin = new User("Kevin", chatServer);

        kevin.sendMessage(new String[]{"Philip", "James"}, "Ya I like you");
        kevin.sendMessage(new String[]{"Philip", "James"}, "JK I Don't like you");
        kevin.viewChatHistory();
        kevin.undoLastMessage();
        //kevin.viewChatHistory();
        philip.blockUser(kevin);
        kevin.sendMessage(new String[]{"Philip", "James"}, "Hi");
        philip.viewChatHistory();

    }
}
