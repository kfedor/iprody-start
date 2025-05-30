package lesson47.kfedor.service;

import com.github.kfedor.dto.author.AuthorRequestDto;
import com.github.kfedor.entity.Author;
import com.github.kfedor.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    @Autowired
    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author getById(UUID authorId) {
        return repository.findById(authorId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no author with such id."));
    }

    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    public Author createAuthor(AuthorRequestDto authorToCreate) {
        Author author = new Author();
        author.setName(authorToCreate.getAuthorName());
        author.setBirthdate(authorToCreate.getBirthDate());
        return repository.save(author);
    }

    public Author updateAuthor(UUID authorId, AuthorRequestDto authorToUpdate) {
        Author author = getById(authorId);
        author.setName(authorToUpdate.getAuthorName());
        author.setBirthdate(authorToUpdate.getBirthDate());
       return repository.save(author);
    }

    public void deleteAuthor(UUID id) {
        repository.deleteById(id);
    }
}
