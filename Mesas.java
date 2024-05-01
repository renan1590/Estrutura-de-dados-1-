package Trabalho;

import java.util.ArrayList;
import java.util.List;

public class Mesas {
    private static int proximoId = 1;
    private int id;
    private int capacidade;
    private Cliente cliente;

    private static List<Mesas> mesasDisponiveis = new ArrayList<>();
    private static List<Mesas> mesasOcupadas = new ArrayList<>();

    public Mesas(int capacidade) {
        this.id = proximoId++;
        this.capacidade = capacidade;
        mesasDisponiveis.add(this);
    }

    public static Mesas cadastrarNovaMesa(int capacidade) {
        return new Mesas(capacidade);
    }

    public static void encaminharClienteParaMesa(Cliente cliente, Mesas mesa) {
        if (mesasDisponiveis.contains(mesa)) {
            mesa.setCliente(cliente);
            mesasDisponiveis.remove(mesa);
            mesasOcupadas.add(mesa);
            System.out.println("Cliente " + cliente.getNome() + " alocado na mesa " + mesa.getId());
        } else {
            System.out.println("Mesa " + mesa.getId() + " já está ocupada.");
        }
    }

    public static void liberarMesa(int idMesa) {
        for (Mesas mesa : mesasOcupadas) {
            if (mesa.getId() == idMesa) {
                mesasDisponiveis.add(mesa);
                mesasOcupadas.remove(mesa);
                mesa.setCliente(null);
                System.out.println("Mesa " + idMesa + " liberada.");
                return;
            }
        }
        System.out.println("Mesa " + idMesa + " não encontrada ou não ocupada.");
    }

    public static void consultarMesasDisponiveis() {
        System.out.println("\nMesas disponíveis:");
        if (mesasDisponiveis.size() > 0) {
            for (Mesas mesa : mesasDisponiveis) {
                System.out.println("Mesa " + mesa.getId() + " - Capacidade: " + mesa.getCapacidade());
            }
        } else {
            System.out.println("Nenhuma mesa disponível!");
        }
    }

    public static void consultarMesasOcupadas() {
        System.out.println("\nMesas ocupadas:");
        for (Mesas mesa : mesasOcupadas) {
            System.out.println("Mesa " + mesa.getId() + " - Cliente: " + mesa.getCliente().getNome());
        }
    }

    public static List<Mesas> getMesasOcupadas() {
        return mesasOcupadas;
    }

    public static int getTotalMesas() {
        return mesasDisponiveis.size() + mesasOcupadas.size();
    }

    public static Cliente obterClienteDaMesa(int idMesa) {
        for (Mesas mesa : mesasOcupadas) {
            if (mesa.getId() == idMesa) {
                return mesa.getCliente();
            }
        }
        return null;
    }

    // Métodos para preparação e entrega de pedidos não foram implementados

    // Getters e setters
    public int getId() {
        return id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
