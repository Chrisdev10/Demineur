package be.technifutur.demineurApp;

import be.technifutur.java2021.api.ApplicationFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemineurFactoryTest {

    @Test
    public void testgetApplicationNotNull() {
        ApplicationFactory fact = new DemineurFactory();
        assertNotNull(fact.getApplication());
    }
}
