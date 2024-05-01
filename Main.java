package Trabalho;

public class Main {
    public static void main(String[] args) {
        // Cadastro de novos clientes
        Cliente cliente1 = cadastrarNovoCliente("Vitoria", "9999-1234");
        Cliente cliente2 = cadastrarNovoCliente("Renan", "9999-5678");
        Cliente cliente3 = cadastrarNovoCliente("Pedro", "9999-0000");
        System.out.println("-------------------------");
        // Cadastro de novas mesas
        Mesas mesa1 = cadastrarNovaMesa(4);
        Mesas mesa2 = cadastrarNovaMesa(6);
        Mesas mesa3 = cadastrarNovaMesa(2);
        System.out.println("-------------------------");
        // Cadastro de produtos
        Produto produto1 = new Produto(1, "Pizza de Marguerita", 60.00);
        Produto produto2 = new Produto(2, "Pizza de Bacon", 70.00);
        Produto produto3 = new Produto(2, "Pizza de Broculoes", 70.00);
        System.out.println("-------------------------");
        // Consulta de mesas disponíveis e ocupadas
        consultarMesasDisponiveis();
        consultarMesasOcupadas();
        System.out.println("-------------------------");
        // Adicionar pessoas no restaurante
        adicionarPessoasNoRestaurante(3);
        System.out.println("-------------------------");
        // Adicionar pessoas na fila para almoçar
        adicionarFilaAlmoco(cliente1);
        adicionarFilaAlmoco(cliente2);
        adicionarFilaAlmoco(cliente3);
        System.out.println("-------------------------");
        // Adicionar pessoas na fila do caixa
        adicionarFilaCaixa(cliente1);
        adicionarFilaCaixa(cliente2);
        System.out.println("-------------------------");
        // Atendimento de pedidos pelos garçons
        atenderPedido(cliente1, "Pedido mesa " + mesa1.getId(), produto1);
        atenderPedido(cliente2, "Pedido mesa " + mesa2.getId(), produto2);
        System.out.println("-------------------------");
        // Preparação de pedidos pelos cozinheiros
        prepararPedido(mesa1.getId());
        prepararPedido(mesa2.getId());
        System.out.println("-------------------------");
        // Entrega de pedidos aos clientes
        entregarPedido(mesa1.getId());
        entregarPedido(mesa2.getId());
        System.out.println("-------------------------");
        // Consulta de estatísticas
        consultarEstatisticas();
        System.out.println("-------------------------");
        // Fechamento de contas
        fecharConta(mesa1.getId(), 60.00, 100.00);
        fecharConta(mesa2.getId(), 70.00, 70.00); // Mesa sem pedido
        fecharConta(mesa3.getId(), 0.00, 0.00); // Mesa sem pedido
    }

    public static Cliente cadastrarNovoCliente(String nome, String telefone) {
        return Cliente.cadastrarNovoCliente(nome, telefone);
    }

    public static Mesas cadastrarNovaMesa(int capacidade) {
        return Mesas.cadastrarNovaMesa(capacidade);
    }

    public static void consultarMesasDisponiveis() {
        Mesas.consultarMesasDisponiveis();
    }

    public static void consultarMesasOcupadas() {
        Mesas.consultarMesasOcupadas();
    }

    public static void adicionarFilaAlmoco(Cliente cliente) {
        Restaurante.adicionarFilaAlmoco(cliente);
    }

    public static void adicionarFilaCaixa(Cliente cliente) {
        Restaurante.adicionarFilaCaixa(cliente);
    }

    public static void adicionarPessoasNoRestaurante(int quantidade) {
        Restaurante.adicionarPessoasNoRestaurante(quantidade);
    }

    public static void atenderPedido(Cliente cliente, String descricaoPedido, Produto produto) {
        Restaurante.registrarNovoPedido(cliente, descricaoPedido, produto);
    }

    public static void prepararPedido(int idMesa) {
        Restaurante.prepararPedido(idMesa);
    }

    public static void entregarPedido(int idMesa) {
        Restaurante.entregarPedido(idMesa);
    }

    public static void fecharConta(int idMesa, double valorConta, double valorPago) {
        Restaurante.fecharConta(idMesa, valorConta, valorPago);
    }

    public static void consultarEstatisticas() {
        Restaurante.consultarEstatisticas();
    }
}
