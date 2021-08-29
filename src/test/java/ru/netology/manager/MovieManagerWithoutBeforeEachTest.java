package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerWithoutBeforeEachTest {

        MovieRepository movieRepository = new MovieRepository();
        MovieManager manager = new MovieManager(movieRepository);
        private Movie first = new Movie(1, 1, "first", "Url1", "q", 1);
        private Movie second = new Movie(2, 2, "second", "Url2", "w", 1);
        private Movie third = new Movie(3, 3, "third", "Url3", "e", 2);
        private Movie forth = new Movie(4, 4, "forth", "Url4", "w3", 1);
        private Movie fifth = new Movie(5, 5, "fifth", "Url5", "s", 1);
        private Movie sixth = new Movie(6, 6, "sixth", "Url6", "r", 3);


        @Test
        public void shouldShowLast10Movies() {
            movieRepository.add(first);
            movieRepository.add(second);
            movieRepository.add(third);
            movieRepository.add(forth);
            movieRepository.add(fifth);

            Movie[] actual = manager.getLast();
            Movie[] expected = new Movie[]{fifth, forth, third, second,first};

            assertArrayEquals(expected, actual);
        }

        @Test
       public void shouldShowLast11Movies() {
            movieRepository.add(first);
            movieRepository.add(second);
            movieRepository.add(third);
            movieRepository.add(forth);
            movieRepository.add(fifth);
            MovieManager manager = new MovieManager(movieRepository, 11);

            Movie[] actual = manager.getLast();
            Movie[] expected = new Movie[]{fifth, forth, third, second, first};

            assertArrayEquals(expected, actual);
        }

    }
