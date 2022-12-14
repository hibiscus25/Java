package A_GROM_lesson.lesson14;

public class Test implements Cloneable {
  private int someNumber;
  private String name;

  public Test(int someNumber, String name) {
      this.someNumber = someNumber;
      this.name = name;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
      return super.clone();
  }

  public static void main(String[] args) throws CloneNotSupportedException {
        Test test=new Test(10000,"name");
        System.out.println(test);
        System.out.println(test.hashCode());

        Test test1=(Test) test.clone();
        System.out.println(test1);
        System.out.println(test1.hashCode());

        Test tes2=new Test(test.getSomeNumber(),test.getName());
  }

    public int getSomeNumber() {
        return someNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "B_readMe.Test{" +
                "someNumber=" + someNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
