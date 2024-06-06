package gateway;
import java.util.Scanner;

public class ExecutarProdutos {
    public static void executar_menuprodutos(Scanner scanner) {
        Scanner sc = new Scanner(System.in);
        MenuPerfumes menuPerfumes = new MenuPerfumes();
        MenuProdutos menuProdutos = new MenuProdutos();
        MenuMaquiagem menuMaquiagem = new MenuMaquiagem();

        while (true) {
            System.out.print("""
                    ******************************
                    *                            *
                    *      Menu de Produtos      *
                    *                            *
                    ******************************
                    
                    Digite a opção desejeta:
                    
                    1 - Menu de Perfumes
                    2 - Menu de Maquiagem
                    3 - Menu de Outros Produtos
                    
                    0 - Voltar ao Menu Principal
                    
                    ******************************
                    """);
            System.out.print("Digite aqui: ");
            int opcao;
            try {
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Opção inválida! Digite um número inteiro.");
                sc.nextLine();
                continue;
            }
            switch (opcao) {
                case 1:
                    menuPerfumes.executar_perfumes();
                    break;

                case 2:
                    menuMaquiagem.executar_maquiagem();
                    break;

                case 3:
                    menuProdutos.executar();
                    break;

                case 0:
                    return;
            }
        }
    }
}