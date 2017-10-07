package de.philipppixel.featherwhite.app;

import de.philipppixel.featherwhite.domain.TextChunk;
import de.philipppixel.featherwhite.repository.TextChunkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.System.exit;

@Component
public class TextChunkService {
    @Autowired
    TextChunkRepository repo;


    public void doSomething() {

        Iterable<TextChunk> result = matchAllChunks();
        printResult(result);

        appendChunk("Guten Tag\n\nMein Name ist sowieso und ich regiere hier.");
        result = matchAllChunks();
        printResult(result);

        exit(0);
    }

    private void appendChunk(String content) {
        TextChunk chunk = new TextChunk();
        chunk.setContent(content);
        chunk.setContentAbstract(content);
        repo.save(chunk);

    }

    private Iterable<TextChunk> matchAllChunks() {
        return repo.findAll();
    }

    static void printResult(Iterable<TextChunk> result) {
        System.out.println("print result for " + result);
        for (TextChunk thing : result) {
            System.out.printf("Key: %s", thing);
        }
    }
}
