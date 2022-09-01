package C1_Pattern.C_behavior;

interface Strategy{
    double getPrice(double price);
}

class FullPrice implements  Strategy{
    @Override
    public double getPrice(double price) {
        return price;
    }
}

class HalfPrice implements  Strategy{
    @Override
    public double getPrice(double price) {
        return price * 0.5;
    }
}

//-------------------------------------------------------
class Contexts{
    Strategy strategy;

    public Contexts(Strategy strategy) {
        this.strategy = strategy;
    }

    public double getPrice(double price){
        return strategy.getPrice(price);
    }
}

//-------------------------------------------------------
public class V2_Strategy {
    public static void main(String[] args) {
        Contexts contexts = new Contexts(new HalfPrice());
        System.out.println(contexts.getPrice(100l));
    }
}
