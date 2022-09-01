package A_GROM_lesson.lesson11.biginterfaceexample;

public class FileReader implements Readable {

    @Override
    public void readFilesFromStorage(Storage storage) {
        //найти файл мах размера
        //вывести всю информацию о нем
        printFile(findMaxSizeFile(storage.getFiles()));
    }

    private File findMaxSizeFile(File[] files) {
        File maxSizeFile = files[0];

        for (File file : files) {
            if (file != null && file.getSize() > maxSizeFile.getSize()) {
                maxSizeFile = file;
            }
        }
        return maxSizeFile;
    }

    private void printFile(File files) {
        System.out.println("max file will be printed now...");
        System.out.println(files.getName());
        System.out.println(files.getExtension());
        System.out.println(files.getPath());
        System.out.println(files.getSize());
        System.out.println();

    }
}
