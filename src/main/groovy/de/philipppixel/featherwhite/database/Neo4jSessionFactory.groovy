package de.philipppixel.featherwhite.database

import org.neo4j.ogm.config.ClasspathConfigurationSource
import org.neo4j.ogm.config.Configuration
import org.neo4j.ogm.config.ConfigurationSource
import org.neo4j.ogm.session.Session
import org.neo4j.ogm.session.SessionFactory

enum Neo4jSessionFactory {

    INSTANCE

    private final static SessionFactory sessionFactory = new SessionFactory(buildConfigForPropertyFile(),"de.philipppixel.featherwhite")

    SessionFactory getSession() {
        return sessionFactory
    }

    private static Configuration buildConfigForPropertyFile() {
        ConfigurationSource props = new ClasspathConfigurationSource("ogm.properties")
        return new Configuration.Builder(props).build()
    }
}