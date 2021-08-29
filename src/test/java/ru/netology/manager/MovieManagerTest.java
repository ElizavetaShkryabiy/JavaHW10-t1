package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)

public class MovieManagerTest {
    @Mock
    MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
    @InjectMocks
    MovieManager manager = new MovieManager(movieRepository);
    private Movie first = new Movie(1, 1, "first", "Url1", "q", 1);
    private Movie second = new Movie(2, 2, "second", "Url2", "w", 1);
    private Movie third = new Movie(3, 3, "third", "Url3", "e", 2);
    private Movie forth = new Movie(4, 4, "forth", "Url4", "w3", 1);
    private Movie fifth = new Movie(5, 5, "fifth", "Url5", "s", 1);
    private Movie sixth = new Movie(6, 6, "sixth", "Url6", "r", 3);
    private Movie seventh = new Movie(7, 7, "seventh", "Url7", "t", 4);
    private Movie eighth = new Movie(8, 8, "eighth", "Url8", "g", 1);
    private Movie ninth = new Movie(9, 9, "ninth", "Url9", "b", 1);
    private Movie tenth = new Movie(10, 10, "tenth", "Url10", "q", 6);
    private Movie eleventh = new Movie(11, 11, "eleventh", "Url11", "q", 9);


    @BeforeEach
    public void setUp() {
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        movieRepository.save(forth);
        movieRepository.save(fifth);
        movieRepository.save(sixth);
        movieRepository.save(seventh);
        movieRepository.save(eighth);
        movieRepository.save(ninth);
        movieRepository.save(tenth);
        movieRepository.save(eleventh);
        Movie [] returned = new Movie[] {first,second,third,forth,fifth,sixth,seventh,
                eighth,ninth,tenth,eleventh};
        doReturn(returned).when(movieRepository).findAll();
    }

    @Test
    public void shouldAddMovies() {

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth,
                seventh, sixth, fifth, forth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLast10Movies() {

        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLast11Movies() {

        MovieManager manager = new MovieManager(movieRepository, 11);

        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLast5Movies() {
        MovieManager manager = new MovieManager(movieRepository, 5);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldShowLast10MoviesWithResultLengh() {
        MovieManager manager = new MovieManager(movieRepository, 10);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, forth, third, second};

        assertArrayEquals(expected, actual);
    }

}