package pl.mkowalewski.sse.screens;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import pl.mkowalewski.sse.Window;

@RequiredArgsConstructor
class SearchPhraseScreenRenderer implements ScreenRenderer {

  private final Screen screen;
  private final TextGraphics tg;

  @Override
  public void render() throws IOException {
    tg.putString(1, 1, "Simple search engine by Mateusz Kowalewski", SGR.BOLD);
    tg.putString(1, 2, "SearchPhraseScreenRenderer", SGR.BOLD);
    screen.refresh();
  }

  @Override
  public void arrowUpPressed() {

  }

  @Override
  public void arrowDownPressed() {

  }

  @Override
  public void enterPressed() {

  }

  @Override
  public void backspacePressed() {
    Window.getInstance().setScreen(ScreenEnum.MAIN);
  }

  @Override
  public void otherKeyPressed(KeyStroke keyStroke) {

  }
}
