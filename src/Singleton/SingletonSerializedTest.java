package Singleton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
public class SingletonSerializedTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializedSingleton instanceOne = SerializedSingleton.getInstance();

        // Serialize object
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
        out.writeObject(instanceOne);
        out.close();

        // Deserialize object
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("instanceOne hashCode = " + instanceOne.hashCode());
        System.out.println("instanceTwo hashCode = " + instanceTwo.hashCode());
    }
}
