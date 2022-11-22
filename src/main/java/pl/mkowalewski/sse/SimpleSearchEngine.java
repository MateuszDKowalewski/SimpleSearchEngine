package pl.mkowalewski.sse;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

class SimpleSearchEngine {

  public static void main(String[] args) throws IOException {
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);
    TextGraphics tg = screen.newTextGraphics();
    screen.startScreen();


    boolean keepRunning = true;
    int currentMenuPosition = 0;
    renderScreen(screen, tg, currentMenuPosition);
    while (keepRunning) {
      KeyStroke keyStroke = terminal.pollInput();
      if (keyStroke != null) {
        System.out.println(keyStroke);
        switch (keyStroke.getKeyType()) {
          case Escape:
            keepRunning = false;
            break;
          case ArrowDown:
            currentMenuPosition++;
            renderScreen(screen, tg, currentMenuPosition);
            System.out.println(currentMenuPosition);
            break;
          case ArrowUp:
            currentMenuPosition--;
            renderScreen(screen, tg, currentMenuPosition);
            System.out.println(currentMenuPosition);
            break;
        }
      }
    }
    screen.stopScreen();
  }

  private static void renderScreen(Screen screen, TextGraphics tg, int currentMenuPosition) throws IOException {
    tg.putString(1, 1, "Simple search engine by Mateusz Kowalewski", SGR.BOLD);
    tg.putString(1, 5, "Select search engine", currentMenuPosition % 4 == 0 ? SGR.BLINK : SGR.BOLD);
    tg.putString(1, 6, "Index document from disk", currentMenuPosition % 4 == 1 ? SGR.BLINK : SGR.BOLD);
    tg.putString(1, 7, "Index document manual", currentMenuPosition % 4 == 2 ? SGR.BLINK : SGR.BOLD);
    tg.putString(1, 8, "Search phrase in documents", currentMenuPosition % 4 == 3 ? SGR.BLINK : SGR.BOLD);
    screen.refresh();
  }

}
