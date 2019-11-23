/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rfrodrigues.tests;

import br.com.rfrodrigues.brazildocuments.Cpf;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Rodrigo Ferreira Rodrigues <https://github.com/rfrodriguespe>
 */
public class CpfTest {

    @Test
    public void testIsCpf() {
        assertEquals(true, Cpf.getInstance().isCpf("44027941020"));
        assertEquals(true, Cpf.getInstance().isCpf("440.279.410-20"));
        assertEquals(true, Cpf.getInstance().isCpf("59485047789"));
        assertEquals(true, Cpf.getInstance().isCpf("594850477-89"));
        assertEquals(false, Cpf.getInstance().isCpf("59485047790"));
        assertEquals(false, Cpf.getInstance().isCpf("11111111111"));
        assertEquals(false, Cpf.getInstance().isCpf("22222222222"));
        assertEquals(false, Cpf.getInstance().isCpf("33333333333"));
        assertEquals(false, Cpf.getInstance().isCpf("44444444444"));
        assertEquals(false, Cpf.getInstance().isCpf("55555555555"));
        assertEquals(false, Cpf.getInstance().isCpf("66666666666"));
        assertEquals(false, Cpf.getInstance().isCpf("77777777777"));
        assertEquals(false, Cpf.getInstance().isCpf("88888888888"));
        assertEquals(false, Cpf.getInstance().isCpf("99999999999"));
        assertEquals(false, Cpf.getInstance().isCpf("017asd97486"));
        assertEquals(false, Cpf.getInstance().isCpf("01798689687997486"));
        assertEquals(false, Cpf.getInstance().isCpf("7997486"));
    }
}
