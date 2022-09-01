package C1_Pattern.C_behavior;


interface Iterator{
    boolean hasNext();
    Object next();
}

interface Container{
    Iterator getIterator();
}

class ArrayContainer implements Container{
    String[] array = {"Max", "Jhon", "Mihkale"};

    @Override
    public Iterator getIterator() {
        return new ArrayIterator();
    }

    class ArrayIterator implements Iterator{
        int index;

        @Override
        public boolean hasNext() {
            return (index < array.length) ? true : false;
        }

        @Override
        public Object next() {
            if(hasNext())
                return array [index++];
            return null;
        }
    }
}

//--------------------------------------------------------------------------
public class Q_Iterator {
    public static void main(String[] args) {
        ArrayContainer array = new ArrayContainer();
            Iterator iterator = array. getIterator();
            while(iterator.hasNext())
                System.out.println(iterator.next());
    }
}
