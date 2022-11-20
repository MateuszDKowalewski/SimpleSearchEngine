package pl.mkowalewski.sse.engine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashMapSearchEngine implements SearchEngine {

  Map<String, String> documents = new HashMap<>();
  Map<String, Set<String>> invertedIndexMap = new HashMap<>();

  @Override
  public void indexDocument(String id, String content) {
    documents.put(id, content);
    Stream.of(content.split(" "))
        .forEach(word -> indexWord(id, word));
  }

  @Override
  public List<IndexEntry> search(String term) {
    return invertedIndexMap.getOrDefault(term, new HashSet<>())
        .stream()
        .map(docId -> prepareIndexEntry(docId))
        .collect(Collectors.toList());
  }

  private IndexEntry prepareIndexEntry(String documentId) {
    return new IndexEntry(
        documentId,
        documents.get(documentId),
        null
    );
  }

  private void indexWord(String documentId, String word) {
    if (invertedIndexMap.containsKey(word)) {
      invertedIndexMap.get(word).add(documentId);
    } else {
      Set<String> documentsSet = new HashSet<>();
      documentsSet.add(documentId);
      invertedIndexMap.put(word, documentsSet);
    }
  }

}
