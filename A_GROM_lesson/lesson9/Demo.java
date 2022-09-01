package A_GROM_lesson.lesson9;

import A_GROM_lesson.lesson9.utils.Checker;

public class Demo {
    public static void main(String[] args) {
        String name=null;
        String countryFounded=null;
        Company company = new Company(name, countryFounded);

        System.out.println(company.getCountryFounded());
        System.out.println(company.getName());

        company.setName("NewValue");
        company.setName("IBM");

        Checker checker=new Checker();
        System.out.println(checker.checkCompanyName(company.getName()));
//      System.out.println(checker.companyNamesValidatedCount);

    }
}
