package fr.campus.dungeon;

public class CharacterOutOfBoundsException extends Exception {
    public CharacterOutOfBoundsException() {
        super("Oh no! your Character is out of the map !");
    }
}
