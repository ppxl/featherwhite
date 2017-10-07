package de.philipppixel.featherwhite.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

@NodeEntity
public class TextChunk extends Entity {
    private String content;
    private String contentAbstract;

    @Relationship(type = "ANCESTOR", direction = "OUTGOING")
    private Set<TextChunk> parentTextChunks;
    @Relationship(type = "SUCCESSOR", direction = "OUTGOING")
    private Set<TextChunk> childTextChunks;

    public TextChunk() {
    }

    String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String getContentAbstract() {
        return contentAbstract;
    }

    public void setContentAbstract(String contentAbstract) {
        this.contentAbstract = contentAbstract;
    }

    public void updateFrom(TextChunk update) {
        this.content = update.content;
        this.contentAbstract = update.contentAbstract;
        this.parentTextChunks = update.parentTextChunks;
        this.childTextChunks = update.childTextChunks;
    }

    @Override
    public String toString() {
        return "@" + super.getId() + ": " + contentAbstract;
    }
}
