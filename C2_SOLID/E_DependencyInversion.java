package C2_SOLID;

// концепция: cоздание прослойки между верхним и нижним слоем через интерфейс

interface  DAO {
    void execute();
}

class DataAccess implements DAO{
    @Override
    public void execute() {
        System.out.println("execute");
    }
}

class Client{
    DataAccess dataAccess = new DataAccess();

    void doJob(){
        dataAccess.execute();
    }
}


public class E_DependencyInversion {
}
