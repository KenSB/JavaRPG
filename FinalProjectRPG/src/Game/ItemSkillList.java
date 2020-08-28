package Game;

import java.util.*;
/* Class Description
 * This class manages both the skills and the items in the game.
 */
public class ItemSkillList 
{
	//A hashmap that stores all possible items
	static HashMap <String,Item> items=new HashMap <String,Item>();
	static int HPPotion=0;
	static int SPPotion=0;
	//String image,int healthBuff,int attackBuff,int damageRedBuff,int healthRegen,int skillRegen,int cost
	//CONSTRUCTOR
	ItemSkillList()
	{
		items.put("Practice Sword", new Item("practiceSword",0,3,0,0,0,1,1)); 
		items.put("Iron Sword", new Item("ironSword",0,6,0,0,0,1,1)); 
		items.put("Legendary Sword", new Item("legendarySword",0,15,0,0,0,1,1)); 
		items.put("Wooden Staff", new Item("woodenStaff",0,4,0,0,0,1,1)); 
		items.put("Mythical Staff", new Item("mythicalStaff",0,7,0,0,0,1,1)); 
		items.put("Legendary Staff", new Item("legendaryStaff",0,18,0,0,0,1,1));
		items.put("Health Potion", new Item("healthPotion",0,0,0,10,0,1,2));
		items.put("Skill Potion", new Item("skillPotion",0,0,0,10,0,1,2));
		items.put("Tattered Robes", new Item("tatteredRobes",0,0,1,0,0,1,0)); 
		items.put("Reinforced Robes", new Item("reinforcedRobes",0,4,0,0,0,1,0)); 
		items.put("Legendary Robes", new Item("legendaryRobes",0,0,8,0,0,1,0)); 
		items.put("Leather Armour", new Item("leatherArmour",0,0,2,0,0,1,0)); 
		items.put("Chainmail Armour", new Item("chainmailArmour",0,0,5,0,0,1,0)); 
		items.put("Legendary Armour", new Item("legendaryArmour",0,0,10,0,0,1,0)); 
	}
	/* Method Description
	 *  Desc: The following methods are for each of the players' skills 
	 *  Para: Varies depending on the skill
	 *  Return: They are voids
	 */
	static public void skillHeal(int player)
	{
		PlayerStats.player2SP-=5+PlayerStats.player2Level;
		if(player==1)
		{
			if(PlayerStats.player1Health+PlayerStats.player1Level+5>=PlayerStats.player1MaxHealth)
			{
				PlayerStats.player1Health=PlayerStats.player1MaxHealth;
			}
			else
			{
				PlayerStats.player1Health+=PlayerStats.player1Level+5;
			}
		}
		if(player==2)
		{
			if(PlayerStats.player2Health+PlayerStats.player2Level+5>=PlayerStats.player2MaxHealth)
			{
				PlayerStats.player2Health=PlayerStats.player2MaxHealth;
			}
			else
			{
				PlayerStats.player2Health+=PlayerStats.player2Level+5;
			}
		}
	}
	static public void skillStrength(int player)
	{
		PlayerStats.player1SP-=5+PlayerStats.player1Level;
		if(player==1)
		{
			PlayerStats.player1TempStrenght+=PlayerStats.player1Level+2;
			PlayerStats.player1TempRed+=PlayerStats.player1Level;
		}
		if(player==2)
		{
			PlayerStats.player2TempStrenght+=PlayerStats.player2Level+2;
			PlayerStats.player2TempRed+=PlayerStats.player2Level;
		}
	}
	static public int skillBlizzard()
	{
		PlayerStats.player2SP-=7+PlayerStats.player2Level;
		return PlayerStats.player2Level+3;
	}
	static public int skillFire()
	{
		PlayerStats.player1SP-=7+PlayerStats.player1Level;
		return PlayerStats.player1Level+2;
	}
	static public int skillHydro()
	{
		PlayerStats.player2SP-=3+PlayerStats.player2Level;
		return PlayerStats.player1Level+7;
	}
	static public int skillSlash()
	{
		PlayerStats.player1SP-=3+PlayerStats.player1Level;
		return PlayerStats.player1Level+7;
	}
}