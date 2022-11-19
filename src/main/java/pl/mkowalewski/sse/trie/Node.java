package pl.mkowalewski.sse.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

class Node {

  private static int nextIndex = 0;

  private final UUID uuid;
  private int index;

  private Map<Character, Node> edges = new HashMap<>();
  private boolean isWord;

  public static Node withWord(String word) {
    Node node = new Node();
    node.addSuffix(word);
    return node;
  }

  public boolean isSuffixPresent(String suffix) {
    if (suffix.length() == 0 && isWord) {
      return true;
    }
    Character current = suffix.charAt(0);
    suffix = getNextSuffix(suffix);
    if (!edges.containsKey(current)) {
      return false;
    }
    return edges.get(current).isSuffixPresent(suffix);
  }

  public Node() {
    isWord = false;
    uuid = UUID.randomUUID();
    index = nextIndex++;
  }

  public void addSuffix(String suffix) {
    if (suffix.length() == 0) {
      isWord = true;
      return;
    }
    Character current = suffix.charAt(0);
    suffix = getNextSuffix(suffix);
    if (edges.containsKey(current)) {
      edges.get(current).addSuffix(suffix);
    } else {
      edges.put(current, withWord(suffix));
    }
  }

  private String getNextSuffix(String suffix) {
    return suffix.length() > 1 ? suffix.substring(1) : "";
  }

  @Override
  public String toString() {
    String s = "Node " + index
        + "{ edges = " + edgesToString()
        + ", isWord = " + isWord
        + "}";
    StringBuilder sb = new StringBuilder(s);
    sb.append("\n");
    edges.values().forEach(node -> {
      sb.append(node.toString());
    });
    return sb.toString();
  }

  private String edgesToString() {
    String s = edges.keySet()
        .stream()
        .map(String::valueOf)
        .collect(Collectors.joining(", "));
    return "[" + s + "]";
  }
}
