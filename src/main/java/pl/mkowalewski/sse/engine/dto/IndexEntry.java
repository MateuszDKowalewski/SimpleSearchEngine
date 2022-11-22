package pl.mkowalewski.sse.engine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class IndexEntry {

  private String documentId;
  private String content;
  private Float tfIdfScore;

}