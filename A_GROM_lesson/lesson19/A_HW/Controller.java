package A_GROM_lesson.lesson19.A_HW;

public class Controller {
    private Storage[] storage;

    public Controller(Storage[] storage) {
        this.storage = storage;
    }


//methods
    public void put(Storage storage, File file) {                                           //добавляет файл в хранилище
        File[] files = storage.getFiles();

        check(storage, file);
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = file;
                break;
            }
        }
    }

    public void delete(Storage storage, File file) {                                         //удаляет файл из хранилища
        File[] files = storage.getFiles();

        int count = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i] != null) {
                if (files[i].getId() == file.getId() && files[i].getName().equals(file.getName())) {
                    files[i] = null;
                    count++;
                }
            }
        }

        if (count == 0) {
            throw new RuntimeException("Storage id: " + storage.getId() + " no such file exists  id: " + file.getId());
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {                   //трансфер по id файла
        File[] files = storageFrom.getFiles();

        int count = 0;
        File fileCopy = null;
        for (int i = 0; i < files.length; i++) {
            if (files[i] != null) {
                if (files[i].getId() == id) {
                    fileCopy = files[i];
                    count++;
                    break;
                }
            }
        }

        if (count == 0) {
            throw new RuntimeException("Storage id: " + storageFrom.getId() + " no such file exists id: " + id);
        }

        put(storageTo, fileCopy);
        delete(storageFrom, fileCopy);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) {              //трансфер всех файлов из одного хранилища в другое.
        File[] filesFrom = storageFrom.getFiles();
        File[] filesTo = storageTo.getFiles();
        //допускаем, что  в Storage не все null
        try {
            for (int i = 0; i < filesFrom.length; i++) {       //допустимость формата файлов + наличие похоже id
                if (filesFrom[i] != null) {
                    checkFormat(storageTo, filesFrom[i]);
                    checkFile(storageTo, filesFrom[i]);
                }
            }

            int count = 0;                                     //допустимость размера для переноса
            long sizeAll = 0;
            for (int i = 0; i < filesFrom.length; i++) {
                if (filesFrom[i] != null) {
                    count++;                                        //количество объектов для переноса
                    sizeAll += filesFrom[i].getSize();                //общий размер, который хотим перенести
                }
            }

            int count2 = 0;
            for (int i = 0; i < filesTo.length; i++) {                 //cколько пустых нул, куда хотим перенести
                if (filesTo[i] == null) {
                    count2++;
                }
            }

            if (!(count <= count2)) {
                throw new RuntimeException("StorageTO id: " + storageTo.getId() + " no free space in the file array");
            }

            checkSize(storageTo, new File(0, "", "", sizeAll)); //проверка поместиться или нет в StorageTo

            File[] addFile=new File[count];                     //добавляем в StorageTo
            int countPlace=0;
            for(int i=0;i<filesFrom.length;i++){
                if(filesFrom[i]!=null){
                    addFile[countPlace]=filesFrom[i];
                    countPlace++;
                }
            }
            int countPlace2=0;
            for (int i = 0; i < filesTo.length; i++) {           //добавляем с StorageTo
                if (filesTo[i] == null) {
                    filesTo[i]=addFile[countPlace2];
                    countPlace2++;
                }
            }

            for (int i=0;i<filesFrom.length;i++) {               //удаляем с StorageFrom
                filesFrom[i]=null;
            }

        } catch (RuntimeException e) {
            System.err.println("error:" + e.getMessage());
            System.exit(0);
        }
    }


//data validation
    private void check(Storage storage, File file) {
        try {
            checkPlace(storage);
            checkFormat(storage, file);
            checkFile(storage, file);
            checkSize(storage, file);
        } catch (RuntimeException e) {
            System.err.println("error:" + e.getMessage());
            System.exit(0);
        }
    }

    private boolean checkPlace(Storage storage) throws RuntimeException {    //есть ли место  в массиве файлов у Storage
        File[] files = storage.getFiles();
        for (File file : files) {
            if (file == null) {
                return true;
            }
        }
        throw new RuntimeException("Storage id: " + storage.getId() + " no free space in the file array");
    }

    private boolean checkFormat(Storage storage, File file) throws RuntimeException {  //может ли Storage хранить  файлы такого формата?
        String[] check = storage.getFormatSuppored();
        String fileFormat = file.getFormat();
        for (String checks : check) {
            if (fileFormat.equals(checks)) {
                return true;
            }
        }
        throw new RuntimeException("Storage id: " + storage.getId() + " files cannot be stored in the format: " + file.getFormat());
    }

    private boolean checkFile(Storage storage, File file) throws RuntimeException {  //есть ли в Storage файл с таким же id
        long id = file.getId();
        File[] allFile = storage.getFiles();

        for (int i = 0; i < allFile.length; i++) {
            if (allFile[i] != null) {
                if (id == allFile[i].getId())
                    throw new RuntimeException("Storage - id: " + storage.getId() + " there is a file  with this id: " + file.getId());
            }
        }
        return true;
    }

    private boolean checkSize(Storage storage, File file) throws RuntimeException {  //хватит ли размера Storage для перенесения файлов
        long size = storage.getStorageSize();
        File[] allFile = storage.getFiles();

        long sizeAllFile = 0;
        for (int i = 0; i < allFile.length; i++) {
            if (allFile[i] != null) {
                sizeAllFile += allFile[i].getSize();
            }
        }

        if (sizeAllFile == 0) {
            if ((size - file.getSize()) >= 0)
                return true;
            else
                throw new RuntimeException("Storage id: " + storage.getId() + " there is not enough space to transfer the file id: " + file.getId());
        } else {
            if ((size - sizeAllFile - file.getSize()) >= 0)
                return true;
            else
                throw new RuntimeException("Storage id: " + storage.getId() + " there is not enough space to transfer the file id: " + file.getId());
        }
    }
}

