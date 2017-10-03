package de.philipppixel.featherwhite.domain

import org.neo4j.ogm.annotation.NodeEntity
import org.neo4j.ogm.annotation.Relationship

@NodeEntity
class TextChunk extends Entity {
    private String content
    private String contentAbstract

    @Relationship(type="ANCESTOR", direction="OUTGOING")
    private Set<TextChunk> parentTextChunks
    @Relationship(type="SUCCESSOR", direction="OUTGOING")
    private Set<TextChunk> childTextChunks
    private String chunkHash

    TextChunk() {
    }

    @Override
    String toString() {
        return contentAbstract
    }
}
