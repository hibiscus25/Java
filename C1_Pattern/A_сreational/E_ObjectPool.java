package C1_Pattern.A_сreational;

import java.util.LinkedList;
import java.util.List;

// используется для уменьшения создания объектов
class Persona{

}

class ObjectPool{
    List<Persona> free = new LinkedList<>();            // пустой
    List<Persona> used = new LinkedList<>();

    public Persona getPersona(){
        if(free.isEmpty()){                             // если пустой
            Persona persona = new Persona();                // создаем
                free.add(persona);                          // добавляем в массив
        return persona;
        }else{
            Persona persona = free.get(0);              // если не пустой
            used.add(persona);                              // добавляем в массив
            free.remove(persona);                           // с пустого удаляем
            return persona;
        }
    }

    public void releasePooledObject(Persona persona){
        used.remove(persona);
        free.add(persona);
    }
}

public class E_ObjectPool {
    public static void main(String[] args) {
        ObjectPool objectPool = new ObjectPool();
        Persona persona = objectPool.getPersona();          // достали
            //......                                        // использовали
        objectPool.releasePooledObject(persona);            // удалили

    }
}
