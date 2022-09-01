package B_ReadMe.B9_Collection;

import java.util.TreeSet;

    //  В примере значения сортируются сначала по полю str (по алфавиту), а затем по num в методе compareTo.
    //  Это хорошо видно по двум строкам с одинаковыми значения str и различными num.
    class Compare implements Comparable<Object>{
        String  str;
        int num;
        String  TEMPLATE = "num = %d, str = '%s'";

        Compare(String str, int num){
            this.str = str;
            this.num = num;
        }

//        @Override
//        public int compareTo(Object obj){
//            Compare entry = (Compare) obj;
//            int result = str.compareTo(entry.str);
//            if(result != 0)
//                return result;
//            result = num - entry.num;
//            if(result != 0)
//                return (int) result / Math.abs( result );
//            return 0;
//        }

        //cортировка в обратном порядке
        @Override
        public int compareTo(Object obj) {
            Compare entry = (Compare) obj;
            int result = ((Compare)obj).str.compareTo(str);
            if(result != 0)
                return result;
            result = entry.num - num;
            if(result != 0)
                return (int) result / Math.abs(result);
            return 0;
        }

        @Override
        public String toString(){
            return String.format(TEMPLATE, num, str);
        }
    }

    public class SortСomparable {
        public static void main(String[] args){
            TreeSet<Compare> data = new TreeSet<Compare>();
            data.add(new Compare("Начальная школа"  , 234));
            data.add(new Compare("Начальная школа"  , 132));
            data.add(new Compare("Средняя школа"    , 357));
            data.add(new Compare("Высшая школа"     , 246));
            data.add(new Compare("Музыкальная школа", 789));
            for (Compare e : data)
                System.out.println(e.toString());
        }
    }


