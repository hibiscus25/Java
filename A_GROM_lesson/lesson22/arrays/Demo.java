package A_GROM_lesson.lesson22.arrays;


public class Demo {
    public static void main(String[] args) {
        int[] array = {10, 4, 6, 9, 5, 4};
        System.out.println(ArrayUtils.nCount(array, 4));
        System.out.println(ArrayUtils.maxElement(array));
        System.out.println(ArrayUtils.sortAscending(array));
        System.out.println(ArrayUtils.sortDescending(array));
    }
}
