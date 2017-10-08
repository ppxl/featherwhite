package de.philipppixel.featherwhite.core.app;

import de.philipppixel.featherwhite.core.domain.Note;
import org.springframework.data.repository.CrudRepository;

interface NoteRepository extends CrudRepository<Note, Long> {
}
