package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class MovieRepositoryTest {
    MovieRepository movieRepository = new MovieRepository();
    MovieManager manager = new MovieManager(movieRepository);
    private Movie first = new Movie(1, 1, "first", "Url1", "q", 1);
    private Movie second = new Movie(2, 2, "second", "Url2", "w", 1);
    private Movie third = new Movie(3, 3, "third", "Url3", "e", 2);
    private Movie forth = new Movie(4, 4, "forth", "Url4", "w3", 1);
    private Movie fifth = new Movie(5, 5, "fifth", "Url5", "s", 1);

    @Test
    public void shouldAddMoviesToRepository() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        movieRepository.save(forth);
        movieRepository.save(fifth);
        Movie[] actual = movieRepository.findAll();
        Movie[] expected = new Movie[]{first, second, third, forth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNotAllMoviesToRepository() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        Movie[] actual = movieRepository.findAll();
        Movie[] expected = new Movie[]{first, second, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        Movie[] actual = movieRepository.findById(3);
        Movie[] expected = new Movie[]{third};
        assertArrayEquals(expected, actual);
    }


//    @Test
//    public void shouldFindByNotExistingId() {
//        movieRepository.save(first);
//        movieRepository.save(second);
//        movieRepository.save(third);
//        Movie[] actual = movieRepository.findById(6);
//        Movie[] expected = new Movie[]{null};
//        assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldRemoveById() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        movieRepository.save(forth);
        movieRepository.save(fifth);
        Movie[] actual = movieRepository.removeById(1);
        Movie[] expected = new Movie[]{second, third, forth, fifth};
        assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldRemoveByNotExistingId() {
//        movieRepository.save(first);
//        movieRepository.save(second);
//        movieRepository.save(third);
//        movieRepository.save(forth);
//        movieRepository.save(fifth);
//        Movie[] actual = movieRepository.removeById(6);
//        Movie[] expected = new Movie[]{null};
//        assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldRemoveAll() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        movieRepository.save(forth);
        movieRepository.save(fifth);
        Movie[] actual = movieRepository.removeAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }

}
