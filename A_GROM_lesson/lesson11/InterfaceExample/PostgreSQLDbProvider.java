package A_GROM_lesson.lesson11.InterfaceExample;

public class PostgreSQLDbProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //logic of Postgres
    }

    @Override
    public void disconnectFromDb() {
        //logic of Postgres
    }

    @Override
    public void encyrptData() {
        //logic of Postgres
    }
}
