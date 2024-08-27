package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Ludoman extends Hero  {
    public Ludoman(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.DICE_ROLL);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int dice1 = RPG_Game.random.nextInt(6)+1;
        int dice2 = RPG_Game.random.nextInt(6)+1;
        System.out.println(this.getName() + " dice 1 :" + dice1 + " dice2 : "+ dice2);
        if (dice1 == dice2){
            int damageBoss = dice1* dice2;
            boss.setHealth(boss.getHealth() - damageBoss);
            System.out.println("Ludoman hits Boss : "+ damageBoss);
        }else {

            Hero randomHero;
            do {
                randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
            } while (randomHero == this || randomHero.getHealth() <= 0);

            int damageToHero = dice1 + dice2;
            randomHero.setHealth(randomHero.getHealth() - damageToHero);
            System.out.println("Ludoman hits " + randomHero.getName() + " damamge :" + damageToHero);
        }
    }
    }

