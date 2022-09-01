package C1_Pattern.D_web;

// transfer object
class User{
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

//-------------------------------------------------------------------
interface Services{
    User getUser();
}

class ServiceEJB implements Services{
    @Override
    public User getUser(){
        User user = new User();
            user.setAge(13);
            user.setName("Max");
        return user;
    }
}

class ServiceABC implements Services{
    @Override
    public User getUser(){
        User user = new User();
            user.setAge(14);
            user.setName("Max2");
        return user;
    }
}

//-------------------------------------------------------------------
class BusinessObject{
    ServiceEJB serviceEJB = new ServiceEJB();
    ServiceABC serviceABC = new ServiceABC();

    public User getUserEJB(){
        return serviceEJB.getUser();
    }

    public User getUserABC(){
        return serviceABC.getUser();
    }
}

//-------------------------------------------------------------------
public class Z10_TransferObject {
    public static void main(String[] args) {
        BusinessObject businessObject = new BusinessObject();
            System.out.println(businessObject.getUserEJB().getName());
            System.out.println(businessObject.getUserABC().getName());
    }
}
