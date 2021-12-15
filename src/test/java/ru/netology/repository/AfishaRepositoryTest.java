package ru.netology.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {

    private AfishaRepository filmRepository = new AfishaRepository();

    private Film bladShot = new Film(6, "Бладшот", "Боевик", 2020);
    private Film forward = new Film(3, "Вперёд", "Мультфильм", 2020);
    private Film hotelBelgrad = new Film(17, "Отель Белград", "Комедия", 2020);

    @Test
    void shouldAddFilm() {
        filmRepository.save(forward);
        Film[] expected = {forward};
        Film[] actual = filmRepository.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllFilms() {
        filmRepository.save(bladShot);
        Film[] expected = {bladShot};
        Film[] actual = filmRepository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByValidId() {
        Film[] films = {bladShot, forward, hotelBelgrad};
        for (Film film : films) {
            filmRepository.save(film);
        }
        Film expected = hotelBelgrad;
        Film actual = filmRepository.findById(17);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByInvalidId() {
        Film actual = filmRepository.findById(100);
        assertNull(actual);
    }

    @Test
    void shouldRemoveById() {
        Film[] films = {bladShot, forward, hotelBelgrad};
        for (Film film : films) {
            filmRepository.save(film);
        }
        filmRepository.removeById(6);
        Film[] expected = {forward, hotelBelgrad};
        Film[] actual = filmRepository.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        filmRepository.removeAll();
        Film[] expected = {};
        Film[] actual = filmRepository.getFilms();
        assertArrayEquals(expected, actual);
    }

}