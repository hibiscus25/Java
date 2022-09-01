package C1_Pattern.D_web;

import java.util.ArrayList;
import java.util.List;



interface Service{
    String getName();
    void execute();
}

class Service1 implements Service{

    @Override
    public String getName() {
        return "Service1";
    }

    @Override
    public void execute() {
        System.out.println("Executing Service1");
    }
}

class Service2 implements Service{

    @Override
    public String getName() {
        return "Service2";
    }

    @Override
    public void execute() {
        System.out.println("Executing Service2");
    }
}

//------------------------------------------------------------------
class InitialContext{

    public Object lookup(String jndiName){
        if(jndiName.equalsIgnoreCase("SERVICE1")){
            return new Service1();
        }else if(jndiName.equalsIgnoreCase("SERVICE2")){
            return new Service2();
        }
        return null;
    }
}

//------------------------------------------------------------------
class Cache{                                                            // будет все кэшировать
    private List<Service> services = new ArrayList<>();

    public Service getService(String serviceName){
        for(Service el : services){
            if(el.getName().equalsIgnoreCase(serviceName)){
                System.out.println("Returning cached " + serviceName + " object");
                return el;
            }
        }
        return null;
    }

    public void addService(Service newService){
        boolean exists = false;
        for(Service el : services){
            if(el.getName().equalsIgnoreCase(newService.getName()))
                exists = true;
        }
        if(!exists)
            services.add(newService);
    }
}

//------------------------------------------------------------------
class ServiceLocator{
    private static Cache cache;

    static{
        cache = new Cache();
    }

    public static Service getService(String jndiName){
        Service service = cache.getService(jndiName);
        if(service != null)                                             // если в cache ecть возвращает
            return service;
        InitialContext context = new InitialContext();
        Service service1 = (Service) context.lookup(jndiName);          // создает новый
        cache.addService(service1);                                             // добавляет в cache
    return service1;
    }
}


//------------------------------------------------------------------
public class Z9_ServiceLocator {
    public static void main(String[] args) {
        Service service = ServiceLocator.getService("Service1");
                    service.execute();
                service = ServiceLocator.getService("Service1");        // взят из cache
                    service.execute();

        System.out.println();
                service = ServiceLocator.getService("Service2");
                    service.execute();
                service = ServiceLocator.getService("Service2");        // взят из cache
                    service.execute();
    }
}
