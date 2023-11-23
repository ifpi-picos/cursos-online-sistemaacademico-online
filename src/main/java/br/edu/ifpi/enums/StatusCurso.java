package br.edu.ifpi.enums;

public enum StatusCurso {
  ABERTO("aberto"), 
  FECHADO("fechado");

  private final String desc;

  StatusCurso(String desc) {
    this.desc = desc;
}

public String getDescricao() {
    return desc;
}
}
