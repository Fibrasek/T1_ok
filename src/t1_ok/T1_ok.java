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
        print_menu();

    }

    static public void print_menu() {
        System.out.println("=== BEM VINDO AO SISTEMA DE CADASTRO ===");
        System.out.println("O que deseja fazer?");
        System.out.println("1 - Cadastrar um novo veículo;");
        System.out.println("2 - Procurar um veículo;");
        System.out.println("3 - Remover um veículo;");
        System.out.println("4 - Listar veículos no sistema.");
        functions(escolha());
    }

    private static void limpar_console() {
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception exception) {
            //  Handle exception.
        }
    }

    static public String escolha() {
        System.out.print("> ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    static public void functions(String escolha) {
        String aux = null;
        
        Record carro;
        int num_chassi, ano;
        String nome, modelo, marca;

        switch (escolha) {
            case "1":
                System.out.println("=== CADASTRAR NOVO VEÍCULO ===");
                           
                do{
                    System.out.print("Número do Chassi (min. 3 Dígitos): ");
                    aux = escolha();
                    if(aux.length() < 3){ System.out.println("ERRO: Valor em formato errado.");}
                }while(aux.length() < 3 );
                
                num_chassi = Integer.parseInt(aux);
                
                System.out.print("Nome: ");
                nome = escolha();
                
                System.out.print("Modelo: ");
                modelo = escolha();
                
                System.out.print("Marca: ");
                marca = escolha();
                
                do{
                    System.out.print("Ano: ");
                    aux = escolha();
                    if(aux.length() < 4){ System.out.println("ERRO: Valor em formato errado.");}
                }while(aux.length() < 4 );
                
                ano = Integer.parseInt(aux);

                carro = new Record(num_chassi, nome, modelo, marca, ano);
                hs.insert(carro);
                System.out.print("Pressione Enter para voltar ao menu.");
                escolha();
                

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
        }
    }
}
