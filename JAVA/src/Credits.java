import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Klasa Credits zawiera metody obsługujące wyświetlenie creditsów.
 */
public class Credits {

    /**
     * Funkcja show zawiera wyświetlenie tła z creditsami oraz działanie przycisku do cofnięcia do menu głównego.
     *
     * @param frame Przekazywane okno aplikacji.
     */
    static void show(final JFrame frame) {
        ImageIcon bcgimg = new ImageIcon("img/credits_page.png");
        final JLabel background = new JLabel("",bcgimg,JLabel.CENTER);
        background.setBounds(0,0,1920,1080);

        Icon back_icon = new ImageIcon("img/ingame_back_button.png");
        final JButton back_button = new JButton(back_icon);
        back_button.setOpaque(false);
        back_button.setContentAreaFilled(false);
        back_button.setBorderPainted(false);
        back_button.setFocusPainted(false);
        back_button.setBounds(830, 850, 280, 90);

        frame.add(back_button); frame.add(background); frame.repaint();

        back_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                back_button.removeMouseListener(this);
                frame.getContentPane().removeAll();
                frame.removeMouseListener(this);
                Menu menu = new Menu();
                menu.menu(frame);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                back_button.setIcon(new ImageIcon("img/ingame_back_button_hover.png"));
                frame.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back_button.setIcon(new ImageIcon("img/ingame_back_button.png"));
//                frame.repaint();
            }
        });
    }
}
