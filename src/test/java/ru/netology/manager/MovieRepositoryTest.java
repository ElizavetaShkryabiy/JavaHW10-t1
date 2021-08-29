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
        movieRepository.add(first);
        movieRepository.add(second);
        movieRepository.add(third);
        movieRepository.add(forth);
        movieRepository.add(fifth);
        Movie[] actual = movieRepository.getAll();
        Movie[] expected = new Movie[]{first, second, third, forth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNotAllMoviesToRepository() {
        movieRepository.add(first);
        movieRepository.add(second);
        movieRepository.add(third);
        Movie[] actual = movieRepository.getAll();
        Movie[] expected = new Movie[]{first, second, third};
        assertArrayEquals(expected, actual);
    }
}
