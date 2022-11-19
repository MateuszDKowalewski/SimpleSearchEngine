package pl.mkowalewski.sse;

import pl.mkowalewski.sse.trie.TrieTree;

class SimpleSearchEngine {

  public static void main(String[] args) {
    TrieTree t = new TrieTree();
    t.addWord("mapa");
    t.addWord("plan");
    t.addWord("pole");
    t.addWord("las");
    t.addWord("loch");
    System.out.println(t);
    System.out.println();
    System.out.println();
    System.out.println("mapa: " + t.isWordPresent("mapa"));
    System.out.println("mapy: " + t.isWordPresent("mapy"));
    System.out.println("test: " + t.isWordPresent("test"));
  }

}
