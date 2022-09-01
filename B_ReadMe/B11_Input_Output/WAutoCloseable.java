package B_ReadMe.B11_Input_Output;


class MyClosable implements AutoCloseable{
    MyClosable() throws Exception {
        System.out.println("constructor");
        // throw new Exception("job exception");    // 1 - constructor   java.lang.Exception: job exception
    }

    void doJob() throws Exception {
        System.out.println("dojob");
        // throw new Exception("job exception");    // 2 - constructor   dojob   сlose   java.lang.Exception: job exception
        // throw new Exception("job exception");    // 4

        throw new Exception("job exception");       // 5
    }

    @Override
    public void close() throws Exception {
        System.out.println("сlose");
        // throw new Exception("close exception");    // 3 - constructor   dojob   сlose   java.lang.Exception: job exception
        // throw new Exception("close exception");    // 4 - будет два Exception, но один поглатит второй Exception
                                                      //      - constructor   dojob   сlose   java.lang.Exception: jobexception

        throw new Exception("close exception");       // 5  - constructor dojob   сlose  java.lang.Exception: job exception
    }                                                 //                                 java.lang.Exception: close exception
}


public class WAutoCloseable {
    public static void main(String[] args) {
        try(MyClosable myClosable = new MyClosable()){          // все открытые здесь ресурсы закрываются в ****
            myClosable.doJob();

            // ****
        }catch (Exception e){
            // System.out.println(e);                       // 1,2,3,4

            System.out.println(e);                          // 5     - выводится главный Exception
            Throwable[] throwab = e.getSuppressed();        //       - выводит подавленные Exception
            for(Throwable t : throwab)
                System.out.println(t);
        }
        finally {
             // myClosable.doJob()  - не видит, так как ресурс закрыт в месте ****
        }
    }
}
