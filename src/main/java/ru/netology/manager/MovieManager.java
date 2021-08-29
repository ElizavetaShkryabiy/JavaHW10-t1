package ru.netology.manager;

import ru.netology.domain.Movie;


public class MovieManager {
    private MovieRepository repository;
    private int resultLength;

    public MovieManager(MovieRepository repository, int resultLength) {
        this.repository = repository;
        this.resultLength = resultLength;
    }

    public MovieManager(MovieRepository repository) {
        this.repository = repository;
        resultLength = 10;
    }


    public Movie[] getLast() {

        Movie[] movies = repository.findAll();
        Movie[] result = new Movie[movies.length];
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
        Movie[] last = new Movie[length];
        for (int i = 0; i < last.length; i++) {
            last[i] = result[i];
        }

        return last;
    }


    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = result.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void add(Movie item) {
        repository.save(item);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll(){
        repository.removeAll() ;
    }






}
