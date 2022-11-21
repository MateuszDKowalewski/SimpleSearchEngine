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
  Map<String, Map<String, Integer>> invertedIndexMap = new HashMap<>();

  @Override
  public void indexDocument(String id, String content) {
    documents.put(id, content);
    Stream.of(content.split(" "))
        .forEach(word -> indexWord(id, word));
  }

  @Override
  public List<IndexEntry> search(String term) {
    Map<String, Integer> countInDocuments = invertedIndexMap.getOrDefault(term, new HashMap<>());
    return countInDocuments.keySet().stream()
        .map(key -> prepareIndexEntry(key, countInDocuments))
        .collect(Collectors.toList());
  }

  private void indexWord(String documentId, String word) {
    Map<String, Integer> countForWord = invertedIndexMap.get(word);
    if (countForWord != null) {
      Integer countInDocument = countForWord.get(documentId);
      if (countInDocument == null) {
        countInDocument = 0;
      }
      countInDocument++;
      countForWord.put(documentId, countInDocument);
    } else {
      Set<String> documentsSet = new HashSet<>();
      documentsSet.add(documentId);
      Map<String, Integer>  countForDocuments = new HashMap<>();
      countForDocuments.put(documentId, 1);
      invertedIndexMap.put(word, countForDocuments);
    }
  }

  private IndexEntry prepareIndexEntry(String documentId, Map<String, Integer> countInDocuments) {
    Float tf = 1f * countInDocuments.get(documentId) / documents.get(documentId).split(" ").length;
    Float idf = 1f * documents.size() / countInDocuments.size();
    return new IndexEntry(
        documentId,
        documents.get(documentId),
        tf * idf
    );
  }

}
