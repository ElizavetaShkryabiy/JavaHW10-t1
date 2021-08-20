package ru.netology.manager;

import ru.netology.domain.Movies;


public class MovieManager {
    private MovieRepository repository;

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    private int resultLength;


    public Movies[] getLast() {
        int resultLength = 10;
        Movies[] movies = repository.getAll();
        Movies[] result = new Movies[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = result.length - i - 1;
            result[i] = movies[index];
        }
        int length;
        if (result.length < resultLength) {
            length = result.length;
        } else {
            length = resultLength;
        }
        Movies[] last = new Movies[length];
        for (int i = 0; i < last.length; i++) {
            last[i] = result[i];
        }

        return last;
    }

    public Movies[] getLast(int resultLength) {
        Movies[] movies = repository.getAll();
        Movies[] result = new Movies[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = result.length - i - 1;
            result[i] = movies[index];
        }
        int length;
        if (result.length < resultLength) {
            length = result.length;
        } else {
            length = resultLength;
        }
        Movies[] last = new Movies[length];
        for (int i = 0; i < last.length; i++) {
            last[i] = result[i];
        }

        return last;
    }

    public Movies[] getAll() {
        Movies[] movies = repository.getAll();
        Movies[] result = new Movies[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = result.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

}
