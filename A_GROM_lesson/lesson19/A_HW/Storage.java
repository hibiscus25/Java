package A_GROM_lesson.lesson19.A_HW;

//хранилище файлов
public class Storage {
    private long id;
    private File[] files;
    private String[] formatSuppored;
    private String storageCountry;
    private long storageSize;

    public Storage(long id, File[] files, String[] formatSuppored, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatSuppored = formatSuppored;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public String[] getFormatSuppored() {
        return formatSuppored;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }
}
