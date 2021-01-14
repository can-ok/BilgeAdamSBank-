import javax.swing.*;

import java.awt.event.*;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;


import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import javafx.scene.effect.Reflection;
import org.reflections.Reflections;


import com.entity.News;
import com.entity.Website;
import com.scraper.RssScraper;

public class App {
    private JPanel root;
    private JComboBox comboBox1;
    private JButton searchBtn;
    private JList headlineList;
    private JTextArea IntoArea;

    public App(){
        comboBox1.setLocation(100,120);


        setComboBoxItem();



        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Website selectedSite= (Website) comboBox1.getSelectedItem();

                List<News> newslist=selectedSite.getDescription();


                DefaultListModel dm=new DefaultListModel();

                for(int i=0; i<newslist.size(); i++){

                    //JScroller ekle
                    dm.add(i,newslist.get(i));
                }
                headlineList.setModel(dm);

            }
        });

        headlineList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                IntoArea.setText(" ");
               // int index=headlineList.getSelectedIndex();
                News selectedNews = (News) headlineList.getSelectedValue();
                IntoArea.setText(selectedNews.getDescription());

            }


        });
    }

    public static void main(String[] args) {

        JFrame frame=new JFrame("App");
        frame.setContentPane(new App().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(100,200);
        frame.setSize(800,500);
        frame.setVisible(true);



    }


    public void setComboBoxItem(){
        Reflections reflections = new Reflections("com.entity");


        Set<Class<? extends Website>> allClasses =
                reflections.getSubTypesOf(Website.class);



        for (Class<? extends Website> subClass : allClasses){
            System.out.println(subClass);

            try {

                //subClass.getConstructor().newInstance();
                //allClasses.getClass().newInstance(();
                comboBox1.addItem(subClass.getConstructor().newInstance());


            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }



        }
    }


}
