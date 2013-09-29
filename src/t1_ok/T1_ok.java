/*
 Trabalho:
 Tabela Hash

 Autores:
 João Gabriel P. Bellon
 Mário Esperança

 Disciplina:
 Estruturas de Dados 1

 UTFPR - 2013
 */
package t1_ok;

import java.util.Scanner;

public class T1_ok {

    static HashTable hs;

    public static void main(String[] args) {

        hs = new HashTable(10);
        limpar_console();
        print_menu();

    }

    static public void print_menu() {
        System.out.println("=== BEM VINDO AO SISTEMA DE CADASTRO ===");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Cadastrar um novo veículo;");
        System.out.println("2 - Procurar um veículo;");
        System.out.println("3 - Remover um veículo;");
        System.out.println("4 - Listar veículos no sistema.");
        System.out.println("5 - Sair :(");
        functions(escolha());
    }

    static public void voltar() {
        System.out.print("Pressione Enter para voltar ao menu");
        escolha();
        limpar_console();
        print_menu();
    }

    private static void limpar_console() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }

    static public String escolha() {
        System.out.print("> ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    static public void functions(String escolha) {
        limpar_console();
        String aux = null;

        Record carro;
        int num_chassi, ano;
        String nome, modelo, marca;

        switch (escolha) {
            case "1":
                System.out.println("=== CADASTRAR NOVO VEÍCULO ===");

                do {
                    System.out.print("Número do Chassi (min. 3 Dígitos): ");
                    aux = escolha();
                    if (aux.length() < 3) {
                        System.out.println("ERRO: Valor em formato errado.");
                    }
                } while (aux.length() < 3);

                num_chassi = Integer.parseInt(aux);

                System.out.print("Nome: ");
                nome = escolha();

                System.out.print("Modelo: ");
                modelo = escolha();

                System.out.print("Marca: ");
                marca = escolha();

                do {
                    System.out.print("Ano (YYYY): ");
                    aux = escolha();
                    if (aux.length() < 4) {
                        System.out.println("ERRO: Valor em formato errado.");
                    }
                } while (aux.length() < 4);

                ano = Integer.parseInt(aux);

                carro = new Record(num_chassi, nome, modelo, marca, ano);
                hs.insert(carro);

                voltar();
                break;
            case "2":
                System.out.println("=== PESQUISAR VEICULO ===");
                System.out.print("Digite o número do chassi: ");
                num_chassi = Integer.parseInt(escolha());

                hs.search_record(num_chassi);

                voltar();
                break;
            case "3":
                System.out.println("=== REMOVER VEICULO ===");
                System.out.print("Digite o número do chassi: ");
                num_chassi = Integer.parseInt(escolha());


                hs.remove(num_chassi);
                voltar();
                break;
            case "4":
                System.out.println("=== LISTANDO ITENS CADASTRADOS ===");

                hs.print_hash_table();
                voltar();
                break;
            case "5":
                System.out.println("=== VOLTE SEMPRE ===");
                break;
        }
    }
}
