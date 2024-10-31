package com.factoriaf5.kata;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    
    private Character character;

    @BeforeEach
    public void init() {
        this.character = new Character();
    }


    @Test
    public void testConstructor() {

        int expectedHealth = 100;
        int expectedLevel = 5;
        boolean expectedAlive = true;

        Character result = new Character(expectedHealth, expectedLevel, expectedAlive);

        assertEquals(expectedHealth, result.getHealth());
        assertEquals(expectedLevel, result.getLevel());
        assertEquals(expectedAlive, result.isAlive());

    }

    @Test
    public void testSetAndGetHealth() {
        int health = 750;
        
        character.setHealth(health);
        int result=character.getHealth();
        assertEquals(750, result);
    }

    @Test
    public void testSetAndGetLevel() {
        int level = 2;
        
        character.setLevel(level);
        int result=character.getLevel();
        assertEquals(2, result);
    }

    @Test
    public void testSetAndIsAlive() {
        boolean alive = false;
        
        character.setAlive(alive);
        boolean result=character.isAlive();
        assertEquals(false, result);
    }


    @Test
    public void testHealtDealDamageWhenTargCharacterHealthIsSmallerThanDamage() {
        int damage = 50;
        Character character = new Character(500, 1, true);
        Character targCharacter = new Character(40, 1, true);

        character.dealDamage(damage, character, targCharacter);

        assertEquals(0, targCharacter.getHealth());
    }

    @Test
    public void testAlivetDealDamageWhenTargCharacterHealthIsSmallerThanDamage() {
        int damage = 50;
        Character character = new Character(500, 1, true);
        Character targCharacter = new Character(40, 1, true);

        character.dealDamage(damage, character, targCharacter);

        assertEquals(false, targCharacter.isAlive());
    }

    @Test
    public void testHealtDealDamageWhenTargCharacterHealthIsEqualThanDamage() {
        int damage = 50;
        Character character = new Character(500, 1, true);
        Character targCharacter = new Character(damage, 1, true);

        character.dealDamage(damage, character, targCharacter);

        assertEquals(0, targCharacter.getHealth());
    }

    @Test
    public void testAlivetDealDamageWhenTargCharacterHealthIsEqualThanDamage() {
        int damage = 50;
        Character character = new Character(500, 1, true);
        Character targCharacter = new Character(damage, 1, true);

        character.dealDamage(damage, character, targCharacter);

        assertEquals(false, targCharacter.isAlive());
    }

    @Test
    public void testHealtDealDamageWhenTargCharacterHealthIsBiggerThanDamage() {
        int damage = 50;
        Character character = new Character(500, 1, true);
        Character targCharacter = new Character(60, 1, true);

        character.dealDamage(damage, character, targCharacter);

        assertEquals(10, targCharacter.getHealth());
    }

    @Test
    public void testAlivetDealDamageWhenTargCharacterHealthIsBiggerThanDamage() {
        int damage = 50;
        Character character = new Character(60, 1, true);
        Character targcharacter = new Character(damage, 1, true);

        character.dealDamage(damage, character, targcharacter);

        assertEquals(true, character.isAlive());
    }

    @Test
    public void testDealDamageToItself() {
        int damage = 50;
        Character character = new Character(500, 1, true);

        assertThrows(IllegalArgumentException.class, () -> {
            character.dealDamage(damage, character, character);
        });
    }

    @Test
    public void testHealWhenCharacterHealthPlusHealPointsIsBiggerThanThousand() {
        Character character = new Character(950,1,true);
        int healPoints = 100;

        character.heal(healPoints, character);

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void testHealWhenCharacterHealthPlusHealPointsIsEqualThanThousand() {
        Character character = new Character(900,1,true);
        int healPoints = 100;

        character.heal(healPoints, character);

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void testHealWhenCharacterAliveIsFalse() {
        Character character = new Character(0,1,false);
        int healPoints = 100;

        character.heal(healPoints, character);

        assertEquals(false, character.isAlive());
    }

    @Test
    public void testHeal() {
        Character character = new Character(200,1,true);
        int healPoints = 100;

        character.heal(healPoints, character);

        assertEquals(300, character.getHealth());
    }

    // public void heal(int healPoints, Character targCharacter) {
    //     if(targCharacter.alive == false) {
    //         targCharacter.alive = false;
    //     }
        
    //     else if((targCharacter.health + healPoints) >= 1000) {
    //         targCharacter.health = 1000;
    //     }

    //     else {
    //         targCharacter.health = healPoints + targCharacter.health;
    //     }
    // }

}
