package C3_BestPractics;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class C_Composition {
    public static void main(String[] args) {
        InstrumentedHashSet<String> set = new InstrumentedHashSet<>();
            set.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(set.getAddCount());

        InstrumentedComposition<String> s = new InstrumentedComposition<>();
            s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }
}

class InstrumentedHashSet<E> extends HashSet<E>{
    private int addCount = 0;

    @Override
    public boolean add(E e) {
        if (e instanceof String)
            return false;
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount(){
        return addCount;
    }
}


class InstrumentedComposition<E>{
    private int addCount = 0;
    private final Set<E> set = new HashSet<E>();

    public boolean add(E e){
        if (e instanceof String)
            return false;
        addCount++;
        return set.add(e);
    }

    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return set.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}