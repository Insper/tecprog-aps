package br.edu.insper.tecprog.aps06;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMaisLeve {

	@Test
	void TestIn1() {
		int[] peso = {3, 8, 6, 4, 5, 10, 1, 9, 3, 3};
		int[] valor = {70, 56, 17, 91, 77, 69, 98, 54, 13, 54};
		int capMaxima = 10;

		Solucao S = new MaisLeve().resolveMochila(valor, peso, capMaxima);
		assertEquals(10, S.peso);
		assertEquals(235, S.valor);
		assertArrayEquals( new boolean[] {
			true,
			false,
			false,
			false,
			false,
			false,
			true,
			false,
			true,
			true
		}, S.objetos);
	}

	@Test 
	void TestIn2() {
		int[] peso = {1, 1, 2, 2, 1};
		int[] valor = {50, 94, 40, 39, 62};
		int capMaxima = 2;

		Solucao S = new MaisLeve().resolveMochila(valor, peso, capMaxima);
		assertEquals(2, S.peso);
		assertEquals(144, S.valor);
		assertArrayEquals( new boolean[] {
			true,
			true,
			false,
			false,
			false
		}, S.objetos);
	}

	@Test 
	void TestIn3() {
		int[] peso = {58, 90, 36, 53, 8, 98, 31, 37, 36, 6};
		int[] valor = {95, 32, 37, 54, 9, 29, 43, 59, 3, 98};
		int capMaxima = 100;

		Solucao S = new MaisLeve().resolveMochila(valor, peso, capMaxima);
		assertEquals(81, S.peso);
		assertEquals(187, S.valor);
		assertArrayEquals( new boolean[] {
			false,
			false,
			true,
			false,
			true,
			false,
			true,
			false,
			false,
			true,
		}, S.objetos);

	}

	@Test 
	void TestIn4() {
		int[] peso = {1, 1, 2, 1, 8};
		int[] valor = {5, 10, 5, 20, 25};
		int capMaxima = 10;

		Solucao S = new MaisLeve().resolveMochila(valor, peso, capMaxima);
		assertEquals(5, S.peso);
		assertEquals(40, S.valor);
		assertArrayEquals( new boolean[] {
			true,
			true,
			true,
			true,
			false,
		}, S.objetos);
	}

}
