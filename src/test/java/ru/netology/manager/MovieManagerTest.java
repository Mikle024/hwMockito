package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    MovieManager manager = new MovieManager();

    @Test
    public void findAllIfNoMoviesTest() {

        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addMovieTest() {

        manager.addMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addSeveralMovieTest() {

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель \"Белград\"");

        String[] expected = {"Бладшот", "Вперёд", "Отель \"Белград\""};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastTest() {
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель \"Белград\"");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");

        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентльмены", "Отель \"Белград\""};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastIfMoviesBelowLimitTest() {
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель \"Белград\"");


        String[] expected = {"Отель \"Белград\"", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastSetLimitTest() {
        MovieManager manager = new MovieManager(2);
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель \"Белград\"");


        String[] expected = {"Отель \"Белград\"", "Вперёд"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
