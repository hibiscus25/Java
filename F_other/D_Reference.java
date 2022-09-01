package F_other;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class D_Reference {
    public static void main(String[] args) throws InterruptedException {
//        Object o = new Object();    // пока есть ссылка на объект, этот объект не может быть собран GarbageCollection
//            o = null;
//
//        // ccылка, которая позволяет вытянуть ссылку - но эта ссылка удалиться при запуске GarbageCollection
//        WeakReference<Object> weak = new WeakReference<>(o);
//            Object o1 = weak.get();
//
//        // аналогична с  WeakReference, но живет, когда будет заполнена память
//        SoftReference<Object> soft = new SoftReference<>(o);
//
//        // для подтверждения, что объект был собран GarbageCollection
//        Object o2 = new Object();
//        ReferenceQueue<Object> ref = new ReferenceQueue<>();
//        PhantomReference<Object> ob = new PhantomReference<>(o2, ref);
//            o2 = null;
//            new Thread (){
//                @Override
//                public void run(){
//                    try{
//                        ref.remove();
//                        System.out.println("reference was removed");
//                    }catch (InterruptedException e){}
//                }
//            }.start();
//        System.out.println("start gc");
//        System.gc();
//        System.out.println("gc was started");
//        Thread.sleep(3000);
//        System.out.println("\n");

    //------------------------------------------------------------------------------------------------------------------
//        MyObject o2 = new MyObject();
//        ReferenceQueue<MyObject> reference = new ReferenceQueue<>();
//        PhantomReference<MyObject> ob2 = new PhantomReference<>(o2, reference);
//        o2 = null;
//            new Thread (){
//                @Override
//                public void run(){
//                    try{
//                        reference.remove();
//                        System.out.println("reference was removed");
//                    }catch (InterruptedException e){}
//                }
//            }.start();
//        System.out.println("start gc");
//        System.gc();
//        System.out.println("gc was started");

    //------------------------------------------------------------------------------------------------------------------
//        MyObject o3 = new MyObject();
//            WeakReference<MyObject> weak3 = new WeakReference<>(o3);
//            ReferenceQueue<MyObject> reference3 = new ReferenceQueue<>();
//            PhantomReference<MyObject> ob3 = new PhantomReference<>(o3, reference3);
//        o3 =  null;
//            System.out.println(weak3.get());                // cодержит ссылку, до первой сборки мусора
//            System.out.println(ob3.get());                  // всегда null
//            System.gc();
//            System.out.println("-----------------");
//            System.out.println(weak3.get());
//            System.out.println(ob3.get());                  // всегда nul

        // устанавливаем объем памяти  - 1m  (VM options:  -Xmx1m)
        MyObject o4 =  new MyObject();
        SoftReference<MyObject> soft4 = new SoftReference<>(o4);
        WeakReference<MyObject> weak4 = new WeakReference<>(o4);
        ReferenceQueue<MyObject> reference4 = new ReferenceQueue<>();
        PhantomReference ob4 = new PhantomReference<>(o4, reference4);
        o4 =  null;
            List<Integer> list = new ArrayList<>();
                for(int i =0; i < 40_000; i++)
                    list.add(i);
            System.out.println(soft4.get());                // cодержит ссылку, до очищения памяти
            System.out.println(weak4.get());                // cодержит ссылку, до первой сборки мусора
            System.out.println(ob4.get());                  // всегда null
            System.gc();
            System.out.println("start Garbage Collection");
            Thread.sleep(1000);
            System.out.println("-----------------");
            System.out.println(soft4.get());
            System.out.println(weak4.get());
            System.out.println(ob4.get());

    }

    static class MyObject {
        @Override
        protected void finalize() throws Throwable{
            System.out.println("Object was finalized");
        }
    }
}
