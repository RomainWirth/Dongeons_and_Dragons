package fr.campus.dungeon.equipments.offense.spells;

public class LightningBolt extends Spell {
    public LightningBolt(){super(2);}

    @Override
    public String toString() {
        return "Lightning Bolt {\n" +
                " attack level = " + attackLevel +
                '}';
    }
}