package Trabalho;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private static int proximoId = 1;
    private int id;
    private String nome;
    private String cargo;

    private static List<Funcionario> funcionariosCadastrados = new ArrayList<>();

    public Funcionario(String nome, String cargo) {
        this.id = proximoId++;
        this.nome = nome;
        this.cargo = cargo;
        funcionariosCadastrados.add(this);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public static List<Funcionario> getFuncionariosCadastrados() {
        return funcionariosCadastrados;
    }

    public static Funcionario cadastrarNovoFuncionario(String nome, String cargo) {
        Funcionario novoFuncionario = new Funcionario(nome, cargo);
        System.out.println("Novo funcionário cadastrado: " + novoFuncionario);
        return novoFuncionario;
    }

    public static void removerFuncionarioPorId(int id) {
        for (Funcionario funcionario : funcionariosCadastrados) {
            if (funcionario.getId() == id) {
                funcionariosCadastrados.remove(funcionario);
                System.out.println("Funcionário removido com sucesso. ID: " + id);
                return;
            }
        }
        System.out.println("Funcionário não encontrado. ID: " + id);
    }

    public static void atualizarEscalaTrabalho(int id, String novaEscala) {
        for (Funcionario funcionario : funcionariosCadastrados) {
            if (funcionario.getId() == id) {
                funcionario.setCargo(novaEscala);
                System.out.println("Escala de trabalho atualizada para o funcionário. ID: " + id);
                return;
            }
        }
        System.out.println("Funcionário não encontrado. ID: " + id);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
