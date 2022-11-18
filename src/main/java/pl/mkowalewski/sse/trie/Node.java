package pl.mkowalewski.sse.trie;

class Node {

  private static final int ALPHABET_SIZE = 'z' - 'a';

  private Integer[] edges = new Integer[ALPHABET_SIZE];

  public Node() {
  }

  boolean existEdgeFor(char c) {
    return edges[c - 'a'] != null;
  }

  public void addEdge(char c, int index) {
    if (edges[c - 'a'] != null) {
      throw new RuntimeException(); // TODO: mkowalewski - add custom errors
    }
    edges[c - 'a'] = index;
  }
}
