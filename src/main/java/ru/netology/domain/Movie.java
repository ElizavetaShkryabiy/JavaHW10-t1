package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public class Movie {
        private int id;
        private int movieId;
        private String movieName;
        private String imageUrl;
        private String genre;
        private int premier;


    }


