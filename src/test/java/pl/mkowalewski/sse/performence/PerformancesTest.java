package pl.mkowalewski.sse.performence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.mkowalewski.sse.engine.HashMapSearchEngine;
import pl.mkowalewski.sse.engine.IndexEntry;
import pl.mkowalewski.sse.engine.SearchEngine;

class PerformancesTest {

  private static final String DOC_1 = "document1.txt";
  private static final String DOC_2 = "document2.txt";
  private static final String DOC_3 = "document3.txt";
  private static final String DOC_4 = "document4.txt";
  private static final String DOC_5 = "document5.txt";

  static Stream<Arguments> searchVerification() {
    return Stream.of(
        arguments("proin", Arrays.asList(DOC_1, DOC_2, DOC_3, DOC_4, DOC_5)),
        arguments("habitasse", Arrays.asList(DOC_1, DOC_2, DOC_3, DOC_5)),
        arguments("dictumst", Arrays.asList(DOC_1, DOC_3, DOC_5)),
        arguments("temple", Arrays.asList(DOC_1)),
        arguments("escape", Arrays.asList(DOC_2, DOC_5)),
        arguments("tempt", Arrays.asList(DOC_5))
    );
  }

  @ParameterizedTest(name = "should return {1} when search for {0}")
  @MethodSource("searchVerification")
  void hashMapEnginePerformance(String word, List<String> documentIds) throws IOException {
    // given
    SearchEngine se = initHashMapSearchEngine();

    // when
    List<IndexEntry> result = se.search(word);

    // then
    assertEquals(documentIds.size(), result.size());
    documentIds.forEach(documentId -> {
      assertTrue(result.stream().anyMatch(entry -> entry.getDocumentId().equals(documentId)));
    });
  }

  private SearchEngine initHashMapSearchEngine() throws IOException {
    SearchEngine se = new HashMapSearchEngine();
    indexDocument(se, DOC_1);
    indexDocument(se, DOC_2);
    indexDocument(se, DOC_3);
    indexDocument(se, DOC_4);
    indexDocument(se, DOC_5);
    return se;
  }

  private void indexDocument(SearchEngine se, String doc1) throws IOException {
    String path;
    File file;
    String content;
    path = "src/test/resources/documents/" + doc1;
    file = new File(path);
    content = Files.readString(Path.of(file.getAbsolutePath()), StandardCharsets.UTF_8);
    se.indexDocument(doc1, content);
  }

}
