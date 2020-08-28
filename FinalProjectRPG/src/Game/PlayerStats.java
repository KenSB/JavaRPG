package Game;

import java.util.HashMap;
/* Class Description
 * This class manages all stats concerning the players.
 */
public class PlayerStats 
{
	//List of all items
	static ItemSkillList list=new ItemSkillList();
	//Player inventory
	static HashMap <String,Item> inventory=new HashMap<String,Item>();
	//ALL VARIABLES FOR ALL STATS
	static String p1Weapon;
	static String p2Weapon;
	static String p1Armour;
	static String p2Armour;

	static int player1MaxHealth;
	static int player1MaxSP;
	static int player1Health=10;
	static int player1SP=6;
	static int player1MaxEXP=0;
	static int player1EXP=0;
	static int player1Level;
	static int player2MaxHealth;
	static int player2MaxSP;
	static int player2Health=9;
	static int player2SP=20;
	static int player2MaxEXP=0;
	static int player2EXP=0;
	static int player2Level;
	static int player1AttackStrenght;
	static int player1DamageRed;
	static int player2AttackStrenght;
	static int player2DamageRed;
	
	static int player1TempStrenght;
	static int player1TempRed;
	static int player2TempStrenght;
	static int player2TempRed;
	
	static boolean p1KO=false;
	static boolean p2KO=false;
	/* Method Description
	 *  Desc: This method updates the player's level
	 *  Para: It takes in the current level of the player and the player that is leveling up
	 *  Return: it's a void
	 */
	static public void statChangeLevel(int level, int player)
	{
		if(player==1)
		{
			player1MaxHealth=15+(5*level);
			player1Health=15+(5*level);
			player1MaxSP=8+(2*level);
			player1SP=8+(2*level);
			player1MaxEXP=2+(level*3);
			player1EXP=0;
			player1Level++;
			player1AttackStrenght=5+(2*level);
			player1DamageRed=5+(2*level);
		}
		if(player==2)
		{
			player2MaxHealth=12+(3*level);
			player2Health=12+(3*level);
			player2MaxSP=25+(5*level);
			player2SP=25+(5*level);
			player2MaxEXP=2+(level*3);
			player2EXP=0;
			player2Level++;
			player2AttackStrenght=8+(3*level);
			player2DamageRed=3+(2*level);
		}
	}
	/* Method Description
	 *  Desc: This method check if the player has enough skill points to use  skill
	 *  Para: It takes in the amount of sp needed and the player that is using the skill
	 *  Return: it's returns a boolean value
	 */
	static public boolean checkSP(int sp, boolean player)
	{
		if(player)
		{
			if(sp>player1SP)
				return false;
			else
				return true;
		}
		else 
		{
			if(sp>player2SP)
				return false;
			else
				return true;
		}
	}
	/* Method Description
	 *  Desc: This method adds items to the inventory
	 *  Para: It takes in a string which is the item
	 *  Return: it's a void
	 */
	static public void addItem(String item)
	{
		if(item.equals("Health Potion"))
			ItemSkillList.HPPotion++;
		else if(item.equals("Skill Potion"))
			ItemSkillList.SPPotion++;
		else
			inventory.put(item, list.items.get(item));
	}
	/* Method Description
	 *  Desc: This method removes items from the inventory
	 *  Para: It takes in a string which is the item
	 *  Return: it's a void
	 */
	static public void removeItem(String item)
	{
		inventory.remove(item);
	}
	/* Method Description
	 *  Desc: This method adds items to the player inventory
	 *  Para: It takes in a string which is the item and the player that it will add to
	 *  Return: it's a void
	 */
	static public void addItemPlayer(String item,int player)
	{
		if(player==1)
		{
			if(item.equals("Practice Sword")||item.equals("Iron Sword")||item.equals("Legendary Sword"))
				p1Weapon=item;
			if(item.equals("Leather Armour")||item.equals("Iron Armour")||item.equals("Legendary Armour"))
				p1Armour=item;
			player1MaxHealth+=ItemSkillList.items.get(item).getHealth();
			player1Health+=ItemSkillList.items.get(item).getHealthRegen();
			player1SP+=ItemSkillList.items.get(item).getSkillRegen();
			player1AttackStrenght+=ItemSkillList.items.get(item).getAttackBuff();
			player1DamageRed+=ItemSkillList.items.get(item).getDamageRed();
		}
		else if(player==2)
		{
			if(item.equals("Wooden Staff")||item.equals("Mythical Staff")||item.equals("Legendary Staff"))
				p2Weapon=item;
			if(item.equals("Tattered Robes")||item.equals("Reinforced Robes")||item.equals("Legendary Robes"))
				p2Armour=item;
			player2MaxHealth+=ItemSkillList.items.get(item).getHealth();
			player2Health+=ItemSkillList.items.get(item).getHealthRegen();
			player2SP+=ItemSkillList.items.get(item).getSkillRegen();
			player2AttackStrenght+=ItemSkillList.items.get(item).getAttackBuff();
			player2DamageRed+=ItemSkillList.items.get(item).getDamageRed();
		}
	}
	/* Method Description
	 *  Desc: This method removes items from the player inventory
	 *  Para: It takes in a string which is the item and the player that it is taking from
	 *  Return: it's a void
	 */
	static public void removeItemPlayer(String item,int player)
	{
		if(player==1)
		{
			player1MaxHealth-=ItemSkillList.items.get(item).getHealth();
			player1Health-=ItemSkillList.items.get(item).getHealthRegen();
			player1SP-=ItemSkillList.items.get(item).getSkillRegen();
			player1AttackStrenght-=ItemSkillList.items.get(item).getAttackBuff();
			player1DamageRed-=ItemSkillList.items.get(item).getDamageRed();
		}
		else if(player==2)
		{
			player2MaxHealth-=ItemSkillList.items.get(item).getHealth();
			player2Health-=ItemSkillList.items.get(item).getHealthRegen();
			player2SP-=ItemSkillList.items.get(item).getSkillRegen();
			player2AttackStrenght-=ItemSkillList.items.get(item).getAttackBuff();
			player2DamageRed-=ItemSkillList.items.get(item).getDamageRed();
		}
	}
	/* Method Description
	 *  Desc: This method resets everting for a game over
	 *  Para: None
	 *  Return: it's a void
	 */
	static public void gameOver()
	{
		inventory.clear();
		p1Weapon="Empty";
		p2Weapon="Empty";
		p1Armour="Empty";
		p2Armour="Empty";
		player1EXP=0;
		player2EXP=0;
		player1MaxEXP=0;
		player2MaxEXP=0;
	}
}
