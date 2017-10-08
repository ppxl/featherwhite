package de.philipppixel.featherwhite.core.app;

import de.philipppixel.featherwhite.core.domain.TextChunk;
import de.philipppixel.featherwhite.core.repository.TextChunkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.System.exit;

@Component
public class TextChunkServiceImpl implements TextChunkService {
    @Autowired
    private TextChunkRepository repo;

    public void doSomething() {

        Iterable<TextChunk> result = matchAllChunks();
        printResult(result, "EMPTY set");

        TextChunk chunk = new TextChunk("Guten Tag\n\nMein Name ist sowieso und ich regiere hier.", "Guten Tag");
        repo.save(chunk);
        TextChunk chunk1 = new TextChunk("Guten Abend", "Guten Abend");
        chunk.getChildTextChunks().add(chunk1);
        result = matchAllChunks();
        printResult(result, "in between");
        repo.save(chunk);

        result = matchAllChunks();
        printResult(result, "after save");

        exit(0);
    }

    private Iterable<TextChunk> matchAllChunks() {
        return repo.findAll();
    }

    static void printResult(Iterable<TextChunk> result, String comment) {
        System.out.println("==== print result for " + result + " ==== " + comment);
        for (TextChunk thing : result) {
            System.out.printf("Key: %s", thing);
        }
    }
}
