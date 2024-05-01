package Trabalho;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int proximoId = 1;
    private int id;
    private String nome;
    private String telefone;

    private static List<Cliente> clientesCadastrados = new ArrayList<>();

    public Cliente(String nome, String telefone) {
        this.id = proximoId++;
        this.nome = nome;
        this.telefone = telefone;
        clientesCadastrados.add(this);
    }

    public static Cliente cadastrarNovoCliente(String nome, String telefone) {
        return new Cliente(nome, telefone);
    }

    public static List<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }
    public static void atualizarCliente(int idCliente, String novoNome, String novoTelefone) {
        for (Cliente cliente : clientesCadastrados) {
            if (cliente.getId() == idCliente) {
                cliente.setNome(novoNome);
                cliente.setTelefone(novoTelefone);
                System.out.println("Informações do cliente atualizadas. ID: " + idCliente);
                return;
            }
        }
        System.out.println("Cliente não encontrado. ID: " + idCliente);
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
