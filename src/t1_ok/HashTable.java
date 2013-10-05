/*
 Trabalho:
 Tabela Hash

 Autores:
 João Gabriel P. Bellon

 Disciplina:
 Estruturas de Dados 1

 UTFPR - 2013
 */
package t1_ok;

import java.util.ArrayList;

public class HashTable implements HashFunctions {

    /*
     Classe interna Bucket, que armazena os Records
     de acordo com o hash do mesmo.
     */
    public class Bucket {

        ArrayList<Record> records;

        public Bucket() {
            this.records = new ArrayList<>();
        }

        /*
         Insere um objeto tipo record na lista.
         */
        public void insert(Record record) {
            records.add(record);
        }

        /*
         Função para remover um Record, baseado no número do chassi.
         */
        public int remove(int num_chassi) {
            for (int pos = 0; pos <= records.size() - 1; pos++) {
                if (((Record) records.get(pos)).get_num_chassi() == num_chassi) {
                    records.remove(pos);
                    return 1;
                }
            }
            return 0;
        }

        // GETTERS
        public int get_tam() {
            return records.size();
        }

        public ArrayList<Record> get_records() {
            return records;
        }
    }
    int tam;
    ArrayList<Bucket> buckets;

    /*
     Construtor
     */
    public HashTable(int tam) {
        this.tam = tam;
        this.buckets = new ArrayList<Bucket>(tam);

        for (int a = 0; a < tam - 1; a++) {
            this.buckets.add(null);
        }
    }

    /*
     Calcula o hash do Record de acordo com a variavel num_chassi,
     utilizando do método do módulo (%) da divisão.
     */
    @Override
    public int hash(Record record) {
        //Para montar o hash, utilizamos os 3 primeiro digitos do num_chassi.
        int x = Integer.parseInt((record.get_num_chassi() + "").substring(0, 2));

        //Com os 3 primeiros números, obtemos um index/posição de um bucket na table.
        int hash = x % this.tam;

        //Retorna o valor hash.
        return hash;
    }

    /*
     Mesma função de hash, com a passagem do num_chassi direto.
     Função de conveniência, para busca e remoção.
     */
    @Override
    public int hash(int num_chassi) {
        //Para montar o hash, utilizamos os 3 primeiro digitos do num_chassi.
        int x = Integer.parseInt((num_chassi + "").substring(0, 2));

        //Com os 3 primeiros números, obtemos um index/posição de um bucket na table.
        int hash = x % tam;

        //Retorna o valor do hash.
        return hash;
    }

    /*
     Para inserir, passamos um objeto do tipo Record para a função,
     a partir deste objeto obtemos o hash (explicado anteriormente).

     Verificamos se a posição da tabela contem um bucket, caso não,
     é criado e assim inserido o item.
     */
    public int insert(Record record) {
        //Realizamos o hash.
        int pos = hash(record);

        //Verificamos se a posição possui um bucket.
        if (buckets.get(pos) == null) {
            //Caso não, criamos um com o tamanho determinado.
            buckets.add(pos, new Bucket());

            //Inserimos o Record no bucket.
            ((Bucket) buckets.get(pos)).insert(record);

            //Retorna 1 (sucesso), para fins de loging.
            return 1;
        } else {
            //Caso bucket já exista, apenas inserimos.
            ((Bucket) buckets.get(pos)).insert(record);

            //Retorna 1 (sucesso), para fins de loging.
            return 1;
        }
    }

    /*
     Obtem o hash para saber em qual bucket o valor está,
     agilizando o processo de leitura.
     */
    public int remove(int num_chassi) {
        //Obtem o hash a partir do num_chassi.
        int hash = hash(num_chassi);

        //A partir do hash, encontramos o bucket e removemos o item.
        if (buckets.get(hash) != null) {
            return ((Bucket) buckets.get(hash)).remove(num_chassi);
        } else {
            return 0;
        }
    }

    /*
     Obtem o hash para saber em qual bucket o valor está,
     e após encontrar o bucket, percorre o mesmo para encontrar
     o valor a partir do num_chassi.
     */
    public int search_record(int num_chassi) {
        int hash = hash(num_chassi);

        Bucket b = buckets.get(hash);

        if (b == null) {
            System.out.println("Não existe um registro com esse Núm. Chassi.");
            return 0;
        }

        for (int pos = 0; pos <= b.get_records().size() - 1; pos++) {
            if (b.get_records().get(pos).get_num_chassi() == num_chassi) {
                Record r = b.get_records().get(pos);
                System.out.println("Num. Chassi: " + r.get_num_chassi());
                System.out.println("Nome: " + r.get_nome());
                System.out.println("Modelo: " + r.get_modelo());
                System.out.println("Marca: " + r.get_marca());
                System.out.println("Ano: " + r.get_ano());

                return r.get_num_chassi();
            }
        }
        return 0;
    }

    /*
     Função utilizada para validar a existência de um registro
     existente, no caso do cadastro. Para não haver duplicatas,
     ou registros com valores fora do padrão.
     */
    public int validate_record(int num_chassi) {
        int hash = hash(num_chassi);

        Bucket b = buckets.get(hash);

        if (b == null) {
            return 0;
        }

        for (int pos = 0; pos <= b.get_records().size() - 1; pos++) {
            if (b.get_records().get(pos).get_num_chassi() == num_chassi) {
                Record r = b.get_records().get(pos);

                return r.get_num_chassi();
            }
        }
        return 0;
    }

    /*
     Percorre os buckets e records imprimindo os valores e suas
     posições, tanto no bucket quanto na hash table.
     */
    public void print_hash_table() {
        for (int pos = 0; pos <= buckets.size() - 1; pos++) {
            if (buckets.get(pos) != null) {
                Bucket b = buckets.get(pos);

                for (int aux = 0; aux <= b.get_records().size() - 1; aux++) {

                    Record r = b.get_records().get(aux);

                    System.out.println("=== BUCKET " + pos + " ITEM " + aux + "===");
                    System.out.println("= Num. Chassi: " + r.get_num_chassi());
                    System.out.println("= Nome: " + r.get_nome());
                    System.out.println("= Modelo: " + r.get_modelo());
                    System.out.println("= Marca: " + r.get_marca());
                    System.out.println("= Ano: " + r.get_ano());
                }
            }
        }
    }
}