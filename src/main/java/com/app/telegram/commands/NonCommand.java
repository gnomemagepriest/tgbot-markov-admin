package com.app.telegram.commands;

/**
 * Обработка сообщения, не являющегося командой
 */
public class NonCommand {

    public String nonCommandExecute(Long chatId, String userName, String text) {
        String answer = "Placeholder";

        return answer;
    }

}