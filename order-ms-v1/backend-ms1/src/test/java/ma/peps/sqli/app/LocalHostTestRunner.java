package ma.peps.sqli.app;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;


public class LocalHostTestRunner {


    @BeforeAll
    public static void beforeAll() {
        System.setProperty("karate.env", "localhost");
    }

    @Karate.Test
    Karate HappyOrderDelete() {
        return Karate.run("test/HappyAppTest").tags("CheckAppUp").relativeTo(getClass());
    }



}
