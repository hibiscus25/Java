package A_GROM_lesson.lesson19.A_HW;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

 /*имя файла не моджет быть больше 10 символов проверка на уровне конструктора */
    public File(long id, String name, String format, long size) {
        this.id = id;
        try{
            this.name = validationName(name);}
        catch(RuntimeException e){
            System.err.println("error: " + e.getMessage());
            System.exit(0);
        }
        this.format = format;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }

    private String validationName(String name) {
        if (name.length() > 10) {
            throw new RuntimeException(name+" -file name cannot exceed 10 characters...");
        }
        return name;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format='" + format + '\'' +
                ", size=" + size +
                '}';
    }
}
