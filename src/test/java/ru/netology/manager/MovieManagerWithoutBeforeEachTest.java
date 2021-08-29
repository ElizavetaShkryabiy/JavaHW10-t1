package ru.netology.manager;

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


public class MovieManagerWithoutBeforeEachTest {
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


        @Test
        public void shouldShowLast10Movies() {
            movieRepository.save(first);
            movieRepository.save(second);
            movieRepository.save(third);
            movieRepository.save(forth);
            movieRepository.save(fifth);
            Movie [] returned = new Movie[] {first,second,third,forth,fifth};
            doReturn(returned).when(movieRepository).findAll();

            Movie[] actual = manager.getLast();
            Movie[] expected = new Movie[]{fifth, forth, third, second,first};

            assertArrayEquals(expected, actual);
        }

        @Test
       public void shouldShowLast11Movies() {
            movieRepository.save(first);
            movieRepository.save(second);
            movieRepository.save(third);
            movieRepository.save(forth);
            movieRepository.save(fifth);
            Movie [] returned = new Movie[] {first,second,third,forth,fifth};
            doReturn(returned).when(movieRepository).findAll();

            Movie[] actual = manager.getLast(11);
            Movie[] expected = new Movie[]{fifth, forth, third, second, first};

            assertArrayEquals(expected, actual);
        }

    }
