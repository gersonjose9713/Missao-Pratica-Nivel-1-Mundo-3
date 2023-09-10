package model.test;

import model.domain.PessoaJuridica;
import model.domain.PessoaJuridicaRepo;

import java.io.IOException;

public class TestPessoaJuridicaRepo {
    public static void main(String[] args) {
        PessoaJuridicaRepo repositorio = new PessoaJuridicaRepo();
        PessoaJuridica empresa = new PessoaJuridica();
        PessoaJuridica empresa1 = new PessoaJuridica();
        PessoaJuridica empresa2 = new PessoaJuridica();
        PessoaJuridica empresa3 = new PessoaJuridica();
        empresa.setNome("Coca-Cola");
        empresa.setId(10);
        empresa.setCnpj("61037629000109");
        empresa1.setNome("Pepsi");
        empresa1.setId(25);
        empresa1.setCnpj("21875932000158");
        empresa2.setNome("McDonalds");
        empresa2.setId(40);
        empresa2.setCnpj("51711041000127");
        empresa3.setNome("Burger King");
        empresa3.setId(3);
        empresa3.setCnpj("27382421000180");
        repositorio.inserir(empresa);
        repositorio.inserir(empresa1);
        repositorio.inserir(empresa2);
        repositorio.inserir(empresa3);
        repositorio.alterar(empresa, empresa1);
        repositorio.excluir(40);
        repositorio.obter(3);

        try {
            System.out.println("Salvo com sucesso");
            repositorio.persistir("pessoaJuridica.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            repositorio.recuperar("pessoaJuridica.bin");
            System.out.println("Pessoas Jurídica recuperadas:");
            repositorio.obterTodos().forEach(PessoaJuridica::exibir);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
