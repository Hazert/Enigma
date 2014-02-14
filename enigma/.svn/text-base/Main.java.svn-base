package enigma;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/** Enigma simulator.
 *  @author Allis Yao
 */
public final class Main {

    /** Process a sequence of encryptions and decryptions, as
     *  specified in the input from the standard input.  Print the
     *  results on the standard output. Exits normally if there are
     *  no errors in the input; otherwise with code 1. */
    public static void main(String[] unused) {
        Machine M;
        BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));

        M = null;
        boolean firstline = true;

        try {
            while (true) {
                String line = input.readLine();
                if (line == null) {
                    break;
                }
                if (firstline) {
                    String[] firstinput = line.split(" ");
                    if (!firstinput[0].equals("*")) {
                        System.exit(1);
                    }
                    firstline = false;
                }
                if (isConfigurationLine(line)) {
                    M = new Machine();
                    configure(M, line);
                } else {
                    printMessageLine(M.convert(standardize(line)));
                }
            }
        } catch (IOException excp) {
            System.err.printf("Input error: %s%n", excp.getMessage());
            System.exit(1);
        }
    }

    /** Return true iff LINE is an Enigma configuration line. */
    private static boolean isConfigurationLine(String line) {
        ArrayList<String> possiblereflec = new ArrayList<String>(
            Arrays.asList("B", "C"));
        ArrayList<String> possiblefixed = new ArrayList<String>(
            Arrays.asList("BETA", "GAMMA"));
        ArrayList<String> possiblerotors = new ArrayList<String>(
            Arrays.asList("I", "II", "III", "IV", "V", "VI",
                "VII", "VIII"));
        String[] input = line.split(" ");
        if ((!input[0].equals("*")) || input.length != 7) {
            return false;
        }
        ArrayList<String> other = new ArrayList<String>();
        for (int i = 1; i < input.length - 1; i += 1) {
            if (other.contains(input[i])) {
                System.exit(1);
            }
            other.add(input[i]);
            if (i == 1) {
                if (!(possiblereflec.contains(input[i]))) {
                    System.exit(1);
                }
            } else if (i == 2) {
                if (!(possiblefixed.contains(input[i]))) {
                    System.exit(1);
                }
            } else {
                if (!(possiblerotors.contains(input[i]))) {
                    System.exit(1);
                }
            }
        }
        String initialpos = input[input.length - 1];
        if (initialpos.length() != 4) {
            System.exit(1);
        }
        for (int i = 0; i < initialpos.length(); i += 1) {
            if (Character.isWhitespace(initialpos.charAt(i))
                || Character.isLetter(initialpos.charAt(i))) {
                continue;
            } else {
                System.exit(1);
            }
        }
        return true;
    }

    /** Configure M according to the specification given on CONFIG,
     *  which must have the format specified in the assignment. */
    private static void configure(Machine M, String config) {
        String[] rotors = config.split(" ");
        Rotor[] listofrotors = {new Rotor(rotors[5]), new Rotor(rotors[4]),
            new Rotor(rotors[3]), new FixedRotor(rotors[2]),
            new Reflector(rotors[1])};
        M.replaceRotors(listofrotors);
        M.setRotors(rotors[6]);
    }

    /** Return the result of converting LINE to all upper case,
     *  removing all blanks and tabs.  It is an error if LINE contains
     *  characters other than letters and blanks. */
    private static String standardize(String line) {
        for (int i = 0; i < line.length(); i += 1) {
            if (Character.isWhitespace(line.charAt(i))
                || Character.isLetter(line.charAt(i))) {
                continue;
            } else {
                System.exit(1);
            }
        }
        String stuff = "";
        for (int i = 0; i < line.length(); i += 1) {
            if (Character.isWhitespace(line.charAt(i))) {
                continue;
            } else if (Character.isUpperCase(line.charAt(i))) {
                stuff += line.charAt(i);
            } else if (Character.isLowerCase(line.charAt(i))) {
                stuff += Character.toUpperCase(line.charAt(i));
            }
        }
        return stuff;
    }

    /** Print MSG in groups of five (except that the last group may
     *  have fewer letters). */
    private static void printMessageLine(String msg) {
        for (int i = 5; i <= msg.length(); i += 5) {
            System.out.print(msg.substring(i - 5, i) + " ");
        }
        int leftover = msg.length() % 5;
        if (leftover == 0) {
            System.out.println();
        } else {
            System.out.println(msg.substring(msg.length() - leftover,
                msg.length()));
        }
    }

}

