package pl.mkowalewski.sse.engine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
class IndexEntry {

  private String documentId;
  private String content;
  private Float tfIdfScore;

}
