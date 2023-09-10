package model.test;

import model.domain.PessoaFisica;
import model.domain.PessoaFisicaRepo;

import java.io.IOException;

public class TestPessoaFisicaRepo {
    public static void main(String[] args) {
        PessoaFisicaRepo repositorio = new PessoaFisicaRepo();
        PessoaFisica pessoa = new PessoaFisica();
        PessoaFisica pessoa1 = new PessoaFisica();
        PessoaFisica pessoa2 = new PessoaFisica();
        PessoaFisica pessoa3 = new PessoaFisica();
        pessoa.setNome("Thiago");
        pessoa.setId(1);
        pessoa.setIdade(30);
        pessoa.setCpf("04789272079");
        pessoa1.setNome("Gustavo");
        pessoa1.setId(2);
        pessoa1.setIdade(50);
        pessoa1.setCpf("04789272079");
        pessoa2.setNome("Matheus");
        pessoa2.setId(3);
        pessoa2.setIdade(18);
        pessoa2.setCpf("36418840046");
        pessoa3.setNome("Sara");
        pessoa3.setId(3);
        pessoa3.setIdade(60);
        pessoa3.setCpf("77031356075");
        repositorio.inserir(pessoa);
        repositorio.inserir(pessoa1);
        repositorio.inserir(pessoa2);
        repositorio.inserir(pessoa3);
        repositorio.alterar(pessoa,pessoa1);
        repositorio.excluir(2);
        repositorio.obter(3);

        try {
            System.out.println("Salvo com sucesso");
            repositorio.persistir("pessoasFisicas.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            repositorio.recuperar("pessoasFisicas.bin");
            System.out.println("Pessoas Físicas recuperadas:");
            repositorio.obterTodos().forEach(PessoaFisica::exibir);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
