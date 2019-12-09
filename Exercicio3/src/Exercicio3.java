/* Entrar com um vetor desordenado, desde que nao haja duplicidade, funcao quantidadeMinimaTroca
retornara um inteiro que representa a quantidade minimas de trocas.
Neste exemplo foi dado um vetor pronto, de 5 posicoes fixo vetorNumeros = { 7, 2, 5, 1, 9 }
 */

import java.util.Scanner;

public class Exercicio3 {
    private static int quantidadeMinimaTroca(int[] array){
        /*
            Para calcular a menor quantidade de trocas, percorre-se o vetor uma unica vez,
            sempre comparando os elementos a sua frente. Caso seja maior que o menor encontrado,
            troque os dois de lugares. O menor valor encontrado apos a troca ja estara em seu devido lugar.
         */
        int j;
        int valorSerTrocado; // Menor numero encontrado
        int posicaoTrocar = 0;
        //boolean houveTroca;
        int numeroAuxiliar; // Copia do valor que ira mudar de posicao
        int quantidadeTrocas = 0;

        for (int i = 0; i < array.length - 1; i++) { // Loop Principal
            j = i + 1;
            valorSerTrocado = -1;
            //houveTroca = false;
            while(j < array.length) { // Elementos posteriores
                //if (array[i] > valorSerTrocado && array[i] > array[j]) {
                // Definir menor valor
                if(array[j] < valorSerTrocado || valorSerTrocado == -1) {
                    valorSerTrocado = array[j];
                    posicaoTrocar = j;
                    //houveTroca = true;
                }
                //}
                j++;
            }

            //if(houveTroca){
            // Caso precise trocar de posicoes dois elementos
            if(array[i] > valorSerTrocado){
                numeroAuxiliar = array[i];
                array[i] = valorSerTrocado;
                array[posicaoTrocar] = numeroAuxiliar;
                quantidadeTrocas ++;
            }
        }
        return quantidadeTrocas;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        int tamanho = scanner.nextInt();
        int[] vetorNumeros = new int[tamanho];
        for(int i = 0; i < tamanho; i ++) {
            vetorNumeros[i] = scanner.nextInt();
        }

        // Resultado
        System.out.println(quantidadeMinimaTroca(vetorNumeros));
    }
}