package A_GROM_lesson.lesson9.utils;

public class Checker {
    //private - в пределах класса
    //default - в пределах пакета
    //protected - в пределах пакета/класса/наследников класса
    //public - везде

    int companyNamesValidatedCount = 0;

    public boolean checkCompanyName(String companyName) {
//      if (companyName == "Google" || companyName == "Amazon")
//            return false;
        if(companyNamesValidatedCount>10)
            return false;
        companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";
    }
}
