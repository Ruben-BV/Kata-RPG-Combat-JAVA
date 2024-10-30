package com.factoriaf5.kata;

public class Character {
    
    private int health = 1000;
    private int level = 1;
    private boolean alive = true;

    public Character() {

    }

    public Character(int health, int level, boolean alive) {
        this.health = health;
        this.level = level;
        this.alive = alive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
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

    public void dealDamage(int damage, Character targCharacter) {
        if (targCharacter.health <= damage){
            targCharacter.health = 0;
            targCharacter.alive = false;
        }
        else {
            targCharacter.health = targCharacter.health - damage;
        }
    }

    public void heal(int healPoints, Character targCharacter) {
        if(targCharacter.alive == false) {
            targCharacter.alive = false;
        }
        
        else if((targCharacter.health + healPoints) >= 1000) {
            targCharacter.health = 1000;
        }

        else {
            targCharacter.health = healPoints + targCharacter.health;
        }
    }
}
