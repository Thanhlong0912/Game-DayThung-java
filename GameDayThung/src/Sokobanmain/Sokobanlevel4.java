/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokobanmain;

import javax.swing.JFrame;

/**
 *
 * @author Milo
 */
public class Sokobanlevel4 extends JFrame{
        private final int OFFSET = 70;
    
    public Sokobanlevel4() {
        InitUI();
    }

    public void InitUI() {
        Board3 board = new Board3();
        add(board);
            setDefaultCloseOperation(this.EXIT_ON_CLOSE);
       
        setSize(board.getBoardWidth() + OFFSET,
                board.getBoardHeight() + 2*OFFSET);
        setLocationRelativeTo(null);
        setTitle("Sokoban Level 4");
    }
    public static void main(String[] args) {
        Sokobanlevel4 skb = new Sokobanlevel4();
        skb.setVisible(true);
    }
}

