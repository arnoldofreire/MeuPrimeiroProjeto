package com.dio.exemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("=" .repeat(40));
        System.out.println("MINHA AGENDA");
        System.out.println("=" .repeat(40));

        while (opcao != 3) {
            System.out.println("\n1 - Adicionar nome");
            System.out.println("2 - Ver nomes");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");

            // TRATAMENTO DE ERRO - Se digitar letra, não quebra
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("❌ Digite APENAS números (1, 2 ou 3)!");
                scanner.nextLine(); // Limpa o buffer
                continue; // Volta para o início do loop
            }

            if (opcao == 1) {
                System.out.print("Digite um nome: ");
                String nome = scanner.nextLine();

                // Não deixa adicionar nome vazio
                if (nome.trim().isEmpty()) {
                    System.out.println("❌ Nome não pode ser vazio!");
                } else {
                    nomes.add(nome);
                    System.out.println("✅ Nome adicionado! Total: " + nomes.size());
                }

            } else if (opcao == 2) {
                System.out.println("\n--- LISTA DE NOMES ---");
                if (nomes.isEmpty()) {
                    System.out.println("📭 Nenhum nome cadastrado ainda.");
                } else {
                    for (int i = 0; i < nomes.size(); i++) {
                        System.out.println((i+1) + " - " + nomes.get(i));
                    }
                    System.out.println("📊 Total: " + nomes.size() + " nome(s)");
                }

            } else if (opcao == 3) {
                System.out.println("👋 Programa finalizado! Até logo!");

            } else {
                System.out.println("❌ Opção inválida! Digite 1, 2 ou 3.");
            }
        }

        scanner.close();
    }
}