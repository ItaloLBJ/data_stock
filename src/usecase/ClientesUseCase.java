package usecase;

import model.Clientes;
import java.util.ArrayList;

public class ClientesUseCase {

    private static ArrayList<Clientes> listaClientes = new ArrayList<>();

    static {
        listaClientes.add(new Clientes(1, "Dona Zefinha", "Imbiribeira"));
        listaClientes.add(new Clientes(2, "Thamires", "Candeias"));
        listaClientes.add(new Clientes(3, "Joelma", "Caxangá"));
    }

    public static String adicionarClientes(Clientes clientes) {
        if (clienteExiste(clientes.getNumeroPedido())) {
            return "Cliente com este número de pedido já existe!";
        }
        listaClientes.add(clientes);
        return "Cliente adicionado com sucesso!";
    }

    public static String mostrarClientes() {
        StringBuilder sb = new StringBuilder();
        for (Clientes clientes : listaClientes){
            sb.append(clientes.toString()).append("\n");
        }
        return sb.toString();
    }

    public static Clientes pesquisarClientes(int numeroPedido) {
        for (Clientes clientes : listaClientes) {
            if (clientes.getNumeroPedido() == numeroPedido) return clientes;
        }
        return null;
    }

    public static boolean apagarCliente(int numeroPedido) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getNumeroPedido() == numeroPedido) {
                listaClientes.remove(i);
                return true;
            }

        }
        return false;
    }

    public static Clientes editarCliente(int numeroPedido, Clientes novoCliente) {
        apagarCliente(numeroPedido);
        adicionarClientes(novoCliente);
        return novoCliente;
    }

    public static boolean clienteExiste(int numeroPedido) {
        return listaClientes.stream().anyMatch(cliente -> cliente.getNumeroPedido() == numeroPedido);
    }
}
