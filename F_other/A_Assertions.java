package F_other;

import java.io.IOException;

// добавляется в VM option:   - ea              - включает assert
public class A_Assertions {
    public static void main(String[] args) {
        int x = 4;
        assert x < 3 : "ballll";

        assert x > 2 : new IOException("Blablaa");
    }
}
