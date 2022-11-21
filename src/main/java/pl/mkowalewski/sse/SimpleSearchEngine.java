package pl.mkowalewski.sse;

import java.util.List;
import pl.mkowalewski.sse.engine.HashMapSearchEngine;
import pl.mkowalewski.sse.engine.IndexEntry;
import pl.mkowalewski.sse.engine.SearchEngine;

class SimpleSearchEngine {

  public static void main(String[] args) {
    SearchEngine se = new HashMapSearchEngine();
    se.indexDocument("Document 1", "the brown fox jumped over the brown dog");
    se.indexDocument("Document 2", "the lazy brown dog sat in the corner");
    se.indexDocument("Document 3", "the red fox bit the lazy dog");
    List<IndexEntry> result = se.search("brown");
    result.forEach(doc -> {
      System.out.println(doc.getDocumentId());
      System.out.println(doc.getContent());
      System.out.println(doc.getTfIdfScore());
      System.out.println();
    });
  }

}
