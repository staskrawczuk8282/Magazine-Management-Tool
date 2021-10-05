import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;

public class UsageDisplayer extends JComponent {


    double freePercentage;
    double usedPercentage;

    public UsageDisplayer(Magazine m){
        freePercentage =  (m.capAviable/m.capacity);
        usedPercentage = 1-freePercentage;
        freePercentage*=100;
        usedPercentage*=100;

        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setSize(100,100);
        Graphics2D g2d = (Graphics2D)g;
        DecimalFormat format = new DecimalFormat("#.#");
        String percentageStr = format.format(usedPercentage);
        percentageStr+="%";

        int usedHight = (int)usedPercentage;

        Rectangle2D freeRect = new Rectangle.Double(30,0,50,100-usedHight);
        Rectangle2D usedRect = new Rectangle.Double(30,0,50,100);

        Rectangle fRect = new Rectangle(50,100-usedHight);
        Rectangle uRect =new Rectangle(50,100);


        g2d.setColor(Color.RED);
        g2d.fill(uRect);
        g2d.setColor(Color.GREEN);
        g2d.fill(fRect);
        g2d.setColor(Color.BLACK);
        g2d.drawString(percentageStr,10,40);

    }


}
