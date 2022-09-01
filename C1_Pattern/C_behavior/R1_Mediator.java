package C1_Pattern.C_behavior;

import java.util.ArrayList;
import java.util.List;



interface Chat{
    void sentMessage(String message, User user);
}


class SimpleTextChat implements Chat{
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin){
        this.admin = admin;
    }

    public void addUserToChat(User user){
        this.users.add(user);
    }

    @Override
    public void sentMessage(String message, User user) {
        admin.getMessage(message);
        for(User el : users){
            if (el != user)
                el.getMessage(message);
        }
    }
}


//--------------------------------------------------------------------------
interface User{
    void getMessage(String message);
    void sendMessage(String message);
}

class Admin implements User{
    Chat chat;
    String name;

    public Admin(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    @Override
    public void getMessage(String message) {
        System.out.println(this.name + " receiving message " + message + ".");
    }

    @Override
    public void sendMessage(String message) {
        chat.sentMessage(message, this);
    }
}


class SimpleUser implements User{
    Chat chat;
    String name;

    public SimpleUser(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    @Override
    public void getMessage(String message) {
        System.out.println(this.name + " receiving message " + message + ".");
    }

    @Override
    public void sendMessage(String message) {
        chat.sentMessage(message, this);
    }
}


//--------------------------------------------------------------------------
public class R1_Mediator {
    public static void main(String[] args) {
        SimpleTextChat chat = new SimpleTextChat();

        User admin = new Admin(chat, "Admin");
        User user1 = new SimpleUser(chat, "User 1");
        User user2 = new SimpleUser(chat, "User 2");
        User user3 = new SimpleUser(chat, "User 3");

        chat.setAdmin(admin);
        chat.addUserToChat(user1);
        chat.addUserToChat(user2);
        chat.addUserToChat(user3);

        user1.sendMessage("Hello, I'm User 1!!!");
        System.out.println();
        admin.sendMessage("Rogger that admin!!!!");
    }
}
