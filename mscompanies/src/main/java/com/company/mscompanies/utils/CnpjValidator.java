package com.company.mscompanies.utils;

public class CnpjValidator {

    /**
     * Valida um CNPJ.
     *
     * @param cnpj CNPJ a ser validado.
     * @return true se o CNPJ é válido, false caso contrário.
     */
    public static boolean isValid(String cnpj) {
        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("[^\\d]", "");

        // Verifica se o CNPJ tem 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            int digito = Character.getNumericValue(cnpj.charAt(i));
            soma += digito * peso;
            peso = (peso + 1) % 10 == 0 ? 2 : peso + 1;
        }
        int digito1 = soma % 11 < 2 ? 0 : 11 - soma % 11;

        // Calcula o segundo dígito verificador
        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            int digito = Character.getNumericValue(cnpj.charAt(i));
            soma += digito * peso;
            peso = (peso + 1) % 10 == 0 ? 2 : peso + 1;
        }
        int digito2 = soma % 11 < 2 ? 0 : 11 - soma % 11;

        // Verifica se os dígitos verificadores são válidos
        return Character.getNumericValue(cnpj.charAt(12)) == digito1 &&
                Character.getNumericValue(cnpj.charAt(13)) == digito2;
    }

}
