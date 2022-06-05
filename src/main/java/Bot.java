import Languages.Ru;
import Languages.Ukr;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    final static String botUsername = "snc_apexbot";
    final static String botToken = "5205088524:AAHzaUuDUrkaKIBpe5kcsbR-QI09sobhS_Y";
    SendMessage message = new SendMessage();
    Ukr ukr = new Ukr();
    Ru ru = new Ru();
    LinkedList<String> linkedList = new LinkedList<>();

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }


    @Override
    public void onUpdateReceived(Update update) {
        CallbackQuery callbackQuery;
        String answer;

        //looking for callback
        if (update.hasCallbackQuery()) {
            callbackQuery = update.getCallbackQuery();
            answer = callbackQuery.getData();
            linkedList.add(answer);
            System.out.println("CallbackQuery: " + callbackQuery);
            System.out.println("============================================");

            //buttons actions
            switch (linkedList.getLast()) {
                //russian language
                case "ru", "RUback" -> {
                    linkedList.removeFirst();
                    System.out.println("List: " + linkedList);
                    try {
                        execute(
                                SendMessage.builder()
                                        .text(ru.getMenu())
                                        .chatId(message.getChatId())
                                        .replyMarkup(ru.getMainMenuButtons())
                                        .build()
                        );
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case "RUabout" -> {
                    linkedList.removeFirst();
                    try {
                        execute(
                                SendMessage.builder()
                                        .text(ru.getAbout())
                                        .chatId(message.getChatId())
                                        .replyMarkup(ru.getAboutButtons())
                                        .build()
                        );
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case "RUinstructions" -> {
                    linkedList.removeFirst();
                    try {
                        execute(
                                SendMessage.builder()
                                        .text(ru.getInstruction())
                                        .chatId(message.getChatId())
                                        .replyMarkup(ru.getInstructionButton())
                                        .build()
                        );
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                //ukrainian language
                case "ua", "UAback" -> {
                    linkedList.removeFirst();;
                    try {
                        execute(
                                SendMessage.builder()
                                        .text(ukr.getMenu())
                                        .chatId(message.getChatId())
                                        .replyMarkup(ukr.getMainMenuButtons())
                                        .build()
                        );
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case "UAabout" -> {
                    try {
                        linkedList.removeFirst();
                        execute(
                                SendMessage.builder()
                                        .text(ukr.getAbout())
                                        .chatId(message.getChatId())
                                        .replyMarkup(ukr.getAboutButtons())
                                        .build()
                        );
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case "UAinstructions" -> {
                    linkedList.removeFirst();
                    try {
                        execute(
                                SendMessage.builder()
                                        .text(ukr.getInstruction())
                                        .chatId(message.getChatId())
                                        .replyMarkup(ukr.getInstructionButton())
                                        .build()
                        );
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (update.hasMessage() && update.getMessage().hasText()) {
            //creating obligatory field
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());
            String text = update.getMessage().getText();
            System.out.println("User message: " + text);
            System.out.println("Chat id: " + message.getChatId());
            System.out.println("============================================");

            //default commands
            switch (text) {
                case "/start" -> {
                    try {
                        message.setText(ru.getStart());
                        execute(message);
                        execute(
                                SendMessage.builder()
                                        .text(ru.getLanguage())
                                        .chatId(message.getChatId())
                                        .replyMarkup(getLanguageButtons())
                                        .build()
                        );
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case "/menu" -> {
                    try {
                        execute(
                                SendMessage.builder()
                                        .text(ru.getMenu())
                                        .chatId(message.getChatId())
                                        .replyMarkup(ru.getMainMenuButtons())
                                        .build()
                        );
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case "/referal" -> {
                    message.setText("*link*");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case "/about" -> {
                    try {
                        execute(
                                SendMessage.builder()
                                        .text(ru.getAbout())
                                        .chatId(message.getChatId())
                                        .replyMarkup(ru.getAboutButtons())
                                        .build()
                        );
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case "/instruction" -> {
                    try {
                        execute(
                                SendMessage.builder()
                                        .text(ru.getInstruction())
                                        .chatId(message.getChatId())
                                        .replyMarkup(ru.getInstructionButton())
                                        .build()
                        );
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //buttons language
    private InlineKeyboardMarkup getLanguageButtons() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton ukr = new InlineKeyboardButton();
        ukr.setText("Українська\uD83C\uDDFA\uD83C\uDDE6");

        InlineKeyboardButton ru = new InlineKeyboardButton();
        ru.setText("Русский\uD83C\uDDF7\uD83C\uDDFA");

        //callback data
        ukr.setCallbackData("ua");
        ru.setCallbackData("ru");

        //lists of buttons
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(ukr);
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(ru);

        //list of lists of buttons
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        buttons.add(row1);
        buttons.add(row2);

        //inline keyboard markup
        inlineKeyboardMarkup.setKeyboard(buttons);
        return inlineKeyboardMarkup;
    }
}


