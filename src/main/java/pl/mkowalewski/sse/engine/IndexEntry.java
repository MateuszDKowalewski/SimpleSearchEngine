package pl.mkowalewski.sse.engine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
class IndexEntry {

  private Long documentId;
  private String content;
  private float tfIdfScore;

}
