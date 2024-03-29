package SwingAndThread;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SwinAndThread extends JFrame {
    private JLabel jl = new JLabel();
    private static Thread t;
    private int count =0;
    private Container container = getContentPane();
    public SwinAndThread()
    {
        setBounds(300,200,750,800);
        container.setLayout(null);

        URL url =SwinAndThread.class.getResource("timg.gif");
        Icon icon = new ImageIcon(url);
        jl.setIcon(icon);
        jl.setHorizontalAlignment(SwingConstants.LEFT);
        jl.setBounds(10,10,200,200);
        jl.setOpaque(true);

        t=new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <=600)
                {
                    jl.setBounds(count,10,600,50);
                    try {
                        t.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count +=4;
                    if(count ==600)
                        count =10;
                }
            }
        });

        t.start();
        container.add(jl);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


    }

    public static void main(String args[])
    {
        new SwinAndThread();
    }
}
