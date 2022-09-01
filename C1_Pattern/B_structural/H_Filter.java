package C1_Pattern.B_structural;


import java.util.ArrayList;
import java.util.List;




class CarF{
    private int maxspeed;
    private String color;
    private int doors;

    public CarF(int maxspeed, String color, int doors) {
        this.maxspeed = maxspeed;
        this.color = color;
        this.doors = doors;
    }

    public int getMaxspeed() {
        return maxspeed;
    }

    public String getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        return "CarF{" +
                "maxspeed=" + maxspeed +
                ", color='" + color + '\'' +
                ", doors=" + doors +
                '}';
    }
}

// -------------------------------------------- Filter - вариант 1 --------------------------------------------------
interface CarFilter{
    List<CarF> filter(List<CarF> cars);
}


class SpeedFilter implements CarFilter{
    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = new ArrayList<>();
            for(CarF el : cars){
                if (el.getMaxspeed() > 155)
                    list.add(el);
            }
        return list;
    }
}

class DoorFilter implements CarFilter{

    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = new ArrayList<>();
        for(CarF el : cars){
            if (el.getDoors() < 5)
                list.add(el);
        }
        return list;
    }
}


// -------------------------------------------- Filter - вариант 2 --------------------------------------------------
class AndFilter implements CarFilter{
    CarFilter filterOne;
    CarFilter filterTwo;

    public AndFilter(CarFilter filterOne, CarFilter filterTwo){
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<CarF> filter(List<CarF> cars) {
        return filterTwo.filter(filterOne.filter(cars));
    }
}


// -------------------------------------------- Filter - вариант 3 -----------------------------------------------------
class OrFilter implements CarFilter{
    CarFilter filterOne;
    CarFilter filterTwo;

    public OrFilter(CarFilter filterOne, CarFilter filterTwo){
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = filterOne.filter(cars);       // 1 фильтр отфильтровал
                                                                                            System.out.println(list);
        List<CarF> list2 = filterTwo.filter(cars);      // 2 фильтр отфильтровал
                                                                                            System.out.println(list2);
        for(CarF el : list2){
                                                                                            System.out.println(el);
            if(!list.contains(el)) {
                System.out.println(el);
                list.add(el);
            }
        }
        return list;
    }
}


// ------------------------------------------------------------------------------------------------------
public class H_Filter {
    public static void main(String[] args) {
        List<CarF> cars = new ArrayList<>();
            cars.add(new CarF(150,"green",2));
            cars.add(new CarF(200,"blue",4));
            cars.add(new CarF(250,"red",5));

        // фильтр по одному параметру (все, кроме тех кто не соответствует фильтру)
            System.out.println(new SpeedFilter().filter(cars));
            System.out.println(new DoorFilter().filter(cars));

        // фильтр по нескольким параметрам (все, кроме тех кто не соответствуют 2 фильтрам)
            System.out.println();
            System.out.println(new AndFilter(new SpeedFilter(), new DoorFilter()).filter(cars));

        // фильтр в котором совпадают два параметра (общий результат = объекты фильтра 1 + объекты фильтра 2)
            System.out.println();
            System.out.println(new OrFilter(new SpeedFilter(), new DoorFilter()).filter(cars));
    }
}
