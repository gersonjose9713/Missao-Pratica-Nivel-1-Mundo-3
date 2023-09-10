package model.test;

import model.domain.PessoaJuridica;

public class TestPessoaJuridica {
    public static void main(String[] args) {
        PessoaJuridica pessoaJuridica = new PessoaJuridica("", 0, "");
        PessoaJuridica pessoaJuridica1 = new PessoaJuridica("", 0, "");
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica("", 0, "");
        pessoaJuridica.setNome("João");
        pessoaJuridica.setId(1);
        pessoaJuridica.setCnpj("123456789");
        pessoaJuridica1.setNome("Maria");
        pessoaJuridica1.setId(2);
        pessoaJuridica1.setCnpj("987654321");
        pessoaJuridica2.setNome("José");
        pessoaJuridica2.setId(3);
        pessoaJuridica2.setCnpj("123456789");
        pessoaJuridica.exibir();
        pessoaJuridica1.exibir();
        pessoaJuridica2.exibir();
    }
}
