import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o CEP para busca do endereço (somente números, sem caracteres especiais):");
        String cep = scanner.nextLine();
        scanner.close();

        Database_Connection obj = new Database_Connection();
        obj.search(cep);
    }
}
