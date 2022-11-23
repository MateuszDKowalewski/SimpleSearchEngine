package pl.mkowalewski.sse.engine;

import java.util.List;
import pl.mkowalewski.sse.engine.dto.IndexEntry;

public class Engine {

  private static Engine INSTANCE;

  private SearchEngine searchEngine;

  public static Engine getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Engine();
    }
    return INSTANCE;
  }

  public void indexDocument(String id, String content) {
    searchEngine.indexDocument(id, content);
  }

  public List<IndexEntry> search(String term) {
    return searchEngine.search(term);
  }

  private Engine() {
    searchEngine = new HashMapSearchEngine();
  }
}