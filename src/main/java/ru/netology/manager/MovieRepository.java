package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieRepository {

    private Movie[] movies = new Movie[0];

    public void add(Movie item) {

        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        tmp[tmp.length - 1] = item;
        movies = tmp;
    }

    public Movie[] getAll() {
        return movies;
    }

}
