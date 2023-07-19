package fr.campus.dungeon.equipments.offense.spells;

public class LightningBolt extends Spell {
    public LightningBolt(){super(2);}

    @Override
    public String toString() {
        return "LightningBolt {\n" +
                " attackLevel = " + attackLevel +
                '}';
    }
}
