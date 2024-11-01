package com.factoriaf5.kata;

public class Character {
    
    private double health = 1000;
    private int level = 1;
    private boolean alive = true;
    private String fighterType = "rangedFighter";
    private double attackMaxRange = fighterType.equals("meleeFighter") ? 2 : fighterType.equals("rangedFighter") ? 20: null;
    

    public Character() {

    }

    public Character(double health, int level, boolean alive, String fighterType) {
        this.health = health;
        this.level = level;
        this.alive = alive;
        this.fighterType = fighterType;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getFighterType() {
        return fighterType;
    }

    public void setFighterType(String fighterType) {
        this.fighterType = fighterType;
    }
    

    public void dealDamage(double damage, Character character, Character targCharacter, double distance) {
        
        if(distance <= character.attackMaxRange ){

            if(targCharacter == character) {
                throw new IllegalArgumentException("A Character cannot Deal Damage to itself.");
            }
            else{
    
                if (targCharacter.level-5 >= character.level) {
                    damage = damage*0.5;
                    if (targCharacter.health <= damage){
                        targCharacter.health = 0;
                        targCharacter.alive = false;
                    }
                    else {
                        targCharacter.health = targCharacter.health - damage;
                    }
                }
    
                else if (targCharacter.level <= character.level-5) {
                    damage = damage*1.5;
                    if (targCharacter.health <= damage){
                        targCharacter.health = 0;
                        targCharacter.alive = false;
                    }
                    else {
                        targCharacter.health = targCharacter.health - damage;
                    }
                }
    
                else {
                    if (targCharacter.health <= damage){
                        targCharacter.health = 0;
                        targCharacter.alive = false;
                    }
                    else {
                        targCharacter.health = targCharacter.health - damage;
                    }
                }
    
                
            }
        }
        else {
            throw new IllegalArgumentException("The character cannot attack because it is too far from its target.");
        }
        
    }

    public void heal(double healPoints, Character character, Character targCharacter) {
        if (targCharacter != character) {
            throw new IllegalArgumentException("A Character can only heal itself.");
        }
        
        if (!targCharacter.alive) {
            throw new IllegalStateException("Cannot heal a dead character.");
        }
        
        if((targCharacter.health + healPoints) >= 1000) {
            targCharacter.health = 1000;
        }

        else {
            targCharacter.health = healPoints + targCharacter.health;
        }
    }
}
