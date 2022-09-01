package B_ReadMe.B2.CloneObject;

//--------------------------------------------- клонирование объектов --------------------------------------------------
    class MyObject{
        int i;
    }

    //-----------------------------------------------------------------------------------------------------------------
    class ObjectClone implements Cloneable{                     // интерфейс, является маркерным интерфейсом
        int i;

        @Override
        protected ObjectClone clone() throws CloneNotSupportedException {
            return (ObjectClone) super.clone();
        }
    }

    //-----------------------------------------------------------------------------------------------------------------
    class NewObject implements Cloneable{
        int j;

        @Override
        protected NewObject clone() throws CloneNotSupportedException {
            return (NewObject) super.clone();
        }
    }


    class ObjectCloneFull implements Cloneable{
        int i;
        NewObject newObject;

        @Override
        protected ObjectCloneFull clone() throws CloneNotSupportedException {
            ObjectCloneFull ob = (ObjectCloneFull) super.clone();
            ob.newObject = newObject.clone();
            return ob;
        }
    }



    public class Main {
        public static void main(String[] args) throws CloneNotSupportedException {
                // не происходит клонирование, а просто меняются ссылки до объекта
                MyObject myObject = new MyObject();
                    myObject.i = 1;
                MyObject myObject1 = myObject;
                    myObject1.i = 2;
                    System.out.println("Пример 1: " + myObject.i);

                // поверхностное клонирование объекта
                ObjectClone obj = new ObjectClone();
                    obj.i = 1;
                ObjectClone obj1 = obj.clone();
                    obj1.i = 2;
                    System.out.println("Пример 2: " + obj.i);

                // глубокое клонирование объекта, когда в объекте есть ссылочный тип
                ObjectCloneFull objFull = new ObjectCloneFull();
                    objFull.i = 3;
                    NewObject newObject = new NewObject();
                        newObject.j = 4;
                        objFull.newObject = newObject;
                ObjectCloneFull objFull1 = objFull.clone();
                    objFull1.i = 33;
                        System.out.print("Пример 3: ");
                        System.out.print(objFull.i + "   ");
                    objFull1.newObject.j = 44;
                        System.out.println(objFull.newObject.j);
    }
}
