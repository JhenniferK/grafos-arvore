package br.edu.es.ifpb.grafos;

class Nodo {
    int valor;
    Nodo esquerdo;
    Nodo direito;

    public Nodo(int valor) {
        this.valor = valor;
        esquerdo = direito = null;
    }
}

