
import java.util.Scanner;

public class Principal {
    public Principal() {
        Scanner s = new Scanner(System.in);
        Calculadora c;
        int opc;
        String expressao = "";
        System.out.println("Escolha qual pilha usar:\n(1)Pilha Vetor\n(2)Pilha Encadeada\n(3)sair");
        opc = s.nextInt();
        while (opc != 3) {
            expressao = s.nextLine();
            if (opc == 1) {
                try {
                    System.out.println("Agora digite a expressão(pos fixa):");
                expressao = s.nextLine();
                c = new Calculadora(expressao, true);
                System.out.println("O resultado da expressão[" + expressao + "] é: " + c.getResposta());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (opc == 2) {
                try {
                    System.out.println("Agora digite a expressão(pos fixa):");
                expressao = s.nextLine();
                c = new Calculadora(expressao, false);
                System.out.println("O resultado da expressão[" + expressao + "] é: " + c.getResposta());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
            } else if (opc == 3) {
                break;
            } else {
                System.out.println("Opção inválida");

            }

            System.out.println("Escolha qual pilha usar:\n(1)Pilha Vetor\n(2)Pilha Encadeada\n(3)sair");
            opc = s.nextInt();

        }

        s.close();
    }

    public static void main(String[] args) {
        Principal p = new Principal();
    }
}
