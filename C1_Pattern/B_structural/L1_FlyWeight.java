package C1_Pattern.B_structural;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Dev{
    void writeCode();
}

class JavDev implements Dev{
    @Override
    public void writeCode() {
        System.out.println("Java developer writes Java code ...");
    }
}

class CppDev implements Dev{
    @Override
    public void writeCode() {
        System.out.println("Cpp developer writes Cpp code ...");
    }
}

//----------------------------------------------------------------------------------------------------------------------
class DevFlyWeight{
    private static final Map<String, Dev> developers = new HashMap<>();

    public Dev getDeveloperbySpecial(String speciality){
        Dev dev = developers.get(speciality);

        if(dev == null){
            switch (speciality) {
                case "java":
                    System.out.println("Cоздается объект Java developer ...");
                    dev = new JavDev();
                    break;
                case "c++":
                    System.out.println("Создается объект C++ developer ...");
                    dev = new CppDev();
                    break;
            }
            developers.put(speciality, dev);
        }
        return dev;
    }
}

//----------------------------------------------------------------------------------------------------------------------
public class L1_FlyWeight {
    public static void main(String[] args) {
        DevFlyWeight devFlyWeight = new DevFlyWeight();

        List<Dev> devList = new ArrayList<>();                 // добавит 12 объектов, но создаст только 2
            devList.add(devFlyWeight.getDeveloperbySpecial("java"));
            devList.add(devFlyWeight.getDeveloperbySpecial("java"));
            devList.add(devFlyWeight.getDeveloperbySpecial("java"));
            devList.add(devFlyWeight.getDeveloperbySpecial("java"));
            devList.add(devFlyWeight.getDeveloperbySpecial("java"));
            devList.add(devFlyWeight.getDeveloperbySpecial("java"));
            devList.add(devFlyWeight.getDeveloperbySpecial("c++"));
            devList.add(devFlyWeight.getDeveloperbySpecial("c++"));
            devList.add(devFlyWeight.getDeveloperbySpecial("c++"));
            devList.add(devFlyWeight.getDeveloperbySpecial("c++"));
            devList.add(devFlyWeight.getDeveloperbySpecial("c++"));
            devList.add(devFlyWeight.getDeveloperbySpecial("c++"));

        System.out.println(devList.size());

        for(Dev el : devList)
            el.writeCode();
    }
}
