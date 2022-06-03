import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class Ru {
    //texts
    private final String about = """
            Space Noodles Corporations - это NFT — коллекция на блокчейне TON, которая позволяет каждому обзавестись уникальным космическим кораблём и стать частью уникального комьюнити. Выбирайте любой из 555 отрисованных вручную токенов Вселенной SNC.

            Помимо самого токена и возможности его перепродажи на вторичном рынке, вы получаете внушительный набор Плюшек. Подробнее на нашем сайте \uD83D\uDC7E""";
    private final String start = " Привет! Ты в боте APEX 1.0.\uD83D\uDC7E\s";
    private final String language = "Выбери язык:";
    private final String instruction = "Здесь самая актуальная информация о TON. Ниже список доступных инструкций.";

    //buttons main menu
    InlineKeyboardMarkup getMainMenuButtons() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton instructions = new InlineKeyboardButton();
        instructions.setText("ИНСТРУКЦИИ⚡");

        InlineKeyboardButton aboutProject = new InlineKeyboardButton();
        aboutProject.setText("О проекте\uD83D\uDC40");

        InlineKeyboardButton tgChannel = new InlineKeyboardButton();
        tgChannel.setText("Канал SNC\uD83D\uDC7E");
        String link = "https://t.me/+m8CAHPeMkKowMzBi";
        tgChannel.setUrl(link);

        InlineKeyboardButton referalLink = new InlineKeyboardButton();
        referalLink.setText("Рефер.Ссылка🔗");

        //callback data
        instructions.setCallbackData("instructions");
        tgChannel.setCallbackData("channel");
        aboutProject.setCallbackData("channel");
        referalLink.setCallbackData("referal");

        //lists of buttons
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(tgChannel);
        row1.add(instructions);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(aboutProject);
        row2.add(referalLink);

        //list of lists of buttons
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        buttons.add(row1);
        buttons.add(row2);

        //inline keyboard markup
        inlineKeyboardMarkup.setKeyboard(buttons);
        return inlineKeyboardMarkup;
    }

    //buttons about buttons
    InlineKeyboardMarkup getAboutButtons() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");

        InlineKeyboardButton website = new InlineKeyboardButton();
        website.setCallbackData("website");
        String link = "https://spacenoodles.ru";
        website.setUrl(link);
        website.setText("Наш сайт");

        //list of lists of buttons
        List<InlineKeyboardButton> buttons = new ArrayList<>();
        buttons.add(back);
        buttons.add(website);

        List<List<InlineKeyboardButton>> list = new ArrayList<>();
        list.add(buttons);

        //inline keyboard markup
        inlineKeyboardMarkup.setKeyboard(list);
        return inlineKeyboardMarkup;
    }

    //buttons instruction
    InlineKeyboardMarkup getInstructionButton() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton back = new InlineKeyboardButton();
        back.setText("Назад");
        back.setCallbackData("back");

        InlineKeyboardButton nft = new InlineKeyboardButton();
        nft.setText("Ликбез по NFT");
        nft.setCallbackData("nft");
        String linkNFT = "https://telegra.ph/Likbez-po-NFT-05-26";
        nft.setUrl(linkNFT);

        InlineKeyboardButton wallet = new InlineKeyboardButton();
        wallet.setText("Кошелек TON");
        wallet.setCallbackData("wallet");
        String linkWallet = "https://telegra.ph/Koshelek-TON-05-26";
        wallet.setUrl(linkWallet);

        InlineKeyboardButton termin = new InlineKeyboardButton();
        termin.setText("Терминология");
        termin.setCallbackData("termin");
        String linkTermin = "https://telegra.ph/Terminologiya-05-26";
        termin.setUrl(linkTermin);

        InlineKeyboardButton safety = new InlineKeyboardButton();
        safety.setText("Безопасность");
        safety.setCallbackData("safety");
        String linkSafety = "https://telegra.ph/Bezopasnost-05-26-2";
        safety.setUrl(linkSafety);

        //list
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(nft);
        row1.add(termin);
        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(wallet);
        row2.add(safety);
        List<InlineKeyboardButton> row3 = new ArrayList<>();
        row3.add(back);

        //list of lists
        List<List<InlineKeyboardButton>> list = new ArrayList<>();
        list.add(row1);
        list.add(row2);
        list.add(row3);

        //inline keyboard markup
        inlineKeyboardMarkup.setKeyboard(list);
        return inlineKeyboardMarkup;
    }


    //getter
    public String getAbout() {
        return about;
    }

    public String getStart() {
        return start;
    }

    public String getLanguage() {
        return language;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getMenu() {
        return menu;
    }

    private final String menu = "Ты в главном меню \uD83C\uDF9B";
}
