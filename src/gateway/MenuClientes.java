package gateway;

import model.Clientes;
import usecase.ClientesUseCase;
import java.util.Scanner;

public class MenuClientes {
    public static void executar_cliente(Scanner scanner) {
        while (true) {
            System.out.print("""
                    **********************************
                    *                                *
                    *        Menu de Clientes        *
                    *                                *
                    **********************************
                    
                    Selecione uma opção:

                    1 - Adicionar um novo Cliente
                    2 - Remover um Cliente
                    3 - Achar um Cliente (número do pedido)
                    4 - Mostrar todos os Clientes
                    5 - Editar dados de um Cliente (número do pedido)
                    6 - Voltar ao menu principal
                    
                    **********************************
                    """);
            System.out.print("Digite aqui: ");
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
                    Clientes clientes = lerCliente(scanner);
                    System.out.println(ClientesUseCase.adicionarClientes(clientes));
                    break;

                case 2:
                    boolean clienteRemovido = false;
                    while (!clienteRemovido) {
                        System.out.println("Insira o número do pedido para remover cliente (ou digite 0 para cancelar):");
                        int numeroPedido = lerInt(scanner);
                        if (numeroPedido == 0) {
                            System.out.println("Operação de remoção cancelada.");
                            break;
                        }
                        if (ClientesUseCase.clienteExiste(numeroPedido)) {
                            ClientesUseCase.apagarCliente(numeroPedido);
                            System.out.println("Cliente removido com sucesso!");
                            clienteRemovido = true;
                        } else {
                            System.out.println("Cliente com o número de pedido fornecido não existe. Tente novamente.");
                        }
                    }
                    break;

                case 3:
                    boolean clienteEncontrado = false;
                    while (!clienteEncontrado) {
                        System.out.println("Insira o número do pedido que deseja procurar (ou digite 0 para cancelar): ");
                        int numeroPedido = lerInt(scanner);
                        if (numeroPedido == 0) {
                            System.out.println("Operação de busca cancelada.");
                            break;
                        }
                        if (ClientesUseCase.clienteExiste(numeroPedido)) {
                            System.out.println(ClientesUseCase.pesquisarClientes(numeroPedido));
                            clienteEncontrado = true;
                        } else {
                            System.out.println("Cliente com o número de pedido fornecido não existe. Tente novamente.");
                        }
                    }
                    break;

                case 4:
                    System.out.println(ClientesUseCase.mostrarClientes());
                    break;

                case 5:
                    boolean clienteEditado = false;
                    while (!clienteEditado) {
                        System.out.println("Insira o número do pedido do cliente que deseja alterar (ou digite 0 para cancelar): ");
                        int numeroPedido = lerInt(scanner);
                        if (numeroPedido == 0) {
                            System.out.println("Operação de edição cancelada.");
                            break;
                        }
                        if (ClientesUseCase.clienteExiste(numeroPedido)) {
                            Clientes novoCliente = lerCliente(scanner);
                            System.out.println(ClientesUseCase.editarCliente(numeroPedido, novoCliente));
                            clienteEditado = true;
                        } else {
                            System.out.println("Cliente com o número de pedido fornecido não existe. Tente novamente.");
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
    private static Clientes lerCliente(Scanner sc) {
        System.out.println("Insira o número do pedido do cliente: ");
        int numeroPedido = lerInt(sc);
        System.out.println("Insira o nome do cliente: ");
        String nome = sc.nextLine();
        System.out.println("Insira o endereço do cliente: ");
        String endereco = sc.nextLine();

        return new Clientes(numeroPedido, nome, endereco);
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
