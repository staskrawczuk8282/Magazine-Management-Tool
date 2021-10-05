import javax.swing.*;


public class ChoosMagazineInterface extends JPanel {

    static MagComboBox combobox = new MagComboBox();


    public ChoosMagazineInterface(){

        setLayout(null);

        JLabel textLabel = new JLabel("<html>Choose magazine<br/>to add your item:</html>");
        JButton cancel = new JButton("Cancel");
        JButton chooseBtn = new JButton("Select");

        JOptionPane errWindow = new JOptionPane(null , JOptionPane.ERROR_MESSAGE);
        errWindow.setSize(500,200);
        JDialog dialog = errWindow.createDialog(null);
        dialog.setSize(500,200);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(false);

        cancel.addActionListener(
                (e)->{
                    LoginInterface.cl.show(LoginInterface.contentPanel, "createItem");
                }
        );

        chooseBtn.addActionListener(
                (e)->{
                   int index = combobox.getSelectedIndex();
                   if(MagazineDataBase.magazineList.get(index).addItem(CreateItemInterface.holder)){

                   errWindow.setMessage("Sucessfully added item to the magazine");
                   dialog.setTitle("SUCCESS");
                   dialog.setVisible(true);
                   LoginInterface.cl.show(LoginInterface.contentPanel,"createItem");}
                   else{
                       errWindow.setMessage("Not enough space in the magazine");
                       dialog.setTitle("SPACE ERRROR");
                       dialog.setVisible(true);
                   }
                }
        );

        textLabel.setBounds(100,50,120,30);
        combobox.setBounds(60,90,180,30);
        chooseBtn.setBounds(60,130,80,30);
        cancel.setBounds(150,130,80,30);
        add(textLabel);
        add(combobox);
        add(cancel);
        add(chooseBtn);


    }

    public static void refreshComboBox(Magazine a){
        String newComp = "ul."+a.adress;
        combobox.addItem(newComp);
        MagazineListInterface.combobox1.addItem(newComp);
    }


}
