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
    public void testConstructorRangedFighter() {

        double expectedHealth = 100;
        int expectedLevel = 5;
        boolean expectedAlive = true;
        String expectedFighterType = "rangedFighter";

        Character result = new Character(expectedHealth, expectedLevel, expectedAlive, expectedFighterType);

        assertEquals(expectedHealth, result.getHealth());
        assertEquals(expectedLevel, result.getLevel());
        assertEquals(expectedAlive, result.isAlive());
        assertEquals(expectedFighterType, result.getFighterType());
        assertEquals(20, result.getAttackMaxRange());
    }

    @Test
    public void testConstructorMeleeFighter() {

        double expectedHealth = 100;
        int expectedLevel = 5;
        boolean expectedAlive = true;
        String expectedFighterType = "meleeFighter";

        Character result = new Character(expectedHealth, expectedLevel, expectedAlive, expectedFighterType);

        assertEquals(expectedHealth, result.getHealth());
        assertEquals(expectedLevel, result.getLevel());
        assertEquals(expectedAlive, result.isAlive());
        assertEquals(expectedFighterType, result.getFighterType());
        assertEquals(2, result.getAttackMaxRange());
    }

    @Test
    public void testConstructorUnknownFighter() {

        double expectedHealth = 100;
        int expectedLevel = 5;
        boolean expectedAlive = true;
        String expectedFighterType = "unknownFighter";

        Character result = new Character(expectedHealth, expectedLevel, expectedAlive, expectedFighterType);

        assertEquals(expectedHealth, result.getHealth());
        assertEquals(expectedLevel, result.getLevel());
        assertEquals(expectedAlive, result.isAlive());
        assertEquals(expectedFighterType, result.getFighterType());
        assertEquals(1000000, result.getAttackMaxRange());
    }


    @Test
    public void testSetAndGetHealth() {
        double health = 750;
        
        character.setHealth(health);
        double result=character.getHealth();
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
    public void testSetAndGetFighterType() {
        String fighterType = "rangedFighter";
        
        character.setFighterType(fighterType);
        String result=character.getFighterType();
        assertEquals("rangedFighter", result);
    }




    // -------- dealDamage --------

    @Test
    public void testDealDamageToItself() {
        int damage = 50;
        double distance = 2;
        Character character = new Character(500, 1, true, "rangedFighter");
    
        assertThrows(IllegalArgumentException.class, () -> {
            character.dealDamage(damage, character, character, distance);
        });
    }

    @Test
    public void testDealDamageToFar() {
        int damage = 50;
        double distance = 50;
        Character character = new Character(500, 1, true, "rangedFighter");
    
        assertThrows(IllegalArgumentException.class, () -> {
            character.dealDamage(damage, character, character, distance);
        });
    }

        
        // dealDamage: If the target is 5 or more Levels above the attacker, Damage is reduced by 50%

    @Test
    public void testHealthDealDamageWhenTargCharacterHealthIsSmallerThanEndDamageTargetIsFiveLevelsAboveTheAttacker() {
        double damage = 50;
        double distance = 2;
        Character character = new Character(500, 1, true, "rangedFighter");
        Character targCharacter = new Character(20, 6, true, "rangedFighter");
        
        character.dealDamage(damage, character, targCharacter, distance);

        assertEquals(0, targCharacter.getHealth());
    }

    @Test
    public void testAlivetDealDamageWhenTargCharacterHealthIsBiggerThanEndDamageTargetIsMoreThanFiveLevelsAboveTheAttacker() {
        double damage = 50;
        double distance = 2;
        Character character = new Character(500, 1, true, "rangedFighter");
        Character targCharacter = new Character(500, 7, true, "rangedFighter");
        
        character.dealDamage(damage, character, targCharacter, distance);
        
        assertEquals(475, targCharacter.getHealth());
    }
    
    
    // dealDamage: If the target is 5 or more levels below the attacker, Damage is increased by 50%
    
    @Test
    public void testHealthDealDamageWhenTargCharacterHealthIsSmallerThanEndDamageTargetIsMoreThanFiveLevelsBelowTheAttacker() {
        double damage = 50;
        double distance = 2;
        Character character = new Character(500, 7, true, "rangedFighter");
        Character targCharacter = new Character(20, 1, true, "rangedFighter");

        character.dealDamage(damage, character, targCharacter, distance);

        assertEquals(0, targCharacter.getHealth());
    }

    @Test
    public void testAlivetDealDamageWhenTargCharacterHealthIsBiggerThanEndDamageTargetIsMoreThanFiveLevelsBelowTheAttacker() {
        double damage = 50;
        double distance= 2;
        Character character = new Character(500, 7, true, "rangedFighter");
        Character targCharacter = new Character(500, 1, true, "rangedFighter");

        character.dealDamage(damage, character, targCharacter, distance);

        assertEquals(425, targCharacter.getHealth());
    }
    


        // dealDamage: Rest

    @Test
    public void testHealtDealDamageWhenTargCharacterHealthIsBiggerThanDamage() {
        int damage = 50;
        double distance = 2;
        Character character = new Character(500, 1, true, "meleeFighter");
        Character targCharacter = new Character(60, 1, true, "rangedFighter");

        character.dealDamage(damage, character, targCharacter, distance);

        assertEquals(10, targCharacter.getHealth());
    }

    @Test
    public void testAlivetDealDamageWhenTargCharacterHealthIsBiggerThanDamage() {
        int damage = 50;
        double distance = 2;
        Character character = new Character(60, 1, true, "rangedFighter");
        Character targcharacter = new Character(damage, 1, true, "rangedFighter");

        character.dealDamage(damage, character, targcharacter, distance);

        assertEquals(true, character.isAlive());
    }





    // -------- heal --------

    @Test
    public void testHealWhenCharacterHealthPlusHealPointsIsBiggerThanThousand() {
        Character character = new Character(950,1,true, "rangedFighter");
        int healPoints = 100;

        character.heal(healPoints, character, character);

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void testHealWhenCharacterHealthPlusHealPointsIsEqualThanThousand() {
        Character character = new Character(900,1,true, "rangedFighter");
        int healPoints = 100;

        character.heal(healPoints, character, character);

        assertEquals(1000, character.getHealth());
    }

    @Test
    public void testHealWhenCharacterAliveIsFalse() {
        Character character = new Character(0,1,false,"rangedFighter");
        int healPoints = 100;

        assertThrows(IllegalStateException.class, () -> {
            character.heal(healPoints, character, character);
        });
    }

    @Test
    public void testHealWhenTargetCharacterIsDifferent() {
        Character mainCharacter = new Character(0,1,false,"rangedFighter");
        Character targCharacter = new Character(0,1,false,"rangedFighter");
        int healPoints = 100;

        assertThrows(IllegalArgumentException.class, () -> {
            character.heal(healPoints, mainCharacter, targCharacter);
        });
    }

    @Test
    public void testHeal() {
        Character character = new Character(200,1,true, "rangedFighter");
        int healPoints = 100;

        character.heal(healPoints, character, character);

        assertEquals(300, character.getHealth());
    }

}
