

import javax.swing.*;
import java.io.*;


public class test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        UserLogin.loadUsers();
        SaveCreator.Load();



   SwingUtilities.invokeLater(
          ()-> new LoginInterface()
        );



    }
}
