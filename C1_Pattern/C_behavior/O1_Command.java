package C1_Pattern.C_behavior;


class Database{
    public void insert(){
        System.out.println("Inserting record ...");
    }

    public void update(){
        System.out.println("Updating record ...");
    }

    public void select(){
        System.out.println("Reading record ...");
    }

    public void delete(){
        System.out.println("Deleting record ...");
    }
}

//--------------------------------------------------------------------------
interface Commands{
    void execute();
}


class InsertCommands implements Commands{
    Database database;

    public InsertCommands(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.insert();
    }
}


class UpdateCommands implements Commands{
    Database database;

    public UpdateCommands(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.update();
    }
}


class SelectCommands implements Commands{
    Database database;

    public SelectCommands(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.select();
    }
}


class DeleteCommands implements Commands{
    Database database;

    public DeleteCommands(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.delete();
    }
}

//--------------------------------------------------------------------------
class DeveloperDb {
    Commands insert;
    Commands update;
    Commands select;
    Commands delete;

    public DeveloperDb(Commands insert, Commands update, Commands select, Commands delete) {
        this.insert = insert;
        this.update = update;
        this.select = select;
        this.delete = delete;
    }

    public void insertRecord(){
        insert.execute();
    }

    public void updateRecord(){
        update.execute();
    }

    public void selectRecord(){
        select.execute();
    }

    public void deleteRecord(){
        delete.execute();
    }
}

//--------------------------------------------------------------------------
public class O1_Command {
    public static void main(String[] args) {
        Database database = new Database();
        DeveloperDb developerDb = new DeveloperDb(new InsertCommands(database), new UpdateCommands(database),
                new SelectCommands(database), new DeleteCommands(database));

        developerDb.insertRecord();
        developerDb.updateRecord();
        developerDb.selectRecord();
        developerDb.deleteRecord();
    }
}
