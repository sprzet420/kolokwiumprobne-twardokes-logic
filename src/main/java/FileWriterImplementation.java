import java.io.*;
import java.util.ArrayList;

public class FileWriterImplementation implements FileWriterInterface {

    @Override
    public <T> void exportData(ArrayList<T> examplelist, String filename) throws IOException {
        File file = new File(filename);

        if(file.createNewFile()){
            System.out.println("Plik został utworzony");
        }else{
            System.out.println("Plik o takiej nazwie już istnieje");
        }
        /*
        FileWriter outputStream = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStream);

        for(T obj : examplelist){
            bufferedWriter.write(obj.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        outputStream.close();
        */
        OutputStream stream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);

        objectOutputStream.writeObject(examplelist);

        objectOutputStream.close();
        stream.close();

    } ;

}
