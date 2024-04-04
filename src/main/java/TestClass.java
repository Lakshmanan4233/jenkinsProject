import org.testng.annotations.*;

public class TestClass {

//    public static void main(String[] args) {
//
//        //System.getProperties().list(System.out);
//
////        System.out.println(System.getProperty("os.name"));
////        System.out.println(System.getProperty("java.version"));
////        System.out.println(System.getProperty("user.name"));
//        System.out.println(System.getProperty("user.dir"));
//
//    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @Test
    public void Test(){
        System.out.println("Test...");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
}
