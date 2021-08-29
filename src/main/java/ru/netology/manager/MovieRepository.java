package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieRepository {

    private Movie[] movies = new Movie[0];

    public void save(Movie item) {

        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        tmp[tmp.length - 1] = item;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie[] findById(int id) {
        int length = 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                tmp[index] = movie;
                index++;
            }
            movies = tmp;
        }
        return movies;


    }

    public Movie[] removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        return movies = tmp;
    }

    public Movie[] removeAll() {
        Movie[] empty = new Movie[0];
        return empty;
    }

}
