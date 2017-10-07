package de.philipppixel.featherwhite.app;

import de.philipppixel.featherwhite.domain.Note;
import org.springframework.data.repository.CrudRepository;

interface NoteRepository extends CrudRepository<Note, Long> {
}
