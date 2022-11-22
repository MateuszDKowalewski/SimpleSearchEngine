package pl.mkowalewski.sse.screens;

import static pl.mkowalewski.sse.screens.ScreenEnum.CREATE_DOCUMENT;
import static pl.mkowalewski.sse.screens.ScreenEnum.IMPORT_DOCUMENT;
import static pl.mkowalewski.sse.screens.ScreenEnum.MAIN;
import static pl.mkowalewski.sse.screens.ScreenEnum.SEARCH_ENGINE;
import static pl.mkowalewski.sse.screens.ScreenEnum.SEARCH_PHRASE;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import java.util.HashMap;
import java.util.Map;

public class ScreenRendererFactory {

  public static Map<ScreenEnum, ScreenRenderer> getScreens(Screen screen, TextGraphics tg) {
    Map<ScreenEnum, ScreenRenderer> response = new HashMap<>();
    response.put(MAIN, new MainScreenRenderer(screen, tg));
    response.put(SEARCH_ENGINE, new SearchEngineScreenRenderer(screen, tg));
    response.put(IMPORT_DOCUMENT, new ImportDocumentScreenRenderer(screen, tg));
    response.put(CREATE_DOCUMENT, new CreateDocumentScreenRenderer(screen, tg));
    response.put(SEARCH_PHRASE, new SearchPhraseScreenRenderer(screen, tg));
    return response;
  }

}
