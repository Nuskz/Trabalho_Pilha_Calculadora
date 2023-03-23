import java.util.EmptyStackException;

public class PilhaVetor<T> implements Pilha<T> {
    private T[] info;
    private int limite;
    private int tamanho = 0;

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
