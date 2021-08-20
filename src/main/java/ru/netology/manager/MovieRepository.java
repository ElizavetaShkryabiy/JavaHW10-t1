package ru.netology.manager;

import ru.netology.domain.Movies;

public class MovieRepository {

    private Movies[] movies = new Movies[0];

    public void add(Movies item) {

        int length = movies.length + 1;
        Movies[] tmp = new Movies[length];

        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        tmp[tmp.length - 1] = item;
        movies = tmp;
    }

    public Movies[] getAll() {
        return movies;
    }

}
