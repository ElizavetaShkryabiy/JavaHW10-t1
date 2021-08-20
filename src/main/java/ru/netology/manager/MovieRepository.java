package ru.netology.manager;

import ru.netology.domain.Movies;

public class MovieRepository {

    private Movies[] movies = new Movies[0];

    public void save(Movies item) {

        int length = movies.length + 1;
        Movies[] tmp = new Movies[length];

        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        tmp[tmp.length - 1] = item;
        movies = tmp;
    }

    public Movies[] findAll() {
        return movies;
    }

    public Movies[] findById(int id) {
        int length = 1;
        Movies[] tmp = new Movies[length];
        int index = 0;
        for (Movies movie : movies) {
            if (movie.getId() == id) {
                tmp[index] = movie;
                index++;
            }
            movies = tmp;
        }
        return movies;


    }

    public Movies[] removeById(int id) {
        int length = movies.length - 1;
        Movies[] tmp = new Movies[length];
        int index = 0;
        for (Movies movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        return movies = tmp;
    }

    public Movies[] removeAll() {
        Movies[] empty = new Movies[0];
        return empty;
    }

}
