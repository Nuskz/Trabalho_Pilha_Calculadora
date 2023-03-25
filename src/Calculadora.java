
import pilha.PilhaVetor;

public class Calculadora {
    private String expressao;
    private PilhaVetor<String> pilhaVetor = new PilhaVetor<String>(10);

    public Calculadora(String expressao, boolean opcao) {
        this.setExpressao(expressao);
    }

    public void setExpressao(String expressao) {
        if (expressao.isBlank() || expressao.isEmpty()) {
            throw new NullPointerException();
        } else {
            this.expressao = expressao;
        }
    }

    private boolean verificar() {
        String str;
        String v;
        for (char ch : expressao.toCharArray()) {
            for (int i = 0; i < 10; i++) {
                str = "" + ch;
                if(str.equals(" ")){
                    
                }
                if (str.equals("0") || str.equals("1") || str.equals("2") || str.equals("3") || str.equals("4")
                        || str.equals("5") || str.equals("6") || str.equals("7") || str.equals("8")
                        || str.equals("9")) {

                } else if(str.equals(".")){

                }
            }
        }

        return true;
    }

    public String getExpressao() {
        return expressao;
    }
}
