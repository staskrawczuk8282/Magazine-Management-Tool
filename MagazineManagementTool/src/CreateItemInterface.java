
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;

public class CreateItemInterface extends JPanel {

   static Item holder;

    public CreateItemInterface(){

        setLayout(null);

        JTextField itemSize = new JTextField();
        JTextField itemName = new JTextField();
        JTextArea itemDesc = new JTextArea();

        JLabel title = new JLabel("Describe your item:");
        JLabel itemSizeLabel = new JLabel("Volume:");
        JLabel itemNameLabel = new JLabel("Name:");
        JLabel itemDescLabel = new JLabel("Description:");

        JButton createItem = new JButton("Create");
        JButton cancel = new JButton("Cancel");

        itemSizeLabel.setBounds(30,20,80,30);
        itemSize.setBounds(120,20,160,30);
        itemNameLabel.setBounds(30, 60, 80,30);
        itemName.setBounds(120,60,160,30);
        itemDescLabel.setBounds(30,100,80,30);
        itemDesc.setBounds(120,100,160,75);

        createItem.setBounds(100,180,90,30);
        cancel.setBounds(200,180,90,30);

        JOptionPane errWindow = new JOptionPane(null , JOptionPane.ERROR_MESSAGE);
        errWindow.setSize(500,200);
        JDialog dialog = errWindow.createDialog(null);
        dialog.setSize(500,200);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(false);


        createItem.addActionListener(
                (e)->{
                    String itmVol = itemSize.getText();
                    String itmName = itemName.getText();
                    String itmDescr = itemDesc.getText();
                    double volume = 0;

                    try{
                        volume=Double.parseDouble(itmVol);
                    } catch (java.lang.NumberFormatException ex) {
                        errWindow.setMessage("Wrong volume value");
                        dialog.setTitle("VOLUME ERROR");
                        dialog.setVisible(true);
                    }
                    if((volume==0)||(itmName.equals("")||(itmDescr.equals("")))){
                        errWindow.setMessage("Text spaces cannot be empty");
                        dialog.setTitle("TEXT ERROR");
                        dialog.setVisible(true);
                    }
                    else{
                    holder = new Item(volume,itmName,itmDescr);
                    itemSize.setText("");
                    itemName.setText("");
                    itemDesc.setText("");
                    LoginInterface.cl.show(LoginInterface.contentPanel,"chooseMags");
                    }


                }
        );

        cancel.addActionListener(
                (e)->{
                    LoginInterface.cl.show(LoginInterface.contentPanel, "menu");
                }
        );



        add(itemSizeLabel);
        add(itemSize);
        add(itemNameLabel);
        add(itemName);
        add(itemDescLabel);
        add(itemDesc);
        add(createItem);
        add(cancel);

        setSize(new Dimension(300,400));
        setVisible(true);


    }



}
