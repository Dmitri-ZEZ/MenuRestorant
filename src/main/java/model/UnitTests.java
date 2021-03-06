package model;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;


public class UnitTests {

    @Test
    public void createMenuAndAddsMenuItems(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Menu menu = new Menu("Business lunch");
        MenuItem menuItem1 = new MenuItem("Caesar salad", 100.0,200,50,10,10);
        MenuItem menuItem2 = new MenuItem("Borscht", 150.0,150,90,15,10);
        MenuItem menuItem3 = new MenuItem("Coffee", 75.0,80,10,5,15);



        menu.addItem(menuItem1);
        menu.addItem(menuItem2);
        menu.addItem(menuItem3);

        session.save(menu);

        session.getTransaction().commit();

        Assert.assertNotNull(session.get(Menu.class, 1L));
    }

    @Test
    public void getMenuFromBase(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Menu menu = session.get(Menu.class, 1L);

        System.out.println(menu.getTitle());


        Assert.assertNotNull(menu);
    }

    @Test
    public void addMenuItem(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Menu menu = session.get(Menu.class, 1L);

        MenuItem nweMenuItem = new MenuItem("Tea", 50.0,30,5,5,1);


        menu.addItem(nweMenuItem);

        session.save(menu);
        session.getTransaction().commit();



        Assert.assertEquals(menu.getItems().get(3).getName(), "Tea");

    }
}
