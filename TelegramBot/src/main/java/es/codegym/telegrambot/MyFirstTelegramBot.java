package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "Gatocracia_bot";
    public static final String TOKEN = "6975255302:AAHx2lB_s26GxdveMAVdsxxM3p1qldlyBG4";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if(getMessageText().equalsIgnoreCase("/start")){
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera", "step_1_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Tomar una salchicha! +20 de fama", "step_2_btn",
                            "Tomar un pescado! +20 de fama", "step_2_btn",
                            "Tirar una lata de pepinillos! +20 de fama)", "step_2_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear al robot aspirador", "step_3_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_3_btn")){
            addUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot aspirador a por comida! +30 de fama", "step_4_btn",
                            "Dar un paseo en el robot aspirador! +30 de fama", "step_4_btn",
                            "Huir del robot aspirador! +30 de fama", "step_4_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_4_btn")){
            addUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Encender la GoPro", "step_5_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_5_btn")){
            addUserGlory(30);
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Eres un gatito viral en TikTok! +40 de fama", "step_6_btn",
                            "Podrás acompañar siempre a tu dueño al baño! +40 de fama", "step_6_btn",
                            "Rascadores infinitos! +40 de fama", "step_6_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_6_btn")){
            addUserGlory(30);
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Hackear contraseña", "step_7_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_7_btn")){
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Sube tus contenidos a redes", "step_8_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_8_btn")){
            sendTextMessageAsync(FINAL_TEXT,
                    Map.of("Gracias por jugar", "final_/btn"));
        }

        /*if(getMessageText().toLowerCase().contains("hola")){
            sendTextMessageAsync("¿Qué tal? ¿Cuál es tu nombre?");
        }

        if(getMessageText().toLowerCase().contains("mi nombre es")){
            sendTextMessageAsync("¡Un placer! Yo soy *Gato*");
        }*/
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}