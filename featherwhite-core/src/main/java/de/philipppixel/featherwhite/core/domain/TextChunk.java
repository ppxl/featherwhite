package de.philipppixel.featherwhite.core.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class TextChunk extends Entity {
    private String content;
    private String title;

    @Relationship(type = "ANCESTOR", direction = "OUTGOING")
    private Set<TextChunk> parentTextChunks = new HashSet<>();
    @Relationship(type = "SUCCESSOR", direction = "OUTGOING")
    private Set<TextChunk> childTextChunks = new HashSet<>();

    public TextChunk() {
    }

    public TextChunk(String content, String title) {
        setContent(content);
        setTitle(title);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<TextChunk> getParentTextChunks() {
        return parentTextChunks;
    }

    public void setParentTextChunks(Set<TextChunk> parentTextChunks) {
        this.parentTextChunks = parentTextChunks;
    }

    public Set<TextChunk> getChildTextChunks() {
        return childTextChunks;
    }

    public void setChildTextChunks(Set<TextChunk> childTextChunks) {
        this.childTextChunks = childTextChunks;
    }

    public void updateFrom(TextChunk update) {
        this.content = update.content;
        this.title = update.title;
        this.parentTextChunks = update.parentTextChunks;
        this.childTextChunks = update.childTextChunks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TextChunk textChunk = (TextChunk) o;

        return content.equals(textChunk.content);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return 31 * result + content.hashCode();
    }

    @Override
    public String toString() {
        String result = "@" + super.getId() + ": " + title;
        if (childTextChunks != null) {
            for (TextChunk childTextChunk : childTextChunks) {
                result += childTextChunk.toString();
            }
        }
        return result;
    }
}
