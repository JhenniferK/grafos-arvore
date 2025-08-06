package br.edu.es.ifpb.grafos;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Travessia em ordem:");
        arvore.emOrdem();

        System.out.println("Travessia pré-ordem:");
        arvore.preOrdem();

        System.out.println("Travessia pós-ordem:");
        arvore.posOrdem();

        System.out.println("Menor valor da árvore: " + arvore.encontrarMenorValor()); // 20

        System.out.println("Busca por 60: " + arvore.buscar(60));
        System.out.println("Busca por 90: " + arvore.buscar(90));

        System.out.println("Removendo o valor 50...");
        arvore.remover(50);

        System.out.println("Travessia em ordem após remoção:");
        arvore.emOrdem();
    }
}
