/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rfrodrigues.test;

import br.com.rfrodrigues.brazildocuments.Cnpj;
import br.com.rfrodrigues.brazildocuments.Cpf;

/**
 *
 * @author Rodrigo Ferreira Rodrigues <https://github.com/rfrodriguespe>
 */
public class TestApi {
    public static void main(String[] args) {
        String cpf = "013.231.974-86";
        System.out.println("Teste do CPF: '"+cpf+"' : "+Cpf.getInstance().isCpf(cpf));
        
        String cnpj = "473.795.65/0061-26";
        //String cnpj = "013.231.974-86";
        System.out.println("Teste do CPF: '"+cnpj+"' : "+Cnpj.getInstance().isCnpj(cnpj));
        
    }
}
