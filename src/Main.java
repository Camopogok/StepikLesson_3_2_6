import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JComponent implements ActionListener {
    int x = 0;
    int y = 0;
    int w = 90;
    int h = 90;
    int deltaX=1;
    int deltaY=1;
    static int winW = 510;
    static int winH = 430;
    Image dvd0 = new ImageIcon("src/dvd.png").getImage();
    Image dvd1 = new ImageIcon("src/dvd1.png").getImage();
    Image dvd2 = new ImageIcon("src/dvd2.png").getImage();
    Image dvd3 = new ImageIcon("src/dvd3.png").getImage();
    Image dvd = dvd0;
    Timer timer = new Timer(10, this);

    public Image randomDvd () {
        int a = (int) (Math.random() * 4);
        switch (a) {
            case 0:
                return dvd0;
            case 1:
                return dvd1;
            case 2:
                return dvd2;
            case 3:
                return dvd3;
        }
        return null;
    }
    public static void main(String[] args) {
        Main t = new Main();
        JFrame frame = new JFrame("Рикошет со сменой цвета");
        frame.setSize(winW, winH);
        frame.setLocation(434, 134);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(t);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(dvd, x,y, w,h,null);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (x + w +15 >= winW) {
            deltaX = -1;
            dvd = randomDvd();
        } if (x<=0) {
            deltaX = 1;
        dvd = randomDvd();
    }
        if (y + h + 15 >= winH) {
            deltaY = -1;
            dvd = randomDvd();
        }
        if (y<=-25) {
            deltaY = 1;
            dvd = randomDvd();
        }
        x+=deltaX;
        y+=deltaY;
        repaint();
    }
}