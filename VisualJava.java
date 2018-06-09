import java.io.*;
import javax.sound.sampled.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;



public class VisualJava extends JFrame{
  
  JButton button1;
  JButton button2;
  JButton button3;
  JButton button4;
  JButton start;
  
  public static void main(String[] args) {
    
    new VisualJava();
    
  
  }
  
  public VisualJava() {
    
  //  this.setSize(400, 400);
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    
    Dimension dim = tk.getScreenSize();
    
    int xPos = (dim.width / 2) - (this.getWidth() / 2);
    int yPos = (dim.height / 2) - (this.getHeight()/ 2);
    
    this.setLocation(xPos, yPos);
    
    this.setResizable(false);
    
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.setTitle("Soundboard");
    
    JPanel panel = new JPanel();
    
    start = new JButton("Start / Reset");
    
    button1 = new JButton("Button 1");
    
    button2 = new JButton("Button 2");
    
    button3 = new JButton("Button 3");
    
    button4 = new JButton("Button 4");
    
    ListenForButton lForButton = new ListenForButton();
    
    panel.setLayout(new GridLayout(2, 2, 3, 3));
    
    panel.add(start);
    
    panel.add(button1);
    
    panel.add(button2);
    
    panel.add(button3);
    
    panel.add(button4);
    
    this.add(panel);
    
    this.pack();
    
    this.setVisible(true);
    
    start.addActionListener(lForButton);
    button1.addActionListener(lForButton);
    button2.addActionListener(lForButton);
    button3.addActionListener(lForButton);
    button4.addActionListener(lForButton);
    
}


private class ListenForButton implements ActionListener {

  public void actionPerformed(ActionEvent event) {
    
    if(event.getSource() == start) {
      
     populate();
      
    }
    else if (event.getSource() ==  button1) {
  
     PlaySound(0);
      
    }
    else if (event.getSource() ==  button2) {
      
     PlaySound(1);
      
    }
    else if (event.getSource() ==  button3) {
      
     PlaySound(2);
      
    }
    else if (event.getSource() ==  button4) {
      
     PlaySound(3);
      
    }
    
  }

 ArrayList<File> sounds = new ArrayList<File>();
      
  public void PlaySound(int x) {
    
    try {
      
      File Sound = sounds.get(x);
      Clip clip = AudioSystem.getClip();
      clip.open(AudioSystem.getAudioInputStream(Sound));
      clip.start();
      
      Thread.sleep(clip.getMicrosecondLength()/1000);
      
    }catch(Exception e) {
      
    }
    
  }
  
  public void populate() {
    
    File begin = new File("begin.wav");
    File coin = new File("coin.wav");
    File gameover = new File("gameover.wav");
    File win = new File("win.wav");
    
    sounds.add(begin);
    sounds.add(coin);
    sounds.add(gameover);
    sounds.add(win);

  }
  
  
  
}
}