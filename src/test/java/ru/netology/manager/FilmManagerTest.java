package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {

    Film bladShot = new Film(6, "Бладшот", "Боевик", 2020);
    Film forward = new Film(3, "Вперёд", "Мультфильм", 2020);
    Film hotelBelgrad = new Film(17, "Отель Белград", "Комедия", 2020);
    Film gentlemen = new Film(183, "Джентельмены", "Боевик", 2019);
    Film invisibleMan = new Film(28, "Человек-невидимка", "Ужасы", 2020);
    Film fastAndTheFurious = new Film(2, "Форсаж", "Боевик", 2001);
    Film numberOne = new Film(20, "Номер один", "Комедия", 2020);


    FilmManager filmManager = new FilmManager();

    @Test
    void shouldGetDefaultNumberOfFilms() {
        int expected = 10;
        int actual = filmManager.getResultLengthFilms();
        assertEquals(expected, actual);
    }

    @Test
    void shouldChangeTheDefaultNumberOfFilms() {
        FilmManager filmManager = new FilmManager(5);
        int expected = 5;
        int actual = filmManager.getResultLengthFilms();
        assertEquals(expected, actual);
    }

    @Test
    void shouldAddFilm() {
        filmManager.addFilm(bladShot);
        Film[] expected = {bladShot};
        Film[] actual = filmManager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllFilmsLessThan10() {
        Film[] films = {bladShot, forward, hotelBelgrad, gentlemen, invisibleMan, fastAndTheFurious, numberOne};
        for (Film film : films) {
            filmManager.addFilm(film);
        }
        Film[] expected = {numberOne, fastAndTheFurious, invisibleMan, gentlemen, hotelBelgrad, forward, bladShot};
        Film[] actual = filmManager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllFilmsMoreThan10() {
        Film[] films = {bladShot, forward, hotelBelgrad, gentlemen, invisibleMan, fastAndTheFurious, numberOne,
                bladShot, forward, hotelBelgrad, gentlemen, invisibleMan, fastAndTheFurious, numberOne};
        for (Film film : films) {
            filmManager.addFilm(film);
        }
        Film[] expected = {numberOne, fastAndTheFurious, invisibleMan, gentlemen, hotelBelgrad, forward, bladShot,
                numberOne, fastAndTheFurious, invisibleMan};
        Film[] actual = filmManager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAllFilmsExactly10() {
        Film[] films = {bladShot, forward, hotelBelgrad, gentlemen, invisibleMan, fastAndTheFurious, numberOne,
                bladShot, forward, hotelBelgrad};
        for (Film film : films) {
            filmManager.addFilm(film);
        }
        Film[] expected = {hotelBelgrad, forward, bladShot, numberOne, fastAndTheFurious, invisibleMan, gentlemen,
                hotelBelgrad, forward, bladShot};
        Film[] actual = filmManager.getAll();
        assertArrayEquals(expected, actual);
    }
}