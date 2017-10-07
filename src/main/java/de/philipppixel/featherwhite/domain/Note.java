package de.philipppixel.featherwhite.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Note extends Entity {
    private String content;

    @Relationship(type = "DENOTES", direction = "OUTGOING")
    private TextChunk textChunk;

    Note() {
    }

    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }

    void setTextChunk(TextChunk textChunk) {
        this.textChunk = textChunk;
    }

    void updateFrom(Note update) {
        this.content = update.content;
        this.textChunk = update.textChunk;
    }

    @Override
    public String toString() {
        return "Note@" + super.getId() + ": " + content;
    }
}
