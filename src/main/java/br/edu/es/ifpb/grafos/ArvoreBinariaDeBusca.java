package br.edu.es.ifpb.grafos;

public class ArvoreBinariaDeBusca {
    private Nodo raiz;

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private Nodo inserirRecursivo(Nodo raiz, int valor) {
        if (raiz == null) {
            return new Nodo(valor);
        }

        if (valor < raiz.valor)
            raiz.esquerdo = inserirRecursivo(raiz.esquerdo, valor);
        else if (valor > raiz.valor)
            raiz.direito = inserirRecursivo(raiz.direito, valor);

        return raiz;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(Nodo raiz, int valor) {
        if (raiz == null)
            return false;

        if (valor == raiz.valor)
            return true;

        return valor < raiz.valor
                ? buscarRecursivo(raiz.esquerdo, valor)
                : buscarRecursivo(raiz.direito, valor);
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private Nodo removerRecursivo(Nodo raiz, int valor) {
        if (raiz == null)
            return null;

        if (valor < raiz.valor) {
            raiz.esquerdo = removerRecursivo(raiz.esquerdo, valor);
        } else if (valor > raiz.valor) {
            raiz.direito = removerRecursivo(raiz.direito, valor);
        } else {
            if (raiz.esquerdo == null)
                return raiz.direito;
            else if (raiz.direito == null)
                return raiz.esquerdo;

            raiz.valor = encontrarMenorValorRec(raiz.direito);
            raiz.direito = removerRecursivo(raiz.direito, raiz.valor);
        }
        return raiz;
    }

    public int encontrarMenorValor() {
        return encontrarMenorValorRec(raiz);
    }

    private int encontrarMenorValorRec(Nodo raiz) {
        if (raiz == null)
            throw new IllegalStateException("Árvore vazia.");
        while (raiz.esquerdo != null)
            raiz = raiz.esquerdo;
        return raiz.valor;
    }

    public void emOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(Nodo raiz) {
        if (raiz != null) {
            emOrdemRec(raiz.esquerdo);
            System.out.print(raiz.valor + " ");
            emOrdemRec(raiz.direito);
        }
    }

    public void preOrdem() {
        preOrdemRec(raiz);
        System.out.println();
    }

    private void preOrdemRec(Nodo raiz) {
        if (raiz != null) {
            System.out.print(raiz.valor + " ");
            preOrdemRec(raiz.esquerdo);
            preOrdemRec(raiz.direito);
        }
    }

    public void posOrdem() {
        posOrdemRec(raiz);
        System.out.println();
    }

    private void posOrdemRec(Nodo raiz) {
        if (raiz != null) {
            posOrdemRec(raiz.esquerdo);
            posOrdemRec(raiz.direito);
            System.out.print(raiz.valor + " ");
        }
    }
}
