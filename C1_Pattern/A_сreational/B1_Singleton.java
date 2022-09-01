package C1_Pattern.A_сreational;


class ProgramLogger{
    private static ProgramLogger programLogger;
    private static String logFile = "This is log file.\n";

    private ProgramLogger(){

    }

    public static synchronized ProgramLogger getProgramLogger() {
        if (programLogger == null)
            programLogger = new ProgramLogger();

        return programLogger;
    }

    public void addLogInfo(String logInfo){
        logFile += logInfo + "\n";
    }

    public void showLogFile(){
        System.out.println(logFile);
    }
}


public class B1_Singleton {
    public static void main(String[] args) {
        // один и тот же объект - hash - совпадают
            System.out.println(ProgramLogger.getProgramLogger().toString());
            System.out.println(ProgramLogger.getProgramLogger().toString());
            System.out.println(ProgramLogger.getProgramLogger().toString());


        System.out.println();
        // можно только добавить значение (так как logFile += logInfo + "\n";)
        ProgramLogger programLogger = ProgramLogger.getProgramLogger();
            programLogger.addLogInfo("First");
            programLogger.addLogInfo("Second");
            programLogger.addLogInfo("Third");

        programLogger.showLogFile();
    }
}
