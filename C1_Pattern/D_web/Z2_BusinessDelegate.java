package C1_Pattern.D_web;


// решение для сетевых приложений (кэширование вэб серверов)

interface BusinessService{
    void doJob();
}

class EJBService implements BusinessService{
    @Override
    public void doJob() {
        System.out.println("do ejb job");
    }
}

class JMCService implements BusinessService{
    @Override
    public void doJob() {
        System.out.println("do jms job");
    }
}

//-------------------------------------------------------------
class LookUpService{                                                     // cоздание и получение BusinessService
    BusinessService getService(String seviceType){
        if(seviceType.equals("ejb")){
            return new EJBService();
        } else {
            return new JMCService();
        }
    }
}

//-------------------------------------------------------------
class BusinessDelegat{                                                    // предоставляет доступ и запускает его
    LookUpService lookUpService = new LookUpService();
    BusinessService businessService;

    void doTask(String seviceType){
        businessService = lookUpService.getService(seviceType);
        businessService.doJob();
    }
}

//-------------------------------------------------------------
public class Z2_BusinessDelegate {
    public static void main(String[] args) {
        BusinessDelegat businessDelegat = new BusinessDelegat();
            businessDelegat.doTask("ejb");
    }
}
