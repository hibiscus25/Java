package A_GROM_lesson.lesson30.task1;

public class File implements Comparable<File> {
    private String fileName;
    private long sizeInBytes;

    public File(String fileName, long sizeInBytes) {
        this.fileName = fileName;
        this.sizeInBytes = sizeInBytes;
    }

    public String getFileName() {
        return fileName;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }


    @Override
    public int compareTo(File o) {
        int res=0;
        if(o.getSizeInBytes()>this.sizeInBytes)
            res=1;
        else if(o.getSizeInBytes()<this.sizeInBytes)
            res=-1;
        return res;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileName='" + fileName + '\'' +
                ", sizeInBytes=" + sizeInBytes +
                '}';
    }
}
