package A_GROM_lesson.lesson12;

public class Main {
    public static void main(String[] args) {
        //bankers
        BankSystem bankSystem=new UkrainianBankSystem();

        //bank
        USBank usBank= new USBank(1,"USBank",Currency.EURO,100,1800,1,444433340);
        USBank usBank2= new USBank(1,"USBank",Currency.USD,100,1800,1,444433340);

        EUBank euBank= new EUBank(2,"EUBank",Currency.EURO,100,2100,4,24433340);
        EUBank euBank2= new EUBank(2,"EUBank",Currency.USD,100,2100,4,24433340);

        ChinaBank chinaBank= new ChinaBank(1222,"ChinaBank",Currency.EURO,100,1400,5,17433340);
        ChinaBank chinaBank2= new ChinaBank(1222,"ChinaBank",Currency.USD,100,1400,5,17443334);

        //user
        User user=new User(1,"Denis",10000,40,"GMD",1000,usBank);
        User user1=new User(2,"Evgen",10000,40,"GMD",1000,usBank2);
        User user2=new User(3,"Alex",10000,40,"GMD",1000,euBank);
        User user3=new User(4,"Nord",10000,40,"GMD",1000,euBank2);
        User user4=new User(5,"Sama",10000,40,"GMD",1000,chinaBank);
        User user5=new User(6,"Kim",10000,40,"GMD",1000,chinaBank2);
        User[]  users= {user,user1,user2,user3,user4,user5};

    //variants
        for(int i=0;i<users.length;i++){
            bankSystem.paySalary(users[i]);
            System.out.println(users[i].getBalance());
        }
        System.out.println("");

        for(int i=0;i<users.length;i++){
            bankSystem.withdraw(users[i],500);
        }
        System.out.println("");
        for(int i=0;i<users.length;i++){
            System.out.println(users[i].getBalance());
        }
        System.out.println("");

        System.out.println(""+user2.getBalance()+"    -    "+user4.getBalance());
        bankSystem.transferMoney(user2,user4,12000);
        System.out.println(""+user2.getBalance()+"    -    "+user4.getBalance());
    }
}