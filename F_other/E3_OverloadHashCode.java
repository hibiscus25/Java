package F_other;

import java.util.HashMap;
import java.util.Map;

public class E3_OverloadHashCode {
    int i;
    int x;
    int k = i + x;

    /* HashCode должен:
            - использовать максимальный разброс значений;
            - в hash должны использоваться значения, которые используются в equals (можно меньше);
            - не использовать значения, которые считаются на основании других значений (пример к);
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        E3_OverloadHashCode that = (E3_OverloadHashCode) obj;
        return i == that.i &&  x==that.x;
    }

    @Override
    public int hashCode() {                         // будет работать - данные будут храниться в одном хэше
       // return 12;                                // но производительность будет очень плохая
       // return result;

        int result = 17;                            // так производительность будет хорошая
        return 31 * result + i;

//      return id;                                  // если есть id, можно его использовать как уникальное значение
    }

    public static void main(String[] args) {
        Map<E3_OverloadHashCode, String> map = new HashMap<>();
            map.put(new E3_OverloadHashCode(),"one");
        System.out.println(map.get(new E3_OverloadHashCode()));
    }
}
