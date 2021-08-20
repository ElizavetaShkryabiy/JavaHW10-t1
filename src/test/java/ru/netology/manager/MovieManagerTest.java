package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    MovieRepository movieRepository = new MovieRepository();
    MovieManager manager = new MovieManager(movieRepository);
    private Movies first = new Movies(1, 1, "first", "Url1", "q", 1);
    private Movies second = new Movies(2, 2, "second", "Url2", "w", 1);
    private Movies third = new Movies(3, 3, "third", "Url3", "e", 2);
    private Movies forth = new Movies(4, 4, "forth", "Url4", "w3", 1);
    private Movies fifth = new Movies(5, 5, "fifth", "Url5", "s", 1);
    private Movies sixth = new Movies(6, 6, "sixth", "Url6", "r", 3);
    private Movies seventh = new Movies(7, 7, "seventh", "Url7", "t", 4);
    private Movies eighth = new Movies(8, 8, "eighth", "Url8", "g", 1);
    private Movies ninth = new Movies(9, 9, "ninth", "Url9", "b", 1);
    private Movies tenth = new Movies(10, 10, "tenth", "Url10", "q", 6);
    private Movies eleventh = new Movies(11, 11, "eleventh", "Url11", "q", 9);


    @BeforeEach
    public void setUp() {

        movieRepository.add(first);
        movieRepository.add(second);
        movieRepository.add(third);
        movieRepository.add(forth);
        movieRepository.add(fifth);
        movieRepository.add(sixth);
        movieRepository.add(seventh);
        movieRepository.add(eighth);
        movieRepository.add(ninth);
        movieRepository.add(tenth);
        movieRepository.add(eleventh);
    }

    @Test
    public void shouldAddMovies() {

        Movies[] actual = manager.getAll();
        Movies[] expected = new Movies[]{eleventh, tenth, ninth, eighth,
                seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLast10Movies() {

        Movies[] actual = manager.getLast();
        Movies[] expected = new Movies[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLast11Movies() {

        Movies[] actual = manager.getLast(11);
        Movies[] expected = new Movies[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLast5Movies() {

        Movies[] actual = manager.getLast(5);
        Movies[] expected = new Movies[]{eleventh, tenth, ninth, eighth, seventh};

        assertArrayEquals(expected, actual);
    }


}