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

public class Record {

    private int num_chassi;
    private String nome;
    private String modelo;
    private String marca;
    private int ano;

    public Record(int num_chassi, String nome, String modelo, String marca, int ano) {
        this.num_chassi = num_chassi;
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
    }

    // GETTERS E SETTERS
    public int get_num_chassi() {
        return num_chassi;
    }

    public String get_nome() {
        return nome;
    }

    public String get_modelo() {
        return modelo;
    }

    public String get_marca() {
        return marca;
    }

    public int get_ano() {
        return ano;
    }

    public void set_num_chassi(int num_chassi) {
        this.num_chassi = num_chassi;
    }

    public void set_nome(String nome) {
        this.nome = nome;
    }

    public void set_modelo(String modelo) {
        this.modelo = modelo;
    }

    public void set_marca(String marca) {
        this.marca = marca;
    }

    public void set_ano(int ano) {
        this.ano = ano;
    }
}