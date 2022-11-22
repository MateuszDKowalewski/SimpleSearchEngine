package pl.mkowalewski.sse.screens;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;

public class MainScreenRenderer implements ScreenRenderer {

  private Screen screen;
  private TextGraphics tg;
  private int currentMenuPosition = 0;

  public MainScreenRenderer(Screen screen, TextGraphics tg) {
    this.screen = screen;
    this.tg = tg;
  }

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

  }

  @Override
  public void backspacePressed() {

  }

  @Override
  public void otherKeyPressed(KeyStroke keyStroke) {

  }

}
