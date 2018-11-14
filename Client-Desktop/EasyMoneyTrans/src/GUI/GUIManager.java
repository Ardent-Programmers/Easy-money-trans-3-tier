/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Security.Notification;
import GUI.Security.NotificationManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

/**
 *
 * @author User
 */
public class GUIManager {
    
    JFrame window;
    public Notification popup;
    
    private JPanel prevComp;

    public GUIManager() {
        startApplication();
        //        adding menu inorder to send notification in later?
        popup = new Notification();
        
        
    }
    
    
    
    public void  startApplication() {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               
                window = new JFrame();



        //        this will get the screen size and assign
                Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();

                window.setMinimumSize(windowSize);


                JPanel p = new Welcome();
                prevComp = p;
                loadScene(p);







        //      this will maximize the window
                window.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);



        //      to hide the Topbar
        //      topBarInvisible(true);

                window.setVisible(true);



                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




            }
        });
        
        
    }
    
    public void topBarInvisible(boolean t)
    {
        //                remove the titleBar completly

          if(t)
          {
            window.setUndecorated(true);
            window.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
          }
    }
    
    
    public void loadScene(JPanel scene)
    {
        
        
        window.getContentPane().removeAll();
        
        //window.repaint();
        
        
        window.setLayout(new BorderLayout());
        window.add(scene,BorderLayout.CENTER);
        

        window.add(popup,BorderLayout.PAGE_END);
        popup.setVisible(false);
        
      
        
        
        
        
        window.validate();

    }
    
    
    public void sendNotification(String msg)
    {
        
    }
}
