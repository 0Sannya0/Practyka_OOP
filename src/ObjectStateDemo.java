import java.io.*;

public class ObjectStateDemo {
    public static void main(String[] args) {
        ParametersResult obj = new ParametersResult();
        obj.setAlpha(0.5);
        obj.setMaxSequenceLength(10);
        // Серіалізація об'єкта
        try {
            FileOutputStream fileOut = new FileOutputStream("object.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.println("Serialized object is saved in object.ser");
        } catch (IOException i) {
            i.printStackTrace();}
        // Десеріалізація об'єкта
        try {FileInputStream fileIn = new FileInputStream("object.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ParametersResult newObj = (ParametersResult) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Deserialized object: " + newObj);
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }
}

