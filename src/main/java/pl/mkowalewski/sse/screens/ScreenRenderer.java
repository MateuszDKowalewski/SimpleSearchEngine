package pl.mkowalewski.sse.screens;

import com.googlecode.lanterna.input.KeyStroke;
import java.io.IOException;

public interface ScreenRenderer {
  void render() throws IOException;
  void arrowUpPressed();
  void arrowDownPressed();
  void enterPressed();
  void backspacePressed();
  void otherKeyPressed(KeyStroke keyStroke);
}
