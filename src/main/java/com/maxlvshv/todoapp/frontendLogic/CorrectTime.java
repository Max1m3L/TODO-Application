package com.maxlvshv.todoapp.frontendLogic;

import java.time.LocalDate;


public class CorrectTime {
    public static String get_correct_time() {
        String[] time = LocalDate.now().toString().split("-");
        String result = time[2];
        switch (time[1]) {
            case "1" -> result += " Января ";
            case "2" -> result += " Февраля ";
            case "3" -> result += " Марта ";
            case "4" -> result += " Арпреля ";
            case "5" -> result += " Мая ";
            case "6" -> result += " Июня ";
            case "7" -> result += " Июля ";
            case "8" -> result += " Августа ";
            case "9" -> result += " Сентября ";
            case "10" -> result += " Октября ";
            case "11" -> result += " Ноября ";
            case "12" -> result += " Декабря ";
        }
        result += time[0];
        return result;
    }
}
