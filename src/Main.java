import gateway.ExecutarProdutos;
import gateway.MenuClientes;
import gateway.MenuFuncionarios;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                **********************************
                *                                *
                *      Bem-vindo ao DataStock!   *
                *                                *
                **********************************
                
                O que você deseja acessar?
                
                1 - Menu de Produtos
                2 - Menu de Funcionários
                3 - Menu de Clientes
                
                0 - Encerrar o programa
                
                **********************************
                """);
            System.out.print("Digite aqui: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Opção inválida! Digite um número.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    ExecutarProdutos.executar_menuprodutos(scanner);
                    break;
                case 2:
                    MenuFuncionarios.executar_func(scanner);
                    break;
                case 3:
                    MenuClientes.executar_cliente(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}