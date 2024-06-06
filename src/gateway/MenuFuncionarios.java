package gateway;

import model.Funcionarios;
import usecase.FuncionariosUseCase;

import java.util.Scanner;

public class MenuFuncionarios {
    public static void executar_func(Scanner scanner) {
        while (true) {
            System.out.print("""
                    **********************************
                    *                                *
                    *      Menu de Funcionários      *
                    *                                *
                    **********************************
                    
                    Selecione a opção desejada
                    
                    1 - Adicionar um novo Funcionário
                    2 - Dispensar um Funcionário
                    3 - Achar um Funcionário (id)
                    4 - Mostrar todos os Funcionários
                    5 - Alterar os dados de um Funcionário
                    6 - Voltar ao menu principal
                    
                    **********************************
                    
                    Digite aqui: """);

            int opcao;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Opção inválida! Digite um número inteiro.");
                scanner.nextLine();
                continue;
            }
            switch (opcao) {
                case 1:
                    Funcionarios funcionario = lerFuncionario(scanner);
                    System.out.println(FuncionariosUseCase.adicionarFuncionario(funcionario));
                    break;

                case 2:
                    boolean funcionarioRemovido = false;
                    while (!funcionarioRemovido) {
                        System.out.println("Insira o id do funcionário a ser dispensado (ou digite 0 para cancelar): ");
                        int id = lerInt(scanner);
                        if (id == 0) {
                            System.out.println("Operação de dispensa cancelada.");
                            break;
                        }
                        if (FuncionariosUseCase.funcionarioExiste(id)) {
                            FuncionariosUseCase.dispensarFuncionario(id);
                            System.out.println("Funcionário dispensado com sucesso!");
                            funcionarioRemovido = true;
                        } else {
                            System.out.println("Funcionário fornecido não existe. Tente novamente.");
                        }
                    }
                    break;

                case 3:
                    boolean funcionarioEncontrado = false;
                    while (!funcionarioEncontrado) {
                        System.out.println("Insira o id do funcionário a procurar (ou digite 0 para cancelar): ");
                        int id = lerInt(scanner);
                        if (id == 0) {
                            System.out.println("Operação de busca cancelada.");
                            break;
                        }
                        if (FuncionariosUseCase.funcionarioExiste(id)) {
                            System.out.println(FuncionariosUseCase.pesquisarFuncionario(id));
                            funcionarioEncontrado = true;
                        } else {
                            System.out.println("Funcionário fornecido não existe. Tente novamente.");
                        }
                    }
                    break;

                case 4:
                    System.out.println(FuncionariosUseCase.mostrarFuncionarios());
                    break;

                case 5:
                    boolean funcionarioEditado = false;
                    while (!funcionarioEditado) {
                        System.out.println("Insira o ID do funcionário a ser alterado (ou digite 0 para cancelar): ");
                        int id = lerInt(scanner);
                        if (id == 0) {
                            System.out.println("Operação de edição cancelada.");
                            break;
                        }
                        if (FuncionariosUseCase.funcionarioExiste(id)) {
                            Funcionarios novoFuncionario = lerFuncionario(scanner);
                            System.out.println(FuncionariosUseCase.editarFuncionario(id, novoFuncionario));
                            funcionarioEditado = true;
                        } else {
                            System.out.println("Funcionário fornecido não existe. Tente novamente.");
                        }
                    }
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
    private static Funcionarios lerFuncionario(Scanner sc) {
        System.out.println("Insira o id do novo funcionário: ");
        int id = lerInt(sc);
        System.out.println("Insira o nome do novo funcionário: ");
        String nome = sc.nextLine();
        System.out.println("Insira o cargo do novo funcionário: ");
        String cargo = sc.nextLine();

        return new Funcionarios(id, nome, cargo);
    }

    protected static int lerInt(Scanner sc) {
        while (true) {
            try {
                int numero = sc.nextInt();
                sc.nextLine();
                return numero;
            } catch (Exception e) {
                System.out.println("Código inválido! Digite um número inteiro.");
                sc.nextLine();
            }
    
        }
    }
}