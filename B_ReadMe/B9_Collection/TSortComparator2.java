package B_ReadMe.B9_Collection;

import java.util.Arrays;
import java.util.Comparator;

//------------------------------------------- несколько видов сортировки -----------------------------------------------
    class Product{
        private String name;
        private float  price;
        private float  quantity;

        public Product (String name, float price, float quantity){
            this.name     = name;
            this.price    = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public float getPrice() {
            return price;
        }

        public float getQuantity() {
            return quantity;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public void setQuantity(float quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString(){
            return name + "', цена - "
                    + price
                    + ", количество - "
                    + quantity;
        }
    }

    class SortedByName implements Comparator<Product> {                         // сортировка по названию
        public int compare(Product obj1, Product obj2){
            String str1 = obj1.getName();
            String str2 = obj2.getName();
        return str1.compareTo(str2);
        }
    }

    class SortedByPrice implements Comparator<Product>{                         // сортировка по цене
        public int compare(Product obj1, Product obj2){
            float price1 = obj1.getPrice();
            float price2 = obj2.getPrice();
            if (price1 > price2) {
                return 1;
            } else if (price1 < price2) {
                return -1;
            } else {
                return 0;
            }
        }
    }


    // cортировка выполняется с помощью класса Arrays, у которого есть метод sort.
    //        -   Arrays.sort(T[] arg1, Comparator<? super T> arg2) - в качестве второго аргумента принимает тип компаратора

    // можно использовать также метод sort класса Collections, который в качестве первого входного аргумента принимает список объектов:
    //        -   Collections.sort(List<T> arg1, Comparator<? super T> arg2)

    public class TSortComparator2 {
        public static void main(String[] args){
            Product[] products = new Product[3];
                products[0] = new Product("Молоко", 35.56f,900.00f);
                products[1] = new Product("Кофе"  ,199.50f, 90.00f);
                products[2] = new Product("Чай"   , 78.50f,150.00f);

            System.out.println("~~~~~ без сортировки");                                         // данные без сортировки
            for(Product product : products)
                System.out.println(product.toString());

            Arrays.sort(products, new SortedByPrice());                                         // cортировка по цене
            System.out.println("\n~~~ сортировка по цене");
            for(Product product : products)
                System.out.println(product.toString());

            Arrays.sort(products, new SortedByName());                                          // cортировка по названию
            System.out.println("\n~~~ сортировка по названию");
            for(Product product : products)
                System.out.println(product.toString());
        }
    }

