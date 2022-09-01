package C1_Pattern.B_structural;

interface Database{
    void insert();
    void update();
    void select();
    void remove();
}

class JavaApplication {
    public void saveObject() {
        System.out.println("Saving Java Object ....");
    }

    public void updateObject() {
        System.out.println("Updating Java Object ....");
    }

    public void loadObject() {
        System.out.println("Loading Java Object ....");
    }

    public void deleteObject() {
        System.out.println("Deleting Java Object ....");
    }
}

//------------------------------------------------ Adapter -------------------------------------------------------------
class AdapterJavaToDatabase extends JavaApplication implements Database{

    @Override
    public void insert() {
        saveObject();
    }

    @Override
    public void update() {
        updateObject();
    }

    @Override
    public void select() {
        loadObject();
    }

    @Override
    public void remove() {
        deleteObject();
    }
}


//----------------------------------------------------------------------------------------------------------------------
public class F1_Adapter {
    public static void main(String[] args) {
        Database database = new AdapterJavaToDatabase();
            database.insert();
            database.update();
            database.select();
            database.remove();
    }
}
