interface Pilha<T> {
   public void push(T v);
   public T pop();
   public T peek();
   public boolean estaVazia();
   public void liberar();
}
