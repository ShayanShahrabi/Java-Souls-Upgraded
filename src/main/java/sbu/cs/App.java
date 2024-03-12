package sbu.cs;

import sbu.cs.monsterClasses.Dragon;
import sbu.cs.monsterClasses.Goblin;
import sbu.cs.monsterClasses.Skeleton;
import sbu.cs.playerClasses.Assassin;
import sbu.cs.playerClasses.Knight;
import sbu.cs.playerClasses.Wizard;

import javax.management.DescriptorAccess;
import java.util.*;

public class App {

    private static List<Monster> monsterList = new ArrayList<>();
    private static List<Player> playerList = new ArrayList<>();


    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu()
    {
        createCharacter();
        initializeMonsters();
        startBattle();
    }

    public static void initializeMonsters()
    {
        monsterList.add(new Goblin("Goblin 1"));
        monsterList.add(new Goblin("Goblin 2"));
        monsterList.add(new Dragon("Dragon 1"));
        monsterList.add(new Skeleton("Skeleton 1"));
    }

    public static void createCharacter()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players do you want?");
        int playerCount = scanner.nextInt();
        if(playerCount <= 0) { createCharacter();}

        System.out.println("-------- CREATING PLAYER --------");

        System.out.println("1) Assassin");
        System.out.println("2) Knight");

        for(int i = 0; i < playerCount; i++)
        {
            System.out.println("");
            System.out.println((i + 1) + ") Enter player type?");
            int playerType = scanner.nextInt();

            String playerName = scanner.next();
            switch (playerType)
            {
                case 2: playerList.add(new Knight(playerName)); break;
                case 3: playerList.add(new Wizard(playerName)); break;
                default: playerList.add(new Assassin(playerName)); break;
            }
        }
    }


    static int alivePlayerCount;
    static int aliveMonsterCount;
    public static void startBattle()
    {
        alivePlayerCount = playerList.size();
        aliveMonsterCount = monsterList.size();
        while(alivePlayerCount > 0 && aliveMonsterCount >  0)
        {
            Player player = playerNextMove();
            aliveMonsterCount = getAliveMonsters().size();
            if(aliveMonsterCount == 0)
            {
                break;
            }
            System.out.println("---- Enemy's Turn ----");

            enemyNextMove(player);
            alivePlayerCount = getAlivePlayers().size();

        }

        if(alivePlayerCount == 0)
        {
            System.out.println("GAME OVER!");
        }
        if(aliveMonsterCount == 0)
        {
            System.out.println("You WON!");
        }
    }

    private static Monster chooseRandomAliveMonster()
    {
        ArrayList<Monster> theAvailabeMonsters = getAliveMonsters();
        if(theAvailabeMonsters.isEmpty())
        {
            return null;
        }
        Random rand = new Random();
        return theAvailabeMonsters.get(rand.nextInt(theAvailabeMonsters.size()));
    }

    private static ArrayList<Monster> getAliveMonsters()
    {
        ArrayList<Monster> theAvailabeMonsters = new ArrayList<>();
        for(Monster monster : monsterList)
        {
            if(monster.isAlive)
            {
                theAvailabeMonsters.add(monster);
            }
        }
        return theAvailabeMonsters;
    }


    private static Player chooseRandomAlivePlayer()
    {
        ArrayList<Player> theAvailabePlayers = new ArrayList<>();
        for(Player player : playerList)
        {
            if(player.isAlive)
            {
                theAvailabePlayers.add(player);
            }
        }
        Random rand = new Random();
        if(theAvailabePlayers.isEmpty())
        {
            return null;
        }
        return theAvailabePlayers.get(rand.nextInt(theAvailabePlayers.size()));
    }

    private static ArrayList<Player> getAlivePlayers()
    {
        ArrayList<Player> theAvailabePlayers = new ArrayList<>();
        for(Player player : playerList)
        {
            if(player.isAlive)
            {
                theAvailabePlayers.add(player);
            }
        }

        return  theAvailabePlayers;
    }


    private static Player playerNextMove()
    {
        Player player = chooseRandomAlivePlayer();
        System.out.println("---- Battle Begins ----");
        System.out.println("You are " + player.playerName);
        System.out.println("Choose enemy to attack..");
        ArrayList<Monster> aliveMonsters = getAliveMonsters();
        int i = 1;
        for(Monster monster : aliveMonsters)
        {
            System.out.println(i + ") " + monster.name + " -- Health: " + monster.health);
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        int chosenMonster = scanner.nextInt();
        if(chosenMonster < 1 || chosenMonster > aliveMonsters.size())
        {
            chosenMonster = 1;
        }
        player.attack(aliveMonsters.get(chosenMonster - 1));
        return  player;
    }

    private static void enemyNextMove(Player player)
    {
        Monster monster = chooseRandomAliveMonster();
        monster.attack(player);
    }

}