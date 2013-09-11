package com.springapp.mvc;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.List;

public class HibernateUtils {

        private static final SessionFactory sessionFactory = buildSessionFactory();

        private static SessionFactory buildSessionFactory() {
            try {
                // Create the SessionFactory from hibernate.cfg.xml
                return new Configuration()
                        .configure()
                        .buildSessionFactory();
            } catch (Throwable ex) {
                String projectPath = System.getProperty("user.dir");
                System.out.println(projectPath);
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }

    public static Employee save(Employee employee) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Long id = (Long) session.save(employee);
        employee.setId(id);

        session.getTransaction().commit();

        session.close();

        return employee;
    }

    public static List<Employee> list() {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        List employees = session.createQuery("from Employee").list();
        session.close();
        return employees;
    }

    public static Employee read(long id) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        Employee employee = (Employee) session.get(Employee.class, id);
        session.close();
        return employee;
    }

    public static Employee update(Employee employee) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.merge(employee);

        session.getTransaction().commit();

        session.close();
        return employee;

    }

    public static void delete(Employee employee) {
        SessionFactory sf = getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        session.delete(employee);

        session.getTransaction().commit();

        session.close();
    }
}
