package lesson47.kfedor.controller;

import com.github.kfedor.dto.author.AuthorDetailedDto;
import com.github.kfedor.dto.author.AuthorDto;
import com.github.kfedor.dto.author.AuthorRequestDto;
import com.github.kfedor.entity.Author;
import com.github.kfedor.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDto> getAuthors() {
        return authorService.getAllAuthors().stream()
                .map(author -> new AuthorDto(author.getName()))
                .toList();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable(name = "id") UUID id) {
        return authorService.getById(id);
    }

    @PostMapping
    public AuthorDetailedDto createAuthor(@RequestBody AuthorRequestDto authorToCreate) {
        return toAuthorDetailedDto(authorService.createAuthor(authorToCreate));
    }

    @PutMapping("/{id}")
    public AuthorDetailedDto updateAuthor(@PathVariable(name = "id") UUID id, @RequestBody AuthorRequestDto authorToUpdate) {
        return toAuthorDetailedDto(authorService.updateAuthor(id, authorToUpdate));
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable(name = "id") UUID id) {
        authorService.deleteAuthor(id);
    }

    private AuthorDetailedDto toAuthorDetailedDto(Author author) {
        return new AuthorDetailedDto(author.getId(), author.getName(), author.getBirthdate());
    }
}
