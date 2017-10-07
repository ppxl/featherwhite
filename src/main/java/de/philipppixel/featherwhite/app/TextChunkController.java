package de.philipppixel.featherwhite.app;

import de.philipppixel.featherwhite.domain.TextChunk;
import de.philipppixel.featherwhite.repository.TextChunkRepository;
import org.neo4j.ogm.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
class TextChunkController {
    private TextChunkRepository textChunkRepository;

    @Autowired
    public TextChunkController(TextChunkRepository textChunkRepository) {
        this.textChunkRepository = textChunkRepository;
    }

    public Iterable<TextChunk> readAll() {
        return textChunkRepository.findAll();
    }

    public TextChunk create(TextChunk textChunk) {
        return textChunkRepository.save(textChunk);
    }

    public TextChunk read(Long id) {
        return textChunkRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void delete(Long id) {
        textChunkRepository.deleteById(id);
    }

    @Transactional
    public TextChunk update(Long id, TextChunk update) {
        final TextChunk existing = textChunkRepository.findById(id).orElseThrow(NotFoundException:: new);
        existing.updateFrom(update);
        return textChunkRepository.save(existing);
    }
}
