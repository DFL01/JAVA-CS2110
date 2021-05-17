package a1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PhdTest {

    @Test
    public void testConstructor1() {
        // creates a Phd object to be tested
        Phd professorPlum= new Phd("Plum", 2000, 2);

        // checks that the first constructor initializes its values correctly
        assertEquals("Plum", professorPlum.name());
        assertEquals("2/2000", professorPlum.date());
        assertEquals(null, professorPlum.advisor1());
        assertEquals(null, professorPlum.advisor2());
        assertEquals(0, professorPlum.nAdvisees());
    }

    @Test
    public void testMutators() {

        // creates three Phd objects to be tested
        Phd professorPlum= new Phd("Pizza", 2001, 6);
        Phd professorPeach= new Phd("Peach", 1979, 11);
        Phd professorPizza= new Phd("Pizza", 1980, 12);

        // configures the advisors of a Phd object to be tested
        professorPlum.setAdvisor1(professorPeach);
        professorPlum.setAdvisor2(professorPizza);

        // checks that the mutator methods changed the values of the advisors correctly, <br>
        // and that the value for advisees was incremented properly
        assertEquals(professorPeach, professorPlum.advisor1());
        assertEquals(professorPizza, professorPlum.advisor2());
        assertEquals(1, professorPeach.nAdvisees());
        assertEquals(1, professorPizza.nAdvisees());
    }

    @Test
    public void testConstructor2() {
        // creates three Phd objects to be tested
        Phd professorPeach= new Phd("Peach", 1978, 10);
        Phd professorPizza= new Phd("Pizza", 1981, 7);
        Phd professorPlum= new Phd("Plum", 2002, 4, professorPeach, professorPizza);

        // checks that the second constructor initializes its variables correctly, <br>
        // including the advisor and advisee variables
        assertEquals("Plum", professorPlum.name());
        assertEquals("4/2002", professorPlum.date());
        assertEquals(professorPeach, professorPlum.advisor1());
        assertEquals(professorPizza, professorPlum.advisor2());
        assertEquals(0, professorPlum.nAdvisees());
        assertEquals(1, professorPeach.nAdvisees());
        assertEquals(1, professorPizza.nAdvisees());
    }

    @Test
    public void test3BooleanFunctions() {
        // creates three Phd objects to test method hasNoAdvisees()
        Phd professorPeach= new Phd("Peach", 1978, 10);
        Phd professorPizza= new Phd("Pizza", 1981, 7);
        Phd professorPlum= new Phd("Plum", 2002, 4, professorPeach, professorPizza);

        // checks if the method hasNoAdvisees has returned the correct values
        assertEquals(true, professorPlum.hasNoAdvisees());
        assertEquals(false, professorPeach.hasNoAdvisees());
        assertEquals(false, professorPizza.hasNoAdvisees());

        // creates nine Phd objects to test method gotBefore(), accounting for <br>
        // the nine possible cases outlined by the instructions
        Phd feb77= new Phd("feb77", 1977, 2);
        Phd jun77= new Phd("jun77", 1977, 6);
        Phd dupJun77= new Phd("jun77", 1977, 6);
        Phd feb80= new Phd("feb80", 1980, 2);
        Phd mar80= new Phd("mar80", 1980, 3);
        Phd nov80= new Phd("nov80", 1980, 11);
        Phd nov70= new Phd("nov70", 1970, 11);
        Phd dec70= new Phd("dec70", 1970, 12);
        Phd jan70= new Phd("jan70", 1970, 1);

        // checks if the method gotBefore has returned the correct values
        assertEquals(true, feb77.gotBefore(jun77));
        assertEquals(false, jun77.gotBefore(dupJun77));
        assertEquals(false, jun77.gotBefore(feb77));

        assertEquals(true, jan70.gotBefore(feb80));
        assertEquals(true, nov70.gotBefore(nov80));
        assertEquals(true, dec70.gotBefore(nov80));

        assertEquals(false, mar80.gotBefore(dec70));
        assertEquals(false, nov80.gotBefore(nov70));
        assertEquals(false, feb80.gotBefore(jan70));

        // creates multiple Phd objects to test method areSibs()

        // tests when neither a nor b has an adviser.
        Phd professorPotato= new Phd("Potato", 1952, 4);
        Phd professorPapaya= new Phd("Papaya", 1965, 7);
        assertFalse(professorPotato.areSibs(professorPapaya));

        // tests when A and B are the same object and they have the same non-null first advisor
        professorPapaya.setAdvisor1(professorPotato);
        assertFalse(professorPapaya.areSibs(professorPapaya));

        // tests when A and B are different objects and they have the same first advisor
        Phd professorPeanut= new Phd("Peanut", 1964, 3);
        professorPeanut.setAdvisor1(professorPotato);
        assertTrue(professorPeanut.areSibs(professorPapaya));

        // tests when A and B are different objects and they have the same second advisor
        Phd professorPumpkin= new Phd("Pumpkin", 1951, 6);
        Phd professorPersimmon= new Phd("Persimmon", 1960, 10);
        Phd professorPepperoni= new Phd("Pepperoni", 1962, 12);
        professorPeanut.setAdvisor2(professorPepperoni);
        professorPersimmon.setAdvisor1(professorPumpkin);
        professorPersimmon.setAdvisor2(professorPotato);
        assertTrue(professorPeanut.areSibs(professorPapaya));

        // tests when A and B are different objects and the first advisor of one is the second
        // advisor of the other
        Phd professorPineapple= new Phd("Pineapple", 1966, 4);
        professorPineapple.setAdvisor1(professorPotato);
        assertTrue(professorPineapple.areSibs(professorPersimmon));

        // tests when A and B are different objects and they have different first advisors.
        Phd professorPecan= new Phd("Pecan", 1964, 7);
        professorPecan.setAdvisor1(professorPumpkin);
        assertFalse(professorPecan.areSibs(professorPineapple));

        // tests when A and B are different objects and they have different second advisors
        Phd professorPickle= new Phd("Pickle", 1950, 10);
        Phd professorPork= new Phd("Pork", 1969, 9);
        professorPork.setAdvisor1(professorPotato);
        professorPork.setAdvisor2(professorPickle);
        assertFalse(professorPork.areSibs(professorPotato));
    }

    @Test
    void testAsserts() {
        // constructor1 asserts
        assertThrows(AssertionError.class, () -> { new Phd("", 1450, 1); });
        assertThrows(AssertionError.class, () -> { new Phd("Popcorn", 130, 1); });
        assertThrows(AssertionError.class, () -> { new Phd("Popcorn", 2000, -1); });
        assertThrows(AssertionError.class, () -> { new Phd("Popcorn", 2000, 18); });

        // constructor2 asserts
        assertThrows(AssertionError.class, () -> { new Phd("", 1450, 1); });
        assertThrows(AssertionError.class, () -> { new Phd("Pomegranate", 130, 1); });
        assertThrows(AssertionError.class, () -> { new Phd("Pomegranate", 2000, -1); });
        assertThrows(AssertionError.class, () -> { new Phd("Pomegranate", 2000, 18); });

        Phd paprika= new Phd("tester", 1800, 1);
        assertThrows(AssertionError.class,
            () -> { new Phd("Paprika", 2000, 1, paprika, null); });
        assertThrows(AssertionError.class,
            () -> { new Phd("Paprika", 2000, 1, null, paprika); });
        assertThrows(AssertionError.class,
            () -> { new Phd("Paprika", 2000, 1, paprika, paprika); });

        // creates Phd objects to test the asserts in methods setAdvisor1() & setAdvisor2()
        Phd professorPickle= new Phd("Pickle", 1950, 10);
        Phd professorPotato= new Phd("Potato", 1952, 4);
        Phd professorPeach= new Phd("Peach", 1961, 8);
        Phd professorPeanut= new Phd("Peanut", 1960, 3);

        // setAdvisor1() and setAdvisor2() asserts
        assertThrows(AssertionError.class, () -> { professorPeach.setAdvisor1(null); });
        professorPeach.setAdvisor1(professorPotato);
        assertThrows(AssertionError.class, () -> { professorPeach.setAdvisor1(professorPickle); });
        assertThrows(AssertionError.class, () -> { professorPotato.setAdvisor2(professorPickle); });
        assertThrows(AssertionError.class, () -> { professorPotato.setAdvisor2(null); });
        assertThrows(AssertionError.class, () -> { professorPeach.setAdvisor2(professorPotato); });

        professorPeach.setAdvisor2(professorPickle);
        assertThrows(AssertionError.class, () -> { professorPeach.setAdvisor2(professorPeanut); });

        // gotBefore asserts
        assertThrows(AssertionError.class, () -> { professorPickle.gotBefore(null); });

        // areSibs asserts
        assertThrows(AssertionError.class, () -> { professorPickle.areSibs(null); });

    }
}
