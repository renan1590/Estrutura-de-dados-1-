package Trabalho;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private static List<Pedido> pedidosRealizados = new ArrayList<>();
    private static List<Cliente> filaAlmoco = new ArrayList<>();
    private static List<Cliente> filaCaixa = new ArrayList<>();
    private static int pessoasNoRestaurante = 0;
    private static int pessoasAtendidas = 0;

    public Restaurante(){
    }

    public static void registrarNovoPedido(Cliente cliente, String descricao, Produto produto) {
        Pedido novoPedido = new Pedido(cliente, descricao);
        novoPedido.adicionarProduto(produto);
        pedidosRealizados.add(novoPedido);
        System.out.println("Novo pedido registrado: " + novoPedido);
        pessoasNoRestaurante++;
    }

    public static void prepararPedido(int idMesa) {
        for (Pedido pedido : pedidosRealizados) {
            if (pedido.getCliente().getId() == idMesa) {
                pedido.setPronto(true);
                System.out.println("Pedido preparado para a mesa " + idMesa);
            }
        }
    }

    public static void entregarPedido(int idMesa) {
        for (Pedido pedido : pedidosRealizados) {
            if (pedido.getCliente().getId() == idMesa && pedido.isPronto()) {
                System.out.println("Pedido entregue para a mesa " + idMesa + ": " + pedido.getDescricao());
                pessoasAtendidas++;
            }
        }
    }

    public static void fecharConta(int idMesa, double valorConta, double valorPago) {
        Pedido pedidoParaRemover = null;
        for (Pedido pedido : pedidosRealizados) {
            if (pedido.getCliente().getId() == idMesa) {
                pedidoParaRemover = pedido;
                break;
            }
        }
        if (pedidoParaRemover != null) {
            pedidosRealizados.remove(pedidoParaRemover);
            System.out.println("Conta fechada para a mesa " + idMesa);
            pessoasNoRestaurante--;
        } else {
            System.out.println("Nenhum pedido encontrado para a mesa " + idMesa);
        }
    }

    public static void consultarValorPedido(int idMesa) {
        double valorTotal = 0;
        for (Pedido pedido : pedidosRealizados) {
            if (pedido.getCliente().getId() == idMesa) {
                for (Produto produto : pedido.getProdutos()) {
                    valorTotal += produto.getValor();
                }
            }
        }
        DecimalFormat formato = new DecimalFormat("R$ #,##0.00");
        String valorFormatado = formato.format(valorTotal);

        System.out.println("Valor total do pedido: " + valorFormatado);
    }

    public static void adicionarFilaAlmoco(Cliente cliente) {
        filaAlmoco.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado à fila para almoçar.");
    }

    public static void adicionarFilaCaixa(Cliente cliente) {
        filaCaixa.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado à fila do caixa.");
    }

    public static void removerFilaAlmoco(Cliente cliente) {
        filaAlmoco.remove(cliente);
        System.out.println("Cliente " + cliente.getNome() + " removido da fila para almoçar.");
    }

    public static void removerFilaCaixa(Cliente cliente) {
        filaCaixa.remove(cliente);
        System.out.println("Cliente " + cliente.getNome() + " removido da fila do caixa.");
    }

    public static void adicionarPessoasNoRestaurante(int quantidade) {
        pessoasNoRestaurante += quantidade;
        System.out.println(quantidade + " pessoas entraram no restaurante.");
    }

    public static void removerPessoasNoRestaurante(int quantidade) {
        pessoasNoRestaurante -= quantidade;
        System.out.println(quantidade + " pessoas saíram do restaurante.");
    }

    public static void consultarEstatisticas() {
        System.out.println("Estatísticas do Restaurante:");
        System.out.println("Pessoas na fila para almoçar: " + filaAlmoco.size());
        System.out.println("Pessoas na fila do caixa: " + filaCaixa.size());
        System.out.println("Pessoas almoçando no restaurante: " + pessoasNoRestaurante);
        System.out.println("Pessoas atendidas no restaurante: " + pessoasAtendidas);
    }

    public static List<Pedido> getPedidosRealizados() {
        return pedidosRealizados;
    }
}
