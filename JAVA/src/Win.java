import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

/**
 * Klasa obsługuję zapis do pliku ranking.txt
 */
class FileOperations{

    /**
     *
     * @param name Zmienna zawierająca nazwę pliku txt.
     * @param number Zmienna zawierająca liczbę punktów zdobytą przez użytkownika.
     */
    public void save(String name, int number) throws IOException {
        FileWriter fstream = new FileWriter(name,true);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write(number + "\n");
        out.close();
    }
}

/**
 * Klasa Win zawiera metody obsługujące sytuację kiedy użytkownik wygra grę.
 */
public class Win extends JFrame implements MouseListener {

    /**
     * Funkcja obsługuję zapis do pliku oraz graficzne ukazanie ekranu końcowego gry.
     *
     * @param executionTime Czas uzyskany przez użytkownika.
     * @param frame Przekazywane okno aplikacji.
     * @param bombs_number Ilość bomb w grze użytkownika.
     */
    void scoreSaving(double executionTime,final JFrame frame, int bombs_number) throws IOException {
        frame.getContentPane().removeAll();
        //Zapis do pliku z wynikami
        executionTime = executionTime*bombs_number*100;

        executionTime = (int) executionTime;

        FileOperations operations = new FileOperations();
        operations.save("ranking.txt", (int) executionTime);

        JLabel label = new JLabel();
        label.setText(String.valueOf(executionTime));
        label.setBounds(840,400,500,500);
        label.setFont(new Font("Verdana", Font.PLAIN, 70));

        Icon mainMenu_icon = new ImageIcon("img/backtomainmenu_button.png");
        final JButton mainMenu_button = new JButton(mainMenu_icon);
        mainMenu_button.setOpaque(false);
        mainMenu_button.setContentAreaFilled(false);
        mainMenu_button.setBorderPainted(false);
        mainMenu_button.setFocusPainted(false);
        mainMenu_button.setBounds((1920/2)-250, 850, 520, 100);


        ImageIcon bcgimg = new ImageIcon("img/victory_background.png");
        final JLabel background = new JLabel("",bcgimg,JLabel.CENTER);
        background.setBounds(0,0,1920,1080);
        frame.add(label); frame.add(mainMenu_button); frame.add(background);
        frame.repaint();



        System.out.print("\n FUNKCJA \n");

        mainMenu_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainMenu_button.removeMouseListener(this);
                frame.getContentPane().removeAll();
                frame.repaint();
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
                mainMenu_button.setIcon(new ImageIcon("img/backtomainmenu_button_hover.png"));
                frame.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mainMenu_button.setIcon(new ImageIcon("img/backtomainmenu_button.png"));
                frame.repaint();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
