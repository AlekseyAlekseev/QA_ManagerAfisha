package ru.netology.repository;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Film;

@Data
@NoArgsConstructor
public class AfishaRepository {

    private Film[] films = new Film[0];

    /**
     * добавляет объект в массив
     * @param film фильм
     */
    public void save(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    /**
     * @return возвращает массив всех хранящихся в массиве объектов
     */
    public Film[] findAll() {
        return films;
    }

    /**
     * @return возвращает объект по идентификатору (либо null, если такого объекта нет)
     */
    public Film findById(int id) {
        for (Film film : films) {
            if (film.getId() == id) {
                return film;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = films.length - 1;
        Film[] tmp = new Film[length];
        int index = 0;
        for (Film film : films) {
            if (film.getId() != id) {
                tmp[index] = film;
                index++;
            }
        }
        films = tmp;
    }

    public void removeAll() {
        films = new Film[0];
    }


}
