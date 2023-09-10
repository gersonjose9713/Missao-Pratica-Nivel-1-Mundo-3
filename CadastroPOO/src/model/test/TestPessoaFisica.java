package model.test;

import model.domain.PessoaFisica;

public class TestPessoaFisica {
    public static void main(String[] args) {
        PessoaFisica pessoaFisica = new PessoaFisica("", 0, "", 0);
        PessoaFisica pessoaFisica1 = new PessoaFisica("", 0, "", 0);
        PessoaFisica pessoaFisica2 = new PessoaFisica("", 0, "", 0);
        pessoaFisica.setNome("João");
        pessoaFisica.setId(1);
        pessoaFisica.setCpf("123456789");
        pessoaFisica.setIdade(20);
        pessoaFisica1.setNome("Maria");
        pessoaFisica1.setId(2);
        pessoaFisica1.setCpf("987654321");
        pessoaFisica1.setIdade(30);
        pessoaFisica2.setNome("José");
        pessoaFisica2.setId(3);
        pessoaFisica2.setCpf("123456789");
        pessoaFisica2.setIdade(40);
        pessoaFisica.exibir();
        pessoaFisica1.exibir();
        pessoaFisica2.exibir();
    }
}
