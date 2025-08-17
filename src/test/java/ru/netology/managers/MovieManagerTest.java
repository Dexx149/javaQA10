package ru.netology.managers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    @Test
    void shouldAddMovieAndReturnAll() {
        MovieManager manager = new MovieManager();
        manager.add("Бладшот");
        manager.add("Вперед");

        String[] expected = {"Бладшот", "Вперед"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Отель Белград");
        manager.add("Джентельмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли");

        String[] expected = {"Тролли", "Человек-невидимка", "Джентельмены", "Отель Белград", "Вперед"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldFindLastCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.add("Бладшот");
        manager.add("Вперед");
        manager.add("Отель Белград");
        manager.add("Джентельмены");

        String[] expected = {"Джентельмены", "Отель Белград", "Вперед"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldFindLastWhenLessThanLimit() {
        MovieManager manager = new MovieManager(5);
        manager.add("Бладшот");
        manager.add("Вперед");

        String[] expected = {"Вперед", "Бладшот"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void ShouldFindLastWhenEmpty() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        assertArrayEquals(expected, manager.findLast());
    }

}
