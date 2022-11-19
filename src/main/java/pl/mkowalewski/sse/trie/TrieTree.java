package pl.mkowalewski.sse.trie;

public class TrieTree {

  private Node root;

  public TrieTree() {
    root = new Node();
  }

  public boolean isWordPresent(String word) {
    return root.isSuffixPresent(word);
  }

  public void addWord(String s) {
    root.addSuffix(s);
  }

  @Override
  public String toString() {
    return root.toString();
  }
}
