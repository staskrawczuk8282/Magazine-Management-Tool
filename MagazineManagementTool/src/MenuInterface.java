import javafx.geometry.HorizontalDirection;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MenuInterface extends JPanel {


    public MenuInterface(){

        setLayout(null);

        JButton creatMag = new JButton("Create Magazine");
        JButton createItem = new JButton("Add Item");
        JButton printChosen = new JButton("<html>Print Magazines Details<html/>");
        JButton exitButton = new JButton("Exit and Save");

        creatMag.setBounds(80,50,150,30);
        createItem.setBounds(80,85,150,30);
        printChosen.setBounds(80,125,150,40);
        exitButton.setBounds(90,200,120,30);


        exitButton.addActionListener(
                e -> {
                    try {
                        SaveCreator.Save(MagazineDataBase.magazineList);
                        UserLogin.saveUsers();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
                }
        );

        createItem.addActionListener(
                e -> {
                    LoginInterface.cl.show(LoginInterface.contentPanel, "createItem");
                }
        );

        creatMag.addActionListener(
                e -> {
                    LoginInterface.cl.show(LoginInterface.contentPanel,"addMag");
                }
        );

        printChosen.addActionListener(
                e -> {
                    LoginInterface.cl.show(LoginInterface.contentPanel,"listMag");
                }
        );


        add(creatMag);
        add(createItem);
        add(printChosen);
        add(exitButton);

        setVisible(true);

        revalidate();
        repaint();

    }


}
