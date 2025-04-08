package com.prashantMaurya.PSO.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Settings {
  private Long id;
  private boolean confirmResign;
  private boolean premove;
  private boolean piecesSound;
  private boolean confirmMove;
}
