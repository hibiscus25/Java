package D_Algorithms;

import java.util.Arrays;
import java.util.Comparator;


//набрать в рюкзак предметы по максимально возможной ценности
public class FractionalKnapsack {
    public static void main(String[] args) {
        final Item item1 = new Item(4,20);          //предметы (масса, ценность)
        final Item item2 = new Item(3,18);
        final Item item3 = new Item(2,14);

        final Item[] items = {item1, item2, item3};

        // сортировка O(N*log(N)
        // соритрует по ценнности (от большего к меньшему)
        Arrays.sort(items, Comparator.comparingDouble(Item :: valuePerUnitOfWeight).reversed());
            System.out.println(Arrays.toString(items));

        final int W = 7;                            // вместимость рюкзака
            int weightSoFar = 0;                        // текущий вес
            double valueSoFar = 0;                      // ценность, которую уже набрали в рюкзак
            int currentItem = 0;                        // индекс текущего предмета


        while(currentItem < items.length  &&  weightSoFar != W){
            if (weightSoFar + items[currentItem].getWeight() < W){  //если текущий вес + вес всего предмета < вместимости
                    // берем объект целяком
                    valueSoFar += items[currentItem].getValue();
                    weightSoFar += items[currentItem].getWeight();

            }else {
                // берем только часть объекта
                valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight()) *
                        items[currentItem].getValue();

                weightSoFar = W; //полный рюкзак
            }
            currentItem++;

        }
        System.out.println("Ценность наилучшего набора: " + valueSoFar);
    }
}


// описание предмета
class Item{
    private int weight;                              // масса
    private int value;                               // ценность

    public Item(int weight, int value){
        this.weight = weight;
        this.value = value;
    }

    public double valuePerUnitOfWeight(){            // значение на единицу веса
        return value / (double) weight;
    }

    public int getWeight(){
        return weight;
    }

    public int getValue(){
        return value;
    }

    public String toString(){
        return "{w:" + weight + ",v" + value + "}";
    }
}
