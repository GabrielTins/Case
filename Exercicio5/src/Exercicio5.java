import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
public class Exercicio5 {
    static boolean estaBalanceado(String texto){
        ArrayList<String> listaBalanceamento = new ArrayList<String>(); // Lista de strings
        /* Cada vez que um valor de abertura do bracket e lido, o mesmo e colocado em uma lista
           caso seja um valor de fechamento, a funcao verifica se a ultima string da lista e o equivalente,
           Se sim -> Remove da Lista
           Se nao -> Retorna acusando que nao esta balanceado
        *  */
        for (int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) == '}') {
                String palavra = listaBalanceamento.get(listaBalanceamento.size()-1);
                if (!palavra.equals("{")){
                    return false;
                } else{
                    listaBalanceamento.remove(listaBalanceamento.size()-1);
                }
            }
            else if(texto.charAt(i) == ']') {
                String palavra = listaBalanceamento.get(listaBalanceamento.size()-1);
                if (!palavra.equals("[")){
                    return false;
                } else{
                    listaBalanceamento.remove(listaBalanceamento.size()-1);
                }
            }
            else if(texto.charAt(i) == ')') {
                String palavra = listaBalanceamento.get(listaBalanceamento.size()-1);
                if (!palavra.equals("(")){
                    return false;
                } else{
                    listaBalanceamento.remove(listaBalanceamento.size()-1);
                }
            } else {
                listaBalanceamento.add(String.valueOf(texto.charAt(i)));
            }
        }
        if (listaBalanceamento.size() == 0){
            return true;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados
        String brackets = scanner.next();

        // Resultado
        if(estaBalanceado(brackets)){
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }
    }
}
