package Utils;

import FileReader.ReaderFiles;
import US01.NetworkBuilder;

import java.io.IOException;

public class InputDataFromFiles {
    public void run(){
        try {
            //ReaderFiles.importDistanceData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\ESINF\\src\\main\\resources\\distancias_big.csv");
            ReaderFiles.importDistanceData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\ESINF\\src\\main\\resources\\distancias_small.csv");
            //ReaderFiles.importLocalData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\ESINF\\src\\main\\resources\\locais_big.csv");
            ReaderFiles.importLocalData("C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\ESINF\\src\\main\\resources\\locais_small.csv");

            NetworkBuilder networkBuilder = NetworkBuilder.getInstance();

            System.out.println(networkBuilder.toString());

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}