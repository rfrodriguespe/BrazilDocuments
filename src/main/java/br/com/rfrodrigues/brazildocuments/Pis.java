/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rfrodrigues.brazildocuments;

/**
 *
 * @author Rodrigo Ferreira Rodrigues <https://github.com/rfrodriguespe>
 */
public class Pis {
    
    private static Pis uniqueInstance;

    private Pis() {

    }

    /**
     *
     * @return
     */
    public static synchronized Pis getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Pis();
        }
        return uniqueInstance;
    }
    
    /**
     *
     * @param pis Brazilian number PIS at format ###.#####.##-# or ###########
     * @return Returns True when is a valid Brazilian PIS or false when it
     * isn't.
     */
    public boolean isPis (String pis) {
        return validatePis(pis);
    }
    
    
    private boolean validatePis(String pis) {
        /**
         * Removing nonnumeric characters
         */
        pis = pis.replace(".", "").replace("-", "");
        
        String firstPart = pis.substring(0, 10);
        String div1FirstPart = firstPart.substring(0, 2);
        String div2FirstPart = firstPart.substring(2, 10);
        int firstDigit = Integer.parseInt(pis.substring(10, 11));
        int firstSum = 0;
        int div1FirstSum = 0;
        int div2FirstSum = 0;
        int firstDigitCalculated = 9999;

        /**
         * First Digit Calculation
         */
        int cont = 3;
        for (int i = 0; i < div1FirstPart.length(); i++) {
            div1FirstSum += Character.getNumericValue(div1FirstPart.charAt(i)) * cont;
            cont--;
        }
        int cont2 = 9;
        for (int i = 0; i < div2FirstPart.length(); i++) {
            div2FirstSum += Character.getNumericValue(div2FirstPart.charAt(i)) * cont2;
            cont2--;
        }
        firstSum = div1FirstSum + div2FirstSum;

        if (firstSum % 11 < 2) {
            firstDigitCalculated = 0;
        } else {
            firstDigitCalculated = 11 - firstSum % 11;
        }
        
        return firstDigit == firstDigitCalculated;
    }
    
}
