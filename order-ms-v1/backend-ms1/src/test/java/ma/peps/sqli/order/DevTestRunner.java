package ma.peps.sqli.order;

import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.BeforeAll;


public class DevTestRunner {


    @BeforeAll
    public static void beforeAll() {
        System.setProperty("karate.env", "localhost");
    }

    @Karate.Test
    Karate SadOrderDuplicate() {
        return Karate.run("test/SadOrderTest").tags("duplicate").relativeTo(getClass());
    }

    @Karate.Test
    Karate HappyOrderDelete() {
        return Karate.run("test/HappyOrderTest").tags("Delete").relativeTo(getClass());
    }

    @Karate.Test
    Karate HappyOrderFindAll() {
        return Karate.run("test/HappyOrderTest").tags("FindAll").relativeTo(getClass());
    }


    @Karate.Test
    Karate HappyOrderSave() {
        return Karate.run("test/HappyOrderTest").tags("Save").relativeTo(getClass());
    }


}
