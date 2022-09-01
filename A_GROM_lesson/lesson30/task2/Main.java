package A_GROM_lesson.lesson30.task2;

import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{
        //bankers
        UkrainianBankSystem ukrainianBankSystem=new UkrainianBankSystem();

        //bank
        USBank usBank= new USBank(1,"USBank", Currency.EURO,100,1800,1,444433340);
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

        ukrainianBankSystem.withdraw(user,250);
        Thread.sleep(2000);
        ukrainianBankSystem.fund(user2,100);
        Thread.sleep(2000);
        ukrainianBankSystem.paySalary(user3);
        Thread.sleep(2000);
        ukrainianBankSystem.transferMoney(user4,user3,50);
        Thread.sleep(2000);
        Set<Transaction> transaction=ukrainianBankSystem.getTransactions();
        for(Transaction tr:transaction){
            System.out.println(tr);
        }
    }
}