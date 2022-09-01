package B_ReadMe.B20_Logger;

import java.io.File;
import java.util.logging.*;

public class Main {
//      private static final Logger logger = Logger.getGlobal();                    // глобальный логгер, редко используется
    private static final Logger logger = Logger.getLogger(Main.class.getName());    // как аргумент имя класса - название логгера


    public static void main(String[] args) throws Exception {
        // изначально используются properties по умолчанию - можно менять на свой properties

        // используются уровни  log, все что выше - показывает
//            logger.info("message");
//            logger.finer("finer");
//            logger.log(Level.WARNING, "warning", new Exception());


        // Handler есть несколько видов
            // Handler handler = new ConsoleHandler();      - запись в консоль
            // Handler handler = new FileHandler();         - запись в файл
            // Handler handler = new StreamHandler();       - запись в поток
            // Handler handler = new SocketHandler();       - посылать на другой сервер
            Handler fileHandler = new FileHandler("logger.txt");    //в корне проекта
            logger.setUseParentHandlers(false);                             //отключаем parentsHandler в properties
            logger.addHandler(fileHandler);
                logger.info("message");
            fileHandler.close();                                //закрывать, если хочу удалить файл


        // Filter - используется для фильтрации logger-ов, которые необходимо записывать
        Handler consoleHandler = new ConsoleHandler();
            logger.setUseParentHandlers(false);
            logger.addHandler(consoleHandler);
            consoleHandler.setFilter(new MyFilter());
                logger.info("message");
                logger.info("message max");


        // Formatter - используется для ограничения информации logger-ов при выводе
        consoleHandler.setFormatter(new MyFormatter());
                logger.info("message");
                logger.info("message max");


        //-------------------------------------------------------------------------------------------------------------
            new File("logger.txt").delete();
    }
}

    class MyFilter implements Filter {
        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("max");
        }
    }

    class MyFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() + " - " + record.getMessage();
        }
    }