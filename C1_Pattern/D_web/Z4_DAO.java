package C1_Pattern.D_web;

interface Data{
    String getData();
}

class Db implements Data{
    String getFromTable(){
        return "data from table";
    }

    @Override
    public String getData() {
        return getFromTable();
    }
}

class FileSystem implements Data{
    String getFromFs(){
        return "data from table";
    }

    @Override
    public String getData() {
        return getFromFs();
    }
}

//---------------------------------------------------------------
public class Z4_DAO {
    static Data data = new FileSystem();

    public static void main(String[] args) {
        System.out.println(data.getData());
    }
}
