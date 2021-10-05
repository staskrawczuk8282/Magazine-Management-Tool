import javax.swing.*;
import java.awt.*;

public class CustomTest extends JFrame {

    public CustomTest(){


      setLayout(null);
      ItemListInterface lol = new ItemListInterface();

      getContentPane().add(lol);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(new Dimension(300,200));
    setResizable(true);
    setVisible(true);
}}
