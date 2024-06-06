package gateway;

import java.util.Scanner;
import products.Maquiagem;
import usecase.MaquiagemUseCase;

public class MenuMaquiagem {

    public void executar_maquiagem() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    ***********************************
                    *                                 *
                    *        Menu de Maquiagem        *
                    *                                 *
                    ***********************************
                    
                    Selecione a opção desejada
                    
                    1 - Adicionar uma nova Maquiagem
                    2 - Pesquisar uma maquiagem
                    3 - Ver todas as maquiaagens em estoque
                    4 - Remover uma maquiagem do estoque
                    5 - Alterar os dados de uma maquiagem em estoque
                    6 - Sair
                    
                    ***********************************
                    
                    Digite aqui: """);
            int opcao_6;
            try {
                opcao_6 = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Opção inválida! Digite um número inteiro.");
                sc.nextLine();
                continue;
            }
            switch (opcao_6) {
                case 1:
                    Maquiagem maquiagem = lerMaquiagem(sc);
                    System.out.println(MaquiagemUseCase.adicionarMaquiagem(maquiagem));
                    break;
                case 2:
                    boolean maquiagemEncontrada = false;
                    while (!maquiagemEncontrada) {
                        System.out.println("Insira o código ou digite 0 para cancelar: ");
                        int codigo = lerInt(sc);
                        if (codigo == 0) {
                            System.out.println("Operação de buscar cancelada. ");
                            break;
                        }
                        if (MaquiagemUseCase.maquiagemExiste(codigo)) {
                            System.out.println(MaquiagemUseCase.mostrarMaquiagem(codigo));
                            maquiagemEncontrada = true;
                        } else {
                            System.out.println("Produto não existe. Tente novamente.");
                        }
                    }
                    break;

                case 3:
                    System.out.println(MaquiagemUseCase.mostrarMaquiagens());
                    break;

                case 4:
                    boolean maquiagemRemovida = false;
                    while (!maquiagemRemovida) {
                        System.out.println("Insira o código da Maquiagem ou digite 0 para canelar: ");
                        int codigo = lerInt(sc);
                        if(codigo == 0) {
                            System.out.println("Operação de remoção cancelada");
                            break;
                        }
                        if (MaquiagemUseCase.maquiagemExiste(codigo)) {
                            MaquiagemUseCase.removerMaquiagem(codigo);
                            System.out.println("Maquiagem removida com sucesso!");
                            maquiagemRemovida = true;
                        } else {
                            System.out.println("Maquiagem fornecida não existe. Tente novamente.");
                        }
                    }
                    break;

                case 5:
                    boolean maquiagemEditada = false;
                    while (!maquiagemEditada) {
                        System.out.println("Insira o código da Maquiagem a ser alterado (ou digite 0 para cancelar): ");
                        int codigo = lerInt(sc);
                        if (codigo == 0) {
                            System.out.println("Operação de edição canclada.");
                            break;
                        }
                        if (MaquiagemUseCase.maquiagemExiste(codigo)) {
                            Maquiagem novaMaquiagem = lerMaquiagem(sc);
                            System.out.println(MaquiagemUseCase.editarMaquiagem(codigo, novaMaquiagem));
                            maquiagemEditada = true;
                        } else {
                            System.out.println("Maquiagem fornecida não existe. Tente novamente.");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Menu Produtos");
                    return;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static Maquiagem lerMaquiagem(Scanner sc) {
        System.out.println("Digite o código da Maquiagem: ");
        int codigo = lerInt(sc);

        System.out.println("Digite o nome da Maquiagem: ");
        String nome = sc.nextLine();


        System.out.println("Digite a Marca: ");
        String marca = sc.nextLine();

        System.out.println("Digite a quantidade que deseja adicionar: ");
        int quantidade = lerInt(sc);

        System.out.println("Digite o peso da Maquiagem: ");
        double peso = lerDouble(sc);


        System.out.println("Digite o valor da Maquiagem: ");
        double valor = lerDouble(sc);

        System.out.println("Digite o tipo de Maquiagem: ");
        String tipo = sc.nextLine();

        return new Maquiagem(codigo, nome, marca, quantidade, peso, valor, tipo);
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

    private static double lerDouble(Scanner sc) {
        while (true) {
            try {
                double numero = sc.nextDouble();
                sc.nextLine();
                return numero;
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número decimal.");
                sc.nextLine();
            }
        }
    }
}