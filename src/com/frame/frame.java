//proyecto sacado de aqui: http://www.myjavazone.com/2011/02/ventana-con-marco-personalizado.html

package com.frame;

import jdk.internal.org.jline.terminal.MouseEvent.Modifier;
//encontre aqui esta clase: https://www.javaclassfile.org/search/jdk.internal.jline.internal.TestAccessible

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;


public class frame extends JFrame {


 private static final long serialVersionUID = 1L;
 private JPanel jContentPane = null;
 static JLabel movimiento = null;
 private JLabel acerca_de = null;
 private JButton boto_cerrar = null;
 private JButton boto_mini = null;
 ImageIcon iconoadvertencia = new ImageIcon("src/com/frame/ardilla64.png");  //para las ventanas de aviso

 private JButton getBoto_cerrar() {
  if (boto_cerrar == null) {
   boto_cerrar = new JButton();
   boto_cerrar.setIcon(new ImageIcon(this.getClass().getResource("src/com/frame/ardilla64.png")));
   boto_cerrar.setBounds(new Rectangle(512, 35, 34, 16));
   boto_cerrar.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent e) {
     System.exit(0);
    }
   });
  }
  return boto_cerrar;
 }


 private JButton getBoto_mini() {
  if (boto_mini == null) {
   boto_mini = new JButton();
   boto_mini.setIcon(new ImageIcon(this.getClass().getResource("src/com/frame/ardilla64.png")));
   boto_mini.setBounds(new Rectangle(471, 35, 34, 16));
   boto_mini.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent e) {
     
     setExtendedState(JFrame.CROSSHAIR_CURSOR);
    }
   });
  }
  return boto_mini;
 }


 public static void main(String[] args) {
  // TODO Auto-generated method stub
  SwingUtilities.invokeLater(new Runnable() {
   public void run() {
    try{
     UIManager.setLookAndFeel(
       UIManager.getSystemLookAndFeelClassName());
    }catch(Exception e){}
    
    frame thisClass = new frame();
    thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    thisClass.setVisible(true);
    try {
       @SuppressWarnings("rawtypes")
     Class clazz =  Class.forName("com.sun.awt.AWTUtilities");
       @SuppressWarnings("unchecked")
     Method method = clazz.getMethod("setWindowOpaque", java.awt.Window.class, Boolean.TYPE);
       method.invoke(clazz,thisClass , false);
       } catch (Exception e) 
       { } 
    mover mml = new mover(movimiento);
    movimiento.addMouseListener(mml);
    movimiento.addMouseMotionListener(mml);


   }
   
   
  });
 }


 public frame() {
  super();
  initialize();
 }


 private void initialize() {
  this.setSize(601, 548);
  this.setUndecorated(true);
  this.setResizable(false);
  this.setLocationRelativeTo(null);
  this.setContentPane(getJContentPane());
  this.setTitle("MOVER JFRAME SIN BORDES");
 }


 private JPanel getJContentPane() {
  if (jContentPane == null) {
   acerca_de = new JLabel();
   acerca_de.setBounds(new Rectangle(301, 419, 190, 43));
   acerca_de.setFont(new Font("Bauhaus 93", Font.BOLD, 24));
   acerca_de.setForeground(new Color(224, 93, 37));
   acerca_de.setText("ACERCA DE....");
   acerca_de.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent e) {
     
     JOptionPane.showMessageDialog(null,"FACIL SKIN EN JAVA PARA MEJORAR TUS APLICACIONES"+"\n"+"desarrollado por:"+"  HANNIBAL T"+"\n"+"             imagina,crea,no te rindas,no evidies"+"\n"+"                           si copias,mejoralo", "SKIN", 1); 
    }
   });
   movimiento = new JLabel();
   movimiento.setBounds(new Rectangle(5, 5, 587, 505));
   movimiento.setIcon(new ImageIcon(this.getClass().getResource("src/com/frame/ardilla64.png")));
   jContentPane = new JPanel();
   jContentPane.setLayout(null);
   jContentPane.add(acerca_de, null);
   jContentPane.add(getBoto_cerrar(), null);
   jContentPane.add(getBoto_mini(), null);
   jContentPane.add(movimiento, null);
  }
  return jContentPane;
}
}

