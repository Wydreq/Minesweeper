import javax.swing.*;
import java.awt.*;


/**
 * Klasa główna programu.
 **/
public class Main  {
    /**
     * Zawiera wywołanie funkcji Menu.
     *
     * @param args Argumenty
     */
    public static void main(String[] args) {
        //Okno
        final JFrame frame = new JFrame("MINESWEEPER");
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        frame.setSize(1920, 1080);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(width == 1920 && height == 1080) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
        }

        frame.setVisible(true);
        Menu menu = new Menu();
        menu.menu(frame);

    }

}
