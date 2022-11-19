package pl.mkowalewski.sse;

import pl.mkowalewski.sse.trie.TrieTree;

class SimpleSearchEngine {

  public static void main(String[] args) {
    TrieTree t = new TrieTree();
    System.out.println("Test 1");
    t.addWord("mapa");
    System.out.println(t);
    System.out.println("Test 2");
    t.addWord("plan");
    System.out.println(t);
    System.out.println("Test 3");
    t.addWord("pole");
    System.out.println(t);
    System.out.println("Test 4");
    t.addWord("las");
    System.out.println(t);
    System.out.println("Test 5");
    t.addWord("loch");
    System.out.println(t);
  }

}
