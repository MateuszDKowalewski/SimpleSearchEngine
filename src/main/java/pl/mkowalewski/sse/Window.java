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

public class Window {

  private static Window INSTANCE;

  private Terminal terminal;
  private Screen screen;
  private TextGraphics tg;

  private Map<ScreenEnum, ScreenRenderer> screens;
  private ScreenRenderer screenRenderer;
  private boolean keepRunning;

  public static Window getInstance() throws IOException {
    if (INSTANCE == null) {
      INSTANCE = new Window();
    }
    return INSTANCE;
  }

  public void loop() throws IOException {
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

  private Window() throws IOException {
    terminal = new DefaultTerminalFactory().createTerminal();
    screen = new TerminalScreen(terminal);
    tg = screen.newTextGraphics();
    screen.startScreen();
    screens = ScreenRendererFactory.getScreens(screen, tg);
    screens.get(ScreenEnum.MAIN);
    keepRunning = true;
    screenRenderer = screens.get(ScreenEnum.MAIN);
  }

}
