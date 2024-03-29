package JoinTest;

import javax.swing.*;
import java.awt.*;

public class JoinTest extends JFrame {
    private  Thread threadA;
    private  Thread threadB;
    final  JProgressBar progressBar1= new JProgressBar();
    final  JProgressBar progressBar2= new JProgressBar();
    int count=0;
    public static  void main(String[] args)
    {
        init(new JoinTest(),100,100);
    }

    public JoinTest(){
        super();
        getContentPane().add(progressBar1, BorderLayout.NORTH);
        getContentPane().add(progressBar2,BorderLayout.SOUTH);
        progressBar1.setStringPainted(true);
        progressBar2.setStringPainted(true);

        threadA = new Thread(new Runnable() {
            int count =0;
            @Override
            public void run() {
                while (true)
                {
                    progressBar1.setValue(++count);
                    try {
                        threadA.sleep(100);
                        threadB.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA.start();
        threadB = new Thread(new Runnable() {
            int count =0;
            @Override
            public void run() {
                while (true)
                {
                    progressBar2.setValue(++count);
                    try {
                        threadB.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(count==100)
                        break;
                }
            }
        });
        threadB.start();
    }

    public static void init(JFrame frame,int width,int height)
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.setVisible(true);
    }
}
