       First Fantasy - A Simple D&D-based Fantasy Game.

# Developers:

Jonatan Martinez  
Enoc Santiago  
Chris Eshelman  
Calvin England  



# Description:

First Fantasy is a semi-original turn-based RPG playable in your web browser. Defend yourself from a horde of goblins by using strategy to cut them down using your four-player party’s attacks. This project uses a simple and intuitive UI to increase legibility. Round results are displayed in clear and unambiguous language. It also connects to an Amazon RDS with default character information, allowing for quick start-up to the gameplay.

## This project utilizes the following technologies:

Spring JVM  
Postgres  
Hibernate  
Angular  
AWS RDS  
Integration Testing with Jenkins Pipeline into AWS PaaS instance  
Intuitive UI using point-and-click inputs  
Used powerful Java business logic to process battle and output results to the user  



# Current Functionality:

Ability to Login to get saved data  
One-Player  
Four character types  
One monster type  
One menu option (Attack only)  
Turn-based combat  
Simple Menu Interface  
Win state and lose state  
Save progress to server after the battle  
(Java handles menu entries, battle logic, win/loss states)  
(Persistent data: user, character, monster)  

# Desired Features:

Multiple Classes  
Multiple Monsters  
Game Balance  
Leveling up  
Buff Spells  
Debuff Spells  
Multiple Spells  
Different type of encounters  
Multiple rooms  
Multiple weapons  
Multiple armors  
Player Inventory  
Save progress to server after each battle  
(Persistent data: weapons, spells)  

# Gameplay:

The player logs in to the website, granting them access to their save data.  
If it is their first time playing, the player can choose which characters to take into a dungeon.  
Afterwards, they will continue playing from where they left off and cannot change their party.  
The dungeon consists of several pregenerated encounters.  
Once an encounter has been resolved, the player can click on the “Next Room” button if they wish to continue, or the “Save Progress” button if they wish to continue later on.  
The player will see several different types of encounters, including normal battles, healing rooms, merchants, and a boss battle at the end.  
The player wins when the boss of the dungeon is defeated.  

# Battles:

The battles are turn-based, with each character taking an action in a pre-defined order based on their speed stat. 
There are Attack, Spell, Defend, Run Away options.  Different characters will be better at one of the options in battle.
Monster-type characters select their actions at random.

# Characters:

Warrior: A physical damage character. Better damage when using the attack option.  
Mage: Has access to stronger damaging spells, and debuff spells.  
Healer: Has access to healing and buff spells to aid in combat.  
Guard: Has a higher HP, able to take more damage and can reduce damage taken while defending.  

# Monsters:

Goblin: Weak monster, only able to attack.  
Gelatinous Cube: “404 Not Found.”  
Hobgoblin: Boss monster, can attack or cast spells.  
