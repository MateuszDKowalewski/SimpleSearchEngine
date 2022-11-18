package pl.mkowalewski.sse.trie;

import java.util.ArrayList;
import java.util.List;

class TrieTree {

  private List<Node> nodes = new ArrayList<Node>();
  private int indexCount = 0;

  public TrieTree() {
    nodes.add(new Node());
  }

  public void addWord(String s) {
    // TODO: mkowalewski - check for invalid input?
    // probably should be in different class
    s.toLowerCase();
    for (int i = 0; i < s.length(); i++) {
      if (nodes.size() > i) {
        if (!nodes.get(i).existEdgeFor(s.charAt(i))) {
          nodes.get(i).addEdge(s.charAt(i), indexCount++);
        }
      } else {
        nodes.get(i).addEdge(s.charAt(i), indexCount++);
      }
    }
  }

}
