package pl.mkowalewski.sse.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

class Node {

  private final UUID uuid;

  private Map<Character, Node> edges = new HashMap<>();
  private boolean isWord;

  public static Node withWord(String word) {
    Node node = new Node();
    node.addSuffix(word);
    return node;
  }

  public Node() {
    isWord = false;
    uuid = UUID.randomUUID();
  }

  public void addSuffix(String s) {
    if (s.length() == 0) {
      isWord = true;
      return;
    }
    Character current = s.charAt(0);
    String suffix = s.substring(1);
    if (edges.containsKey(current)) {
      edges.get(current).addSuffix(suffix);
    } else {
      edges.put(current, withWord(suffix));
    }
  }

  @Override
  public String toString() {
    String s = "Node" + uuid
        + "{ edges = " + edgesToString()
        + ", isWord = " + isWord
        + "}";
    StringBuilder sb = new StringBuilder(s);
    sb.append("\n");
    edges.values().forEach(node -> {
      sb.append(node.toString());
      sb.append("\n");
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
