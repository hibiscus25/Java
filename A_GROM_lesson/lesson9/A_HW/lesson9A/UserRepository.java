package A_GROM_lesson.lesson9.A_HW.lesson9A;

public class UserRepository {
    private User[] users;

    UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

//-----------------------------------------------------------------------------------------------------
    public String[] getUserNames() {
        String[] strings = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                strings[i] = users[i].getName();
        }
        return strings;
    }

    public Long[] getUserIds() {
        Long[] longs = new Long[users.length];
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null)
                longs[i] = users[i].getId();
        }
        return longs;
    }

    public String getUserNameById(long id) {
        String result = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && id == users[i].getId()) {
                result = users[i].getName();
                break;
            }
        }
        return result;
    }
}