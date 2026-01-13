import br.com.alura.modulos.BuscarCEP;
import br.com.alura.modulos.CEP;
import br.com.alura.modulos.GeradorDeArquivo;

import java.io.IOException;

import java.util.Scanner;

public class Main {
    static void main() throws IOException, InterruptedException {
        Scanner busca = new Scanner(System.in);
        BuscarCEP buscarCEP = new BuscarCEP();

        System.out.print("Digite o cep que deseja buscar: ");
        String consulta = busca.nextLine();

        try {
            CEP consultarCEP = buscarCEP.ConsultarEndereco(consulta);
            System.out.println(consultarCEP);

            GeradorDeArquivo gerarArquivo = new GeradorDeArquivo();
            gerarArquivo.GerarArquivoJson(consultarCEP);
        } catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
        }
    }
}
