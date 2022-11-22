package pl.mkowalewski.sse.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;
import pl.mkowalewski.sse.engine.dto.IndexEntry;

class HashMapSearchEngineTest {

  @Test
  void shouldFindDocumentsWithBrown() {
    // given
    SearchEngine se = new HashMapSearchEngine();
    se.indexDocument("Document 1", "the brown fox jumped over the brown dog");
    se.indexDocument("Document 2", "the lazy brown dog sat in the corner");
    se.indexDocument("Document 3", "the red fox bit the lazy dog");

    // when
    List<IndexEntry> result = se.search("brown");

    // then
    assertEquals(2, result.size());
    assertTrue(result.stream().anyMatch(entry -> entry.getDocumentId().equals("Document 1")));
    assertTrue(result.stream().anyMatch(entry -> entry.getDocumentId().equals("Document 2")));
  }

  @Test
  void shouldFindDocumentsWithFox() {
    // given
    SearchEngine se = new HashMapSearchEngine();
    se.indexDocument("Document 1", "the brown fox jumped over the brown dog");
    se.indexDocument("Document 2", "the lazy brown dog sat in the corner");
    se.indexDocument("Document 3", "the red fox bit the lazy dog");

    // when
    List<IndexEntry> result = se.search("fox");

    // then
    assertEquals(2, result.size());
    assertTrue(result.stream().anyMatch(entry -> entry.getDocumentId().equals("Document 1")));
    assertTrue(result.stream().anyMatch(entry -> entry.getDocumentId().equals("Document 3")));
  }

  @Test
  void shouldNotFindDocumentsWithMerge() {
    // given
    SearchEngine se = new HashMapSearchEngine();
    se.indexDocument("Document 1", "the brown fox jumped over the brown dog");
    se.indexDocument("Document 2", "the lazy brown dog sat in the corner");
    se.indexDocument("Document 3", "the red fox bit the lazy dog");

    // when
    List<IndexEntry> result = se.search("merge");

    // then
    assertEquals(0, result.size());
  }

}