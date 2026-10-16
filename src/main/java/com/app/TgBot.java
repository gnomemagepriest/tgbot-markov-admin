package com.app;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import io.github.cdimascio.dotenv.Dotenv;

import com.app.telegram.Bot;

public class TgBot {
    public static void main(String[] args) {
        // Загружаем .env из корня проекта
        Dotenv dotenv = Dotenv.configure().directory("./").load();

        String token = dotenv.get("BOT_TOKEN");
        String name = dotenv.get("BOT_NAME");

        // Проверка, что токен подгрузился
        if (token == null || token.isEmpty()) {
            System.err.println("Ошибка: BOT_TOKEN не найден в .env файле!");
            return;
        }

        // Запуск бота
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot(name, token));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}