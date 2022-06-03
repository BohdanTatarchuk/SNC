import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi t = new TelegramBotsApi(DefaultBotSession.class);
        try {
            t.registerBot(new Bot());
            System.out.println("Bot has been started");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
