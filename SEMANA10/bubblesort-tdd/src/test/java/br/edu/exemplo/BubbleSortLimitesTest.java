package br.edu.exemplo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortLimitesTest {

    @Test
    void deveAceitarVetorVazio() {
        BubbleSort bubbleSort = new BubbleSort(new int[]{});

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{}, bubbleSort.getNumeros());
    }

    @Test
    void deveManterUmUnicoNumero() {
        BubbleSort bubbleSort = new BubbleSort(new int[]{7});

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{7}, bubbleSort.getNumeros());
    }

    @Test
    void deveOrdenarNegativosEValoresExtremos() {
        BubbleSort bubbleSort = new BubbleSort(new int[]{Integer.MAX_VALUE, 0, -3, Integer.MIN_VALUE});

        bubbleSort.ordenar();

        assertArrayEquals(new int[]{Integer.MIN_VALUE, -3, 0, Integer.MAX_VALUE}, bubbleSort.getNumeros());
    }
}
