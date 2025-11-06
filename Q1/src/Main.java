import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        double precoBotijao = 103.00; // preço médio
        
        int opcao;
        
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Fazer pedido");
            System.out.println("2. Confirmar entrega");
            System.out.println("3. Ver pedidos confirmados");
            System.out.println("4. Ver pedidos entregues");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer
            
            switch (opcao) {
                case 1 -> {
                    // Fazer pedido
                    System.out.print("Digite o endereço de entrega: ");
                    String endereco = sc.nextLine();
                    System.out.print("Digite a quantidade de botijões: ");
                    int qtd = sc.nextInt();
                    sc.nextLine();
                    
                    Pedido novo = new Pedido(LocalDate.now(), LocalTime.now(), endereco, qtd, precoBotijao);
                    novo.exibirPedido();
                    
                    System.out.print("\nConfirma os dados? (S/N): ");
                    String resp = sc.nextLine().toUpperCase();
                    
                    if (resp.equals("N")) {
                        System.out.print("Digite o novo endereço: ");
                        String novoEnd = sc.nextLine();
                        novo.setEnderecoEntrega(novoEnd);
                        novo.exibirPedido();
                    }
                    
                    System.out.print("\nDeseja confirmar o pedido? (S/N): ");
                    String confirma = sc.nextLine().toUpperCase();
                    
                    if (confirma.equals("S")) {
                        System.out.print("Digite o número do cartão de crédito: ");
                        String cartao = sc.nextLine();
                        novo.confirmar(cartao);
                        pedidos.add(novo);
                        System.out.println("\nPedido confirmado com sucesso! Código: " + novo.getCodigo());
                    } else {
                        System.out.println("Pedido cancelado.");
                    }
                }
                
                case 2 -> {
                    // Confirmar entrega
                    System.out.print("Digite o código do pedido: ");
                    int cod = sc.nextInt();
                    sc.nextLine();
                    boolean encontrado = false;
                    
                    for (Pedido p : pedidos) {
                        if (p.getCodigo() == cod) {
                            encontrado = true;
                            if (p.getStatus().equals("confirmado")) {
                                p.entregar();
                                System.out.println("Pedido entregue com sucesso!");
                            } else {
                                System.out.println("Pedido não está confirmado ou já foi entregue.");
                            }
                        }
                    }
                    if (!encontrado)
                        System.out.println("Pedido não localizado.");
                }
                
                case 3 -> {
                    // Ver pedidos confirmados
                    System.out.println("\n=== PEDIDOS CONFIRMADOS ===");
                    for (Pedido p : pedidos) {
                        if (p.getStatus().equals("confirmado"))
                            p.exibirPedido();
                    }
                }
                
                case 4 -> {
                    // Ver pedidos entregues
                    System.out.println("\n=== PEDIDOS ENTREGUES ===");
                    for (Pedido p : pedidos) {
                        if (p.getStatus().equals("entregue"))
                            p.exibirPedido();
                    }
                }
                
                case 0 -> System.out.println("Encerrando o sistema...");
                
                default -> {
                    if (opcao < 0 || opcao > 4)
                        System.out.println("Opção inválida!");
                }
            }
            
        } while (opcao != 0);
        
        sc.close();
    }
}
