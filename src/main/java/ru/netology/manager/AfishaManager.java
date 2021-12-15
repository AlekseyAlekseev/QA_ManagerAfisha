package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;
import ru.netology.repository.AfishaRepository;

@Data
@NoArgsConstructor
public class AfishaManager {

    private AfishaRepository filmRepository;

    public AfishaManager(AfishaRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void addFilm(Film film) {
        filmRepository.save(film);
    }

    public Film[] getAll() {
        Film[] films = filmRepository.findAll();
        Film[] result = new Film[films.length];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }

    public Film findById(int id) {
        return filmRepository.findById(id);
    }

    public void removeById(int id) {
        filmRepository.removeById(id);
    }

    public void removeAll() {
        filmRepository.removeAll();
    }
}
