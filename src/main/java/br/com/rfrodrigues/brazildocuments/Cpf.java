/*
 * The MIT License
 *
 * Copyright 2019 Rodrigo Ferreira Rodrigues <https://github.com/rfrodriguespe>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.com.rfrodrigues.brazildocuments;

/**
 *
 * @author Rodrigo Ferreira Rodrigues <https://github.com/rfrodriguespe>
 */
public class Cpf {

    private static Cpf uniqueInstance;

    private Cpf() {

    }

    /**
     *
     * @return
     */
    public static synchronized Cpf getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Cpf();
        }
        return uniqueInstance;
    }

    /**
     *
     * @param cpf Brazilian CPF in a fotmat 123.456.789-00 123456789-00 or
     * 12345678900
     * @return Returns True when is a valid Brazilian CPF or false when it
     * isn't.
     */
    public boolean isCpf(String cpf) {
        return validateCpf(cpf);
    }

    /**
     *
     * @param cpf Brazilian CPF in a fotmat 12345678900
     * @return Returns True when is a valid Brazilian CPF or false when it
     * isn't.
     */
    public boolean isCpf(long cpf) {
        return validateCpf(""+cpf);
    }

    /**
     *
     * @param cpf Brazilian CPF in a fotmat 123.456.789-00 123456789-00 or
     * 12345678900
     * @return Returns True when is a valid Brazilian CPF or false when it
     * isn't.
     */
    private boolean validateCpf(String cpf) {
        
        /**
         * Variables declaration's wich will be used by Method.
         */
        cpf = cpf.replace(".", "").replace("-", "");
        String firstPartCpf = cpf.substring(0, 9);
        String secodPartCpf = cpf.substring(0, 10);
        int firstDigit = Integer.parseInt(cpf.substring(9, 10));
        int secondDigit = Integer.parseInt(cpf.substring(10, 11));
        int firstSum = 0;
        int secondSum = 0;
        int firsDigitCalculated = 9999;
        int secondDigitCalculated = 9999;

        /**
         * Brazilian CPF has 11 digits length, anything different, it's invalid
         * number
         */
        if (cpf.equals("00000000000") || cpf.equals("11111111111")
                || cpf.equals("22222222222") || cpf.equals("33333333333")
                || cpf.equals("44444444444") || cpf.equals("55555555555")
                || cpf.equals("66666666666") || cpf.equals("77777777777")
                || cpf.equals("88888888888") || cpf.equals("99999999999")
                || (cpf.length() != 11)) {
            return false;
        }
        

        /**
         * First Digit Calculation
         */
        int cont = 10;
        for (int i = 0; i < firstPartCpf.length(); i++) {
            firstSum += Character.getNumericValue(firstPartCpf.charAt(i)) * cont;
            cont--;
        }

        
        if (firstSum % 11 < 2) {
            firsDigitCalculated = 0;
        } else {
            firsDigitCalculated = 11 - firstSum % 11;
        }

        /**
         * Second Digit Calculation
         */
        int cont2 = 11;
        for (int i = 0; i < secodPartCpf.length(); i++) {
            secondSum += Character.getNumericValue(secodPartCpf.charAt(i)) * cont2;
            cont2--;
        }
        
        if (secondSum % 11 < 2) {
            secondDigitCalculated = 0;
        } else {
            secondDigitCalculated = 11 - secondSum % 11;
        }
        

        /**
         * Validation of check digits
         */
        return firstDigit == firsDigitCalculated && secondDigit == secondDigitCalculated;
    }
    
}
