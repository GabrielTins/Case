// Bibliotecas
import java.util.Scanner;

/* Receber um array de inteiros e um valor X que representa a quantidade de vezes que cada elemento do vetor
foi rotacionado para a esquerda
    1 - Receber valores do vetor
    Entrada: numeroElementos -> Quantidade de numeros do vetor
             vetorInt[] -> array de inteiros
 */
/*public class Exercicio2 { // Rotacoes Usando Vetor Auxiliar
    static int[] vetorRotacionadoEsquerda(int array[], int quantidadeRotacoes){
        int vetorAuxiliar[] = new int[array.length];
        int posicaoNumero;
        for(int i = 0; i < array.length; i++){
            posicaoNumero = i - quantidadeRotacoes;
            if (posicaoNumero < 0){
                posicaoNumero = array.length - Math.abs(posicaoNumero);
            }
            vetorAuxiliar[posicaoNumero] = array[i];
        }
        return vetorAuxiliar;
    }*/
public class Exercicio2 {
    private static void rotacionarVetorEsquerda(int[] array, int quantidadeRotacoes){
            /* A estrategia utilizada para rotacionar o vetor foi a seguinte:
                Comecando sempre da origem, indice 0, os seguintes algoritmos sao implementados
                1- Calcula a nova posicao do numero (Nova Posicao = Posicao Origem - Numero de Rotacoes
                    Caso a posicao seja menor que 0, um indice negativo representaria uma posicao invalida
                    portanto faz um novo ajuste:
                    Posicao agora se torna o (final do vetor - valor absoluto da Nova Posicao)
                2- Uma vez na posicao, o numeroAuxiliar recebe o valor da posicao atual, que sera
                o proximo elemento a ser deslocado, o elemento que estava em numeroColocar ocupa a posicao destino
                3- A posicao de origem agora passa a ser a atual posicao destino para saber de onde sera feito o
                deslocamento para a proxima rotacao
                4- Por ultimo, pegue o valor que esta armazenamedo temporariamente na variavel auxiliar e coloque em
                numeroCalcular. Ao voltar no loop, veremos onde sera a nova posicao deste elemento
                5- Incremente a variavel
                6- Repita enquanto o numero de vezes que realizarem trocas for menor que o tamanho do vetor
             */
        int posicaoNumeroDestino;
        int posicaoNumeroOrigem = 0;
        int vezesTroca = 0;
        int numeroAuxiliar; // Proximo Elemento a ser inserido na nova posicao
        int numeroColocar = array[0]; // Elemento atual a ser inserido na nova posicao
        while(vezesTroca < array.length) {
            posicaoNumeroDestino = posicaoNumeroOrigem - quantidadeRotacoes;
            if (posicaoNumeroDestino < 0) {
                posicaoNumeroDestino = array.length - Math.abs(posicaoNumeroDestino);
            }
            numeroAuxiliar = array[posicaoNumeroDestino];
            array[posicaoNumeroDestino] = numeroColocar;
            vezesTroca ++;
            posicaoNumeroOrigem = posicaoNumeroDestino;
            numeroColocar = numeroAuxiliar;
        }
        //return array;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroElementos = scanner.nextInt();
        int[] vetorInt = new int[numeroElementos];

        // Entrada de dados
        for(int i = 0; i < numeroElementos; i ++) {
            vetorInt[i] = scanner.nextByte();
        }
        int rotacoes = scanner.nextInt();
        rotacionarVetorEsquerda(vetorInt,rotacoes); // Chamada do Procedimento
        //vetorInt = vetorRotacionadoEsquerda(vetorInt,rotacoes);

        // Saida dos Dados
        for(int valor: vetorInt){
            System.out.print(valor + " ");
        }
    }
}