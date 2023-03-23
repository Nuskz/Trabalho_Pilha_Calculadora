package lista;

public interface Lista<T> {

    void inserir(T valor);

    int buscar(T valor);

    boolean estaVazia();

    void retirar(T valor);

    String exibir();

    Lista<T> copiar();

    Lista<T> dividir();

    int getTamanho();

    void concatenar(Lista<T> outraLista);

    void inserir(T valor, int pos);

    T pegar(int pos);

}