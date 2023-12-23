package LAPR.Interface.Readers;

import LAPR.Interface.Domain.ResultEntry;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * JUnit test class for the ReadInstructionsFromFile class.
 */
class ReadInstructionsFromFileTest {
    /**
     * Tests the readInformation method with a valid file.
     */
    @Test
    public void testReadInformation() {
        ReadInstructionsFromFile reader = new ReadInstructionsFromFile();
        String fileName = "C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\source\\main\\resources\\LAPR\\instructions.txt"; // Replace with the actual file path

        try {
            List<ResultEntry> resultEntries = reader.readInformation(fileName);

            assertNotNull(resultEntries);
            assertFalse(resultEntries.isEmpty());

        } catch (IOException e) {
            fail("IOException occurred during the test: " + e.getMessage());
        }
    }
    /**
     * Tests the readInformation method with an empty file.
     */
    @Test
    public void testReadInformationWithEmptyFile() {
        ReadInstructionsFromFile reader = new ReadInstructionsFromFile();
        String fileName = "C:\\Users\\Utilizador\\OneDrive\\Ambiente de Trabalho\\Faculdade\\2º Ano\\1º Semestre\\LAPR3\\Project\\SRC\\source\\main\\resources\\LAPR\\empty.txt";

        assertThrows(IOException.class, () -> {
            List<ResultEntry> resultEntries = reader.readInformation(fileName);
        });
    }
}