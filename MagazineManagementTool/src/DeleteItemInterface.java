

import javax.swing.*;

public class DeleteItemInterface extends JPanel {

    public DeleteItemInterface(){

        setLayout(null);
        JLabel chooseLabel = new JLabel("<html>Choose Item to delete <html/>");
        JButton delete = new JButton("Delete");
        JButton cancel = new JButton("Cancel");
        JComboBox<String> itemCombobox = new JComboBox<>();

        JOptionPane errWindow = new JOptionPane(null , JOptionPane.ERROR_MESSAGE);
        errWindow.setSize(500,200);
        JDialog dialog = errWindow.createDialog(null);
        dialog.setSize(500,200);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(false);

        for(Item x: MagazineDataBase.magazineList.get(LoginInterface.comboIndex).itemList){
            itemCombobox.addItem(x.name);
        }

        cancel.addActionListener(
                e -> {
                    LoginInterface.cl.show(LoginInterface.contentPanel,"listMag");
                }
        );
        delete.addActionListener(
                e -> {

                    MagazineDataBase.magazineList.get(LoginInterface.comboIndex).removeItem(MagazineDataBase.magazineList.get(LoginInterface.comboIndex).itemList.get(itemCombobox.getSelectedIndex()));
                    errWindow.setMessage("Successfully deleted item");
                    dialog.setTitle("SUCCESS");
                    dialog.setVisible(true);
                    LoginInterface.cl.show(LoginInterface.contentPanel,"listMag");

                }
        );


        chooseLabel.setBounds(100,50,120,30);
        itemCombobox.setBounds(60,90,180,30);
        delete.setBounds(60,130,80,30);
        cancel.setBounds(150,130,80,30);

        add(chooseLabel);
        add(itemCombobox);
        add(delete);
        add(cancel);

    }

}
