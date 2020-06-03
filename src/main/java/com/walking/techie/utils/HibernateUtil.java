package com.walking.techie.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
  public static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {
    try {
      StandardServiceRegistry standardRegistry =
          new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
      Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
      return metadata.getSessionFactoryBuilder().build();
    } catch (Exception ex) {
      System.err.println("Initial session factory creation failed: " + ex.getMessage());
      throw new ExceptionInInitializerError();
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
