import lista.ListaEncadeada;
import lista.NoLista;

public class PilhaLista<T> implements Pilha<T>{

    private ListaEncadeada<T> lista = new ListaEncadeada<T>();    

    public String toString(){
        String str = "[";

        return str + " ]";
    }

    @Override
    public void push(T v) {
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    @Override
    public boolean estaVazia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estaVazia'");
    }

    @Override
    public void liberar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'liberar'");
    }
    
}
