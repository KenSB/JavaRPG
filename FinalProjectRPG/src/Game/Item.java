package Game;

import java.awt.Image;
import java.awt.Toolkit;
/* Class Description
 * This class creates items.
 */
public class Item 
{
	private int type;
	private int healthBuff;
	private int attackBuff;
	private int damageRedBuff;
	private int healthRegen;
	private int skillRegen;
	private int cost;
	Image image;
	Item(String image,int healthBuff,int attackBuff,int damageRedBuff,int healthRegen,int skillRegen,int cost,int type)
	{
		this.image=Toolkit.getDefaultToolkit ().getImage (image+".png");
		this.healthBuff=healthBuff;
		this.attackBuff=attackBuff;
		this.damageRedBuff=damageRedBuff;
		this.healthRegen=healthRegen;
		this.skillRegen=skillRegen;
		this.cost=cost;
		this.type=type;
	}
	public int getHealth()
	{
		return healthBuff;
	}
	public int getAttackBuff()
	{
		return attackBuff;
	}
	public int getDamageRed()
	{
		return damageRedBuff;
	}
	public int getHealthRegen()
	{
		return healthRegen;
	}
	public int getSkillRegen()
	{
		return skillRegen;
	}
	public int getType()
	{
		return type;
	}
}