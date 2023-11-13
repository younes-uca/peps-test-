package ma.peps.sqli.app;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;


public class DevTestRunner {


    @BeforeAll
    public static void beforeAll() {
        System.setProperty("karate.env", "localhost");
    }

    @Karate.Test
    Karate HappyAppTest() {
        return Karate.run("test/HappyAppTest").tags("CheckAppUp").relativeTo(getClass());
    }



}
