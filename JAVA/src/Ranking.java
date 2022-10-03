import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

/**
 * Klasa Ranking zawiera wszystkie metody obsługujące działanie rankingu wyników użytkowników.
 */
public class Ranking {

    /**
     * Funkcja obsługuję odczytywanie wszystkich wyników oraz wsadzanie ich do listy scoreList.
     *
     * @param name Nazwa pliku z którego odczytywany jest wynik.
     * @param scoreList Lista, do której wsadzane są wyniki.
     */
    public void read(String name, List<Integer> scoreList) throws FileNotFoundException {
        System.out.println("Odczytuje z pliku");

        File myObj = new File(name);

        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            scoreList.add(Integer.valueOf(data));
        }
        myReader.close();
    }

    /**
     * Funkcja służąca do graficznego odwzorowania wyników.
     * Tworzy listę, wywołuje metodę read oraz sortuje w niej wyniki.
     * Najlepsze 8 wyników wyświetlane są na ekranie.
     *
     * @param frame Przekazywane okno aplikacji.
     */
    static void show(final JFrame frame) throws FileNotFoundException {
        ImageIcon bcgimg = new ImageIcon("img/ranking_background.png");
        final JLabel background = new JLabel("",bcgimg,JLabel.CENTER);
        background.setBounds(0,0,1920,1080);

        Icon back_icon = new ImageIcon("img/ingame_back_button.png");
        final JButton back_button = new JButton(back_icon);
        back_button.setOpaque(false);
        back_button.setContentAreaFilled(false);
        back_button.setBorderPainted(false);
        back_button.setFocusPainted(false);
        back_button.setBounds(830, 970, 280, 90);



        List<Integer> scoreList = new ArrayList<Integer>();
        Ranking ranking2 = new Ranking();
        ranking2.read("ranking.txt",scoreList);
        Collections.sort(scoreList);

        //Wyniki
        JLabel rank1 = new JLabel();
        rank1.setText("1.  " + scoreList.get(scoreList.size() - 1));
        rank1.setBounds(550,300,500,500);
        rank1.setFont(new Font("Verdana", Font.PLAIN, 60));

        JLabel rank2 = new JLabel();
        rank2.setText("2.  " + scoreList.get(scoreList.size() - 2));
        rank2.setBounds(550,400,500,500);
        rank2.setFont(new Font("Verdana", Font.PLAIN, 60));

        JLabel rank3 = new JLabel();
        rank3.setText("3.  " + scoreList.get(scoreList.size() - 3));
        rank3.setBounds(550,500,500,500);
        rank3.setFont(new Font("Verdana", Font.PLAIN, 60));

        JLabel rank4 = new JLabel();
        rank4.setText("4.  " + scoreList.get(scoreList.size() - 4));
        rank4.setBounds(550,600,500,500);
        rank4.setFont(new Font("Verdana", Font.PLAIN, 60));

        JLabel rank5 = new JLabel();
        rank5.setText("5.  " + scoreList.get(scoreList.size() - 5));
        rank5.setBounds(1000,300,500,500);
        rank5.setFont(new Font("Verdana", Font.PLAIN, 60));

        JLabel rank6 = new JLabel();
        rank6.setText("6.  " + scoreList.get(scoreList.size() - 6));
        rank6.setBounds(1000,400,500,500);
        rank6.setFont(new Font("Verdana", Font.PLAIN, 60));

        JLabel rank7 = new JLabel();
        rank7.setText("7.  " + scoreList.get(scoreList.size() - 7));
        rank7.setBounds(1000,500,500,500);
        rank7.setFont(new Font("Verdana", Font.PLAIN, 60));

        JLabel rank8 = new JLabel();
        rank8.setText("8.  " + scoreList.get(scoreList.size() - 8));
        rank8.setBounds(1000,600,500,500);
        rank8.setFont(new Font("Verdana", Font.PLAIN, 60));
        //
        frame.add(rank1);frame.add(rank2);frame.add(rank3);frame.add(rank4);
        frame.add(rank5);frame.add(rank6);frame.add(rank7);frame.add(rank8);
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
                frame.repaint();
            }
        });
    }
}
