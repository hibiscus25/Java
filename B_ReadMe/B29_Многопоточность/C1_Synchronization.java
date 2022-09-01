package B_ReadMe.B29_Многопоточность;


public class C1_Synchronization {
    public static void main(String[] args) throws InterruptedException {
        // все методы, которые меняют значения должны быть  synchronized
        // synchronized - пока поток не дойдет до конца метода, никакой поток не начнет выполнение этого метода
        //              - блокирует объект, а не класс  -   если не статический метод
        //              - блокирует класс               -   если статический метод

        Resource resource = new Resource();
            resource.setI(5);

        MyThreed4 th = new MyThreed4();
            th.setResource(resource);
            th.setName("one");
        MyThreed4 th2 = new MyThreed4();
            th2.setResource(resource);

            th.start();
            th2.start();
            th.join();
            th2.join();
        System.out.println(resource.getI());
    }
}


class MyThreed4 extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
    }
}


class Resource{
    private int i;

    public synchronized void changeI(){                      // если не использовать synchronized =  7 / 6
        System.out.println(Thread.currentThread().getName() + "   " + this.i);
        int i = this.i;
        if(Thread.currentThread().getName().equals("one"))
            Thread.yield();
        i++;
        this.i = i;
    }


//    public void changeI(){
//            System.out.println(Thread.currentThread().getName() + "   " + this.i);   // не попадает под синхронизацию
//        synchronized (this) {                       // можно cинхронизировать блок - кода  для объекта
//            int i = this.i;
//            if (Thread.currentThread().getName().equals("one"))
//                Thread.yield();
//            i++;
//            this.i = i;
//        }
//    }

    public synchronized void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}