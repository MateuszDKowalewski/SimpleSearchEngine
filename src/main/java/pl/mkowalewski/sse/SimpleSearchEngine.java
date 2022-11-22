package pl.mkowalewski.sse;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.Map;
import pl.mkowalewski.sse.screens.ScreenEnum;
import pl.mkowalewski.sse.screens.ScreenRenderer;
import pl.mkowalewski.sse.screens.ScreenRendererFactory;

class SimpleSearchEngine {

  public static void main(String[] args) throws IOException {
    Terminal terminal = new DefaultTerminalFactory().createTerminal();
    Screen screen = new TerminalScreen(terminal);
    TextGraphics tg = screen.newTextGraphics();
    screen.startScreen();
    Map<ScreenEnum, ScreenRenderer> screens = ScreenRendererFactory.getScreens(screen, tg);
    ScreenRenderer screenRenderer = screens.get(ScreenEnum.MAIN);
    boolean keepRunning = true;

    screenRenderer.render();
    while (keepRunning) {
      KeyStroke keyStroke = terminal.pollInput();
      if (keyStroke != null) {
        switch (keyStroke.getKeyType()) {
          case Escape:
            keepRunning = false;
            break;
          case ArrowDown:
            screenRenderer.arrowUpPressed();
            screenRenderer.render();
            break;
          case ArrowUp:
            screenRenderer.arrowDownPressed();
            screenRenderer.render();
            break;
          case Enter:
            screenRenderer.enterPressed();
            screenRenderer.render();
            break;
          case Backspace:
            screenRenderer.backspacePressed();
            break;
          default:
            screenRenderer.otherKeyPressed(keyStroke);
            break;
        }
      }
    }
    screen.stopScreen();
  }

}
