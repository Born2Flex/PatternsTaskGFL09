package patterns.example.data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileDataStore implements DataStore {
    private final String filename;

    public FileDataStore(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(String statement) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            pw.println(statement);
        } catch (IOException e) {
            System.out.println("Exception occurred while saving statement in file");
            throw new RuntimeException(e);
        }
    }
}
