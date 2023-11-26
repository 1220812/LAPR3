package LAPR.US02_US03.UI.Console;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsumesUI implements Runnable {
    @Override
    public void run() {
        try {
            // Ler o arquivo de entrada
            Scanner sc = new Scanner(new File("output.txt"));

            // Criar um formato de data
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            // Obter a data atual
            Date currentDate = new Date();

            // Criar um arquivo de saída
            PrintWriter writer = new PrintWriter(new FileWriter("datas_passadas.txt"));

            // Pular a primeira linha (cabeçalho)
            sc.nextLine();

            // Iterar sobre as linhas do arquivo
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split("\\s+");

                // Verificar se a linha tem pelo menos cinco elementos
                if (parts.length >= 5) {
                    // Extrair informações da linha
                    String dateString = parts[0];
                    String parcela = parts[1];
                    int duracao = Integer.parseInt(parts[2]);
                    String inicio = parts[3];
                    String fim = parts[4];

                    // Converter a data para um objeto Date
                    Date date = dateFormat.parse(dateString);

                    // Verificar se a data é anterior à data atual
                    if (date.before(currentDate)) {
                        // Escrever informações adicionais no arquivo de saída
                        writer.println("Na data \"" + dateString + "\" na parcela \"" + parcela +
                                "\" e com uma duração de \"" + duracao + "\" minutos, a rega esteve ativa das \"" +
                                inicio + "\" às \"" + fim + "\"");
                    }
                } else {
                    System.err.println("A linha não contém informação suficiente: " + line);
                }
            }

            // Fechar os recursos
            sc.close();
            writer.close();

            System.out.println("Arquivo criado com sucesso.");

        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Erro de entrada/saída: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println("Erro ao fazer parse da data: " + e.getMessage());
        }
    }
}
