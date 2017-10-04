package de.philipppixel.featherwhite.app

import de.philipppixel.featherwhite.database.Neo4jSessionFactory
import de.philipppixel.featherwhite.domain.TextChunk
import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.factory.GraphDatabaseFactory
import org.neo4j.ogm.config.ClasspathConfigurationSource
import org.neo4j.ogm.config.Configuration
import org.neo4j.ogm.config.ConfigurationSource
import org.neo4j.ogm.transaction.Transaction

class FeatherWhite {

    static void main(String[] args) {
        new FeatherWhite()
    }

    FeatherWhite() {
        def DB_PATH = "/home/pxlphile/IdeaProjects/featherwhite/build/distributions/featherwhite/db"
        GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(new File(DB_PATH))

        registerShutdownHook(graphDb)

        Iterable<TextChunk> result = matchAllChunks()
        printResult(result)

        appendChunk("Guten Tag\n\nMein Name ist sowieso und ich regiere hier.")
        result = matchAllChunks()
        printResult(result)
    }

    private void appendChunk(String content) {
        def session = Neo4jSessionFactory.INSTANCE.getSession().openSession()
        Transaction tx = session.beginTransaction()

        def chunk = new TextChunk()
        chunk.setContent(content)
        chunk.setContentAbstract(content)
        session.save(chunk)

        tx.commit()
        tx.close()
    }

    private Iterable<TextChunk> matchAllChunks() {
        def session = Neo4jSessionFactory.INSTANCE.getSession().openSession()
        String query = "MATCH (root:TextChunk)" +
//                "<-[:ANCESTOR *0..]-(child:TextChunk)" +
                " return root"
        session.query(TextChunk.class, query, Collections.EMPTY_MAP)
    }

    static void printResult(Iterable<TextChunk> result) {
        println "print result for " + result
        for (TextChunk thing : result) {
            printf("Key: %s", thing)
        }
    }

    /**
     * Registers a shutdown hook for the Neo4j instance so that it
     * shuts down nicely when the VM exits (even if you "Ctrl-C" the
     * running application).
     */
    static void registerShutdownHook(final GraphDatabaseService graphDb) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            void run() {
                graphDb.shutdown()
            }
        })
    }
}
