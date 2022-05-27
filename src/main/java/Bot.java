import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "snc_apexbot";
    }

    @Override
    public String getBotToken() {
        return "5205088524:AAHzaUuDUrkaKIBpe5kcsbR-QI09sobhS_Y";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            //creating obligatory fields
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());
            String text = update.getMessage().getText();

            //check
            System.out.println(update.getMessage().getText());
            System.out.println(update.getMessage().getChatId().toString());

            //default commands
            final String about = """
                    Space Noodles Corporations - это NFT — коллекция на блокчейне TON, которая позволяет каждому обзавестись уникальным космическим кораблём и стать частью уникального комьюнити. Выбирайте любой из 555 отрисованных вручную токенов Вселенной SNC.

                    Помимо самого токена и возможности его перепродажи на вторичном рынке, вы получаете внушительный набор Плюшек. Подробнее на нашем сайте \uD83D\uDC7E""";
            final String start = """
                    Привет! Ты в боте APEX 1.0.\uD83D\uDC7E\s

                    Для начала выбери язык:""";
            final String instruction = "Здесь самая актуальная информация о TON. Ниже список доступных инструкций.";

            switch (text) {
                case "/start" -> {
                    message.setText(start);
                    try {
                        execute(message);
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
                    message.setText(about);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                case "/instruction" -> {
                    message.setText(instruction);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
