package model.domain;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();

        while (true) {
            System.out.println("Escolha uma opção");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Escolha (1 - Pessoa Física, 2 - Pessoa Jurídica)");
                    System.out.print("Opção: ");
                    int pessoa = scanner.nextInt();
                    scanner.nextLine();
                    if (pessoa == 1) {
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Digite a Idade: ");
                        int idade = scanner.nextInt();

                        PessoaFisica pessoaFisica = new PessoaFisica(nome, id, cpf, idade);
                        pessoaFisicaRepo.inserir(pessoaFisica);
                        System.out.println("Pessoa Física cadastrada com sucesso! \n ");
                    } else if (pessoa == 2) {
                        System.out.print("Digite o ID:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o nome da empresa:");
                        String nomeEmpresa = scanner.nextLine();
                        System.out.print("Digite o CNPJ:");
                        String cnpj = scanner.nextLine();

                        PessoaJuridica pessoaJuridica = new PessoaJuridica(nomeEmpresa, id, cnpj);
                        pessoaJuridicaRepo.inserir(pessoaJuridica);
                        System.out.println("Pessoa Jurídica cadastrada com sucesso! \n ");
                    } else {
                        System.out.println("Opção inválida.\n");
                    }
                    break;
                case 2:
                    System.out.println("Escolha (1 - Pessoa Física, 2 - Pessoa Jurídica)");
                    System.out.print("Opção: ");
                    int alterar = scanner.nextInt();
                    scanner.nextLine();
                    if (alterar == 1) {
                        System.out.println("Digite o ID da Pessoa Física que deseja alterar: ");
                        int idPessoaFisicaAlterar = scanner.nextInt();
                        scanner.nextLine();

                        PessoaFisica pessoaFisicaExistente = pessoaFisicaRepo.obter(idPessoaFisicaAlterar);

                        if (pessoaFisicaExistente != null) {
                            System.out.println("Dados da Pessoa Física a ser alterada: ");
                            pessoaFisicaExistente.exibir();
                            System.out.println("Digite o novo nome: ");
                            String novoNomePF = scanner.nextLine();
                            System.out.println("Digite o novo CPF: ");
                            String novoCpf = scanner.nextLine();
                            System.out.println("Digite a nova idade: ");
                            int novaIdade = scanner.nextInt();

                            PessoaFisica pessoaFisicaAtualizada = new PessoaFisica(novoNomePF, idPessoaFisicaAlterar, novoCpf, novaIdade);
                            pessoaFisicaRepo.alterar(pessoaFisicaExistente, pessoaFisicaAtualizada);

                            System.out.println("Pessoa Física alterada com sucesso! \n ");
                        } else {
                            System.out.println("Pessoa Física com o ID " + idPessoaFisicaAlterar + " não encontrado. \n");
                        }
                    } else if (alterar == 2) {
                        System.out.print("Digite o ID da Pessoa Jurídica que deseja alterar: ");
                        int pessoaJuridicaAlterar = scanner.nextInt();
                        scanner.nextLine();
                        PessoaJuridica pessoaJuridicaExistente = pessoaJuridicaRepo.obter(pessoaJuridicaAlterar);

                        if (pessoaJuridicaExistente != null) {
                            System.out.println("Dados da Pessoa Jurídica a ser alterada");
                            pessoaJuridicaExistente.exibir();
                            System.out.print("Digite o novo nome da Empresa: ");
                            String novoNomePj = scanner.nextLine();
                            System.out.print("Digite o novo CNPJ: ");
                            String novoCnpj = scanner.nextLine();

                            PessoaJuridica pessoaJuridicaAtualizada = new PessoaJuridica(novoNomePj, pessoaJuridicaAlterar, novoCnpj);
                            pessoaJuridicaRepo.alterar(pessoaJuridicaExistente, pessoaJuridicaAtualizada);
                        } else {
                            System.out.println("Pessoa Jurídica com o ID " + pessoaJuridicaAlterar + " não encontrado.\n");
                        }
                    }
                    else {
                        System.out.println("Opção inválida.\n");
                    }
                    break;
                case 3:
                    System.out.println("Escolha (1 - Pessoa Física, 2 - Pessoa Jurídica)");
                    System.out.print("Opção: ");
                    int exluir = scanner.nextInt();
                    scanner.nextLine();
                    if (exluir == 1) {
                        System.out.print("Digite o ID da Pessoa Física que deseja excluir: ");
                        int pessoaFisicaExcluir = scanner.nextInt();

                        PessoaFisica pessoaFisicaExistente = pessoaFisicaRepo.obter(pessoaFisicaExcluir);

                        if (pessoaFisicaExistente != null) {
                            System.out.println("Dados da Pessoa Física a ser excluída");
                            pessoaFisicaExistente.exibir();

                            System.out.print("Tem certeza de que deseja excluir esta Pessoa Física? (S/N): ");
                            String confirmacaoPessoaFisica = scanner.next();

                            if (confirmacaoPessoaFisica.equalsIgnoreCase("S")) {
                                pessoaFisicaRepo.excluir(pessoaFisicaExcluir);
                                System.out.println("Pessoa Física excluída com sucesso! \n");
                            } else {
                                System.out.println("Exclusão cancelada. \n ");
                            }
                        } else {
                            System.out.println("Pessoa Física com o ID " + pessoaFisicaExcluir + " não encontrado. \n");
                        }
                    }
                    else if (exluir == 2) {
                        System.out.print("Digite o ID da Pessoa Jurídica que deseja excluir: ");
                        int pessoaJuridicaExcluir = scanner.nextInt();
                        scanner.nextLine();

                        PessoaJuridica pessoaJuridicaExistente = pessoaJuridicaRepo.obter(pessoaJuridicaExcluir);

                        if (pessoaJuridicaExistente != null) {
                            System.out.print("Dados da Pessoa Jurídica a ser excluída");
                            pessoaJuridicaExistente.exibir();

                            System.out.print("Tem certeza de que deseja excluir esta Pessoa Jurídica? (S/N): ");
                            String confirmacaoPessoaJuridica = scanner.next();

                            if (confirmacaoPessoaJuridica.equalsIgnoreCase("S")) {
                                pessoaJuridicaRepo.excluir(pessoaJuridicaExcluir);
                                System.out.println("Pessoa Jurídica excluída com sucesso! \n");
                            } else {
                                System.out.println("Exclusão cancelada. \n");
                            }
                        } else {
                            System.out.println("Pessoa Jurídica com o ID " + pessoaJuridicaExcluir + " não encontrado. \n");
                        }
                    } else {
                        System.out.println("Opção inválida. \n");
                    }
                    break;
                case 4:
                    System.out.println("Escolha (1 - Pessoa Física, 2 - Pessoa Jurídica)");
                    System.out.print("Opção: ");
                    int obter = scanner.nextInt();
                    if (obter == 1) {
                        System.out.print("Digite o ID da Pessoa Física que deseja obter: ");
                        int obterPessoaFisica = scanner.nextInt();
                        scanner.nextLine();

                        PessoaFisica pessoaFisicaExistente = pessoaFisicaRepo.obter(obterPessoaFisica);

                        if (pessoaFisicaExistente != null) {
                            System.out.println("Dados da Pessoa Física obtida");
                            pessoaFisicaExistente.exibir();
                        } else {
                            System.out.println("Pessoa Física com o ID " + obterPessoaFisica + " não encontrado. \n");
                        }
                    } else if (obter == 2) {
                        System.out.print("Digite o ID da Pessoa Jurídica que deseja obter: ");
                        int obterPessoaJuridica = scanner.nextInt();
                        scanner.nextLine();

                        PessoaJuridica pessoaJuridicaExiste = pessoaJuridicaRepo.obter(obterPessoaJuridica);

                        if (pessoaJuridicaExiste != null) {
                            System.out.println("Dados da Pessoa Jurídica obtida");
                            pessoaJuridicaExiste.exibir();
                        }else {
                            System.out.println("Pessoa Jurídica com o ID " + obterPessoaJuridica + " não encontrado. \n");
                        }
                    } else {
                        System.out.println("Opção inválida. \n");
                    }
                    break;
                case 5:
                    System.out.println("Escolha (1 - Pessoa Física, 2 - Pessoa Jurídica)");
                    System.out.print("Opção: ");
                    int exibirTodos = scanner.nextInt();
                    scanner.nextLine();
                    if (exibirTodos == 1) {
                        List<PessoaFisica> pessoasFisicas = pessoaFisicaRepo.obterTodos();
                        if (!pessoasFisicas.isEmpty()) {
                            System.out.println("Lista de todas as Pessoas Físicas \n");
                            for (PessoaFisica pessoaFisica : pessoasFisicas) {
                                pessoaFisica.exibir();
                                System.out.println();
                            }
                        } else {
                            System.out.println("Nenhuma Pessoa Física encontrada. \n");
                        }
                    } else if (exibirTodos == 2) {
                        List<PessoaJuridica> pessoaJuridicas = pessoaJuridicaRepo.obterTodos();
                        if (!pessoaJuridicas.isEmpty()) {
                            System.out.println("Lista de todas as Pessoas Jurídicas \n");
                            for (PessoaJuridica pessoaJuridica : pessoaJuridicas) {
                                pessoaJuridica.exibir();
                                System.out.println();
                            }
                        } else {
                            System.out.println("Nenhuma Pessoa Jurídica encontrada. \n");
                        }
                    } else {
                        System.out.println("Opção inválida. \n");
                    }
                    break;
                case 6:
                    System.out.print("Digite o nome do arquivo: ");
                    String prefixoSalvar = scanner.next();
                    try {
                        pessoaFisicaRepo.persistir(prefixoSalvar + ".fisica.bin");
                        pessoaJuridicaRepo.persistir(prefixoSalvar + ".juridica.bin");
                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar dados:" + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Digite o nome do arquivo: ");
                    String prefixoRecuperar = scanner.next();
                    try {
                        pessoaFisicaRepo.recuperar(prefixoRecuperar + ".fisica.bin");
                        pessoaJuridicaRepo.recuperar(prefixoRecuperar + ".juridica.bin");
                        System.out.println("Dados recuperados com sucesso. \n");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao recuperar dados: " + e.getMessage());
                    }
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente. \n");
                    break;
            }
        }
    }
}