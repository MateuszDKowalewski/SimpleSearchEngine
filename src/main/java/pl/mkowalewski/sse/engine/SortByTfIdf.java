package pl.mkowalewski.sse.engine;

import java.util.Comparator;
import pl.mkowalewski.sse.engine.dto.IndexEntry;

class SortByTfIdf implements Comparator<IndexEntry> {

  @Override
  public int compare(IndexEntry o1, IndexEntry o2) {
    return o2.getTfIdfScore() - o1.getTfIdfScore() < 0 ? -1 : 1;
  }

}
