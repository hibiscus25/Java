package B_ReadMe.B8_Serializable;

import java.io.Serializable;

//без добавления в класс Person implements Serializable при записи в файл будет выдавать ошибку
//        - NotSerializableException:
//        - добавление implements Serializable, является разрешением на сериализация объекта
public class Person implements Serializable {
    private int id;
    private String name;

//    private transient int id;         //если нехотим сериализовывать именно это поле - указываем transient  - будет 0
//    private transient String name;    //если нехотим сериализовывать именно это поле - указываем transient  - будет null

//    private static final long serialVersionUID = -5340368479803005713L; //меняется если меняется объект кардинально

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
