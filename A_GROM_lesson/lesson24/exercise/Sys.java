package A_GROM_lesson.lesson24.exercise;

public class Sys {
    private int fileCount;
    private String location;

    public Sys(int fileCount, String location) {
        this.fileCount = fileCount;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Sys{" +
                "fileCount=" + fileCount +
                ", location='" + location + '\'' +
                '}';
    }
}
