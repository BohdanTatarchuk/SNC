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

            //beginning
            if(text.equals("/start")){
                message.setText("Привет! Ты в боте APEX 1.0.\uD83D\uDC7E \n" +
                        "\nДля начала выбери язык:");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
