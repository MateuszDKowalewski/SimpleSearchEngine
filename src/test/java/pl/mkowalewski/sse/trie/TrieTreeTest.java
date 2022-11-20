package pl.mkowalewski.sse.trie;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TrieTreeTest {

  @ParameterizedTest
  @ValueSource(strings = {"mapa", "plan", "pole", "las", "loch"})
  void shouldFindExistingWordsInTree(String word) {
    // given
    TrieTree tree = getTrieTreeWithData();

    // when
    boolean wordPresent = tree.isWordPresent(word);

    //then
    assertTrue(wordPresent);
  }

  @ParameterizedTest
  @ValueSource(strings = {"mapy", "planować", "dostał", "mam"})
  void shouldNotFindNotExistingWordsInTree(String word) {
    // given
    TrieTree tree = getTrieTreeWithData();

    // when
    boolean wordPresent = tree.isWordPresent(word);

    //then
    assertFalse(wordPresent);
  }

  TrieTree getTrieTreeWithData() {
    TrieTree tree = new TrieTree();
    tree.addWord("mapa");
    tree.addWord("plan");
    tree.addWord("pole");
    tree.addWord("las");
    tree.addWord("loch");
    return tree;
  }

}