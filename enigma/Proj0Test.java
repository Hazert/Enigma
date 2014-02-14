package enigma;

import org.junit.Test;
import static org.junit.Assert.*;

/** Unit tests for Project 0.
 *  @author Allis Yao
 */
public class Proj0Test {

    /* Run the unit tests in this file. */
    public static void main(String... args) {
        System.exit(ucb.junit.textui.runClasses(Proj0Test.class));
    }

    @Test public void test1() {
        Rotor r = new Rotor("I");
        assertEquals("Should give me the letter at the index in the alphabet",
                    'F', r.toLetter(5));
    }

    @Test public void test2() {
        Rotor r = new Rotor("II");
        assertEquals("Should give me the index of the letter in the alphabet",
                    16, r.toIndex('Q'));
    }

    @Test public void test3() {
        Rotor r = new Rotor("I");
        assertEquals("Should give me the index of the letter in the alphabet",
                    25, r.toIndex('Z'));
    }

    @Test public void test4() {
        Rotor r = new FixedRotor("BETA");
        assertEquals("Should tell me whether BETA can advance or not",
                    false, r.advances());
    }

    @Test public void test5() {
        Rotor r = new Rotor("III");
        r.set(5);
        assertEquals("Should tell me what setting the rotor is on",
                    5, r.getSetting());
    }

    @Test public void test6() {
        Rotor r = new Rotor("I");
        r.set(5);
        assertEquals("Give me the index of the letter converted forward",
                    8, r.convertForward(5));
    }

    @Test public void test7() {
        Rotor r = new Rotor("I");
        r.set(5);
        assertEquals("Give me the index of the letter converted forward",
                    6, r.convertForward(25));
    }

    @Test public void test8() {
        Rotor r = new Rotor("I");
        r.set(16);
        assertEquals("Is my rotor at notch?",
                    true, r.atNotch());
    }

    @Test public void test9() {
        Rotor r = new Rotor("I");
        r.set(16);
        r.advance();
        assertEquals("Get my setting after advancing",
                    17, r.getSetting());
    }
}


