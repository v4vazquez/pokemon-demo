package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sprite {

    @JsonProperty("back_default")
    private String backDefault;
    @JsonProperty("front_default")
    private String frontDefault;

    //to add shinies later remember to do getters+setters and reformat the toString
    @JsonProperty("back_shiny")
    private String backShiny;
    @JsonProperty("front_shiny")
    private String frontShiny;

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getBackShiny() {
        return backShiny;
    }

    public void setBackShiny(String backShiny) {
        this.backShiny = backShiny;
    }

    public String getFrontShiny() {
        return frontShiny;
    }

    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }

    @Override
    public String toString() {
        return "Sprite{" +
                "backDefault='" + backDefault + '\'' +
                ", frontDefault='" + frontDefault + '\'' +
                ", backShiny='" + backShiny + '\'' +
                ", frontShiny='" + frontShiny + '\'' +
                '}';
    }
}
