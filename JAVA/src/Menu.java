import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

/**
 * Klasa Menu zawiera metody obsługujące menu główne.
 */

public class Menu extends JFrame implements MouseListener {

    /**
     * Funkcja menu zawiera wszystkie potrzebne zmiennie do działania menu głównego gry(przyciski,grafiki itp.)
     *
     * @param frame Przekazywane okno aplikacji.
     * */
    void menu(final JFrame frame) {
        frame.getContentPane().removeAll();

        //Przyciski menu

        Icon play_icon = new ImageIcon("img/play_button.png");
        final JButton start_button = new JButton(play_icon);
        start_button.setOpaque(false);
        start_button.setContentAreaFilled(false);
        start_button.setBorderPainted(false);
        start_button.setFocusPainted(false);
        start_button.setBounds((1920/2)-290, 450, 585, 100);

        Icon ranking_icon = new ImageIcon("img/ranking_button.png");
        final JButton rank_button = new JButton(ranking_icon);
        rank_button.setOpaque(false);
        rank_button.setContentAreaFilled(false);
        rank_button.setBorderPainted(false);
        rank_button.setFocusPainted(false);
        rank_button.setBounds((1920/2)-290, 600, 585, 100);

        Icon credits_icon = new ImageIcon("img/credits_button.png");
        final JButton credits_button = new JButton(credits_icon);
        credits_button.setOpaque(false);
        credits_button.setContentAreaFilled(false);
        credits_button.setBorderPainted(false);
        credits_button.setFocusPainted(false);
        credits_button.setBounds((1920/2)-290, 750, 585, 100);


        Icon exit_icon = new ImageIcon("img/exit_button.png");
        final JButton exit_button = new JButton(exit_icon);
        exit_button.setOpaque(false);
        exit_button.setContentAreaFilled(false);
        exit_button.setBorderPainted(false);
        exit_button.setFocusPainted(false);
        exit_button.setBounds(1720, 870, 120, 120);
        frame.add(start_button); frame.add(rank_button); frame.add(credits_button); frame.add(exit_button);


        //Tło
        ImageIcon bcgimg = new ImageIcon("img/background.png");
        final JLabel background = new JLabel("",bcgimg,JLabel.CENTER);
        background.setBounds(0,0,1920,1080);

        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("img/logo.png"));
        logo.setBounds(139,100,1642,285);

        frame.add(logo);
        frame.add(background);
        frame.repaint();

        //Przyciski i ich działanie
        start_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                start_button.removeMouseListener(this);
                frame.getContentPane().removeAll();
                frame.repaint();
                Menu menu = new Menu();
                menu.menu2(frame);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                start_button.setIcon(new ImageIcon("img/play_button_hover.png"));
                frame.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                start_button.setIcon(new ImageIcon("img/play_button.png"));
                frame.repaint();
            }
        });
        rank_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                rank_button.removeMouseListener(this);
                frame.getContentPane().removeAll();
                frame.repaint();
                Ranking ranking = new Ranking();
                try {
                    ranking.show(frame);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                rank_button.setIcon(new ImageIcon("img/ranking_button_hover.png"));
                frame.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                rank_button.setIcon(new ImageIcon("img/ranking_button.png"));
                frame.repaint();
            }
        });
        credits_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                credits_button.removeMouseListener(this);
                frame.getContentPane().removeAll();
                frame.repaint();
                Credits credits = new Credits();
                credits.show(frame);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                credits_button.setIcon(new ImageIcon("img/credits_button_hover.png"));
                frame.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                credits_button.setIcon(new ImageIcon("img/credits_button.png"));
                frame.repaint();
            }
        });
        exit_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exit_button.setIcon(new ImageIcon("img/exit_button_hover.png"));
                frame.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit_button.setIcon(new ImageIcon("img/exit_button.png"));
                frame.repaint();
            }
        });

    }

    /**
     * Funkcja menu2 zawiera wszystkie potrzebne zmiennie do wyboru poziomu trudności gry(przyciski,grafiki itp.)
     *
     * @param frame Przekazywane okno aplikacji.
     * */
    void menu2(final JFrame frame) {

        frame.getContentPane().removeAll();

        //Przyciski menu2

        Icon easy_icon = new ImageIcon("img/easymode_button.png");
        final JButton easy_button = new JButton(easy_icon);
        easy_button.setOpaque(false);
        easy_button.setContentAreaFilled(false);
        easy_button.setBorderPainted(false);
        easy_button.setFocusPainted(false);
        easy_button.setBounds((1920/2)-290, 450, 585, 100);

        Icon hard_icon = new ImageIcon("img/hardmode_button.png");
        final JButton hard_button = new JButton(hard_icon);
        hard_button.setOpaque(false);
        hard_button.setContentAreaFilled(false);
        hard_button.setBorderPainted(false);
        hard_button.setFocusPainted(false);
        hard_button.setBounds((1920/2)-290, 600, 585, 100);

        Icon customize_icon = new ImageIcon("img/customize_button.png");
        final JButton customize_button = new JButton(customize_icon);
        customize_button.setOpaque(false);
        customize_button.setContentAreaFilled(false);
        customize_button.setBorderPainted(false);
        customize_button.setFocusPainted(false);
        customize_button.setBounds((1920/2)-290, 750, 585, 100);

        Icon back_icon = new ImageIcon("img/menu_back_button.png");
        final JButton back_button = new JButton(back_icon);
        back_button.setOpaque(false);
        back_button.setContentAreaFilled(false);
        back_button.setBorderPainted(false);
        back_button.setFocusPainted(false);
        back_button.setBounds((1920/2)-290, 900, 585, 100);
        frame.add(easy_button); frame.add(hard_button); frame.add(customize_button); frame.add(back_button);

        //Tło
        ImageIcon bcgimg = new ImageIcon("img/background.png");
        final JLabel background = new JLabel("",bcgimg,JLabel.CENTER);
        background.setBounds(0,0,1920,1080);

        JLabel logo = new JLabel();
        logo.setIcon(new ImageIcon("img/logo.png"));
        logo.setBounds(139,100,1642,285);

        frame.add(logo);
        frame.add(background);
        frame.repaint();

        easy_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                easy_button.removeMouseListener(this);
                int size_row = 23,size_col = 41, bombs_number = 1;
                int[][] board = new int[size_row][size_col];
                int[][] is_revealed = new int[size_row][size_col];
                boolean[][] if_flag = new boolean[size_row][size_col];
                System.out.print(" \n start_game \n");
                Game.play(board,size_row,size_col, bombs_number, is_revealed, if_flag,frame);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                easy_button.setIcon(new ImageIcon("img/easymode_button_hover.png"));
                frame.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                easy_button.setIcon(new ImageIcon("img/easymode_button.png"));
                frame.repaint();
            }
        });
        hard_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hard_button.removeMouseListener(this);
                int size_row = 23,size_col = 41, bombs_number = 150;
                int[][] board = new int[size_row][size_col];
                int[][] is_revealed = new int[size_row][size_col];
                boolean[][] if_flag = new boolean[size_row][size_col];
                System.out.print(" \n start_game \n");
                Game.play(board,size_row,size_col, bombs_number, is_revealed, if_flag,frame);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hard_button.setIcon(new ImageIcon("img/hardmode_button_hover.png"));
                frame.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hard_button.setIcon(new ImageIcon("img/hardmode_button.png"));
                frame.repaint();
            }
        });
        customize_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int bombs_number = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter the number of mines (1-2774)"));
                if(bombs_number<1 || bombs_number>2774) {
                    JOptionPane.showMessageDialog(frame, "Wrong number of mines.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    customize_button.removeMouseListener(this);
                    int size_row = 23,size_col = 41;
                    int[][] board = new int[size_row][size_col];
                    int[][] is_revealed = new int[size_row][size_col];
                    boolean[][] if_flag = new boolean[size_row][size_col];
                    System.out.print(" \n start_game \n");

                    Game.play(board,size_row,size_col, bombs_number, is_revealed, if_flag,frame);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                customize_button.setIcon(new ImageIcon("img/customize_button_hover.png"));
                frame.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                customize_button.setIcon(new ImageIcon("img/customize_button.png"));
                frame.repaint();
            }
        });
        back_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                back_button.removeMouseListener(this);
                menu(frame);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                back_button.setIcon(new ImageIcon("img/menu_back_button_hover.png"));
                frame.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back_button.setIcon(new ImageIcon("img/menu_back_button.png"));
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
