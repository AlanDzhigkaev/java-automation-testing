package junit;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class FirstJunitTest {

    @Test
    public void firstTest(){
        Assertions.assertTrue(3>2);
    }
}
