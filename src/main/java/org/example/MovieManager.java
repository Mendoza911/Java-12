package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MovieManager {
    private Movie[] items = new Movie[0];
    int lastMovies = 5;

    public MovieManager(int lastMovies) {
        this.lastMovies = lastMovies;
    }

    public MovieManager() {
    }

    public void save(Movie item) {
        Movie[] tmp = new Movie[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Movie[] findAll() {
        return items;
    }

    public Movie[] findLast() {
        int tmplm = Math.min(items.length, lastMovies);
        Movie[] lastItems = new Movie[tmplm];
        for (int i = 0; i < tmplm; i++) {
            lastItems[i] = items[items.length - 1 - i];
        }

        return lastItems;
    }


}
