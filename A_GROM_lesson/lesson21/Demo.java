package A_GROM_lesson.lesson21;

public class Demo {

    {
        //logic
    }


    public static void main(String[] args) throws Exception {
        Company company=new Company(100,"Nokia");

        //call of method by class
        Company.setLicence("GTH999");

        System.out.println(company.getLicence());

        Company company1=new Company(9,"B_readMe.Test");
        System.out.println(company1.getLicence());

        Company.setLicence("TTT11");

        System.out.println(company.getLicence());
        System.out.println(company1.getLicence());

        Company.validate();

        //demo utils
        int min=ArrayUtils.minElement(new int[]{1,10,40});
    }
}
