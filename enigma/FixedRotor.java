package enigma;

/** Class that represents a rotor that has no ratchet and does not advance.
 *  @author Allis Yao
 */
class FixedRotor extends Rotor {

    /** Constructor for a Reflector, it takes in the name of a Rotor Gamma,
     *  Betaa, B, or C.  Then, it creates a rotor that has a name, mapping,
     *  and inverse (if applicable) according to the permutation data.
     *  @param somerotor is the name of the rotor that is passed in. */
    public FixedRotor(String somerotor) {
        super(somerotor);
    }

    @Override
    boolean advances() {
        return false;
    }

    @Override
    boolean atNotch() {
        return false;
    }

    /** Fixed rotors do not advance. */
    @Override
    void advance() {
    }

}
