import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Pedido {
    private static int contador = 1; // para gerar código automático
    
    private int codigo;
    private LocalDate dataCompra;
    private LocalTime horaCompra;
    private String enderecoEntrega;
    private int quantidade;
    private double precoUnitario;
    private double total;
    private LocalTime horaEntrega;
    private String numeroCartao;
    private String status; // "pendente", "confirmado", "entregue"
    
    public Pedido(LocalDate dataCompra, LocalTime horaCompra, String enderecoEntrega, int quantidade, double precoUnitario) {
        this.codigo = contador++;
        this.dataCompra = dataCompra;
        this.horaCompra = horaCompra;
        this.enderecoEntrega = enderecoEntrega;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.status = "pendente";
        calcularTotal();
        calcularHoraEntrega();
    }
    
    //total da compra
    public void calcularTotal() {
        this.total = quantidade * precoUnitario;
    }
    
    //calcula hora de entrega
    public void calcularHoraEntrega() {
        LocalTime novaHora = horaCompra.plusHours(2);
        this.horaEntrega = novaHora;
    }
    
    public void confirmar(String numeroCartao) {
        this.numeroCartao = numeroCartao;
        this.status = "confirmado";
    }
    
    public void entregar() {
        this.status = "entregue";
    }
    
    //getters e setters
    public int getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setEnderecoEntrega(String novoEndereco) {
        this.enderecoEntrega = novoEndereco;
    }

    //status
    public void exibirPedido() {
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("\n===== DADOS DO PEDIDO =====");
        System.out.println("Código: " + codigo);
        System.out.println("Data da compra: " + dataCompra);
        System.out.println("Hora da compra: " + horaCompra.format(formatoHora));
        System.out.println("Endereço: " + enderecoEntrega);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preço unitário: R$" + precoUnitario);
        System.out.println("Total: R$" + total);
        System.out.println("Hora prevista para entrega: " + horaEntrega.format(formatoHora));
        System.out.println("Status: " + status);
    }
}
