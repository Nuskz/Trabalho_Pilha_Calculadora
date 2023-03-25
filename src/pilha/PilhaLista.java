package pilha;
import lista.ListaEncadeada;
import lista.NoLista;

public class PilhaLista<T> implements Pilha<T>{

    private ListaEncadeada<T> lista = new ListaEncadeada<T>();    

    public String toString(){ 
        return lista.exibir();
    }

    @Override
    public void push(T v) {
        if(v == null){
            throw new NullPointerException();
        }
        lista.inserir(v);
    }

    @Override
    public T pop() {
        NoLista<T> atual = lista.getPrimeiro();
        NoLista<T> penultimoNoLista = null;
        if(atual.getProx() == null){
            lista.setQtdDeElementos(0);
            lista.setPrimeiro(null);
            return atual.getInfo();
        }
        while(atual.getProx() != null){
            penultimoNoLista = atual;
            atual = atual.getProx();
        }
        penultimoNoLista.setProx(null);
        lista.setUltimo(penultimoNoLista);
        lista.setQtdDeElementos(lista.getQtdDeElementos() - 1);
        return atual.getInfo();
    }

    @Override
    public T peek() {
        NoLista<T> n = lista.getUltimo();
        if(n != null){
            return n.getInfo();
        }
       return null; 
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        lista = new ListaEncadeada<T>();
    }
    
}
