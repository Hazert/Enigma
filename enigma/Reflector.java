package enigma;

/** Class that represents a reflector in the enigma.
 *  @author Allis Yao
 */
class Reflector extends FixedRotor {

    /** Constructor for a Reflector, it takes in the name of a Rotor B, and C.
     *  Then, it creates a rotor that has a name, and mapping according to the
     *  permutation data.
     *  @param somerotor is the name of the rotor that is passed in. */
    public Reflector(String somerotor) {
        super(somerotor);
    }

    @Override
    boolean hasInverse() {
        return false;
    }

    /** Returns a useless value; should never be called. */
    @Override
    int convertBackward(int unused) {
        throw new UnsupportedOperationException();
    }

}
