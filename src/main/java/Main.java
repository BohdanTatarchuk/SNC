import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi t = new TelegramBotsApi(DefaultBotSession.class);
        try {
            t.registerBot(new Bot());
            log.info("BOT HAS BEEN STARTED");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
