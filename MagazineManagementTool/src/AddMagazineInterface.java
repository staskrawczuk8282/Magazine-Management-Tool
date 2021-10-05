

import javax.swing.*;

public class AddMagazineInterface extends JPanel {

    public AddMagazineInterface(){

    setLayout(null);
    JLabel magCapacityLabel = new JLabel("Capacity:");
    JTextArea magCapacity = new JTextArea();
    JLabel adressLabel = new JLabel("Adress:");
    JTextArea adressGiven = new JTextArea();
    JButton createButton = new JButton("Create");
    JButton cancel = new JButton("Cancel");

        JOptionPane errWindow = new JOptionPane(null , JOptionPane.ERROR_MESSAGE);
        errWindow.setSize(500,200);
        JDialog dialog = errWindow.createDialog(null);
        dialog.setSize(500,200);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(false);


    cancel.addActionListener(
            e -> {
                LoginInterface.cl.show(LoginInterface.contentPanel,"menu");
            }
    );

    createButton.addActionListener(
            e -> {
                String cap = magCapacity.getText();
                String adress = adressGiven.getText();
                double capInt=0;
                try{
                    if(!adress.equals("")){
                        capInt = Double.parseDouble(cap);
                        Magazine mag = new Magazine(capInt,adress);
                        MagazineDataBase.addMag(mag);
                        ChoosMagazineInterface.combobox.Refresh();
                        MagazineListInterface.combobox1.Refresh();
                        errWindow.setMessage("Successfully added magazine");
                        dialog.setTitle("SUCCESS");
                        dialog.setVisible(true);
                        LoginInterface.cl.show(LoginInterface.contentPanel,"menu");
                    }
                    else{
                        errWindow.setMessage("Adress must be given");
                        dialog.setTitle("EMPTY ADRESS");
                        dialog.setVisible(true);
                    }
                }catch(java.lang.NumberFormatException e1){
                    errWindow.setMessage("Capacity must be a number");
                    dialog.setTitle("CAPACITY ERROR");
                    dialog.setVisible(true);
                }

            }
    );
        magCapacityLabel.setBounds(30,20,90,30);
        magCapacity.setBounds(130,20,160,20);
        adressLabel.setBounds(30, 60, 80,30);
        adressGiven.setBounds(130,60,160,20);
        createButton.setBounds(80,100,80,30);
        cancel.setBounds(150,100,80,30);


        add(magCapacityLabel);
        add(magCapacity);
        add(adressLabel);
        add(adressGiven);
        add(cancel);
        add(createButton);


        setVisible(true);


}}
