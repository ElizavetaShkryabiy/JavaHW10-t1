package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movies;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerWithoutBeforeEachTest {

        MovieRepository movieRepository = new MovieRepository();
        MovieManager manager = new MovieManager(movieRepository);
        private Movies first = new Movies(1, 1, "first", "Url1", "q", 1);
        private Movies second = new Movies(2, 2, "second", "Url2", "w", 1);
        private Movies third = new Movies(3, 3, "third", "Url3", "e", 2);
        private Movies forth = new Movies(4, 4, "forth", "Url4", "w3", 1);
        private Movies fifth = new Movies(5, 5, "fifth", "Url5", "s", 1);
        private Movies sixth = new Movies(6, 6, "sixth", "Url6", "r", 3);


        @Test
        public void shouldShowLast10Movies() {
            movieRepository.add(first);
            movieRepository.add(second);
            movieRepository.add(third);
            movieRepository.add(forth);
            movieRepository.add(fifth);

            Movies[] actual = manager.getLast();
            Movies[] expected = new Movies[]{fifth, forth, third, second,first};

            assertArrayEquals(expected, actual);
        }

        @Test
       public void shouldShowLast11Movies() {
            movieRepository.add(first);
            movieRepository.add(second);
            movieRepository.add(third);
            movieRepository.add(forth);
            movieRepository.add(fifth);

            Movies[] actual = manager.getLast(11);
            Movies[] expected = new Movies[]{fifth, forth, third, second, first};

            assertArrayEquals(expected, actual);
        }

    }
