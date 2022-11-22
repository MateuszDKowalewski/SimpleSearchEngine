package pl.mkowalewski.sse.engine;

import java.util.List;
import pl.mkowalewski.sse.engine.dto.IndexEntry;

interface SearchEngine {

  /**
   * Add a document to the index
   *
   * @param id name of the indexed document
   * @param content content of the document
   */
  void indexDocument(String id, String content);

  /**
   * Search the index for the given term
   *
   * @param term to be found
   * @return sorted list of search results containing the given term
   */
  List<IndexEntry> search(String term);

  default String normalizeString(String document) {
    String response = document.toLowerCase();
    response = response.replaceAll("[^a-zA-Z]", " ");
    response = response.trim().replaceAll(" +", " ");
    return response;
  }

}
