package com.factoriaf5.kata;


public final class App {
    private App() {
    }

    
    public static void main(String[] args) {
        
        Character hero1 = new Character();
        Character hero2 = new Character();
        Character villain = new Character();

        hero1.dealDamage(10, villain);
        

    }


}
