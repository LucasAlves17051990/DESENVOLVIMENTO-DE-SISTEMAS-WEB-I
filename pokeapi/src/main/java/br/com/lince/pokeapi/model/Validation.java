package br.com.lince.pokeapi.model;

public class Validation {
    public static boolean titleValidate(String title) {
        return title.length() > 2 && title.length() <= 100;
    }
    public static boolean nameValidate(String name) {
        return name.length() > 2 && name.length() <= 50;
    }
}
                                                              