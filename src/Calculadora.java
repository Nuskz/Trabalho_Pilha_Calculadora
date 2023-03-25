
import pilha.PilhaLista;
import pilha.PilhaVetor;

public class Calculadora {
    private String expressao;
    private PilhaVetor<Float> pilhaVetor = new PilhaVetor<Float>(10);
    private PilhaLista<Float> pilhaLista = new PilhaLista<>();
    private Boolean opcao;


    public Calculadora(String expressao, boolean opcao) {
        this.setExpressao(expressao);
        this.setOpcao(opcao);
    }

    public PilhaVetor<Float> getPilhaVetor() {
        return pilhaVetor;
    }

    public void setPilhaVetor(PilhaVetor<Float> pilhaVetor) {
        this.pilhaVetor = pilhaVetor;
    }

    public Boolean getOpcao() {
        return opcao;
    }

    public void setOpcao(Boolean opcao) {
        this.opcao = opcao;
    }



    public void setExpressao(String expressao) {
        if (expressao.isBlank() || expressao.isEmpty()) {
            throw new NullPointerException();
        } else {
            this.expressao = expressao;
        }
    }

    private float Calcular(float valor1, float valor2, String s){
        float res;
        switch (s){
            case "*":
                res = valor1 * valor2;
                break;
            case "/":
                res = valor2 / valor1;
                break;
            case "+":
                res = valor2 + valor1;
                break;
            case "-":
                res = valor2 - valor1;
                break;
            default:
                throw new IllegalArgumentException("Operador: " + s + " inválido");
        }
        return res;
    }
    private void verificarOpcao(boolean opcao) {
        if(opcao){
            pilhaVetor = new PilhaVetor<Float>(10);
            expressaoPilhaVetor();

        } else {
            pilhaLista = new PilhaLista<Float>();
            expressaoPilhaLista();
        }
    }
    private  float expressaoPilhaVetor() {
        String[] convertido = this.expressao.split(" ");
        Float f;
        float res = 0f;
        int cont = 0;
        for (String s:
                convertido) {
            try {
                f = Float.parseFloat(s);
                pilhaVetor.push(f);
                cont++;
            }catch (Exception e){
                if (cont == 2 || pilhaVetor.getTamanho() != 1){
                    float valor1 = this.pilhaVetor.pop();
                    float valor2 = this.pilhaVetor.pop();
                    res = Calcular(valor1, valor2, s);
                    cont = 0;
                }
            }
        }
        return res;
    }
    private float expressaoPilhaLista(){
        String[] convertido = this.expressao.split(" ");
        Float f;
        float res = 0f;
        int cont = 0;
        for (String s:
                convertido) {
            try {
                f = Float.parseFloat(s);
                pilhaLista.push(f);
                cont++;
            }catch (Exception e){
                if (cont == 2 || pilhaLista.getTamanho() != 1){
                    float valor1 = this.pilhaLista.pop();
                    float valor2 = this.pilhaLista.pop();
                    res = Calcular(valor1, valor2, s);
                    cont = 0;
                }
            }
        }
        return res;
    }


    public String getExpressao() {
        return expressao;
    }
}
