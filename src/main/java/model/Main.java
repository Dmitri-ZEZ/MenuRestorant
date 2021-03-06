package model;

import com.sun.xml.bind.v2.TODO;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        MenuItem menuItem1 = new MenuItem("tomato", 100.0,200,50,10,10);
        session.save(menuItem1);
        MenuItem menuItem2 = new MenuItem("patato", 100.0,200,50,10,10);
        session.save(menuItem2);
        MenuItem menuItem3 = new MenuItem("banana", 100.0,200,50,10,10);
        session.save(menuItem3);

        Menu menu = new Menu("MenuForKids");
        Menu menu2 = new Menu("MenuForOlds");

        menu.addItem(menuItem1);
        menu.addItem(menuItem2);
        menu2.addItem(menuItem3);
        session.save(menu);
        session.save(menu2);


        session.getTransaction().commit();

        session.close();
        System.out.println("ok");
        System.exit(0);
    }
}
