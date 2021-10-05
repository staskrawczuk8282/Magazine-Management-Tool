import javax.swing.*;

public class MagazineListInterface extends JPanel {

    static Magazine chosenMag;
    static MagComboBox combobox1 = new MagComboBox();

    public MagazineListInterface(){

    setLayout(null);




    JLabel textLabel = new JLabel("<html>Choose magazine<br/>to display:</html>");
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
        LoginInterface.cl.show(LoginInterface.contentPanel, "menu");
    }
        );

        chooseBtn.addActionListener(
                (e)->{

        LoginInterface.comboIndex = combobox1.getSelectedIndex();
        MagazineOverviewInterface newOverview = new MagazineOverviewInterface();
        ItemListInterface newItemList = new ItemListInterface();
        DeleteItemInterface newDelteItem = new DeleteItemInterface();
                    LoginInterface.contentPanel.remove(LoginInterface.overviewMag);
                    LoginInterface.contentPanel.remove(LoginInterface.itemList);
                    LoginInterface.contentPanel.remove(LoginInterface.deleteItem);


        LoginInterface.contentPanel.add("overviewMag",newOverview);

        LoginInterface.contentPanel.add("itemList",newItemList);

        LoginInterface.contentPanel.add("deleteItem",newDelteItem);



        LoginInterface.cl.show(LoginInterface.contentPanel,"listMenu");
        }
        );

        textLabel.setBounds(100,50,120,30);
        combobox1.setBounds(60,90,180,30);
        chooseBtn.setBounds(60,130,80,30);
        cancel.setBounds(150,130,80,30);
    add(textLabel);
    add(combobox1);
    add(cancel);
    add(chooseBtn);


}

}
