package A_GROM_lesson.lesson18.A_HW.lesson18A;

public class HandleError {
    public static void main(String[] args) {
        String[] files = {"Korona", "Korova", "Sorova", "Glova"};
        String[] files2 = {"Korona", "Korova", "Sorova", "Glova","Golova","Grova"};
        String[] files3 = {"Korona", "Korova", "Sorova", "Glova",null};

        MusicStorage musicStorage = new MusicStorage();
        musicStorage.setFiles(files);
        print5thName(musicStorage);

        musicStorage.setFiles(files2);
        print5thName(musicStorage);

        musicStorage.setFiles(files3);
        print5thName(musicStorage);
    }

    public static void print5thName(Storage storage) {
        String[] names = storage.getFiles();
        try {
            System.out.println("5th name is " + names[4]);
        } catch (Exception e) {
            System.out.println("5th name cannot be found...");
        }
    }
}
