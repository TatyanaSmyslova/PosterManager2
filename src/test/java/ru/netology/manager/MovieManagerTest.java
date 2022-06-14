package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.movie.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    MovieManager manager = new MovieManager();

    private Movie first = new Movie(1, "Бладшот", "http://", "боевик");
    private Movie second = new Movie(2, "Вперёд", "http://", "мультфильм");
    private Movie third = new Movie(3, "Отель Белград", "http://", "комедия");
    private Movie fourth = new Movie(4, "Джентльмены", "http://", "боевик");
    private Movie fifth = new Movie(5, "Человек-невидимка", "http://", "ужасы");
    private Movie sixth = new Movie(6, "Тролли.Мировой тур", "http://", "мультфильм");
    private Movie seventh = new Movie(7, "Номер один", "http://", "комедия");
    private Movie eighth = new Movie(8, "Название фильма1", "http://", "боевик");
    private Movie ninth = new Movie(9, "Название фильма2", "http://", "боевик");
    private Movie tenth = new Movie(10, "Название фильма3", "http://", "боевик");

    Movie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};


    @Test
    void mustShowTenMovie() {
        MovieManager manager = new MovieManager(10);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowNothing() {
        MovieManager manager = new MovieManager(0);
        Movie[] actual = manager.getLastAdd();
        Movie [] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void mustShowValid() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie movieToAdd = new Movie(11, "Название фильма4", "http://", "ужасы");
        manager.addMovie(movieToAdd);
        Movie[] actual = manager.getLastAdd();
        Movie[] expected = {new Movie(11, "Название фильма4", "http://", "ужасы"), tenth, ninth, eighth, seventh};
        assertArrayEquals(expected, actual);

    }

    @Test
    void mustShowOverMax() {
        MovieManager manager = new MovieManager(11);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        Movie[] actual = manager.getLastAdd();
        assertArrayEquals(expected, actual);

    }
}