package Programa.utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {

    // Formatar valores para moeda
    static NumberFormat formatarValores = new DecimalFormat("R$ #,##0.00");

    // Converte double para String com formatação de moeda
    public static String doubleToString(double valor) {
        return formatarValores.format(valor);
    }

}
