import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;


public class UatTestRunner {

    @BeforeAll
    public static void beforeAll() {
        System.setProperty("karate.env", "UAT");
    }

    @Karate.Test
    Karate HappyOrder(){
        return Karate.run("HappyOrderTest").tags("delete").relativeTo(getClass());
    }

}
