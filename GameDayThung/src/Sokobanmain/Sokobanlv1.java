/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokobanmain;

/**
 *
 * @author Admin
 */
//import javax.swing.JButton;
import com.sun.prism.j2d.J2DPipeline;
import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicArrowButton;
import jdk.nashorn.internal.scripts.JO;


public final class Sokobanlv1 extends JFrame{

    private final int OFFSET = 70;
    
    public Sokobanlv1() {
        InitUI();
    }

    public void InitUI() {
          
        
        Board board = new Board();
        add(board);
       
        
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
       
        setSize(board.getBoardWidth() + OFFSET,
                board.getBoardHeight() + 2*OFFSET);
        setLocationRelativeTo(null);
        setTitle("Sokoban Level 1");
        

        
  }


    public static void main(String[] args) {
        Sokobanlv1 sokoban = new Sokobanlv1();
        sokoban.setVisible(true);
    }

    void exit(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

