package IOReadAndWriteFile;

import LoginManager.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class IOReadAndWriteFile {
    public static List<User> readDataFromFile(String path){
        List<User> list = new ArrayList<>();
        try{
            ObjectInputStream ois  = new ObjectInputStream(new FileInputStream(path));
            list = (ArrayList<User>) ois.readObject();
            ois.close();
        }catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static void Write(String path, List<User> list){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path, false));
            oos.writeObject(list);
            oos.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
