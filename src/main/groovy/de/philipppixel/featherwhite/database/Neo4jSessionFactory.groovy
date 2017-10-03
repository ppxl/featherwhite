package de.philipppixel.featherwhite.database

import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory

class Neo4jSessionFactory {

    private final static SessionFactory sessionFactory = new SessionFactory("de.philipppixel.featherwhite");
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();

    static Neo4jSessionFactory getInstance() {
        return factory;
    }

    // prevent external instantiation
    private Neo4jSessionFactory() {
    }

    Session getNeo4jSession() {
        return sessionFactory.openSession();
    }
}