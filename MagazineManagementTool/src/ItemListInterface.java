

import javax.swing.*;

public class ItemListInterface extends JPanel {

    public ItemListInterface(){

        setLayout(null);

        String [][] itemData = new String[MagazineDataBase.magazineList.get(LoginInterface.comboIndex).itemList.size()][4];
        String [] tableLabels = {"ID","NAME","DESCR.","VOLUME"};
        int iterator=0;


       for (Item x: MagazineDataBase.magazineList.get(LoginInterface.comboIndex).itemList) {

            itemData[iterator][0] = Integer.toString(x.ItemID);
            itemData[iterator][1] = x.name;
            itemData[iterator][2] = x.description;
            itemData[iterator][3] = Double.toString(x.volume);

            iterator++;
        }

        JTable itemTable = new JTable(itemData,tableLabels);
        itemTable.setBounds(0,0,300,300);
        JScrollPane scrollPane = new JScrollPane(itemTable);
        scrollPane.setBounds(0,0,300,150);
        JButton back = new JButton("Back");

        back.addActionListener(
                e -> {
                    LoginInterface.cl.show(LoginInterface.contentPanel,"listMenu");
                }
        );
        back.setBounds(110,175,60,30);

        add(scrollPane);
        add(back);


    }


}
