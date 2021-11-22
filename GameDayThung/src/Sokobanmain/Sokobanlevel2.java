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
public class Sokobanlevel2 extends JFrame{
        private final int OFFSET = 70;
    
    public Sokobanlevel2() {
        InitUI();
    }

    public void InitUI() {
        Board1 board = new Board1();
        add(board);
            setDefaultCloseOperation(this.EXIT_ON_CLOSE);
       
        setSize(board.getBoardWidth() + OFFSET,
                board.getBoardHeight() + 2*OFFSET);
        setLocationRelativeTo(null);
        setTitle("Sokoban Level 2");
    }
    public static void main(String[] args) {
        Sokobanlevel2 skb = new Sokobanlevel2();
        skb.setVisible(true);
    }
}

