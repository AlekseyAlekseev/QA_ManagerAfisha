package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class AfishaManagerTest {


    private AfishaRepository repository = Mockito.mock(AfishaRepository.class);

    private AfishaManager manager = new AfishaManager(repository);
    private Film bladShot = new Film(6, "Бладшот", "Боевик", 2020);
    private Film forward = new Film(3, "Вперёд", "Мультфильм", 2020);
    private Film hotelBelgrad = new Film(17, "Отель Белград", "Комедия", 2020);
    private Film gentlemen = new Film(183, "Джентельмены", "Боевик", 2019);


    @Test
    void shouldSaveAndGetAllFilm() {
        Film[] returned = {hotelBelgrad, gentlemen};
        doReturn(returned).when(repository).findAll();

        manager.addFilm(hotelBelgrad);
        manager.addFilm(gentlemen);
        Film[] expected = {gentlemen, hotelBelgrad};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).findAll();

    }

    @Test
    void shouldFindById() {
        Film returned = forward;
        doReturn(returned).when(repository).findById(3);

        Film expected = forward;
        Film actual = manager.findById(3);
        assertEquals(expected, actual);

        verify(repository).findById(3);
    }

    @Test
    void shouldFindByInvalidId() {
        doReturn(null).when(repository).findById(150);
        Film actual = manager.findById(100);
        assertNull(actual);
        verify(repository).findById(100);
    }

    @Test
    void shouldRemoveById() {
        Film[] returned = {bladShot, gentlemen};
        doReturn(returned).when(repository).findAll();

        manager.addFilm(bladShot);
        manager.addFilm(hotelBelgrad);
        manager.addFilm(gentlemen);

        manager.removeById(17);
        Film[] expected = {gentlemen, bladShot};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeById(17);
    }

    @Test
    void shouldRemoveAll() {
        Film[] returned = {};
        doReturn(returned).when(repository).findAll();

        manager.addFilm(bladShot);
        manager.addFilm(hotelBelgrad);
        manager.addFilm(gentlemen);

        manager.removeAll();

        Film[] expected = {};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

        verify(repository).removeAll();
    }
}