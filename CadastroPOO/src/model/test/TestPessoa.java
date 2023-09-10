package model.test;

import model.domain.Pessoa;

public class TestPessoa {
    public static void main(String[] args ){
        Pessoa pessoa = new Pessoa("", 0);
        Pessoa pessoa1 = new Pessoa("", 0);
        Pessoa pessoa2 = new Pessoa("", 0);
        pessoa.setNome("João");
        pessoa.setId(1);
        pessoa1.setNome("Maria");
        pessoa1.setId(2);
        pessoa2.setNome("José");
        pessoa2.setId(3);
        pessoa.exibir();
        pessoa1.exibir();
        pessoa2.exibir();
    }
}
