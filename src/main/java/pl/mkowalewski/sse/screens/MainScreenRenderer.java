package pl.mkowalewski.sse.screens;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import pl.mkowalewski.sse.Window;

@RequiredArgsConstructor
class MainScreenRenderer implements ScreenRenderer {

  private final Screen screen;
  private final TextGraphics tg;

  private int currentMenuPosition = 0;

  @Override
  public void render() throws IOException {
    tg.putString(1, 1, "Simple search engine by Mateusz Kowalewski", SGR.BOLD);
    tg.putString(1, 5, "Select search engine", currentMenuPosition % 4 == 0 ? SGR.BLINK : SGR.BOLD);
    tg.putString(1, 6, "Index document from disk", currentMenuPosition % 4 == 1 ? SGR.BLINK : SGR.BOLD);
    tg.putString(1, 7, "Index document manual", currentMenuPosition % 4 == 2 ? SGR.BLINK : SGR.BOLD);
    tg.putString(1, 8, "Search phrase in documents", currentMenuPosition % 4 == 3 ? SGR.BLINK : SGR.BOLD);
    screen.refresh();
  }

  @Override
  public void arrowUpPressed() {
    currentMenuPosition++;
    if(currentMenuPosition > 3) {
      currentMenuPosition -= 4;
    }
    System.out.println(currentMenuPosition);
  }

  @Override
  public void arrowDownPressed() {
    currentMenuPosition--;
    if(currentMenuPosition < 0) {
      currentMenuPosition += 4;
    }
    System.out.println(currentMenuPosition);
  }

  @Override
  public void enterPressed() {
    switch (currentMenuPosition) {
      case 0:
        Window.getInstance().setScreen(ScreenEnum.SEARCH_ENGINE);
        break;
      case 1:
        Window.getInstance().setScreen(ScreenEnum.IMPORT_DOCUMENT);
        break;
      case 2:
        Window.getInstance().setScreen(ScreenEnum.CREATE_DOCUMENT);
        break;
      case 3:
        Window.getInstance().setScreen(ScreenEnum.SEARCH_PHRASE);
        break;
    }
  }

  @Override
  public void backspacePressed() {

  }

  @Override
  public void otherKeyPressed(KeyStroke keyStroke) {

  }

}
