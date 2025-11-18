package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstJunitTest {

    @Test
    public void firstTest(){
        Assertions.assertTrue(3>2);
    }
}
