package Game;

import Game.Main.BATTLEPHASE;
import Game.Main.STATE;
import Game.Main.TEXT;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* Class Description
 * This class does everything that has to do with the battle sequence.
 */
public class Battle  
{
	//All variable related to the battle sequence
	static Text text=new Text();
	static Images image= new Images();
	static Rect rect = new Rect();
	static HashMap<String,Mob> mobs = new HashMap<String,Mob>();
	static LinkedList<Mob>enemies = new LinkedList<Mob>();
	static boolean win=false;
	static boolean animation=false;;
	static int addX=-550;
	static int count=0;
	static int numEnemy;
	static int playerSelect=1;
	static int totalExp;
	static boolean p1AOE=false;
	static boolean p2AOE=false;
	static boolean p1Hit=false;
	static boolean p2Hit=false;
	static boolean p1Buff=false;
	static boolean p2Buff=false;
	static boolean p1Fight=true;
	static boolean p2Fight=true;
	static boolean once=true;
	static int mob1Att=0;
	static int mob2Att=0;
	static int mob3Att=0;
	static int mob4Att=0;
	static int mob5Att=0;
	static boolean cycle=true;
	static int mobNum=0;
	static boolean spNote=false;
	static int damage;
	//CONSTRUCTOR
	Battle()
	{
		animate ani=new animate();
		mobs.put("slime", new Mob(10,8,1,1,Images.slime));
		mobs.put("goldenSlime",  new Mob(100,10,4,10,Images.goldenSlime));
		mobs.put("doggo", new Mob(20,3,1,1,Images.doggo));
		ani.start();
	}
	/* Thread Description
	 *  This thread animates the battle start animation.
	 */
	public class animate extends Thread
	{
		public void run ()
		{
			while (true)
			{
				if(animation)
				{
					addX+=25;
					count++;
					if(count==100)
					{
						animation=false;
						addX=-550;
					}
				}
				try
				{
					sleep (50);
				}
				catch (Exception e)
				{
				}
			}
		}
	}
	/* Method Description
	 *  Desc: This method controls player 1's fight
	 *  Para: None
	 *  Return: it's a void
	 */
	public static void startFightP1()
	{
		if(p1AOE)
		{
			damage=ItemSkillList.skillFire();
			for(int count=0;count<numEnemy;count++)
				enemies.get(count).setHP(enemies.get(count).getHP()-damage);
		}
		if(p1Buff)
			ItemSkillList.skillStrength(Main.player1Sec);
		if(!p1AOE&&!p1Buff)
		{
			if(Main.player1Att==1)
			{
				if(p1Hit)
					enemies.get(0).setHP(enemies.get(0).getHP()-ItemSkillList.skillSlash());
				else
					enemies.get(0).setHP(enemies.get(0).getHP()-(PlayerStats.player1AttackStrenght+PlayerStats.player1TempStrenght-enemies.get(0).getDR()));
			}
			else if(Main.player1Att==2)
			{
				if(p1Hit)
					enemies.get(1).setHP(enemies.get(1).getHP()-ItemSkillList.skillSlash());
				else
					enemies.get(1).setHP(enemies.get(1).getHP()-(PlayerStats.player1AttackStrenght+PlayerStats.player1TempStrenght-enemies.get(1).getDR()));		
			}
			else if(Main.player1Att==3)
			{
				if(p1Hit)
					enemies.get(2).setHP(enemies.get(2).getHP()-ItemSkillList.skillSlash());
				else
					enemies.get(2).setHP(enemies.get(2).getHP()-(PlayerStats.player1AttackStrenght+PlayerStats.player1TempStrenght-enemies.get(2).getDR()));
			}
			else if(Main.player1Att==4)
			{
				if(p1Hit)
					enemies.get(3).setHP(enemies.get(3).getHP()-ItemSkillList.skillSlash());
				else
					enemies.get(3).setHP(enemies.get(3).getHP()-(PlayerStats.player1AttackStrenght+PlayerStats.player1TempStrenght-enemies.get(3).getDR()));
			}
			else if(Main.player1Att==5)
			{
				if(p1Hit)
					enemies.get(4).setHP(enemies.get(4).getHP()-ItemSkillList.skillSlash());
				else
					enemies.get(4).setHP(enemies.get(4).getHP()-(PlayerStats.player1AttackStrenght+PlayerStats.player1TempStrenght-enemies.get(4).getDR()));
			}
		}
	}
	/* Method Description
	 *  Desc: This method controls player 1's fight
	 *  Para: None
	 *  Return: it's a void
	 */
	public static void startFightP2()
	{
		if(p2AOE)
		{
			damage=ItemSkillList.skillBlizzard();
			for(int count=0;count<numEnemy;count++)
				enemies.get(count).setHP(enemies.get(count).getHP()-damage);
		}
		if(p2Buff)
			ItemSkillList.skillHeal(Main.player2Sec);
		if(!p2AOE&&!p2Buff)
		{
			if(Main.player2Att==1)
			{
				if(p2Hit)
					enemies.get(0).setHP(enemies.get(0).getHP()-ItemSkillList.skillHydro());
				else
					enemies.get(0).setHP(enemies.get(0).getHP()-(PlayerStats.player2AttackStrenght+PlayerStats.player2TempStrenght-enemies.get(0).getDR()));;
			}
			else if(Main.player2Att==2)
			{
				if(p2Hit)
					enemies.get(1).setHP(enemies.get(1).getHP()-ItemSkillList.skillHydro());
				else
					enemies.get(1).setHP(enemies.get(1).getHP()-(PlayerStats.player2AttackStrenght+PlayerStats.player2TempStrenght-enemies.get(1).getDR()));;
			}
			else if(Main.player2Att==3)
			{
				if(p2Hit)
					enemies.get(2).setHP(enemies.get(2).getHP()-ItemSkillList.skillHydro());
				else
					enemies.get(2).setHP(enemies.get(2).getHP()-(PlayerStats.player2AttackStrenght+PlayerStats.player2TempStrenght-enemies.get(2).getDR()));;
			}
			else if(Main.player2Att==4)
			{
				if(p2Hit)
					enemies.get(3).setHP(enemies.get(3).getHP()-ItemSkillList.skillHydro());
				else
					enemies.get(3).setHP(enemies.get(3).getHP()-(PlayerStats.player2AttackStrenght+PlayerStats.player2TempStrenght-enemies.get(3).getDR()));;
			}
			else if(Main.player2Att==5)
			{
				if(p2Hit)
					enemies.get(4).setHP(enemies.get(4).getHP()-ItemSkillList.skillHydro());
				else
					enemies.get(4).setHP(enemies.get(4).getHP()-(PlayerStats.player2AttackStrenght+PlayerStats.player2TempStrenght-enemies.get(4).getDR()));;
			}
		}
	}
	public static void startFightMobs(int current)
	{
		System.out.println("asdasd");
		if(enemies.get(current-1).getHP()>0)
		{
			if(current==1)
				playerSelect=mob1Att;
			if(current==2)
				playerSelect=mob2Att;
			if(current==3)
				playerSelect=mob3Att;
			if(current==4)
				playerSelect=mob4Att;
			if(current==5)
				playerSelect=mob5Att;
			if(playerSelect==1)
			{
				if(PlayerStats.player1DamageRed>=enemies.get(current-1).getAD());
				else
				{
					PlayerStats.player1Health-=(enemies.get(current-1).getAD()-PlayerStats.player1DamageRed-PlayerStats.player1TempRed);
				}
			}
			else
			{
				if(PlayerStats.player2DamageRed>=enemies.get(current-1).getAD());
				else
				{
					PlayerStats.player2Health-=(enemies.get(current-1).getAD()-PlayerStats.player2DamageRed-PlayerStats.player2TempRed);
				}
			}
		}
	}
	/* Method Description
	 *  Desc: This method checks for a win
	 *  Para: None
	 *  Return: it's a void
	 */
	public static void winCheck()
	{
		win=true;
		for(int num=0;num<numEnemy;num++)
		{
			if(enemies.get(num).getHP()>0)
				win=false;
		}
		if(win)
		{
			for(int num=0;num<numEnemy;num++)
			{
				PlayerStats.player1EXP+=enemies.get(num).getEG();
				PlayerStats.player2EXP+=enemies.get(num).getEG();
			}
			Main.Phase=BATTLEPHASE.FINISH;
		}
		else
		{
			Main.selectAtt=0;
			p1AOE=false;
			p2AOE=false;
			p1Hit=false;
			p2Hit=false;
			p1Buff=false;
			p2Buff=false;
			PlayerStats.player1TempRed=0;
			PlayerStats.player2TempRed=0;
			PlayerStats.player1TempStrenght=0;
			PlayerStats.player2TempStrenght=0;
			if(PlayerStats.player1Health<=0)
			{
				PlayerStats.p1KO=true;
				Main.p1turn=false;
			}
			if(PlayerStats.player2Health<=0)
			{
				PlayerStats.p2KO=true;
			}
			if(PlayerStats.p1KO&&PlayerStats.p2KO)
			{
				Main.State=STATE.GAMEOVER;
				PlayerStats.p1KO=false;
				PlayerStats.p2KO=false;
			}
			Main.Phase=BATTLEPHASE.ACTION;
		}
	}
	/* Method Description
	 *  Desc: This method creates the monsters that will be fought
	 *  Para: A string of enemies
	 *  Return: it's a void
	 */
	public static void mobCreator(String [] enemy)
	{
		enemies.clear();
		numEnemy=enemy.length;
		for(int num=0;num<numEnemy;num++)
		{
			enemies.addLast(new Mob(mobs.get(enemy[num]).getHP(),mobs.get(enemy[num]).getAD(),mobs.get(enemy[num]).getDR(),mobs.get(enemy[num]).getEG(),((Image)mobs.get(enemy[num]).getImage())));
		}
		for(int num=0;num<numEnemy;num++)
		{
			totalExp+=enemies.get(num).getEG();
		}
	}
	/* Method Description
	 *  Desc: This method is the paint component of the battle class
	 *  Para: It takes in a graphical component and a string of enemies
	 *  Return: it's a void
	 */
	public static void createBattle(Graphics g,String [] enemy)
	{
		if(count==0)
			animation=true;
		if(count>49)
		{
			numEnemy=enemy.length;
			g.setColor(Color.lightGray);
			g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
			g.setColor(Color.CYAN);
			g.fillRect(25, 350, 600, 275);
			g.setColor(Color.BLACK);
			g.drawRect(100, 375, 200, 225);
			g.drawRect(350, 375, 200, 225);
			g.setFont(Text.fnt0);
			g.drawString("Attack", 175, 525);
			g.drawString("Skill", 175, 555);
			g.drawString("Item", 175, 585);
			g.drawString("Attack", 425, 525);
			g.drawString("Skill", 425, 555);
			g.drawString("Item", 425, 585);
			g.drawImage(image.down, 130, 385, 100, 100, null);
			g.drawImage(image.blueProtagonist, 385, 385, 100, 100, null);
			g.drawString("HP:"+ PlayerStats.player1Health,225,430);
			g.drawString("SP:"+ PlayerStats.player1SP,225,460);
			g.drawString("EXP:"+ PlayerStats.player1EXP,225,490);
			g.drawString("HP:"+ PlayerStats.player2Health,480,430);
			g.drawString("SP:"+ PlayerStats.player2SP,480,460);
			g.drawString("EXP:"+ PlayerStats.player2EXP,480,490);
			g.drawString("HP:"+ PlayerStats.player1Health,225,430);
			if(numEnemy==1)
			{
				g.drawImage(enemies.get(0).getImage(), 250, 150, 100, 100, null);
				g.drawString("HP:"+ enemies.get(0).getHP(),275,140);
			}
			if(numEnemy==2)
			{	
				g.drawImage(enemies.get(0).getImage(), 150, 150, 100, 100, null);
				g.drawString("HP:"+ enemies.get(0).getHP(),190,140);
				g.drawImage(enemies.get(1).getImage(), 400, 150, 100, 100, null);
				g.drawString("HP:"+ enemies.get(1).getHP(),440,140);
			}
			if(numEnemy==3)
			{
				g.drawImage(enemies.get(0).getImage(), 100, 150, 100, 100, null);
				g.drawString("HP:"+ enemies.get(0).getHP(),150,140);
				g.drawImage(enemies.get(1).getImage(), 275, 150, 100, 100, null);
				g.drawString("HP:"+ enemies.get(1).getHP(),325,140);
				g.drawImage(enemies.get(2).getImage(), 450, 150, 100, 100, null);
				g.drawString("HP:"+ enemies.get(2).getHP(),500,140);
			}
			if(numEnemy==4)
			{
				g.drawImage(enemies.get(0).getImage(), 115, 200, 100, 100, null);
				g.drawString("HP:"+ enemies.get(0).getHP(),150,190);
				g.drawImage(enemies.get(1).getImage(), 200, 75, 100, 100, null);
				g.drawString("HP:"+ enemies.get(1).getHP(),250,50);
				g.drawImage(enemies.get(2).getImage(), 360, 75, 100, 100, null);
				g.drawString("HP:"+ enemies.get(2).getHP(),400,50);
				g.drawImage(enemies.get(3).getImage(), 440, 200, 100, 100, null);
				g.drawString("HP:"+ enemies.get(3).getHP(),500,190);
			}
			if(numEnemy==5)
			{
				g.drawImage(enemies.get(0).getImage(), 20, 150, 100, 100, null);
				g.drawString("HP:"+ enemies.get(0).getHP(),110,200);
				g.drawImage(enemies.get(1).getImage(), 70, 30, 100, 100, null);
				g.drawString("HP:"+ enemies.get(1).getHP(),160,60);
				g.drawImage(enemies.get(2).getImage(), 250, -10, 100, 100, null);
				g.drawString("HP:"+ enemies.get(2).getHP(),340,30);
				g.drawImage(enemies.get(3).getImage(), 410, 30, 100, 100, null);
				g.drawString("HP:"+ enemies.get(3).getHP(),490,60);
				g.drawImage(enemies.get(4).getImage(), 440, 150, 100, 100, null);
				g.drawString("HP:"+ enemies.get(4).getHP(),515,200);

			}
			if(Main.Phase==BATTLEPHASE.ACTION)
			{
				if(Main.p1turn)
				{
					if(Main.selectAct==0)
						g.drawRect(170, 500, 75, 30);
					else if(Main.selectAct==1)
						g.drawRect(170, 530, 75, 30);
					else if(Main.selectAct==2)
						g.drawRect(170, 560, 75, 30);
				}
				else
				{
					if(Main.selectAct==0)
						g.drawRect(420, 500, 75, 30);
					else if(Main.selectAct==1)
						g.drawRect(420, 530, 75, 30);
					else if(Main.selectAct==2)
						g.drawRect(420, 560, 75, 30);
				}
			}
			if(Main.Phase==BATTLEPHASE.SKILLS)
			{
				if(Main.p1turn)
				{
					g.setColor(Color.GRAY);
					g.fillRect(25, 350, 300, 275);
					g.setColor(Color.BLACK);
					g.drawString("Strengthen", 175, 425);
					g.drawString("Slash", 175, 455);
					g.drawString("FireStorm", 175, 485);
					g.drawString("Back", 175, 515);
					if(Main.selectAct2==0)
						g.drawRect(170, 400, 100, 30);
					else if(Main.selectAct2==1)
						g.drawRect(170, 430, 100, 30);
					else if(Main.selectAct2==2)
						g.drawRect(170, 460, 100, 30);
					else if(Main.selectAct2==3)
						g.drawRect(170, 490, 100, 30);
				}
				else
				{
					g.setColor(Color.GRAY);
					g.fillRect(325, 350, 300, 275);
					g.setColor(Color.BLACK);
					g.drawString("Heal", 420, 425);
					g.drawString("Hydro Blast", 420, 455);
					g.drawString("Blizzard", 420, 485);
					g.drawString("Back", 420, 515);
					if(Main.selectAct2==0)
						g.drawRect(420, 400, 100, 30);
					else if(Main.selectAct2==1)
						g.drawRect(420, 430, 100, 30);
					else if(Main.selectAct2==2)
						g.drawRect(420, 460, 100, 30);
					else if(Main.selectAct2==3)
						g.drawRect(420, 490, 100, 30);
				}
				if(spNote)
				{
					text.writeText(g, "Battle-Not enough SP to use that skill");
				}
			}
			if(Main.Phase==BATTLEPHASE.ITEM)
			{

				g.setFont(Game.Text.fnt2);
				g.setColor(Color.DARK_GRAY);
				g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
				g.drawImage(ItemSkillList.items.get("Health Potion").image, 50, 50, 100, 100, null);
				g.drawImage(ItemSkillList.items.get("Skill Potion").image, 50, 150, 100, 100, null);
				g.setColor(Color.BLACK);
				g.drawString("Health Potion: "+ItemSkillList.HPPotion, 150, 80);
				g.drawString("Skill Potion: "+ItemSkillList.SPPotion, 150, 180);

				if(Main.battleItemSelect==0)
					g.drawRect(50, 50, 100, 100);
				else if(Main.battleItemSelect==1)				
					g.drawRect(50, 150, 100, 100);
				else if(Main.battleItemSelect==2)
					g.drawRect(500, 575, 75, 50);
				g.setColor(Color.BLACK);
				g.drawString("BACK", 500, 600);
				g.drawRect(25, 25, 575, 400);

				if(Main.battleItemSelect==0)
					g.drawString("The Health Potion retores 15 HP", 100, 500);
				if(Main.battleItemSelect==1)
					g.drawString("The Skill Potion retores 15 SP", 100, 500);

			}

			if(Main.Phase==BATTLEPHASE.BUFF)
			{
				if(Main.p1turn)
				{
					g.setColor(Color.BLACK);
					if(Main.selectSec==1)
						g.drawRect(130, 380, 120, 120);
					else if(Main.selectSec==2)
						g.drawRect(380, 380, 120, 120);
				}
				else
				{
					g.setColor(Color.BLACK);
					if(Main.selectSec==1)
						g.drawRect(130, 380, 120, 120);
					else if(Main.selectSec==2)
						g.drawRect(380, 380, 120, 120);
				}
			}
			else if(Main.Phase==BATTLEPHASE.ATTACK)
			{
				g.setColor(Color.BLACK);
				if(numEnemy==1)
				{
					if(Main.selectAtt==1)
						g.drawRect(225, 100, 170, 170);
				}
				if(numEnemy==2)
				{
					if(Main.selectAtt==1)
						g.drawRect(115, 100, 170, 170);
					else if(Main.selectAtt==2)
						g.drawRect(365, 100, 170, 170);
				}
				if(numEnemy==3)
				{
					if(Main.selectAtt==1)
						g.drawRect(70, 100, 170, 170);
					else if(Main.selectAtt==2)
						g.drawRect(245, 100, 170, 170);
					else if(Main.selectAtt==3)
						g.drawRect(420, 100, 170, 170);
				}
				if(numEnemy==4)
				{
					if(Main.selectAtt==1)
						g.drawRect(90, 160, 170, 170);
					else if(Main.selectAtt==2)
						g.drawRect(170, 20, 170, 170);
					else if(Main.selectAtt==3)
						g.drawRect(340, 20, 170, 170);
					else if(Main.selectAtt==4)
						g.drawRect(415 , 160, 170, 170);
				}
				if(numEnemy==5)
				{
					if(Main.selectAtt==1)
						g.drawRect(40, 160, 170, 170);
					else if(Main.selectAtt==2)
						g.drawRect(90, 30, 170, 170);
					else if(Main.selectAtt==3)
						g.drawRect(270, 0, 170, 170);
					else if(Main.selectAtt==4)
						g.drawRect(425 , 30, 170, 170);
					else if(Main.selectAtt==5)
						g.drawRect(460, 160, 170, 170);
				}

			}
			else if(Main.Phase==BATTLEPHASE.FIGHTP1)
			{
				if(p1Buff)
					text.writeText(g, "Battle-Scarlet used Strengthen");
				else if(p1Hit)
					text.writeText(g, "Battle-Scarlet used Slash on Mob "+Main.player1Att);
				else if(p1AOE)
					text.writeText(g, "Battle-Scarlet used Fire Storm");
				else if(Main.itemP1SelHP)
					text.writeText(g, "Battle-Scarlet used a Health Potion");
				else if(Main.itemP1SelSP)
					text.writeText(g, "Battle-Scarlet used a Skill Potion");
				else
					text.writeText(g, "Battle-Scarlet attacked Mob "+Main.player1Att);
			}
			else if(Main.Phase==BATTLEPHASE.FIGHTP2)
			{
				if(p2Buff)
					text.writeText(g, "Battle-Aqus used Heal");
				else if(p2Hit)
					text.writeText(g, "Battle-Aqus used HydroBullet on Mob "+Main.player2Att);
				else if(p2AOE)
					text.writeText(g, "Battle-Aqus used Blizzard");
				else if(Main.itemP2SelHP)
					text.writeText(g, "Battle-Aqus used a Health Potion");
				else if(Main.itemP2SelSP)
					text.writeText(g, "Battle-Aqus used a SKill Potion");
				else
					text.writeText(g, "Battle-Aqus attacked Mob "+Main.player2Att);
			}
			else if(Main.Phase==BATTLEPHASE.FIGHTMOB)
			{
				if(once)
				{
					once=false;
					mob1Att=(int) (Math.round(Math.random() * (2 - 1) + 1));
					mob2Att=(int) (Math.round(Math.random() * (2 - 1) + 1));
					mob3Att=(int) (Math.round(Math.random() * (2 - 1) + 1));
					mob4Att=(int) (Math.round(Math.random() * (2 - 1) + 1));
					mob5Att=(int) (Math.round(Math.random() * (2 - 1) + 1));
					if(PlayerStats.p1KO||PlayerStats.p2KO)
					{
						if(PlayerStats.p1KO)
						{
							mob1Att=2;
							mob2Att=2;
							mob3Att=2;
							mob4Att=2;
							mob5Att=2;
						}
						if(PlayerStats.p2KO)
						{
							mob1Att=1;
							mob2Att=1;
							mob3Att=1;
							mob4Att=1;
							mob5Att=1;
						}
					}
				}
				if(cycle)
				{
					cycle=false;
					mobNum++;
				}
				if(mobNum==1&&numEnemy>=1)
				{
					if(enemies.get(0).getHP()>0)
						text.writeText(g, "Battle- mob "+mobNum+" attacked "+mob1Att);
				}
				else if(mobNum==2&&numEnemy>=2)
				{
					if(enemies.get(1).getHP()>0)
						text.writeText(g, "Battle- mob "+mobNum+" attacked "+mob2Att);
				}
				else if(mobNum==3&&numEnemy>=3)
				{
					if(enemies.get(2).getHP()>0)
						text.writeText(g, "Battle- mob "+mobNum+" attacked "+mob3Att);
				}
				else if(mobNum==4&&numEnemy>=4)
				{
					if(enemies.get(3).getHP()>0)
						text.writeText(g, "Battle- mob "+mobNum+" attacked "+mob4Att);
				}
				else if(mobNum==5&&numEnemy==5)
				{
					if(enemies.get(4).getHP()>0)
						text.writeText(g, "Battle- mob "+mobNum+" attacked "+mob5Att);
				}
			}
			else if(Main.Phase==BATTLEPHASE.FINISH)
			{

				g.setColor(Color.BLACK);
				g.fillRect(25, 250, 500, 200);
				g.setColor(Color.WHITE);
				g.drawString("Player 1 gained "+(totalExp)+" EXP", 50, 300);
				g.drawString("Player 2 gained "+(totalExp)+" EXP", 50, 350);
			}
		}
		if(animation)
		{
			g.setColor(Color.BLACK);
			g.fillRect(-650+addX, 0, 1200, 50);
			g.fillRect(-700+addX, 50, 1200, 50);
			g.fillRect(-750+addX, 100, 1200, 50);
			g.fillRect(-800+addX, 150, 1200, 50);
			g.fillRect(-850+addX, 200, 1200, 50);
			g.fillRect(-900+addX, 250, 1200, 50);
			g.fillRect(-950+addX, 300, 1200, 50);
			g.fillRect(-1000+addX, 350, 1200, 50);
			g.fillRect(-1050+addX, 400, 1200, 50);
			g.fillRect(-1100+addX, 450, 1200, 50);
			g.fillRect(-1150+addX, 500, 1200, 50);
			g.fillRect(-1200+addX, 550, 1200, 50);
			g.fillRect(-1250+addX, 600, 1200, 50);
			g.fillRect(-1300+addX, 650, 1200, 50);	
		}
	}
}