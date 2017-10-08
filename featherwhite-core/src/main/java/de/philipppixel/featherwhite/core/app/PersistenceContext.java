package de.philipppixel.featherwhite.core.app;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.neo4j.ogm.config.Configuration.Builder;

@Configuration
@EnableTransactionManagement
@ComponentScan("de.philipppixel.featherwhite")
@EnableNeo4jRepositories("de.philipppixel.featherwhite.core.repository")
public class PersistenceContext {

    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory(configuration(), "de.philipppixel.featherwhite");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() throws Exception {
        return new Neo4jTransactionManager(getSessionFactory());
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return new Builder()
                .uri("file:///home/pxlphile/IdeaProjects/featherwhite/build/distributions/graphdb")
                .build();
    }
}
