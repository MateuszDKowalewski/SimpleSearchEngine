package pl.mkowalewski.sse.trie;

import java.util.HashMap;
import java.util.Map;

class Node {

  private Map<Character, Node> edges = new HashMap<>();
  private boolean isWord;

  public Node() {
  }

}
