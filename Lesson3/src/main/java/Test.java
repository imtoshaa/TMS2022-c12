import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String[][] tabl = {
                {"       ", "byte   ", "short  ", "char   ", "int    ", "long   ", "float  ", "double ", "boolean"},
                {"byte   ", "       ", "       ", "       ", "        ", "      ", "       ", "       ", "       "},
                {"short  ", "       ", "       ", "       ", "        ", "      ", "       ", "       ", "       "},
                {"char   ", "       ", "       ", "       ", "        ", "      ", "       ", "       ", "       "},
                {"int    ", "       ", "       ", "       ", "        ", "      ", "       ", "       ", "       "},
                {"long   ", "       ", "       ", "       ", "        ", "      ", "       ", "       ", "       "},
                {"float  ", "       ", "       ", "       ", "        ", "      ", "       ", "       ", "       "},
                {"double ", "       ", "       ", "       ", "        ", "      ", "       ", "       ", "       "},
                {"boolean", "       ", "       ", "       ", "        ", "      ", "       ", "       ", "       "},
        };
        for (int i = 1; i < tabl.length; i++) {
            for (int j = 1; j < tabl.length; j++) {
                if (i == j) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "т"; //отнимает символы с конца строки. Погуглил.
                }
                if ((tabl[i][1] == "byte   " && tabl[1][j] == "boolean") | (tabl[i][1] == "boolean" && tabl[1][j] == "byte   ") ) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "х";
                }
                if ((tabl[i][1] == "short   " && tabl[1][j] == "boolean") | (tabl[i][1] == "boolean" && tabl[1][j] == "short  ") ) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "х";
                }
                if ((tabl[i][1] == "char   " && tabl[1][j] == "boolean") | (tabl[i][1] == "boolean" && tabl[1][j] == "char   ") ) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "х";
                }
                if ((tabl[i][1] == "int    " && tabl[1][j] == "boolean") | (tabl[i][1] == "boolean" && tabl[1][j] == "int    ") ) {
                    tabl[i][j] = tabl[i][j].substring(0, tabl[i][j].length() - 1) + "х";
                }
            }
        }
        for (String[] strings : tabl) {
            System.out.println(Arrays.toString(strings)); //снова погуглил классы по работе с массивами :) не очень хотелось нагромождать код кучей for
        }
    }
}

