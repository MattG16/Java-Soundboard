import java.io.*;
import javax.sound.sampled.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.awt.CardLayout;

public class VisualJava extends JFrame{
  
  JButton button1;
  JButton button2;
  JButton button3;
  JButton button4;
  JButton start;
  JButton reset;
  JButton customize;
  JButton back;
  JTextField textField1;
  JButton change1;
  JTextField textField2;
  JButton change2;
  JTextField textField3;
  JButton change3;
  JTextField textField4;
  JButton change4;
  JFrame frame = new JFrame();
  public JPanel panel2 = new JPanel();
  public JPanel panel = new JPanel();
  
  public static void main(String[] args) {
    
    new VisualJava();
  
  }
  
  public VisualJava() {
    
  //  this.setSize(400, 400);
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    
    Dimension dim = tk.getScreenSize();
    
    int xPos = (dim.width / 2) - (this.getWidth() / 2);
    int yPos = (dim.height / 2) - (this.getHeight()/ 2);
    
    frame.setLocation(xPos, yPos);
    
    frame.setResizable(false);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.setTitle("Soundboard");

    panel.setBackground(Color.GREEN);
    panel2.setBackground(Color.BLUE);
    
    customize = new JButton("Customize");
    
    start = new JButton("Start");
    
    reset = new JButton("Reset");
    
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
    
    panel.add(customize);
    
    panel.add(reset);
    
    back = new JButton("Back");
    
    textField1 = new JTextField(20);
    
    change1 = new JButton("Save1");
    
    textField2 = new JTextField(20);
    
    change2 = new JButton("Save2");
    
    textField3 = new JTextField(20);
    
    change3 = new JButton("Save3");
    
    textField4 = new JTextField(20);
    
    change4 = new JButton("Save4");
    
    panel2.setLayout(new GridLayout(5, 2));
    
    panel2.add(textField1);
    
    panel2.add(change1);
    
    panel2.add(textField2);
    
    panel2.add(change2);
    
    panel2.add(textField3);
    
    panel2.add(change3);
    
    panel2.add(textField4);
    
    panel2.add(change4);
    
    panel2.add(back);
    
    frame.setContentPane(panel);
    
    frame.pack();
    
    frame.setVisible(true);
    
    start.addActionListener(lForButton);
    button1.addActionListener(lForButton);
    button2.addActionListener(lForButton);
    button3.addActionListener(lForButton);
    button4.addActionListener(lForButton);
    customize.addActionListener(lForButton);
    back.addActionListener(lForButton);
    change1.addActionListener(lForButton);
    change2.addActionListener(lForButton);
    change3.addActionListener(lForButton);
    change4.addActionListener(lForButton);
    reset.addActionListener(lForButton);
}


public class ListenForButton implements ActionListener {

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
    else if (event.getSource() == customize) {
      
      frame.setContentPane(panel2);
      frame.pack();

    }
    else if (event.getSource() == back) {
      
      frame.setContentPane(panel);
      frame.pack();

    }
    else if (event.getSource() == change1) {
      
       String sound1 = textField1.getText();
       File newSound1 = new File(sound1);
       sounds.remove(0);
       sounds.add(0, newSound1);
       

    }
     else if (event.getSource() == change2) {
      
       String sound2 = textField2.getText();
       File newSound2 = new File(sound2);
       sounds.remove(1);
       sounds.add(1, newSound2);
       

    }
     else if (event.getSource() == change3) {
      
       String sound3 = textField3.getText();
       File newSound3 = new File(sound3);
       sounds.remove(2);
       sounds.add(2, newSound3);
       

    }
     else if (event.getSource() == change4) {
      
       String sound4 = textField4.getText();
       File newSound4 = new File(sound4);
       sounds.remove(3);
       sounds.add(3, newSound4);
       

    }
    else if (event.getSource() == reset) {
      reset();
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
  
  File begin = new File("begin.wav");
  File coin = new File("coin.wav");
  File gameover = new File("gameover.wav");
  File win = new File("win.wav");
  
  public void populate() {
    
    sounds.add(begin);
    sounds.add(coin);
    sounds.add(gameover);
    sounds.add(win);

  }
  
  public void reset() {
    
    sounds.set(0, begin);
    sounds.set(1, coin);
    sounds.set(2, gameover);
    sounds.set(3, win);
    
  }
  
  
}
}