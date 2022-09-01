package C1_Pattern.B_structural;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// создание древовидной структуры (пример, папки с файлами)
class File{
    String fileName;
}


class Folder{                                       // такая структура называется композитным объектом
    String name;                                    // объект содержит список самих себя
    Date creationDate;
    List<File> files = new ArrayList<>();           // листы
    List<Folder> folders = new ArrayList<>();       // ответвления

    public Folder(String name) {
        this.name = name;
    }


    void addFile(File file){
        files.add(file);
    }

    void removeFile(File file){
        files.remove(file);
    }

    List<File> getFiles(){
        return files;
    }


    void addFolder(Folder folder){
        folders.add(folder);
    }

    void removeFolder(Folder folder){
        folders.remove(folder);
    }

    List<Folder> getFolders(){
        return folders;
    }

}


public class I2_Composite {
}
