package lashmemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Checks that every service calculates the right price.
 *
 * @author Mia Truong
 */
public class ServicePriceTest {

    /** Lash map shared by the extension services in these tests. */
    private LashMap lashMap;

    /** Builds a simple lash map before each test. */
    @BeforeEach
    public void setUp() {
        lashMap = new LashMap("Cat eye", "Wispy");
        lashMap.setLayer(LashMap.TOP, new LashLayer(11, 15, 0.07));
    }

    /** A full set is always its flat price. */
    @Test
    public void fullSetIsFlatPrice() {
        FullSet fullSet = new FullSet("Black", lashMap, 150);
        assertEquals(150, fullSet.calculatePrice(), 0.001);
    }

    /** A fill at 2 weeks uses the 2-week price. */
    @Test
    public void fillAtTwoWeeks() {
        Fill fill = new Fill("Black", lashMap, 2, 65, 80);
        assertEquals(65, fill.calculatePrice(), 0.001);
    }

    /** A fill under 2 weeks still uses the 2-week price. */
    @Test
    public void fillUnderTwoWeeks() {
        Fill fill = new Fill("Black", lashMap, 1, 65, 80);
        assertEquals(65, fill.calculatePrice(), 0.001);
    }

    /** A fill at 3 weeks uses the 3-week price. */
    @Test
    public void fillAtThreeWeeks() {
        Fill fill = new Fill("Black", lashMap, 3, 65, 80);
        assertEquals(80, fill.calculatePrice(), 0.001);
    }

    /** A fill past 3 weeks uses the 3-week price. */
    @Test
    public void fillPastThreeWeeks() {
        Fill fill = new Fill("Black", lashMap, 4, 65, 80);
        assertEquals(80, fill.calculatePrice(), 0.001);
    }

    /** A lash lift without the add-on is just the flat price. */
    @Test
    public void liftWithoutAddOn() {
        KoreanLashLift lift = new KoreanLashLift("Brown", 85);
        assertEquals(85, lift.calculatePrice(), 0.001);
    }

    /** A lash lift with light extensions adds the add-on price. */
    @Test
    public void liftWithLightExtensions() {
        KoreanLashLift lift = new KoreanLashLift("Brown", 85, 35, lashMap);
        assertEquals(120, lift.calculatePrice(), 0.001);
    }

    /** An appointment gets its price from its service (polymorphism). */
    @Test
    public void appointmentAsksServiceForPrice() {
        Appointment visit = new Appointment("10/28/2026",
                new Fill("Black", lashMap, 2, 65, 80), 75, "Test visit");
        assertEquals(65, visit.getPrice(), 0.001);
    }
}
