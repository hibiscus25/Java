package C1_Pattern.B_structural;


interface Developers{
    void writeCode();
}


class JavaDevelopers implements Developers{

    @Override
    public void writeCode() {
        System.out.println(" - Java developer writes Jave code ....");
    }
}


class CppDevelopers implements Developers{

    @Override
    public void writeCode() {
        System.out.println(" - C++ developer writes C++ code ....");
    }
}


//----------------------------------------------------------------------------------------------------------------------
abstract class Program{
    protected Developers developers;

    protected Program(Developers developers) {
        this.developers = developers;
    }

    abstract void developProgram();
}


class BankSystem extends Program{
    protected BankSystem(Developers developers) {
        super(developers);
    }

    @Override
    void developProgram() {
        System.out.println("Bank System development in progress...");
        developers.writeCode();
    }
}


class StockExchange extends Program{
    protected StockExchange(Developers developers) {
        super(developers);
    }

    @Override
    void developProgram() {
        System.out.println("Stock Exchange development in progress...");
        developers.writeCode();
    }
}

//----------------------------------------------------------------------------------------------------------------------
public class G1_Bridge {
    public static void main(String[] args) {
        Program[] array = {new BankSystem(new JavaDevelopers()), new StockExchange(new CppDevelopers())};
            for (Program el : array)
                el.developProgram();

        System.out.println();
        Program[] array2 = {new BankSystem(new CppDevelopers()), new StockExchange(new JavaDevelopers())};
        for (Program el : array2)
            el.developProgram();

    }
}
