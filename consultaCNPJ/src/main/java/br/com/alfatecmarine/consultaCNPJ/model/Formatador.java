package br.com.alfatecmarine.consultaCNPJ.model;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class Formatador {

    public static String formataCnpj(String cnpj) {
        try {
            String cnpjLimpo = cnpj.replaceAll("\\D", "");
            if (cnpjLimpo.length() != 14) {
                throw new IllegalArgumentException("CNPJ deve conter 14 dígitos");
            }

            MaskFormatter formatador = new MaskFormatter("##.###.###/####-##");
            formatador.setValueContainsLiteralCharacters(false);
            return formatador.valueToString(cnpjLimpo);
        } catch (ParseException e) {
            throw new IllegalArgumentException("CNPJ Inválido", e);
        }
    }
}
