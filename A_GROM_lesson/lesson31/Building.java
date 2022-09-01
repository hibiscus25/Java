package A_GROM_lesson.lesson31;

public class Building {
    private String addres;
    private int floors;

    public Building(String addres, int floors) {
        this.addres = addres;
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Building{" +
                "addres='" + addres + '\'' +
                ", floors=" + floors +
                '}';
    }
}
