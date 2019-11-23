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
        assertEquals(true, Cpf.getInstance().isCpf("01323197486"));
        assertEquals(true, Cpf.getInstance().isCpf("013.231.974-86"));
        assertEquals(false, Cpf.getInstance().isCpf("01321797486"));
        assertEquals(false, Cpf.getInstance().isCpf("01797486"));
        assertEquals(true, Cpf.getInstance().isCpf("29780622829"));
        assertEquals(false, Cpf.getInstance().isCpf("2978062282945"));
        assertEquals(false, Cpf.getInstance().isCpf("017asd97486"));
    }
}
