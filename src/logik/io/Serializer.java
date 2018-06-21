package logik.io;

import logik.Bestellung;

import java.io.*;

public class Serializer {
    private ObjectOutputStream os;
    private ObjectInputStream is;

    public Serializer(String datei) throws IOException{
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(datei));
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(datei));
    }

    public void serializeBestellung(Bestellung bestellung) throws IOException {
        os.writeObject(bestellung);
    }

    public void closeOutput() throws IOException{
        os.close();
    }

    public Bestellung deserializeBestellung() throws IOException, ClassNotFoundException{
        return (Bestellung)is.readObject();
    }

    public void closeInput() throws IOException{
        is.close();
    }
}
