package Game;

import java.awt.Image;
import java.awt.Toolkit;

/* Class Description
 * This class manages creates the monsters that are fought in game.
 */
public class Mob 
{
	private int HP;
	private int attackDamage;
	private int damageRed;
	private int expGain;
	Image picture;
	Mob(int HP,int attackDamage,int damageRed,int  expGain, Image pic)
	{
		this.HP=HP;
		this.attackDamage=attackDamage;
		this.damageRed=damageRed;
		this.expGain=expGain;
		picture= pic;

	}
	Mob()
	{
		
	}
	//getters
	public int getHP()
	{
		return HP;
	}
	public int getAD()
	{
		return attackDamage;
	}
	public int getDR()
	{
		return damageRed;
	}
	public int getEG()
	{
		return expGain;
	}
	public Image getImage()
	{
		return picture;
	}
	//setters
	public void setHP(int HP)
	{
		this.HP=HP;
	}
	public void setAD(int AD)
	{
		this.attackDamage=AD;
	}
	public void setDR(int DR)
	{
		this.damageRed=DR;
	}
	public void setEG(int EG)
	{
		this.expGain=EG;
	}
}
