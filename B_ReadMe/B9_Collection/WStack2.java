package B_ReadMe.B9_Collection;


//------------------------------------------- создание стека для любого типа объектов ----------------------------------
// данный стек имеет свойство - автоматически удваивать размер, если он переполнен
    public class WStack2 {
        private Object[] theArray;
        private int topOfStack;

        static final int DEFAULT_CAPACITY = 10;

        public WStack2(Object[] theArray, int topOfStack) {          // установка объема стека по умолчанию
            this.theArray = new Object[DEFAULT_CAPACITY];
            this.topOfStack = - 1;
        }

        boolean isEmpty(){                                          // проверка, пуст ли стек
            return topOfStack == -1;
        }

        Object top(){                                              // возвращает последний добавленный элемент стека
            if(isEmpty())                                          // не изменяет стек
                return null;
            return theArray [topOfStack];
        }

        void pop() {                                              // извлекает элемент из стека
            if(isEmpty())
                return;
            topOfStack--;
        }

        Object topAndPop(){                                        // извлекает и возвращает элемент с вершины стека
            if(isEmpty())
                return null;
            return theArray [topOfStack--];
        }

        void push(Object x){                                       // добавляет новый элемент в стек
            if(topOfStack + 1 == theArray.length)
                doubleArray();
            theArray [++topOfStack] = x;
        }

        void makeEmpty(){                                          // очистка стека
            topOfStack = -1;
        }

        private void doubleArray(){                                // внутренний метод удвоения размера стека
            Object[] newArray;

            newArray = new Object[theArray.length * 2];
            for(Object el: newArray){
                System.arraycopy(theArray,0,newArray,0,theArray.length);
            }
            theArray = newArray;
        }
    }
