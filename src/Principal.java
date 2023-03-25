import java.io.InputStream;
import java.util.Scanner;

public class Principal {
    public Principal(){
        Scanner s = new Scanner(System.in);
        Calculadora c;
        int opc;
        while(opc != 3){
            System.out.println("Escolha qual pilha usar:\n(1)Pilha Vetor\n(2)Pilha Encadeada");
            opc = s.nextInt();
            System.out.println("Agora digite a expressão(pos fixa):");
            String expressao = s.nextLine();
            s.close();
            if(opc == 1){
                c = new Calculadora(expressao, true);
            } else if (opc == 2){
                c = new Calculadora(expressao, false);
            } else {
                System.out.println("Opção inválida");
            }
        }
        
    }
}
