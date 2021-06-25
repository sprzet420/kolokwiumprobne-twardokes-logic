import java.io.IOException;
import java.util.ArrayList;

public interface FileWriterInterface {
    public <T> void exportData(ArrayList<T> examplelist, String filename)throws IOException;

}
