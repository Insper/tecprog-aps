package br.edu.insper.tecprog.aps02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class EkoTest {
    
    @Test
    void exemplo1() {
        assertEquals(15, Eko.sawbladeHeight(new int[]{20, 15, 10, 17}, 7));
    }

    @Test
    void exemplo2() {
        assertEquals(36 , Eko.sawbladeHeight(new int[]{4, 42, 40, 26, 46}, 20));
    }

    @Test
    void umaArvore() { 
        assertEquals(5, Eko.sawbladeHeight(new int[]{10}, 5));
        assertEquals(3, Eko.sawbladeHeight(new int[]{10}, 7));
        assertEquals(1000000 - 7, Eko.sawbladeHeight(new int[]{1000000}, 7));
    }

    @Test
    void exatoEmUmaArvore() { 
        assertEquals(10, Eko.sawbladeHeight(new int[]{10, 15, 20}, 15));
        assertEquals(15, Eko.sawbladeHeight(new int[]{5, 15, 20, 2, 10}, 5));
    }


    @Test
    @Timeout(value=300, unit=TimeUnit.MILLISECONDS)
    void testesGrandes() throws IOException {
        int N = 176154;
        long M = 1243110;
        int[] inGrande1 = new int[176154];
        
        var u = getClass().getClassLoader().getResourceAsStream("br/edu/insper/tecprog/aps02/in1Eko.txt");

        var buf = new BufferedReader(new InputStreamReader(u));
        var l1 = buf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            inGrande1[i] = Integer.parseInt(l1[i]);
        }

        assertEquals(996257, Eko.sawbladeHeight(inGrande1, M));
    }

    @Test
    @Timeout(value=500, unit=TimeUnit.MILLISECONDS)
    void testesGrandes2() throws IOException {
        int N = 2000000;
        long M = 1842108;
        int[] inGrande1 = new int[N];
        
        var u = getClass().getClassLoader().getResourceAsStream("br/edu/insper/tecprog/aps02/in2Eko.txt");

        var buf = new BufferedReader(new InputStreamReader(u));
        var l1 = buf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            inGrande1[i] = Integer.parseInt(l1[i]);
        }

        assertEquals(998670, Eko.sawbladeHeight(inGrande1, M));
    }
}