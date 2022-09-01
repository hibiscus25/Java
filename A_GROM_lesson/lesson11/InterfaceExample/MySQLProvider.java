package A_GROM_lesson.lesson11.InterfaceExample;

public class MySQLProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //some logic of MySQL
    }

    @Override
    public void encyrptData() {
        //some logic of MySQL
    }

    @Override
    public void disconnectFromDb() {
        //some logic of MySQL
    }
}
