package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        var cities = new String[]{"Горно-Алтайск","УфаУлан-Удэ","Махачкала","Магас","Нальчик","Петразоводск","Сыктывкар",
                "Йошкар-Ола","Саранск","Якутск","Владикавказ","Казань","Кызыл","Ижевск","Абакан","Грозный","Чебоксары",
                "Барнаул","Чита","Петропавловск-Камчатский","Краснодар","Красноярск","Ставрополь","Пермь","Хабаровск",
                "Благовещенск","Архангельск","Астрахань","Белгород","Брянск","Владимир","Волгоград","Вологда","Воронеж",
                "Иваново","Иркутск","Калининград","Калуга","Кемерово","Киров","Кострома","Курган","Курск","Санкт-Петербург",
                "Липецк","Магадан","Москва","Мурманск","Нижний Новгород","Великий Новгород","Новосибирск","Оренбург","Орел",
                "Пенза","Псков","Ростов-на-Дону","Рязань","Саратов","Южно-Сахалинск","Самара","Смоленск","Тамбов","Екатеринбург",
                "Тверь","Томск","Тула","Тюмень","Ульяновск","Челябинск","Ярославль","Нарьян-Мар","Ханты-Мансийск","Анадырь","Салехард","Биробиджан" };
        return cities [new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
