import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

public class ContaTerminal {
    static HashMap<String, String> bancoDeDados = new HashMap<String, String>();

    public static String keyAgencia() {
        Random rand = new Random();

        // Gera três números inteiros aleatórios entre 0 (inclusive) e 10 (exclusive)
        int num1 = rand.nextInt(10);
        int num2 = rand.nextInt(10);
        int num3 = rand.nextInt(10);

        // Gera um número inteiro aleatório entre 0 (inclusive) e 10 (exclusive)
        int num4 = rand.nextInt(10);

        // Formata os números como uma string
        String numeroFormatado = String.format("%d%d%d-%d", num1, num2, num3, num4);
        System.out.println("Seu numero de agencia é: " + numeroFormatado);
        return numeroFormatado;
    }

    public static void addUser(String nome, String agencia) {
        bancoDeDados.put(nome, agencia);
    }

    public static boolean login(String agencia) {
        if (bancoDeDados.containsValue(agencia)) {
            System.out.println("Login bem sucedido!");
            return true;
        } else {
            System.out.println("Agência incorreta. Retornando ao menu...");
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        boolean sair = true;
        Scanner sc = new Scanner(System.in);

        while (sair) {
            System.out.println("\nSeja bem vindo\n-----------\n1 - Criar Conta\n2 - Fazer Login\n3 - Sair");
            int input = sc.nextInt();
            sc.nextLine(); // Consumir o Enter pendente

            if (input == 3) {
                sair = false;
            }
            if (input == 1) {
                System.out.println("Nome: ");
                String nome = sc.nextLine();
                System.out.println("Certo, gerando seu código de agencia...");
                String agencia = keyAgencia();
                addUser(nome, agencia);
                System.out.println("Conta criada com sucesso... Retornado ao terminal");
            }
            if (input == 2) {
                System.out.println("Agência: ");
                String agencia = sc.nextLine();
                if (login(agencia)) {
                    while (sair) {
                        System.out.println("Seja bem vindo " + agencia + "\n1 - Saldo\n2 - Sair\n");
                        String user = sc.nextLine();
                        
                        if (user.equals("1")) {
                            double saldoCliente = 0.0F;
                            System.out.println("Seu saldo é: " + saldoCliente);
                        }
                        if (user.equals("2")) {
                            break;
                        }
                    }
                } else {
                    System.out.println("Usuario incorreto ou inexistente, tente novamente...");
                }
            }
        }
        sc.close();
    }
}
