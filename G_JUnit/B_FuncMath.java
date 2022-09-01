package G_JUnit;

import G_JUnit.java.FuncMath;
import org.junit.*;


//public class JUnit_funcMath{
//    private FuncMath math;
//
//    @Before
//    public void init() {
//        math = new FuncMath();
//    }
//
//    @After
//    public void tearDown() {
//        math = null;
//    }
//
//
//    //------------------------------------------------------------------------------------
////    @Test
////    public void calls() {
////        Assert.assertEquals("math.getCalls() != 0", 0, dao.getConnection());
////            math.factorial(1);
////        Assert.assertEquals(1, math.getCalls());
////            math.factorial(1);
////        Assert.assertEquals(2, math.getCalls());
////    }
//
//    @Test
//    public void factorial() {
//        Assert.assertTrue(math.factorial(0) == 1);
//        Assert.assertTrue(math.factorial(1) == 1);
//        Assert.assertTrue(math.factorial(5) == 120);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void factorialNegative() {
//        math.factorial(-1);
//    }
//
//
//    //------------------------------------------------------------------------------------
//    @Ignore
//    @Test
//    public void todo() {
//        Assert.assertTrue(math.plus(1, 1) == 3);
//    }
//}
