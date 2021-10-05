

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserLogin implements Serializable {
    static boolean didRegister = false;

    private  static Map<String,String> userPasswords =new HashMap<String,String>(){
        {
            put("superuser", "admin");
        }
    };


    public static boolean isPassCorrect (String username, String password){
        if(userPasswords.containsKey(username)){
            if(userPasswords.get(username).equals(password)){
                return true;
            }
        }
        return false;
    }

    public static void Register(String username, String password){
            userPasswords.put(username,password);
            didRegister = true;
    }

    public static boolean checkIfExists(String username){
        if(!userPasswords.containsKey(username))
            return true;
        return false;
    }

    public static void saveUsers() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.ser"));
        out.writeObject(userPasswords);
        out.close();
    }

    public static void loadUsers() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("users.ser"));
        userPasswords = (Map<String, String>) in.readObject();
        in.close();
    }


}
