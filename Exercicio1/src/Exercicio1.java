// Bibliotecas
import java.util.Scanner;


/* Receber um array de inteiros representando as cores de cada meia e mostrar quantos pares possui
    1- Receber valores do vetor:
    Entrada: N -> Quantidade de Meias, coresMeias -> Array de inteiros
    Saida: Quantidade de Pares -> Retorno da funcao ParesMeias(byte quantidade, byte array[]

    Foi utilizado byte devido as restricoes do enunciado onde o valor de N e de cada inteiro do array nunca sera maior que
    100
*/
public class Exercicio1 {
    private static byte ParesMeias(byte quantidade, byte[] array){
        /*
            Utilizado uma matriz auxiliar para registrar cores que estao presentes no array na coluna 0
            e sua quantidade na coluna 1
         */
        byte totalPares = 0;
        boolean encontrouCor; // Flag da matriz auxiliar
        byte[][] frequencia = new byte[quantidade][2]; // Matriz auxiliar

        /* Inicializa todas as posicoes da matriz
            -1 -> Indica que o espaco ainda nao foi utilizado
         */
        for (byte i = 0; i < quantidade; i++){
            frequencia[i][0] = -1; // Cores
            frequencia[i][1] = 0; // Numero de vezes que apareceu
        }


        /* Loop para gerar matriz auxiliar
            Como a matriz tem a mesma quantidade de linhas, nao ha risco de passar do limite do indice,
            neste trecho do codigo
         */
        for(byte cor: array){
            byte i = 0;
            encontrouCor = false;
            while(!encontrouCor) {
                if (cor == frequencia[i][0] || frequencia[i][0] == -1) {
                    if (frequencia[i][0] == -1){
                        frequencia[i][0] = cor;
                    }
                    frequencia[i][1] ++;
                    encontrouCor = true;
                }
                i += 1;
            }
        }

        // Leitura da quantidade de cada cor
        for (int i = 0; i < quantidade; i++) {
            totalPares += (frequencia[i][1]) / 2;
        }

        return totalPares;
    }
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        byte N = scanner.nextByte(); // N representa a quantidade de meias
        byte[] coresMeias = new byte[N]; // Vetor de meias, onde o numero representa sua cor

        // Entrada de Dados
        for(byte indiceVetor = 0; indiceVetor < N; indiceVetor ++) {
            coresMeias[indiceVetor] = scanner.nextByte();
        }

        // Saida
        System.out.println(ParesMeias(N,coresMeias));
    }
}
