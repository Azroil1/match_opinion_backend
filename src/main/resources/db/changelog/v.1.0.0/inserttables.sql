-- Создание расширения uuid-ossp для генерации UUID
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Наполнение таблиц с базовыми данными
INSERT INTO "genre" ("id", "genre") VALUES
                                        (6, 'Драма'),
                                        (2, 'Комедия'),
                                        (3, 'Триллер'),
                                        (4, 'Мелодрама'),
                                        (5, 'Фантастика'),
                                        (7, 'Боевик'),
                                        (8, 'Приключения'),
                                        (9, 'Мультфильм'),
                                        (10, 'Детектив');

INSERT INTO "country" ("id", "country") VALUES
                                            (1, 'Россия'),
                                            (2, 'США'),
                                            (3, 'Франция'),
                                            (4, 'Великобритания'),
                                            (5, 'Германия'),
                                            (6, 'Италия'),
                                            (7, 'Испания'),
                                            (8, 'Япония'),
                                            (9, 'Китай'),
                                            (10, 'Южная Корея');

-- Наполнение таблицы актеров
INSERT INTO "actors" ("id", "last_name", "name", "surname") VALUES
                                                                (uuid_generate_v4(), 'ДиКаприо', 'Леонардо', ''),
                                                                (uuid_generate_v4(), 'Депп', 'Джонни', ''),
                                                                (uuid_generate_v4(), 'Хабенский', 'Константин', ''),
                                                                (uuid_generate_v4(), 'Йоханссон', 'Скарлетт', ''),
                                                                (uuid_generate_v4(), 'Круз', 'Том', ''),
                                                                (uuid_generate_v4(), 'Робертс', 'Джулия', ''),
                                                                (uuid_generate_v4(), 'Питт', 'Брэд', ''),
                                                                (uuid_generate_v4(), 'Бондарчук', 'Фёдор', ''),
                                                                (uuid_generate_v4(), 'Бочкарёв', 'Сергей', ''),
                                                                (uuid_generate_v4(), 'Смоктуновский', 'Иннокентий', '');

-- Наполнение таблицы режиссеров
INSERT INTO "directors" ("id", "last_name", "name", "surname") VALUES
                                                                   (uuid_generate_v4(), 'Нолан', 'Кристофер', ''),
                                                                   (uuid_generate_v4(), 'Спилберг', 'Стивен', ''),
                                                                   (uuid_generate_v4(), 'Балабанов', 'Алексей', ''),
                                                                   (uuid_generate_v4(), 'Тарковский', 'Андрей', ''),
                                                                   (uuid_generate_v4(), 'Кэмерон', 'Джеймс', ''),
                                                                   (uuid_generate_v4(), 'Гайдай', 'Леонид', ''),
                                                                   (uuid_generate_v4(), 'Рязанов', 'Эльдар', ''),
                                                                   (uuid_generate_v4(), 'Шахназаров', 'Карен', ''),
                                                                   (uuid_generate_v4(), 'Финчер', 'Дэвид', ''),
                                                                   (uuid_generate_v4(), 'Быков', 'Юрий', '');

-- Наполнение таблицы фильмов
INSERT INTO "films" ("id", "title", "year", "description", "age_limit", "url_photo", "url_trailer", "url_films", "oscars") VALUES
                                                                                                                               (uuid_generate_v4(), 'Титаник', 1997, 'Трагическая история любви на фоне катастрофы.', '12+', 'https://upload.wikimedia.org/wikipedia/ru/2/22/Titanic_poster.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Начало', 2010, 'Фантастический фильм о вторжении в сны.', '16+', 'https://upload.wikimedia.org/wikipedia/ru/7/7f/Inception_poster.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Аватар', 2009, 'Путешествие на Пандору в мир других существ.', '12+', 'https://upload.wikimedia.org/wikipedia/ru/d/d6/Avatar_poster.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Брат', 1997, 'История Данилы Багрова в суровом Санкт-Петербурге.', '18+', 'https://upload.wikimedia.org/wikipedia/ru/c/c8/Brat_poster.jpg', '', '', false),
                                                                                                                               (uuid_generate_v4(), 'Брат 2', 2000, 'Продолжение приключений Данилы в Америке.', '18+', 'https://upload.wikimedia.org/wikipedia/ru/a/ab/Brat2.jpg', '', '', false),
                                                                                                                               (uuid_generate_v4(), 'Список Шиндлера', 1993, 'Судьба евреев во времена Второй мировой войны.', '16+', 'https://upload.wikimedia.org/wikipedia/ru/3/38/Schindler%27s_List_movie.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Матрица', 1999, 'Борьба человечества против искусственного интеллекта.', '16+', 'https://upload.wikimedia.org/wikipedia/ru/c/c1/The_Matrix_Poster.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Форрест Гамп', 1994, 'История жизни простого, но удивительного человека.', '12+', 'https://upload.wikimedia.org/wikipedia/ru/3/3a/Forrest_Gump.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Джентльмены удачи', 1971, 'Комедия про банду и двойника их главаря.', '6+', 'https://upload.wikimedia.org/wikipedia/ru/4/4b/Gentlemen_of_Fortune.jpg', '', '', false),
                                                                                                                               (uuid_generate_v4(), 'Москва слезам не верит', 1979, 'История жизни трех подруг.', '12+', 'https://upload.wikimedia.org/wikipedia/ru/e/e8/Moscow_does_not_believe_in_tears.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Побег из Шоушенка', 1994, 'Фильм о надежде и борьбе за свободу.', '16+', 'https://upload.wikimedia.org/wikipedia/ru/e/e9/ShawshankRedemptionMoviePoster.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Интерстеллар', 2014, 'Эпическое путешествие через космос.', '12+', 'https://upload.wikimedia.org/wikipedia/ru/f/fc/Interstellar_2014.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Властелин колец: Братство кольца', 2001, 'Первая часть эпопеи по Толкину.', '12+', 'https://upload.wikimedia.org/wikipedia/ru/9/9d/Lord_of_the_Rings_Fellowship_of_the_Ring_%28movie%29.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Пираты Карибского моря: Проклятие Черной жемчужины', 2003, 'Первая часть пиратской саги.', '12+', 'https://upload.wikimedia.org/wikipedia/ru/a/a5/Pirates_of_the_Caribbean_-_The_Curse_of_the_Black_Pearl.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Хатико: Самый верный друг', 2009, 'Трогательная история верной собаки.', '6+', 'https://upload.wikimedia.org/wikipedia/ru/7/70/Hachiko_A_Dog%27s_Story.jpg', '', '', false),
                                                                                                                               (uuid_generate_v4(), 'Гарри Поттер и философский камень', 2001, 'Первая часть приключений Гарри Поттера.', '6+', 'https://upload.wikimedia.org/wikipedia/ru/d/d7/Harry_Potter_and_the_Philosopher%27s_Stone.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Шерлок Холмс', 2009, 'Современная адаптация классических рассказов.', '12+', 'https://upload.wikimedia.org/wikipedia/ru/2/2e/Sherlock_Holmes.jpg', '', '', false),
                                                                                                                               (uuid_generate_v4(), 'Зеленая миля', 1999, 'История о чуде на фоне трагических событий.', '16+', 'https://upload.wikimedia.org/wikipedia/ru/a/a3/The_Green_Mile.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Гладиатор', 2000, 'История мести в Древнем Риме.', '16+', 'https://upload.wikimedia.org/wikipedia/ru/e/ee/Gladiator_Poster.jpg', '', '', true),
                                                                                                                               (uuid_generate_v4(), 'Операция «Ы» и другие приключения Шурика', 1965, 'Три смешных истории.', '6+', 'https://upload.wikimedia.org/wikipedia/ru/c/c4/Operation_Y_and_other_shurik%27s_adventures.jpg', '', '', false);
