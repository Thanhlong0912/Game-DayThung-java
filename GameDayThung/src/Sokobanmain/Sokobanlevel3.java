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
public class Sokobanlevel3 extends JFrame{
        private final int OFFSET = 70;
    
    public Sokobanlevel3() {
        InitUI();
    }

    public void InitUI() {
        Board2 board = new Board2();
        add(board);
            setDefaultCloseOperation(this.EXIT_ON_CLOSE);
       
        setSize(board.getBoardWidth() + OFFSET,
                board.getBoardHeight() + 2*OFFSET);
        setLocationRelativeTo(null);
        setTitle("Sokoban Level 3");
    }
    public static void main(String[] args) {
        Sokobanlevel3 skb = new Sokobanlevel3();
        skb.setVisible(true);
    }
}

