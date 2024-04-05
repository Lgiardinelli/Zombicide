package zombicide.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InfraredGlassesTest {

    private InfraredGlasses infraredGlasses;

    @BeforeEach
    public void setUp() {
        infraredGlasses = new InfraredGlasses();
    }

    @Test
    public void init() {
        assertFalse(infraredGlasses.canOpen());
        assertFalse(infraredGlasses.canAttack());
        assertFalse(infraredGlasses.isNoisyWhenUsedToOpenDoor());
        assertFalse(infraredGlasses.isNoisyWhenUsed());
    }
}
