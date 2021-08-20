package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class MovieRepositoryTest {
    MovieRepository movieRepository = new MovieRepository();
    MovieManager manager = new MovieManager(movieRepository);
    private Movies first = new Movies(1, 1, "first", "Url1", "q", 1);
    private Movies second = new Movies(2, 2, "second", "Url2", "w", 1);
    private Movies third = new Movies(3, 3, "third", "Url3", "e", 2);
    private Movies forth = new Movies(4, 4, "forth", "Url4", "w3", 1);
    private Movies fifth = new Movies(5, 5, "fifth", "Url5", "s", 1);

    @Test
    public void shouldAddMoviesToRepository() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        movieRepository.save(forth);
        movieRepository.save(fifth);
        Movies[] actual = movieRepository.findAll();
        Movies[] expected = new Movies[]{first, second, third, forth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNotAllMoviesToRepository() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        Movies[] actual = movieRepository.findAll();
        Movies[] expected = new Movies[]{first, second, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        Movies[] actual = movieRepository.findById(3);
        Movies[] expected = new Movies[]{third};
        assertArrayEquals(expected, actual);
    }


//    @Test
//    public void shouldFindByNotExistingId() {
//        movieRepository.save(first);
//        movieRepository.save(second);
//        movieRepository.save(third);
//        Movies[] actual = movieRepository.findById(6);
//        Movies[] expected = new Movies[]{null};
//        assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldRemoveById() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        movieRepository.save(forth);
        movieRepository.save(fifth);
        Movies[] actual = movieRepository.removeById(1);
        Movies[] expected = new Movies[]{second, third, forth, fifth};
        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldRemoveByNotExistingId() {
//        movieRepository.save(first);
//        movieRepository.save(second);
//        movieRepository.save(third);
//        movieRepository.save(forth);
//        movieRepository.save(fifth);
//        Movies[] actual = movieRepository.removeById(6);
//        Movies[] expected = new Movies[]{null};
//        assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldRemoveAll() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        movieRepository.save(forth);
        movieRepository.save(fifth);
        Movies[] actual = movieRepository.removeAll();
        Movies[] expected = new Movies[]{};
        assertArrayEquals(expected, actual);
    }

}
