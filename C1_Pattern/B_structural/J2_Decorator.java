package C1_Pattern.B_structural;


interface FileStream{
    void read();
}

class FileStreamReader implements FileStream{

    @Override
    public void read() {
        System.out.println("Read file");
    }
}

//---------------------------------------------------------------------------------------------------------------------
abstract class FileDecorator implements FileStream{
    FileStream fileStream;

    public FileDecorator(FileStream fileStream) {
        this.fileStream = fileStream;
    }

    public abstract void read();
}

class FileBufferedReader extends FileDecorator{

    public FileBufferedReader(FileStream fileStream) {
        super(fileStream);
    }

    @Override
    public void read() {
        fileStream.read();
        System.out.println("buffered read");
    }
}


//---------------------------------------------------------------------------------------------------------------------
public class J2_Decorator {
    public static void main(String[] args) {
        FileStream fileStream = new FileBufferedReader(new FileStreamReader());
        fileStream.read();
    }
}
