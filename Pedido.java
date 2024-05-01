package Trabalho;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int proximoId = 1;
    private int id;
    private Cliente cliente;
    private String descricao;
    private boolean pronto;
    private List<Produto> produtos;


    public Pedido(Cliente cliente, String descricao) {
        this.id = proximoId++;
        this.cliente = cliente;
        this.descricao = descricao;
        this.pronto = false;
        this.produtos = new ArrayList<>();
    }
    
    // Getters e setters
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isPronto() {
        return pronto;
    }

    public void setPronto(boolean pronto) {
        this.pronto = pronto;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(int idProduto) {
        for (Produto produto : produtos) {
            if (produto.getId() == idProduto) {
                produtos.remove(produto);
                return;
            }
        }
    }

    public List<Produto> getProdutos(){
        return produtos;
    }
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente.getNome() +
                ", descricao='" + descricao + '\'' +
                ", pronto=" + pronto +
                ", produtos=" + produtos +
                '}';
    }
}
