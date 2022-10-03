import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

/**
 * Klasa obsługująca działanie całej gry.
 * Scala wszystkie potrzebne obiekty oraz metody.
 */

public class Game  {

    //Działanie gry
    /**
     * Funkcja play scala wszystkie potrzebne metody do rozpoczęcia gry(generowanie planszy itp.).
     *
     * @param board Tablica zawierająca planszę.
     * @param size_col Liczba całkowita zawierająca ilość kolumn planszy.
     * @param size_row Liczba całkowita zawierająca ilość wierszy planszy.
     * @param bombs_number Zmienna zawierająca ilość bomb przekazaną w metodzie Menu.menu2
     * @param is_revealed Tablica zawierająca odzwierciedlenie planszy board, tylko zawiera informacje odnośnie każdego pola czy zostało odkryte przez użytkownika.
     * @param if_flag Tablica zawierająca odzwierciedlenie planszy board, tylko zawiera informacje odnośnie ustawionych flag na planszy.
     * @param frame Zmienna przechowuje okno aplikacji.
     */
    static void play(int[][] board, int size_row, int size_col, int bombs_number,int[][] is_revealed, boolean[][] if_flag, JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
        board_render(board,size_row,size_col,bombs_number,is_revealed,if_flag);
        repaint(board,size_row,size_col,is_revealed,if_flag,frame);
        playing(bombs_number,board,size_row,size_col,is_revealed,if_flag,frame);

    }

    //Generowanie tablicy oraz bomb
    /**
     * Funkcja board_render służy do wygenerowania całej planszy.
     * - Wypełnia tablicę zerami
     * - Losuje miejsca w planszy a następnie wstawia w nich liczbę "9" co oznacza bombę.
     * - Wywołuję funkcję board_render_counting która zlicza dla każdego pola ilość bomb dookoła.
     * @param board Tablica zawierająca planszę.
     * @param size_col Liczba całkowita zawierająca ilość kolumn planszy.
     * @param size_row Liczba całkowita zawierająca ilość wierszy planszy.
     * @param bombs_number Zmienna zawierająca ilość bomb przekazaną w metodzie Menu.menu2
     * @param is_revealed Tablica zawierająca odzwierciedlenie planszy board, tylko zawiera informacje odnośnie każdego pola czy zostało odkryte przez użytkownika.
     * @param if_flag Tablica zawierająca odzwierciedlenie planszy board, tylko zawiera informacje odnośnie ustawionych flag na planszy.
     */
    static void board_render(int[][] board, int size_row, int size_col, int bombs_number,int[][] is_revealed, boolean[][] if_flag) {

        int random_row, random_col;
        Random random = new Random();
        //Wypelnianie tablicy zerami
        for(int i = 0; i < size_row; i++)
        {
            for(int j = 0; j < size_col;j++)
            {
                board[i][j] = 0;
                is_revealed[i][j] = 0;
                if_flag[i][j] = false;
            }
        }

        //Losowanie miejsc bomb w planszy
        for(int i=0;i<bombs_number;i++) {
            random_row = random.nextInt((size_row));
            random_col = random.nextInt((size_col));
            if(board[random_row][random_col] == 9) {
                i--;
            }
            else {
                board[random_row][random_col] = 9;
            }

        }

        //Zliczanie bomb (generowanie planszy)
        board_render_counting(board,size_row,size_col);
    }

    //Zliczanie pól wokół bomb
    /**
     * Funkcja board_render_counting służy do zliczania bomb wokół każdego pola.
     * Na przykład jeżeli wokół jakiegoś pola są 3 bomby to ustawia wartość tego pola na 3.
     *
     * @param board Tablica zawierająca planszę.
     * @param size_col Liczba całkowita zawierająca ilość kolumn planszy.
     * @param size_row Liczba całkowita zawierająca ilość wierszy planszy.
     */
    static void board_render_counting(int[][] board, int size_row, int size_col) {

        int count = 0;
        //Lewy gorny rog
        if(board[0][0]!=9)
        {
            if(board[0][1]==9)
            {
                count++;
            }
            if(board[1][1]==9)
            {
                count++;
            }
            if(board[1][0]==9)
            {
                count++;
            }
            board[0][0] = count;
            count = 0;
        }

        //Prawy gorny rog
        if(board[0][size_col-1]!=9)
        {
            if(board[0][size_col-2]==9)
            {
                count++;
            }
            if(board[1][size_col-2]==9)
            {
                count++;
            }
            if(board[1][size_col-1]==9)
            {
                count++;
            }
            board[0][size_col-1] = count;
            count = 0;
        }
        //Lewy dolny rog
        if(board[size_row-1][0]!=9)
        {
            if(board[size_row-2][0]==9)
            {
                count++;
            }
            if(board[size_row-2][1]==9)
            {
                count++;
            }
            if(board[size_row-1][1]==9)
            {
                count++;
            }
            board[size_row-1][0] = count;
            count = 0;
        }
        //Prawy dolny rog
        if(board[size_row-1][size_col-1]!=9)
        {
            if(board[size_row-2][size_col-1]==9)
            {
                count++;
            }
            if(board[size_row-2][size_col-2]==9)
            {
                count++;
            }
            if(board[size_row-1][size_col-2]==9)
            {
                count++;
            }
            board[size_row-1][size_col-1] = count;
            count = 0;
        }
        //Lewa krawedz
        for(int i=1;i<size_row-1;i++)
        {
            if(board[i][0]!=9)
            {
                if(board[i-1][0]==9)
                {
                    count++;
                }
                if(board[i-1][1]==9)
                {
                    count++;
                }
                if(board[i][1]==9)
                {
                    count++;
                }
                if(board[i+1][1]==9)
                {
                    count++;
                }
                if(board[i+1][0]==9)
                {
                    count++;
                }
                board[i][0] = count;
                count = 0;
            }
        }

        //Gorna krawedz
        for(int j=1;j<size_col-1;j++)
        {
            if(board[0][j]!=9)
            {
                if(board[0][j-1]==9)
                {
                    count++;
                }
                if(board[1][j-1]==9)
                {
                    count++;
                }
                if(board[1][j]==9)
                {
                    count++;
                }
                if(board[1][j+1]==9)
                {
                    count++;
                }
                if(board[0][j+1]==9)
                {
                    count++;
                }
                board[0][j] = count;
                count = 0;
            }
        }

        //Prawa krawedz
        for(int i=1;i<size_row-1;i++)
        {
            if(board[i][size_col-1]!=9)
            {
                if(board[i-1][size_col-1]==9)
                {
                    count++;
                }
                if(board[i-1][size_col-2]==9)
                {
                    count++;
                }
                if(board[i][size_col-2]==9)
                {
                    count++;
                }
                if(board[i+1][size_col-2]==9)
                {
                    count++;
                }
                if(board[i+1][size_col-1]==9)
                {
                    count++;
                }
                board[i][size_col-1] = count;
                count = 0;
            }
        }
        //Dolna krawedz
        for(int j=1;j<size_col-1;j++)
        {
            if(board[size_row-1][j]!=9)
            {
                if(board[size_row-1][j-1]==9)
                {
                    count++;
                }
                if(board[size_row-2][j-1]==9)
                {
                    count++;
                }
                if(board[size_row-2][j]==9)
                {
                    count++;
                }
                if(board[size_row-2][j+1]==9)
                {
                    count++;
                }
                if(board[size_row-1][j+1]==9)
                {
                    count++;
                }
                board[size_row-1][j] = count;
                count = 0;
            }
        }

        //Srodek
        for(int i=1;i<size_row-1;i++)
        {
            for(int j=1;j<size_col-1;j++)
            {
                if(board[i][j]!=9)
                {
                    if(board[i-1][j-1]==9)
                    {
                        count++;
                    }
                    if(board[i][j-1]==9)
                    {
                        count++;
                    }
                    if(board[i+1][j-1]==9)
                    {
                        count++;
                    }
                    if(board[i+1][j]==9)
                    {
                        count++;
                    }
                    if(board[i+1][j+1]==9)
                    {
                        count++;
                    }
                    if(board[i][j+1]==9)
                    {
                        count++;
                    }
                    if(board[i-1][j+1]==9)
                    {
                        count++;
                    }
                    if(board[i-1][j]==9)
                    {
                        count++;
                    }
                    board[i][j] = count;
                    count = 0;
                }
            }
        }
        System.out.println();
        //Wyswietlenie calej tablicy w konsoli
        for(int i = 0; i < size_row; i++)
        {
            for(int j = 0; j < size_col;j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Funkcja repait służy do graficznego(aktualnego) generowania planszy na ekranie.
     * Funkcja jest wywoływana po każdej zmianie na planszy.
     *
     * @param board Tablica zawierająca planszę.
     * @param size_row Liczba całkowita zawierająca ilość wierszy planszy.
     * @param size_col Liczba całkowita zawierająca ilość kolumn planszy.
     * @param is_revealed Tablica zawierająca odzwierciedlenie planszy board, tylko zawiera informacje odnośnie każdego pola czy zostało odkryte przez użytkownika.
     * @param if_flag Tablica zawierająca odzwierciedlenie planszy board, tylko zawiera informacje odnośnie ustawionych flag na planszy.
     * @param frame Zmienna przechowuje okno aplikacji.
     */
    static void repaint(int[][] board, int size_row, int size_col, int[][] is_revealed, boolean[][] if_flag, final JFrame frame) {
        frame.getContentPane().removeAll();



        ImageIcon bcgimg = new ImageIcon("img/background_ingame.png");
        final JLabel background = new JLabel("",bcgimg,JLabel.CENTER);
        background.setBounds(0,0,1920,1080);
        frame.add(background); frame.repaint();

         //Rysowanie klockow
        int x=145,y=120;
        for(int i=0;i<size_row;i++) {
            for(int j=0;j<size_col;j++) {
                if(!if_flag[i][j]) {
                    if(is_revealed[i][j]==1) {
                        if(board[i][j] == 0) {
                            JLabel block0 = new JLabel();
                            block0.setIcon(new ImageIcon("img/block.png"));
                            block0.setBounds(x,y,40,40);
                            frame.add(block0,0);
                        }
                        else if(board[i][j] == 1) {
                            JLabel block1 = new JLabel();
                            block1.setIcon(new ImageIcon("img/block_1.png"));
                            block1.setBounds(x,y,40,40);
                            frame.add(block1,0);
                        }
                        else if(board[i][j] == 2) {
                            JLabel block2 = new JLabel();
                            block2.setIcon(new ImageIcon("img/block_2.png"));
                            block2.setBounds(x,y,40,40);
                            frame.add(block2,0);
                        }
                        else if(board[i][j] == 3) {
                            JLabel block3 = new JLabel();
                            block3.setIcon(new ImageIcon("img/block_3.png"));
                            block3.setBounds(x,y,40,40);
                            frame.add(block3,0);
                        }
                        else if(board[i][j] == 4) {
                            JLabel block4 = new JLabel();
                            block4.setIcon(new ImageIcon("img/block_4.png"));
                            block4.setBounds(x,y,40,40);
                            frame.add(block4,0);
                        }
                        else if(board[i][j] == 5) {
                            JLabel block5 = new JLabel();
                            block5.setIcon(new ImageIcon("img/block_5.png"));
                            block5.setBounds(x,y,40,40);
                            frame.add(block5,0);
                        }
                        else if(board[i][j] == 6) {
                            JLabel block6 = new JLabel();
                            block6.setIcon(new ImageIcon("img/block_6.png"));
                            block6.setBounds(x,y,40,40);
                            frame.add(block6,0);
                        }
                        else if(board[i][j] == 7) {
                            JLabel block7 = new JLabel();
                            block7.setIcon(new ImageIcon("img/block_7.png"));
                            block7.setBounds(x,y,40,40);
                            frame.add(block7,0);
                        }
                        else if(board[i][j] == 8) {
                            JLabel block8 = new JLabel();
                            block8.setIcon(new ImageIcon("img/block_8.png"));
                            block8.setBounds(x,y,40,40);
                            frame.add(block8,0);
                        }
                        else if(board[i][j] == 9) {
                            JLabel bomb = new JLabel();
                            bomb.setIcon(new ImageIcon("img/bomb.png"));
                            bomb.setBounds(x,y,40,40);
                            frame.add(bomb,0);
                        }

                    }
                    else {
                        JLabel cover_block = new JLabel();
                        cover_block.setIcon(new ImageIcon("img/block_covered.png"));
                        cover_block.setBounds(x,y,40,40);
                        frame.add(cover_block,0);
                    }
                }
                else {
                    JLabel flag = new JLabel();
                    flag.setIcon(new ImageIcon("img/flag.png"));
                    flag.setBounds(x,y,40,40);
                    frame.add(flag,0);
                }

                x+=40;
            }
            x=145;
            y+=40;
        }
        frame.repaint();


    }


    /**
     * Funkcja playing zawiera wszystkie funkcje, przyciski służące do działania interaktywności z użytkownikiem.
     * Z każdym kliknięciem użytkownika na planszy sprawdzane są koordynaty kliknięcia myszki a następnie wywoływane są odpowiednie metody.
     * Po oflagowaniu wszystkich bomb wywoływana jest procedura wygranej oraz tworzona oraz wywoływana klasa Win.
     *
     * @param board Tablica zawierająca planszę.
     * @param size_col Liczba całkowita zawierająca ilość kolumn planszy.
     * @param size_row Liczba całkowita zawierająca ilość wierszy planszy.
     * @param bombs_number Zmienna zawierająca ilość bomb przekazaną w metodzie Menu.menu2
     * @param is_revealed Tablica zawierająca odzwierciedlenie planszy board, tylko zawiera informacje odnośnie każdego pola czy zostało odkryte przez użytkownika.
     * @param if_flag Tablica zawierająca odzwierciedlenie planszy board, tylko zawiera informacje odnośnie ustawionych flag na planszy.
     * @param frame Zmienna przechowuje okno aplikacji.
     */
    static void playing(final int bombs_number, final int[][] board, final int size_row, final int size_col, final int[][] is_revealed, final boolean[][] if_flag, final JFrame frame) {

        final int[] correct_bombs_flagged = {0};
        Icon back_icon = new ImageIcon("img/ingame_back_button.png");
        final JButton back_button = new JButton(back_icon);
        back_button.setOpaque(false);
        back_button.setContentAreaFilled(false);
        back_button.setBorderPainted(false);
        back_button.setFocusPainted(false);
        back_button.setBounds(1500, 25, 280, 90);

        final double millisActualTime = System.currentTimeMillis(); // początkowy czas w milisekundach.

        frame.add(back_button,0);

        back_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                back_button.removeMouseListener(this);
                frame.getContentPane().removeAll();
                frame.removeMouseListener(this);
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
                back_button.setIcon(new ImageIcon("img/ingame_back_button_hover.png"));
                frame.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back_button.setIcon(new ImageIcon("img/ingame_back_button.png"));
                frame.repaint();
            }
        });

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
                    double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
                    System.out.print("X: " + mouseX + " Y: " + mouseY + "\n");
                    double x_pom = 145,y_pom = 120, space = 40;
                    for(int i=0;i<size_row;i++) {
                        for(int j=0;j<size_col;j++) {
                            if(mouseX>x_pom && mouseX<x_pom+space && mouseY>y_pom && mouseY<y_pom+space) {
                                if(!if_flag[i][j]) {
                                    if(board[i][j] == 0) {
                                        frame.getContentPane().removeAll();
                                        revealing(board,x_pom,y_pom,i,j,space,size_row,size_col,is_revealed,if_flag);
                                        repaint(board,size_row,size_col,is_revealed,if_flag,frame);
                                        frame.add(back_button,0);
                                        System.out.print("ODKRYWANIE");
                                    }
                                    else if(board[i][j] == 9) {
                                        for(int k=0;k<size_row;k++) {
                                            for (int l=0;l<size_col;l++) {
                                                if(board[k][l]==9) {
                                                    is_revealed[k][l] = 1;
                                                }
                                            }
                                        }
                                        is_revealed[i][j] = 1;
                                        frame.getContentPane().removeAll();
                                        repaint(board,size_row,size_col,is_revealed,if_flag,frame);
                                        frame.add(back_button,0);
                                        int result = JOptionPane.showConfirmDialog(frame,"Do you want to try again??", "BOMB",
                                                JOptionPane.YES_NO_OPTION,
                                                JOptionPane.QUESTION_MESSAGE);
                                        if(result == JOptionPane.YES_OPTION){
                                            frame.getContentPane().removeAll();
                                            frame.removeMouseListener(this);
                                            Game game = new Game();
                                            game.play(board,size_row,size_col, bombs_number, is_revealed, if_flag,frame);
                                        }
                                        else {
                                            frame.getContentPane().removeAll();
                                            frame.removeMouseListener(this);
                                            Menu menu = new Menu();
                                            menu.menu(frame);
                                        }


                                    }
                                    else {
                                        is_revealed[i][j] = 1;
                                        frame.getContentPane().removeAll();
                                        repaint(board,size_row,size_col,is_revealed,if_flag,frame);
                                        frame.add(back_button,0);
                                    }
                                }
                            }
                            x_pom+=40;
                        }
                        x_pom = 145;
                        y_pom+=40;
                    }


                }
                if(e.getButton() == MouseEvent.BUTTON3) {
                    double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
                    double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
                    double x_pom = 145,y_pom = 120, space = 40;
                    for(int i=0;i<size_row;i++) {
                        for(int j=0;j<size_col;j++) {
                            if(mouseX>x_pom && mouseX<x_pom+space && mouseY>y_pom && mouseY<y_pom+space) {
                                if(is_revealed[i][j] == 0) {
                                    if(!if_flag[i][j]) {
                                        if_flag[i][j] = true;
                                        if(board[i][j] == 9) {
                                            correct_bombs_flagged[0] +=1;
                                        }
                                        else {
                                            correct_bombs_flagged[0] -= 1;
                                        }
                                    }
                                    else {
                                        if_flag[i][j] = false;
                                        if(board[i][j] == 9) {
                                            correct_bombs_flagged[0] -=1;
                                        }
                                        else {
                                            correct_bombs_flagged[0] +=1;

                                        }
                                    }
                                }
                                if(correct_bombs_flagged[0] == bombs_number) {
                                    System.out.print("\n WYGRANA \n");
                                    //Tworzenie ekranu końcowego
                                    double executionTime = (System.currentTimeMillis() - millisActualTime)/1000; // czas wykonania programu w ekundach
                                    frame.getContentPane().removeAll();
                                    frame.removeMouseListener(this);
                                    Win win_scr = new Win();
                                    try {
                                        win_scr.scoreSaving(executionTime,frame,bombs_number);
                                    } catch (FileNotFoundException ex) {
                                        ex.printStackTrace();
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                    System.out.print("\n PO FUNKCJI \n");
                                    return;
                                }
                                repaint(board,size_row,size_col,is_revealed,if_flag,frame);
                                frame.add(back_button,0);
                            }
                            x_pom+=40;
                        }
                        x_pom = 145;
                        y_pom+=40;
                    }
                }
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
        });
    }


    /**
     * Funkcja rekurencyjna służąca do odkrywania pól.
     * Dziala w ten sposób, że edytuje tablicę is_revealed[][] w momencie kiedy pole jest równe 0 oraz wykonuje do niej rekurencję.
     * Sprawdza czy na danym polu jest flaga.
     * Jeżeli flaga nie znajduję się na pol do odkrywane są wszystkie pola dookoła.
     *
     * @param board Tablica zawierająca planszę.
     * @param x_pom Koordynaty X myszki użytkownika.
     * @param y_pom Koordynaty Y myszki użytkownika.
     * @param i Zmienna zawierająca współrzędną w tablicy board.
     * @param j Zmienna zawierająca współrzędną w tablicy board.
     * @param space Zmienna zawiera odstęp pomiędzy każdym klockiem
     * @param size_row Liczba całkowita zawierająca ilość wierszy planszy.
     * @param size_col Liczba całkowita zawierająca ilość kolumn planszy.
     * @param is_revealed Tablica zawierająca odzwierciedlenie planszy board, tylko zawiera informacje odnośnie każdego pola czy zostało odkryte przez użytkownika.
     * @param if_flag Tablica zawierająca odzwierciedlenie planszy board, tylko zawiera informacje odnośnie ustawionych flag na planszy.
     */
    static void revealing(final int[][] board, double x_pom, double y_pom, int i, int j, double space, int size_row, int size_col, int[][] is_revealed, boolean[][] if_flag) {
        if(i<0 || j<0 || i>size_row-1 || j>size_col-1)
        {
            return;
        }
        if(!if_flag[i][j])
        {
            if(board[i][j]==1)
                is_revealed[i][j]=1;
            if(board[i][j]==2)
                is_revealed[i][j]=1;
            if(board[i][j]==3)
                is_revealed[i][j]=1;
            if(board[i][j]==4)
                is_revealed[i][j]=1;
            if(board[i][j]==5)
                is_revealed[i][j]=1;
            if(board[i][j]==6)
                is_revealed[i][j]=1;
            if(board[i][j]==7)
                is_revealed[i][j]=1;
            if(board[i][j]==8)
                is_revealed[i][j]=1;
        }
        else
        {
            is_revealed[i][j]=0;
        }

        if(is_revealed[i][j] == 0 && board[i][j]==0)
        {
            if(!if_flag[i][j])
                is_revealed[i][j] = 1;
            revealing(board,x_pom,y_pom-space,i-1,j,space,size_row,size_col,is_revealed,if_flag);
            revealing(board,x_pom,y_pom+space,i+1,j,space,size_row,size_col,is_revealed,if_flag);
            revealing(board,x_pom-space,y_pom,i,j-1,space,size_row,size_col,is_revealed,if_flag);
            revealing(board,x_pom+space,y_pom,i,j+1,space,size_row,size_col,is_revealed,if_flag);
            revealing(board,x_pom-space,y_pom-space,i-1,j-1,space,size_row,size_col,is_revealed,if_flag);
            revealing(board,x_pom+space,y_pom+space,i+1,j+1,space,size_row,size_col,is_revealed,if_flag);
            revealing(board,x_pom+space,y_pom-space,i-1,j+1,space,size_row,size_col,is_revealed,if_flag);
            revealing(board,x_pom-space,y_pom+space,i+1,j-1,space,size_row,size_col,is_revealed,if_flag);
        }
    }
}
