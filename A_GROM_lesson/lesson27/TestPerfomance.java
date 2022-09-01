package A_GROM_lesson.lesson27;

import java.util.*;

public class TestPerfomance {
    public static void main(String[] args) {
        testAddMethod();
        testRemoveMethod();
        testGetMethod();
    }

    private static void testAddMethod(){                //в среднем Linkedin - быстрее
        //arrayList
        ArrayList<String> arrayList=new ArrayList<>();
        Date start=new Date();
//        for(int i=0;i<100_000;i++){                               //1 - будет дольше
//            arrayList.add(0,String.valueOf(i));
//        }
                for(int i=0;i<100_000;i++){                         //2 - практически одинаковы
                    arrayList.add(i,String.valueOf(i));
                }
        Date finish=new Date();
        System.out.println("add-ArrayList: "+(start.getTime()-finish.getTime()));

        //LinkedList
        LinkedList<String> linkedList=new LinkedList<>();
        Date start1=new Date();
//        for(int i=0;i<100_000;i++){                                 //1- намного быстрее
//            linkedList.add(0,String.valueOf(i));
//        }
                for(int i=0;i<100_000;i++){                         //2 - практически одинаковы
                    linkedList.add(0,String.valueOf(i));
                }
        Date finish1=new Date();
        System.out.println("add-LinkedList: "+(start1.getTime()-finish1.getTime()));
     }

    private static void testRemoveMethod(){                 //в среднем Linkedin - быстрее
        //arrayList
        ArrayList<String> arrayList=new ArrayList<>();
        for(int i=0;i<100_000;i++){
            arrayList.add(i,String.valueOf(i));
        }

        Date start=new Date();
//        for(int i=0;i<10000;i++){                      //1- вариант - в начале списка - намного больше
//            arrayList.remove(0);
//        }
//            for(int i=0;i<97000;i++){                  //2- вариант - в 3 раза больше
//                arrayList.remove(3000);
//            }
                for(int i=0;i<90000;i++){                //3- вариант - в 2 раза быстрее
                    arrayList.remove(10000);
                }
        Date finish=new Date();
        System.out.println("remove-ArrayList: "+(start.getTime()-finish.getTime()));

        //LinkedList
        LinkedList<String> linkedList=new LinkedList<>();
        for(int i=0;i<100_000;i++){
            linkedList.add(i,String.valueOf(i));
        }
        Date start1=new Date();
//        for(int i=0;i<10000;i++){                       //1- вариант - в начале списка - намного меньше
//            linkedList.remove(0);
//        }
//            for(int i=0;i<97000;i++){                   //2- вариант - в 3 раза меньше
//                linkedList.remove(3000);
//            }
                for(int i=0;i<90000;i++){                 //2- вариант - в 2 раза больше
                    linkedList.remove(10000);
                }
        Date finish1=new Date();
        System.out.println("remove-LinkedList: "+(start1.getTime()-finish1.getTime()));
    }

    private static void testGetMethod(){                //ArrrayList - мгновенно
        //arrayList
        ArrayList<String> arrayList=new ArrayList<>();
        for(int i=0;i<100_000;i++){
            arrayList.add(i,String.valueOf(i));
        }

        Date start=new Date();
        for(int i=0;i<100_000;i++){
//            arrayList.get(0);                   //1-будет одинаково
//            arrayList.get(99_999);              //2-будет одинаково
            arrayList.get(50_000);                //3-будет очень быстро
        }
        Date finish=new Date();
        System.out.println("get-ArrayList: "+(start.getTime()-finish.getTime()));

        //LinkedList
        LinkedList<String> linkedList=new LinkedList<>();
        for(int i=0;i<100_000;i++){
            linkedList.add(i,String.valueOf(i));
        }

        Date start1=new Date();
        for(int i=0;i<100_000;i++){
//              linkedList.get(0);                //1 - будет одинаково  - ищет с начала
//              linkedList.get(99_999);           //2 - будет одинаково  - потому что ищет с конца
              linkedList.get(50_000);             //3 - будет намного дольше
        }
        Date finish1=new Date();
        System.out.println("get-LinkedList: "+(start1.getTime()-finish1.getTime()));
    }
}
