package C2_SOLID;

// концепция:        класс должен иметь только одну причину для изменения


//class Employee{           // все в одном не правильно, нужно раскидывать
//    int getSalary(){};            // выдача зарплаты
//    void cook(){};                // приготовление еды
//    void cleanFloor(){};          // чистить пол
//    void deliverFood(){};         // доставлять еду
//}

//---------------- вариант 1 ----------------------
class Employee{                                         // если что-то поменяется меняется только один класс
    int getSalary(){return 10;}
}

class Cook extends Employee{
    void cook(){}
}

class Janitor extends Employee{
    void cleanFloor(){}
}

class Deliver extends Employee{
    void deliverFood(){}
}

//---------------- вариант 2 ----------------------
interface Employee2{                                         // если что-то поменяется меняется только один класс
    int getSalary();
}

class Cook2 implements Employee2{
    void cook(){}

    @Override
    public int getSalary() {
        return 50;
    }
}

class Janitor2 implements Employee2{
    void cleanFloor(){}

    @Override
    public int getSalary() {
        return 70;
    }
}

class Deliver2 implements Employee2{
    void deliverFood(){}

    @Override
    public int getSalary() {
        return 80;
    }
}

//---------------- вариант 3 - паттерн Facade ----------------------
class EmployeeFacade{
    Cook cook = new Cook();
    Janitor janitor = new Janitor();
    Deliver deliver = new Deliver();

    void cook(){
        cook.cook();
    }

    void cleanFloor(){
        janitor.cleanFloor();
    }

    void deliverFood(){
        deliver.deliverFood();
    }
}


//-------------------------------------------------
public class A_SingleResponsibility {
    public static void main(String[] args) {
        EmployeeFacade employeeFacade = new EmployeeFacade();
            employeeFacade.cook();
            employeeFacade.cleanFloor();
            employeeFacade.deliverFood();
    }
}
