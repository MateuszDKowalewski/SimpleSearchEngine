package pl.mkowalewski.sse.screens;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor.ANSI;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import pl.mkowalewski.sse.Window;
import pl.mkowalewski.sse.engine.Engine;

@RequiredArgsConstructor
class CreateDocumentScreenRenderer implements ScreenRenderer {

  private final Screen screen;
  private final TextGraphics tg;
  private final Engine engine = Engine.getInstance();

  @Override
  public void render() throws IOException {
    Panel panel = new Panel();
    panel.setLayoutManager(new GridLayout(2));
    panel.addComponent(new Label("Id"));
    panel.addComponent(new TextBox(new TerminalSize(66, 1)));
    panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
    panel.addComponent(new EmptySpace(new TerminalSize(0,1)));
    panel.addComponent(new Label("Content"));
    panel.addComponent(new TextBox(new TerminalSize(66, 17)));
    panel.addComponent(new EmptySpace(new TerminalSize(0,0)));
    panel.addComponent(new Button("Submit", this::indexDocument));

    BasicWindow window = new BasicWindow();
    window.setComponent(panel);
    MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(ANSI.BLACK));
    gui.addWindowAndWait(window);

    screen.refresh();
  }

  private void indexDocument() {
    System.out.println("Index");
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
