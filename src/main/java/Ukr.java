import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class Ukr {
    //texts
    private final String menu = "Ти в головному меню\uD83C\uDF9B";
    private final String about = """
            Space Noodles Corporation - це NFT-колекція на блокчейні TON, яка дозволяє кожному отримати унікальний космічний корабель і стати частиною нашого ком'юніті. Обирайте будь-який із 555 власноруч створених токенів Всесвіту SNC. Окрім самого токену і можливості його продажу на ринку, ви отримуєте багато додаткових плюшок. Детальніше на нашому сайті \uD83D\uDC7E""";
    private final String instruction = "Тут найактуальніша інформація про TON. Нижче перелік доступних інструкцій.";

    //buttons main menu
    InlineKeyboardMarkup getMainMenuButtons() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton instructions = new InlineKeyboardButton();
        instructions.setText("ІНСТРУКЦІЇ⚡");

        InlineKeyboardButton aboutProject = new InlineKeyboardButton();
        aboutProject.setText("Про проєкт\uD83D\uDC40");

        InlineKeyboardButton tgChannel = new InlineKeyboardButton();
        tgChannel.setText("Канал SNC\uD83D\uDC7E");
        String link = "https://t.me/+m8CAHPeMkKowMzBi";
        tgChannel.setUrl(link);

        InlineKeyboardButton referalLink = new InlineKeyboardButton();
        referalLink.setText("Рефер.Посилання");

        //callback data
        instructions.setCallbackData("instructions");
        tgChannel.setCallbackData("channel");
        aboutProject.setCallbackData("about");
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
        nft.setText("Лікнеп по NFT");
        nft.setCallbackData("nft");
        String linkNFT = "https://telegra.ph/Likbez-po-NFT-05-26";
        nft.setUrl(linkNFT);

        InlineKeyboardButton wallet = new InlineKeyboardButton();
        wallet.setText("Гаманець TON");
        wallet.setCallbackData("wallet");
        String linkWallet = "https://telegra.ph/Koshelek-TON-05-26";
        wallet.setUrl(linkWallet);

        InlineKeyboardButton termin = new InlineKeyboardButton();
        termin.setText("Термінологія");
        termin.setCallbackData("termin");
        String linkTermin = "https://telegra.ph/Terminologiya-05-26";
        termin.setUrl(linkTermin);

        InlineKeyboardButton safety = new InlineKeyboardButton();
        safety.setText("Безпека");
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


    public String getMenu() {
        return menu;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getAbout() {
        return about;
    }

}
