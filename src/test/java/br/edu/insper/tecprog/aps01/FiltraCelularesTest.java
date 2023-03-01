package br.edu.insper.tecprog.aps01;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FiltraCelularesTest {
    @Test
    void listaSimples() {
        String[] original = {"+5511912345678", "1155556666", "77778888", "+551133334444", "918273645", "11987654321"};
        String[] resposta = {"912345678", "918273645", "987654321"};

        var resp = FiltraCelulares.celulares(original);
        assertEquals(resp.size(), resposta.length);
        for (int i = 0; i < resposta.length; i++) {
            assertEquals(resposta[i], resp.get(i));
        }
    }

    @Test
    void somenteTelefoneFixoSemDDDSemPais() {
        String[] original = {"12341234", "10101010", "00000000", "87432389", "20492049"};
        String[] resposta = {};

        var resp = FiltraCelulares.celulares(original);
        assertEquals(resp.size(), resposta.length);
        for (int i = 0; i < resposta.length; i++) {
            assertEquals(resposta[i], resp.get(i));
        }
    }

    @Test
    void somenteTelefoneFixoComDDDSemPais() {
        String[] original = {"1112341234", "1910101010", "2700000000", "1987432389", "3120492049"};
        String[] resposta = {};

        var resp = FiltraCelulares.celulares(original);
        assertEquals(resp.size(), resposta.length);
        for (int i = 0; i < resposta.length; i++) {
            assertEquals(resposta[i], resp.get(i));
        }
    }

    @Test
    void somenteTelefoneFixoComDDDComPais() {
        String[] original = {"+551112341234", "+551910101010", "+552700000000", "+551987432389", "+553120492049"};
        String[] resposta = {};

        var resp = FiltraCelulares.celulares(original);
        assertEquals(resp.size(), resposta.length);
        for (int i = 0; i < resposta.length; i++) {
            assertEquals(resposta[i], resp.get(i));
        }
    }

    @Test
    void somenteCelularSemDDDSemPais() {
        String[] original = {"912345678", "987654321", "923345466", "987432389", "920492049"};
        String[] resposta = original;

        var resp = FiltraCelulares.celulares(original);
        assertEquals(resp.size(), resposta.length);
        for (int i = 0; i < resposta.length; i++) {
            assertEquals(resposta[i], resp.get(i));
        }
    }

    @Test
    void somenteCelularComDDDSemPais() {
        String[] original = {"11912345678", "17987654321", "17923345466", "21987432389", "19920492049"};
        String[] resposta = {"912345678", "987654321", "923345466", "987432389", "920492049"};

        var resp = FiltraCelulares.celulares(original);
        assertEquals(resp.size(), resposta.length);
        for (int i = 0; i < resposta.length; i++) {
            assertEquals(resposta[i], resp.get(i));
        }
    }

    @Test
    void somenteCelularComDDDComPais() {
        String[] original = {"+5511912345678", "+5517987654321", "+5517923345466", "+5521987432389", "+5519920492049"};
        String[] resposta = {"912345678", "987654321", "923345466", "987432389", "920492049"};

        var resp = FiltraCelulares.celulares(original);
        assertEquals(resp.size(), resposta.length);
        for (int i = 0; i < resposta.length; i++) {
            assertEquals(resposta[i], resp.get(i));
        }
    }
}
