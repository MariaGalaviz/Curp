import java.io.*;
import java.util.regex.*;

public class main {
    private static final String CURP_REGEX = "^[A-Z]{1}[AEIOU]{1}[A-Z]{2}\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])[HM](AS|BC|BS|CC|CL|CM|CS|CH|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z0-9]\\d$";

    public static void main(String[] args) {
        String archivo = "C:\\Users\\dii\\IdeaProjects\\validadorCURP\\src\\lista_curps.txt";
        validarCurp(archivo);

    }
    public static void validarCurp(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int contador = 1;
            Pattern pattern = Pattern.compile(CURP_REGEX);

            while ((linea = br.readLine()) != null) {
                String curp = linea.trim();
                Matcher matcher = pattern.matcher(curp);


                if (!matcher.matches()) {
                    System.out.println("CURP inválido en la línea " + contador + ": " + curp);
                }
                contador++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}




