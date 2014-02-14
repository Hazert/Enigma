package enigma;

/** Class that represents a complete enigma machine.
 *  @author Allis Yao
 */
class Machine {

    /** The name of the first (reflector) Rotor in the Machine. */
    private Rotor rotor1;
    /** The name of the second (fixed rotor) Rotor in the Machine. */
    private Rotor rotor2;
    /** The name of the third Rotor in the Machine. Between I-VIII. */
    private Rotor rotor3;
    /** The name of the fourth Rotor in the Machine. Between I-VIII. */
    private Rotor rotor4;
    /** The name of the fifth Rotor in the Machine. Between I-VIII. */
    private Rotor rotor5;

    /** Set my rotors to (from left to right) ROTORS.  Initially, the rotor
     *  settings are all 'A'. */
    void replaceRotors(Rotor[] rotors) {
        rotor1 = rotors[4];
        rotor2 = rotors[3];
        rotor3 = rotors[2];
        rotor4 = rotors[1];
        rotor5 = rotors[0];
    }

    /** Set my rotors according to SETTING, which must be a string of four
     *  upper-case letters. The first letter refers to the leftmost
     *  rotor setting.  */
    void setRotors(String setting) {
        int two = Rotor.toIndex(setting.charAt(0));
        int three = Rotor.toIndex(setting.charAt(1));
        int four = Rotor.toIndex(setting.charAt(2));
        int five = Rotor.toIndex(setting.charAt(3));
        rotor2.set(two);
        rotor3.set(three);
        rotor4.set(four);
        rotor5.set(five);
    }

    /** Returns the encoding /decoding of MSG, updating the state of
     *  the rotors accordingly. */
    String convert(String msg) {
        String stuff = "";
        for (int i = 0; i < msg.length(); i += 1) {
            if (rotor5.atNotch()) {
                if (rotor4.atNotch()) {
                    rotor3.advance();
                }
                rotor4.advance();
                rotor5.advance();
            } else if (rotor4.atNotch()) {
                rotor3.advance();
                rotor4.advance();
                rotor5.advance();
            } else {
                rotor5.advance();
            }
            stuff += Rotor.toLetter(rotor5.convertBackward(
                rotor4.convertBackward(rotor3.convertBackward(
                    rotor2.convertBackward(rotor1.convertForward(
                        rotor2.convertForward(rotor3.convertForward(
                            rotor4.convertForward(rotor5.convertForward(
                                Rotor.toIndex(msg.charAt(i))))))))))));
        }
        return stuff;
    }
}
