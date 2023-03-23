package lista;

public class ListaEncadeada<T> implements Lista<T> {
    protected NoLista<T> primeiro;
    protected NoLista<T> ultimo;
    protected int qtdeElementos;

    public ListaEncadeada() {
    }

    @Override
    public void inserir(T valor) {
        NoLista<T> novo =  new NoLista<T>();
        novo.setInfo(valor);
        if (this.estaVazia()) {
            this.primeiro = novo;
        } else {
            this.ultimo.setProx(novo);
        }
        this.ultimo = novo;
        this.qtdeElementos++;
    }

    public void setQtdDeElementos(int qtd){
        this.qtdeElementos = qtd;
    }

    public int getQtdDeElementos(){
        return this.qtdeElementos;
    }

    public void setPrimeiro(NoLista<T> no){
        this.primeiro = no;
    }

    public void setUltimo(NoLista<T> no){
        this.ultimo = no;
    }

    public NoLista<T> getPrimeiro(){
        return this.primeiro;
    }

    public NoLista<T> getUltimo(){
        return this.ultimo;
    }

    @Override
    public int buscar(T valor) {
        NoLista<T> p = primeiro;
        int cont = 0;
        while (p != null) {
            if (p.getInfo() == valor) {
                return cont;
            }
        }

        return -1;

    }

    @Override
    public boolean estaVazia() {
        if (primeiro == null) {
            return true;
        }
        return false;
    }

    @Override
    public void retirar(T valor) {
        NoLista<T> p = primeiro;
        NoLista<T> a = null;
        while (p != null && p.getInfo() != valor) {
            a = p;
            p = p.getProx();
        }
        if (p != null) {
            if (this.ultimo == p) {
                this.ultimo = a;
            } else if (a == null) {
                this.primeiro = p.getProx();
            } else {
                a.setProx(p.getProx());
            }
            this.qtdeElementos--;

        }
    }

    @Override
    public String exibir() {
        NoLista<T> p = primeiro;
        String str = "[";
        while (p != null) {
            str += p.getInfo() + ", ";
            p = p.getProx();
        }
        return str += " ]";
    }

    @Override
    public Lista<T> copiar() {
        Lista<T> copia = new ListaEncadeada<T>();
        for (NoLista<T> p = primeiro; p != null; p = p.getProx()) {
            copia.inserir(p.getInfo());
        }
        return copia;

    }

    @Override
    public Lista<T> dividir() {
        ListaEncadeada<T> outra = new ListaEncadeada<T>();
        int divisao = getTamanho()/2;
        NoLista<T> anterior = null;
        NoLista<T> atual = primeiro;
        for(int i = 0; i < divisao; i++){
            anterior = atual;
            atual = atual.getProx();
        }
        anterior.setProx(null);
        this.ultimo = anterior;
        this.qtdeElementos = divisao;
        outra.primeiro = atual;
        outra.ultimo = this.ultimo;
        outra.qtdeElementos = getTamanho()-(getTamanho() / 2);
        return outra;
    }

    @Override
    public int getTamanho() {
        return this.qtdeElementos;
    }

    @Override
    public void concatenar(Lista<T> outraLista) {
        for(int i = 0; i < outraLista.getTamanho(); i++){
            this.inserir(outraLista.pegar(i));
        }
    }

    @Override
    public T pegar(int pos) {
        if (pos < 0 || pos > this.qtdeElementos) {
            throw new IndexOutOfBoundsException("posição:" + pos + " não existe!");
        }
        NoLista<T> p = primeiro;
        int cont = 0;
        while (p != null) {
            if (cont == pos) {
                return p.getInfo();
            }
            cont++;
            p = p.getProx();
        }
        return null;

    }

    @Override
    public void inserir(T valor, int pos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }

}
