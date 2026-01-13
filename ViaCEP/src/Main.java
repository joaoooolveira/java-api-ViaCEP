import java.io.IOException;

import java.util.Scanner;

public class Main {
    static void main() throws IOException, InterruptedException {
        Scanner busca = new Scanner(System.in);
        System.out.print("Digite o cep que deseja buscar: ");
        String consulta = busca.nextLine();

        BuscarCEP buscarCEP = new BuscarCEP(consulta);
        System.out.println(buscarCEP.ConsultarEndereco(consulta));

    }
}
