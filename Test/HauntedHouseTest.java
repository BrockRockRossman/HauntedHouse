import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class HauntedHouseTest {

    static HauntedHouse house;

    @BeforeEach
    void setUp() {
        house = new HauntedHouse();
    }

    @Test
    void isGhostPresent() {

        boolean presence = house.isGhostPresent(); // Actual Value
        assertTrue(presence);

    }

    @Test
    void scareAwayGhost() {
        boolean presence = house.isGhostPresent(); // Actual Value Before Scare
        assertTrue(presence);
        house.scareAwayGhost();
        presence = house.isGhostPresent(); // Actual Value After Scare
        assertFalse(presence);

    }

    @Test
    void scareAwayNoGhost() {

        boolean presence = house.isGhostPresent(); // Actual Value Before Scare
        assertTrue(presence);
        house.scareAwayGhost();
        presence = house.isGhostPresent(); // Actual Value After Scare
        assertFalse(presence);
        house.scareAwayGhost();
        presence = house.isGhostPresent(); // Actual Value After Scare Again
        assertFalse(presence);

    }

    @Test
    void refillCandyBowlPos() {

        assertEquals(10, house.getCandyCount()); // Starting value of candy in the house
        house.refillCandyBowl(10); // Adding candy to bowl
        assertEquals(20, house.getCandyCount()); // Final value of candy in the house

    }

    @Test
    void refillCandyBowlNeg() {

        assertEquals(10, house.getCandyCount()); // Starting value of candy in the house
        house.refillCandyBowl(-10); // Adding candy to bowl
        assertEquals(10, house.getCandyCount()); // Final value of candy in the house

    }


    @Test
    void trickOrTreat() {

        house.trickOrTreat(5);
        assertEquals(5, house.getCandyCount());

    }

    @Test
    void trickOrTreatNoCandy() {

        house.trickOrTreat(15);
        assertEquals(0, house.getCandyCount());

    }

    @Test
    void getCandyCount() {
        assertEquals(10, house.getCandyCount()); // Verify that candy count matches initial
    }

    @Test
    void spookySound() {

        assertEquals("Boo!", house.spookySound());
    }

    @Test
    void testToStringInitial() {

        assertEquals("The house is haunted by a Ghost and has 10 candy.", house.toString()); // Checks
    }

    @Test
    void testToStringNoGhost() {

        house.scareAwayGhost();
        assertEquals("The house has 10 candy.", house.toString()); // Checks
    }

    @Test
    void testToStringChangeCandy() {

        house.trickOrTreat(5);
        assertEquals("The house is haunted by a Ghost and has 5 candy.", house.toString()); // Checks
    }
}