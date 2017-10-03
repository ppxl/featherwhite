package de.philipppixel.featherwhite.app

import de.philipppixel.featherwhite.database.Neo4jSessionFactory
import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.factory.GraphDatabaseFactory
import org.neo4j.graphdb.Result
import org.neo4j.ogm.model.Result
import org.neo4j.ogm.session.Session
import java.io.File

public class FeatherWhite {

    public static void main(String[] args) {
        def DB_PATH = "./featherwhite.db"
        def graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(new File(DB_PATH))
        registerShutdownHook(graphDb);

        Session session = Neo4jSessionFactory.getInstance().getNeo4jSession()

        String query = "MATCH (root:TextChunk)<-[:ANCESTOR *1..]-(child:TextChunk) return root"
        Result result = Neo4jSessionFactory.getInstance().getNeo4jSession().query(query, Collections.EMPTY_MAP)

        printResult(result)
    }

    static void printResult(Result result) {
        println(result)
    }

    private static void registerShutdownHook(final GraphDatabaseService graphDb) {
        // Registers a shutdown hook for the Neo4j instance so that it
        // shuts down nicely when the VM exits (even if you "Ctrl-C" the
        // running application).
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                graphDb.shutdown();
            }
        });
    }
}
