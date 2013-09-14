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

    public static void mockDateBase() {
        Employee employee0 = new Employee(5, "MVC", "zhou", 5.0, 1.5, DateUtils.createDateWithFormat("2012-09-03", "yyyy-MM-dd"), 0.9, 3.0, true, true);
        Employee employee1 = new Employee(5, "ttc", "xuan", 8.0, 3, DateUtils.createDateWithFormat("2010-08-04", "yyyy-MM-dd"), 1.9, 1.0, true, false);
        Employee employee2 = new Employee(5, "add", "alma", 8.0, 4, DateUtils.createDateWithFormat("2007-07-05", "yyyy-MM-dd"), 2.3, 3.0, true, false);
        Employee employee3 = new Employee(5, "service", "li", 3.0, 8, DateUtils.createDateWithFormat("2013-08-04", "yyyy-MM-dd"), 0.2, 5.0, true, true);

        save(employee0);
        save(employee1);
        save(employee2);
        save(employee3);
    }

}
