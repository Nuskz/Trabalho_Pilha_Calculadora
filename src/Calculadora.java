
import pilha.PilhaLista;
import pilha.PilhaVetor;

public class Calculadora {
    private String expressao;
    private PilhaVetor<Float> pilhaVetor = new PilhaVetor<Float>(10);
    private PilhaLista<Float> pilhaLista = new PilhaLista<>();
    private float resposta;
    
    public Calculadora(String expressao, boolean opcao) {
        this.setExpressao(expressao);
        this.verificarOpcao(opcao);
    }
    public float getResposta() {
        return resposta;
    }

    public void setResposta(float resposta) {
        this.resposta = resposta;
    }

    public PilhaVetor<Float> getPilhaVetor() {
        return pilhaVetor;
    }

    public void setPilhaVetor(PilhaVetor<Float> pilhaVetor) {
        this.pilhaVetor = pilhaVetor;
    }

    public void setExpressao(String expressao) {
        if (expressao.isBlank() || expressao.isEmpty()) {
            throw new NullPointerException();
        } else {
            this.expressao = expressao;
        }
    }

    private float Calcular(float valor1, float valor2, String s) {
        float res;
        switch (s) {
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

    private boolean verificaExpressao(){
        String[] convertido = this.getExpressao().split(" ");
        int cont = 1;
        if(convertido.length % 2 != 0 && convertido.length >= 3){
            for (String s : convertido) {
                if(cont % 2 == 0){
                    if(s.equals("+") || s.equals("-") ||s.equals("*") ||s.equals("/")){
                        return false;
                    }
                } else if(cont % 3 == 0){
                    if(!s.equals("+") || !s.equals("-") ||!s.equals("*") ||!s.equals("/")){
                        return false;
                    }
                }
                cont++;
            }
            return true;
        }
        return false;
    }    

    private void verificarOpcao(boolean opcao) {
        if (verificaExpressao() == false){
            throw new IllegalArgumentException("Expressão [" + this.getExpressao() + "] Inválida!");
        }
        if (opcao) {
            pilhaVetor = new PilhaVetor<Float>(10);
            this.expressaoPilhaVetor();
        } else {
            pilhaLista = new PilhaLista<Float>();
            this.expressaoPilhaLista();
        }
    }

    private void expressaoPilhaVetor() {
        String[] convertido = this.expressao.split(" ");
        Float f;
        float res = 0f;
        int cont = 0;
        for (String s : convertido) {
            try {
                f = Float.parseFloat(s);
                pilhaVetor.push(f);
                cont++;
            } catch (Exception e) {
                if(cont > 2){
                    throw new IllegalArgumentException("Expressão: " + this.getExpressao() + " Inválida!");
                }
                if (cont == 2 || pilhaVetor.getTamanho() != 1) {
                    float valor1 = this.pilhaVetor.pop();
                    float valor2 = this.pilhaVetor.pop();
                    res = Calcular(valor1, valor2, s);
                    pilhaVetor.push(res);
                    cont = 0;
                }
            }
        }
        setResposta(res);
    }

    private void expressaoPilhaLista() {
        String[] convertido = this.expressao.split(" ");
        Float f;
        float res = 0f;
        int cont = 0;
        for (String s : convertido) {
            try {
                f = Float.parseFloat(s);
                pilhaLista.push(f);
                cont++;
            } catch (Exception e) {
                if(cont > 2){
                    throw new IllegalArgumentException("Expressão: " + this.getExpressao() + " Inválida!");
                }
                if (cont == 2 || pilhaLista.getTamanho() != 1) {
                    float valor1 = this.pilhaLista.pop();
                    float valor2 = this.pilhaLista.pop();
                    res = Calcular(valor1, valor2, s);
                    pilhaLista.push(res);
                    cont = 0;
                }
            }
        }
        setResposta(res);
    }

    public String getExpressao() {
        return expressao;
    }
}
