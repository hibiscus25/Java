package A_GROM_lesson.lesson9.A_HW.lesson9A;

public class User {
    private long id;
    private String name;
    private String sessionId;

    public User(long id, String name, String sessionId) {
        this.id = id;
        this.name = name;
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getSessionId() {
        return sessionId;
    }
}
