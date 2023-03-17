package br.edu.insper.tecprog.aps03;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class SLEXSortLargeTest {
    String alfabeto;
    String[] entrada;
    String[] saida;

    void carregaExemplo(String name, String nameSaida) throws IOException {
        var p = Paths.get("src", "test", "java", "br", "edu", "insper", "tecprog", "aps03", name).toFile();
        var buf = new BufferedReader(new FileReader(p));

        alfabeto = buf.readLine();

        var nL = Integer.parseInt(buf.readLine());
        entrada = new String[nL];
        for (int i = 0; i < nL; i++) {
            entrada[i] = buf.readLine();
        }

        var p2 = Paths.get("src", "test", "java", "br", "edu", "insper", "tecprog", "aps03", nameSaida).toFile();
        saida = new String[nL];
        var buf2 = new BufferedReader(new FileReader(p2));
        for (int i = 0; i < nL; i++) {
            saida[i] = buf2.readLine();
        }

        buf.close();
        buf2.close();

    }

    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS)
    void entradaInLex1() throws IOException {
        carregaExemplo("inlex1.txt", "inlex1-out.txt");
        SLEXSort.sortByA(alfabeto, entrada);
        assertArrayEquals(saida, entrada);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void entradaInLex2() throws IOException {
        carregaExemplo("inlex2.txt", "inlex2-out.txt");
        SLEXSort.sortByA(alfabeto, entrada);
        assertArrayEquals(saida, entrada);
    }

}
