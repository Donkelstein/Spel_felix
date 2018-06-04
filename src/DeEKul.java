import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DeEKul extends Canvas {
    JFrame frame;
    //bredden på framen
    int width = 600;
    //höjden på framen
    int height = 600;
    int x = 150;
    int y = 922;
    //hur mycket liv som man börjar med
    double liv = 120;

    Font myFont = new Font("serif", Font.BOLD, 30);

    public DeEKul(){

        this.setBackground(Color.decode("#3db9c4"));
        this.frame = new JFrame("DeEKul");
        this.frame.setSize(new Dimension(width, height));
        this.frame.add(this);
        this.frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.addKeyListener(new KL());
    }

    @Override
    public void paint(Graphics g) {
        draw(g);
    }

        //ritar ut marken
    private void draw(Graphics g) {
        //mark
        g.setColor(Color.decode("#429927"));
        g.fillRect(0,952,1950,50);

        //sol
        g.setColor(Color.decode("#ffed27"));
        g.fillOval(1700,50,150,150);

        //tak
        g.setColor(Color.black);
        g.fillPolygon(new int[] {200, 250, 300},new int[] {852, 820, 852}, 3);

        //hus
        g.setColor(Color.decode("#e02121"));
        g.fillRect(200, 852, 100, 100);

        //dörr
        g.setColor(Color.decode("#55330e"));
        g.fillRect(225,912,15,40);

        //fönster
        g.setColor(Color.decode("#e6e6e6"));
        g.fillRect(260,890,20,20);

        //fönsterDel
        g.setColor(Color.black);
        g.fillRect(260,900,20,2);

        //fönsterDel2
        g.setColor(Color.black);
        g.fillRect(269,890,2,20);

        //handtag
        g.setColor(Color.decode("#606060"));
        g.fillRect(236,930,2,2);

        //träd
        g.setColor(Color.decode("#55330e"));
        g.fillRect(350, 752, 20, 200);

        //löv
        g.setColor(Color.decode("#3cb92c"));
        g.fillOval(338, 720, 50, 50);
        //skriver ut texten
        g.setColor(new Color (0x000));
        g.setFont(myFont);
        g.drawString("liv:" + liv, this.getWidth()/2 - (int)g.getFontMetrics().getStringBounds("liv:" + liv, g).getWidth()/2, 50);

        //vatten flaska
        g.setColor(Color.BLUE);
        g.fillRect(800, y+15, 5, 15);

        if (liv > 0) {
            //man
            g.setColor(Color.black);
            g.fillRect(x, y, 10, 30);

            //vänsterArm
            g.setColor(Color.black);
            g.fillRect(x - 5, y + 8, 5, 15);

            //högerArm
            g.setColor(Color.black);
            g.fillRect(x + 10, y + 8, 5, 15);

            //huvud
            g.setColor(Color.black);
            g.fillRect(x, y - 2, 10, 10);
        }
        else if (liv == 0) {
            //man död
            g.setColor(Color.black);
            g.fillRect(x, y+20, 30, 10);

            //huvud död
            g.setColor(Color.black);
            g.fillRect(x, y+18, 10, 10);
        }
    }


    public class KL implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            //gå vänster
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                if (liv > 0) {
                    x-=3;
                     liv = liv - 0.5;
                }
                repaint();
            }

            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                //gå höger

                if (liv > 0) {
                    liv = liv - 0.5;
                    x+=3;
                }
                repaint();
            }

            else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (x>790 && x<810) {
                    liv = 100;
                    repaint();
                }
            }

            else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                y-=25;
                repaint();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //hoppa
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                y = 922;
                repaint();
            }
        }
    }

    public static void main(String[] args) {
        DeEKul ex1 = new DeEKul();
    }
}
