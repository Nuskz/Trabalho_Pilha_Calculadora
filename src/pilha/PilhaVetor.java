package pilha;
import java.util.EmptyStackException;

public class PilhaVetor<T> implements Pilha<T> {
    private T[] info;
    private int limite;
    private int tamanho = 0;

    public int getTamanho() {
        return tamanho;
    }

    public T[] getInfo(){
        return info;
    }

    public PilhaVetor(int limite) {
        this.limite = limite;
        this.info = (T[]) new Object[limite];
    }

    public String toString() {
        String str = "[ ";
        for(int i = 0; i < tamanho; i++){
            str += info[i] + " ,";
        }
        return str + "]";
    }

    public int compara(PilhaVetor<T> p2){
        if(p2 == null){
            throw new NullPointerException("vetor nulo");
        }
        if(this.getTamanho() < p2.getTamanho()){
            return -1;
        } else if(this.getTamanho() == p2.getTamanho()){
            T[] vetor = p2.getInfo();
            for(int i = 0; i < this.getTamanho(); i++){
                if(this.info[i] != vetor[i]){
                    return 1;
                }
            }
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public void push(T v) {
        if (this.tamanho == this.limite) {
            throw new IndexOutOfBoundsException("Pilha está cheia");
        }
        info[tamanho] = v;
        tamanho++;
    }

    @Override
    public T pop() {
        if (estaVazia()){
            throw new EmptyStackException();
        }
        T valor;
        valor = this.peek();
        info[tamanho] = null;
        tamanho--;
        return valor;
    }

    @Override
    public T peek() {
        if(estaVazia()){
            throw new EmptyStackException();
        }
        return this.info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        if (tamanho == 0){
            return true;
        }
        return false;
    }

    @Override
    public void liberar() {
        this.info = (T[]) new Object[limite];
        this.tamanho = 0;
    }

}
