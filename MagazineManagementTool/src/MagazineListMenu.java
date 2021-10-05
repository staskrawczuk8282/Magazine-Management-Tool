import javax.swing.*;

public class MagazineListMenu extends JPanel {

   public MagazineListMenu(){
    JButton cancel = new JButton("Cancel");
    JButton overview = new JButton("Show Overview");
    JButton itemList = new JButton("Show Item List");
    JButton deleteItem = new JButton("Delete Items");

    cancel.addActionListener(
            e -> {
                LoginInterface.cl.show(LoginInterface.contentPanel,"menu");
            }
    );

    overview.addActionListener(
            e ->{
                LoginInterface.cl.show(LoginInterface.contentPanel,"overviewMag");

            }
    );

    itemList.addActionListener(
            e->{
                LoginInterface.cl.show(LoginInterface.contentPanel,"itemList");
            }
    );

    deleteItem.addActionListener(
            e -> {
                LoginInterface.cl.show(LoginInterface.contentPanel,"deleteItem");
            }
    );

    add(overview);
    add(deleteItem);
    add(itemList);
    add(cancel);

}}
