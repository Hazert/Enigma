package enigma;

/** Class that represents a rotor in the enigma machine.
 *  @author Allis Yao
 */
class Rotor {

    /** Size of alphabet used for plaintext and ciphertext. */
    static final int ALPHABET_SIZE = 26;
    /** A String representation of the alphabet. */
    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /** String with name of the Rotor. */
    private String name;
    /** String with mapping data of the Rotor. */
    private String mapping;
    /** String with inverse data of the Rotor. */
    private String inverse;
    /** String with notch data of the Rotor. */
    private String notch;

    /** Constructor for a Rotor, it takes in the name of a Rotor between I-VIII
     *  or Gamma, Beta, B, and C.  Then, it creates a rotor that has a name,
     *  mapping, inverse, and notch according to the permutation data.  Does
     *  not include inverse or notch if it does not have one.
     *  @param somerotor is the name of the rotor that is passed in. */
    public Rotor(String somerotor) {
        for (int i = 0; i < PermutationData.ROTOR_SPECS.length; i += 1) {
            if (PermutationData.ROTOR_SPECS[i][0].equals(somerotor)) {
                name = PermutationData.ROTOR_SPECS[i][0];
                mapping = PermutationData.ROTOR_SPECS[i][1];
                if (PermutationData.ROTOR_SPECS[i].length == 3) {
                    inverse = PermutationData.ROTOR_SPECS[i][2];
                    break;
                } else if (PermutationData.ROTOR_SPECS[i].length == 4) {
                    inverse = PermutationData.ROTOR_SPECS[i][2];
                    notch = PermutationData.ROTOR_SPECS[i][3];
                    break;
                }
                break;
            }
        }
    }

    /** Assuming that P is an integer in the range 0..25, returns the
     *  corresponding upper-case letter in the range A..Z. */
    static char toLetter(int p) {
        return alphabet.charAt(p);
    }

    /** Assuming that C is an upper-case letter in the range A-Z, return the
     *  corresponding index in the range 0..25. Inverse of toLetter. */
    static int toIndex(char c) {
        return alphabet.indexOf(c);
    }

    /** Returns true iff this rotor has a ratchet and can advance. */
    boolean advances() {
        return true;
    }

    /** Returns true iff this rotor has a left-to-right inverse. */
    boolean hasInverse() {
        return true;
    }

    /** Return my current rotational setting as an integer between 0
     *  and 25 (corresponding to letters 'A' to 'Z').  */
    int getSetting() {
        return _setting;
    }

    /** Set getSetting() to POSN.  */
    void set(int posn) {
        assert 0 <= posn && posn < ALPHABET_SIZE;
        _setting = posn;
    }

    /** Return the conversion of P (an integer in the range 0..25)
     *  according to my permutation. */
    int convertForward(int p) {
        int first = p + _setting;
        if (first >= ALPHABET_SIZE) {
            first -= ALPHABET_SIZE;
        } else if (first < 0) {
            first += ALPHABET_SIZE;
        }
        int second = toIndex(mapping.charAt(first)) - _setting;
        if (second >= ALPHABET_SIZE) {
            second -= ALPHABET_SIZE;
        } else if (second < 0) {
            second += ALPHABET_SIZE;
        }
        return second;
    }

    /** Return the conversion of E (an integer in the range 0..25)
     *  according to the inverse of my permutation. */
    int convertBackward(int e) {
        int first = e + _setting;
        if (first >= ALPHABET_SIZE) {
            first -= ALPHABET_SIZE;
        } else if (first < 0) {
            first += ALPHABET_SIZE;
        }
        int second = toIndex(inverse.charAt(first)) - _setting;
        if (second >= ALPHABET_SIZE) {
            second -= ALPHABET_SIZE;
        } else if (second < 0) {
            second += ALPHABET_SIZE;
        }
        return second;
    }

    /** Returns true iff I am positioned to allow the rotor to my left
     *  to advance. */
    boolean atNotch() {
        return (notch.indexOf(alphabet.charAt(_setting)) != -1);
    }

    /** Advance me one position. */
    void advance() {
        _setting += 1;
        _setting %= ALPHABET_SIZE;
    }

    /** My current setting (index 0..25, with 0 indicating that 'A'
     *  is showing). */
    private int _setting;

}
