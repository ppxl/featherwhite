package de.philipppixel.featherwhite.core.repository;

import de.philipppixel.featherwhite.core.domain.TextChunk;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;

public interface TextChunkRepository extends Neo4jRepository<TextChunk, Long> {

//    @Query("MATCH(s:StudyBuddy)<-[:BUDDY]-(p:Student) RETURN p, count(s) AS buddies ORDER BY buddies DESC")
//    Iterable<Map<String, Object>> getStudyBuddiesByPopularity();
}
