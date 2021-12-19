package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@Data
@NoArgsConstructor
public class FilmManager {

    private Film[] films = new Film[0];

    public FilmManager(int resultLengthFilms) {
        this.resultLengthFilms = resultLengthFilms;
    }

    private int resultLengthFilms = 10;

    public void addFilm(Film film) {

        int length = films.length + 1;
        Film[] tmp = new Film[length];

        System.arraycopy(films, 0, tmp, 0, films.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Film[] getAll() {
        if (films.length <= getResultLengthFilms()) {
            resultLengthFilms = films.length;
        } else {
            resultLengthFilms = getResultLengthFilms();
        }
        Film[] result = new Film[resultLengthFilms];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;
            result[i] = films[index];
        }
        return result;
    }
}
