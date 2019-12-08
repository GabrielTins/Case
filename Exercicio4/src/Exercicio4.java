import java.util.Scanner;

public class Exercicio4 {
    private static int manipulaArray(int N, int[][] arrayBid) { // N representa o tamanho do array a ser criado
        int[] array = new int[N];
        int maiorValorResultante = 0;

        // Inicializar Array de Valores
        for (int valor : array) {
            valor = 0;
        }

        /* Loop externo percorre os dados a,b,k da matriz (0,1,2), onde os dois primeiros e o intervalo a ser somado
        e o ultimo o valor da soma
        */
        for (int op = 0; op < arrayBid.length; op++) {
            for (int i = arrayBid[op][0] - 1; i < arrayBid[op][1]; i++) {
                array[i] += arrayBid[op][2];
            }
        }

        // Procurar maior valor resultante do vetor
        for (int soma : array) {
            if (soma > maiorValorResultante) { // Atualiza maior valor resultante parcial
                maiorValorResultante = soma;
            }
        }
        return maiorValorResultante;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamanhoArray = scanner.nextInt();

        int numeroOperacoes = scanner.nextInt();
        int[][] matrisOp = new int[numeroOperacoes][3];

        for (int i = 0; i < numeroOperacoes; i++) {
            for (int j = 0; j < 3; j++) {
                matrisOp[i][j] = scanner.nextInt();
            }
        }
        System.out.println(manipulaArray(tamanhoArray, matrisOp));
    }
}