package B_ReadMe.B29_Многопоточность;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


/*   CompletableFuture - реализует интерфейс Future, поэтому можем также получить результат.
        - кроме этого, он реализует некоторый CompletionStage.
*/

public class M2_CompletableFuture {
    public static void main(String []args) throws Exception {
    // CompletableFuture уже содержащий результат
        CompletableFuture<String> com = CompletableFuture.completedFuture("Просто значение");
        System.out.println(com.get());

    // CompletableFuture, запускающий (run) новый поток с Runnable, поэтому он void
        CompletableFuture<Void> voids = CompletableFuture.runAsync(() -> {
                                                    System.out.println("run " + Thread.currentThread().getName());
                                                });

    // CompletableFuture, запускающий новый поток, результат которого возьмём у Supplier
        CompletableFuture<String> supplier = CompletableFuture.supplyAsync(() -> {
                                                    System.out.println("supply " + Thread.currentThread().getName());
                                                    return "Возвращает результат";
                                                });
        System.out.println(supplier.get() + "\n");

    //------------------------------------------------------------------------------------------------------------------

    // Cоздание CompletableFuture подразумевает запуск всей цепочки, которое имеет некоторую схожесть со Stream API
        AtomicLong val = new AtomicLong(0);
            // имеет единственный метод  - запустить
                Runnable task = () -> val.set(new Date().getTime());                    // добавили значение
            // принимает А и возвращает Б
                Function<Long, Date> dateConverter = (vals) -> new Date(vals);          // преобразовали в дату
            // принимает А и ничего не возвращает
            Consumer<Date> printer = date -> {
                    System.out.println(date + "\n");                                    // напечатали
                    System.out.flush();
            };

        CompletableFuture
                .runAsync(task)
                .thenApply((v) -> val.get())
                .thenApply(dateConverter)
                .thenAccept(printer);

    //------------------------------------------------------------------------------------------------------------------

    // объединяем результат CompletableFuture с результатом другого CompletableFuture
        Supplier newsSupplier = () -> getMessage();

        CompletableFuture<String> reader = CompletableFuture.supplyAsync(newsSupplier);     // получили Mess
        CompletableFuture.completedFuture("age!!")
                .thenCombine(reader, (a, b) -> b + a)                                       // cкладываем Mess+age!!
                .thenAccept(result -> System.out.println(result + "\n"))                    // печатаем
                .get();
                    //     стоить обратить внимание, что по умолчанию потоки будут демон-потоками,
                    // поэтому для наглядности мы используем get, чтобы дождаться результат.


    // возвращаем CompletableFuture
        CompletableFuture.completedFuture(2L)
                .thenCompose((x) -> CompletableFuture.completedFuture(x + 2))
                .thenAccept(result -> System.out.println(result + "\n"));


    // обработка ошибок
    //    методы принимают альтернативный CompletableStage и будут выполнены на том CompletableStage, который первее выполнится
        CompletableFuture.completedFuture(4L)
                .thenApply((a) -> {
                                     throw new IllegalStateException("error");
                                  })
                .thenApply((a) -> 3L)
                    .exceptionally(ex -> 50000L)
                    .thenAccept(ka -> System.out.println(ka));

    }

    public static String getMessage() {
        try {
            Thread.currentThread().sleep(3000);
            return "Mess";
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
