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

import java.io.Console;
import java.util.Scanner;

public class T1_ok {

    static HashTable hs;

    public static void main(String[] args) {

        hs = new HashTable(10);
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

    static public String escolha() {
        System.out.print("> ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    static public void functions(String escolha) {
        Record carro;
        int num_chassi, ano;
        String nome, modelo, marca;

        switch (escolha) {
            case "1":
                System.out.println("=== CADASTRAR NOVO VEÍCULO ===");
                System.out.print("Número do Chassi (7 Dígitos): ");
                num_chassi = Integer.parseInt(escolha());
                System.out.print("Nome: ");
                nome = escolha();
                System.out.print("Modelo: ");
                modelo = escolha();
                System.out.print("Marca: ");
                marca = escolha();
                System.out.print("Ano: ");
                ano = Integer.parseInt(escolha());

                carro = new Record(num_chassi, nome, modelo, marca, ano);
                hs.insert(carro);
                
                print_menu();
                break;
            case "2":
                System.out.println("=== PESQUISAR VEICULO ===");
                System.out.print("Digite o número do chassi: ");
                num_chassi = Integer.parseInt(escolha());
                
                hs.search_record(num_chassi);
                print_menu();
                break;
            case "3":
                System.out.println("=== REMOVER VEICULO ===");
                System.out.print("Digite o número do chassi: ");
                num_chassi = Integer.parseInt(escolha());
                
                hs.remove(num_chassi);
                print_menu();
                break;
            case "4":
                System.out.println("=== LISTANDO ITENS CADASTRADOS ===");
                
                hs.print_hash_table();
                print_menu();
                break;
            case "5":
                System.out.println("=== VOLTE SEMPRE ===");
                break;
        }
    }
}
