package C1_Pattern.B_structural;

import java.util.HashMap;
import java.util.Map;


// ограничить повторное создание одних и тех же объектов
class Mercedes {
    String color;
}


class FlyWeightGarage {
    Map<String, Mercedes> map = new HashMap<>();

    Mercedes getMercedes(String color){
        Mercedes mercedes = map.get(color);                     //проверяет есть ли в map такой объект
        if(mercedes == null){
            mercedes = new Mercedes();                              // создаем новый
            mercedes.color = color;
            map.put(color, mercedes);                               // добавляет в map
        }
    return mercedes;
    }
}


public class L2_FlyWeight {
    public static void main(String[] args) {
        FlyWeightGarage flyWeightGarage = new FlyWeightGarage();
        Mercedes mercedes = flyWeightGarage.getMercedes("green");
        Mercedes mercedes2 = flyWeightGarage.getMercedes("green");
        Mercedes mercedes3 = flyWeightGarage.getMercedes("red");
        System.out.println(mercedes == mercedes2);
        System.out.println(mercedes == mercedes3);
    }
}
