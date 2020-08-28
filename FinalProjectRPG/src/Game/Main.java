package Game;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel implements ActionListener, KeyListener, MouseListener, Comparable<String>
{
	Rect rect = new Rect();
	static Movement move= new Movement();
	Battle battle=new Battle();
	Images image= new Images();
	Text text=new Text();
	Maps maps = new Maps();
	//enumerators that keep track of the current states of the game
	public static enum MAP
	{
		FOREST,
		HOUSE,
		AREA1,
		AREA2,
		AREA3,
		AREA4,
		AREA5,
		TEST
	};
	public static enum STATE
	{
		MENU,
		LOADMENU,
		GAMEMENU,
		GAMEMENUP1,
		GAMEMENUP2,
		GAMEMENUITEMS,
		GAMEMENUSAVE,
		BATTLE,
		GAME,
		GAMEOVER
	};
	public static enum BATTLEPHASE
	{
		ACTION,
		SKILLS,
		ITEM,
		ATTACK,
		ACTION2,
		ATTACK2,
		FIGHTP1,
		FIGHTP2,
		FIGHTMOB,
		FINISH, 
		BUFF
	};
	public static enum TEXT
	{
		FALSE,
		TRUE
	}
	public static enum SPEACH
	{
		INTROTEXT,
		SCENE1TEXT,
		SCENE2TEXT,
		SCENE3TEXT,
		SCENE4TEXT,
		SCENE5TEXT,
		SCENE6TEXT,
		GAMESAVE,
		ITEMHPPOTION,
		ITEMSPPOTION,
		CHESTEMPTY,
		ITEMIRONSWORD,
		ITEMMYTHICALSTAFF,
		ITEMLEGENDARYSWORD,
		ITEMLEGENDARYSTAFF,
		TEXT1,
		TEXTDOOR,
		TEXTSHELF,
		TEXTBED,
		TEXT5
	};
	public static  BATTLEPHASE Phase = BATTLEPHASE.ACTION;
	public static STATE State = STATE.MENU;
	public static SPEACH Speach = SPEACH.SCENE1TEXT;
	public static MAP map = MAP.AREA1;
	public static TEXT Text=TEXT.TRUE;
	//All the variables that keep the game running
	static int selectAct=0;
	static int selectAct2=-1;
	static int selectAtt=0;
	static int selectSec=1;
	static int menuSelect=0;
	static int loadMenuSelect=0;
	static int loadMenuSaveSelect=-1;
	static int gameMenuSelect=2;
	static int gameItemSelect=0;
	static int gameItemSelectEquip=0;
	static int battleItemSelect=0;
	static int gameOverSelect=-1;
	static int player1InfoSelect=0;
	static int player2InfoSelect=0;
	int mobs=4;
	static int player1Att=0;
	static int player2Att=0;
	static int player1Sec=0;
	static int player2Sec=0;
	static boolean p1turn=true;
	static boolean p2turn=false;
	static boolean itemP1SelHP=false;
	static boolean itemP2SelHP=false;
	static boolean itemP1SelSP=false;
	static boolean itemP2SelSP=false;

	int skip=0;
	boolean animation=false;
	int aniSwitch=0;
	int aniDirect=0;

	static int page=0;
	static int adY=100;
	static boolean focusSaves=false;
	static boolean load=false;
	static boolean switchPage=true;
	String str;
	int imageCount=0;
	static int saveCounter=0;
	static Scanner saves;
	Scanner inText1;
	Scanner inText2;
	Scanner inText3;
	Scanner inText4;
	Scanner inText5;
	Scanner inText6;
	AudioClip mainMenuMusic;
	AudioClip battleMusic;
	AudioClip gameMusic;

	boolean scenePlay=true;
	Iterator<Item> scan;
	Item hold;
	int plusX;

	static boolean chest1=true;
	static boolean chest2=true;
	static boolean chest3=true;
	static boolean chest5=true;
	static boolean testChest1=true;
	static boolean testChest2=true;
	static boolean testChest3=true;
	static boolean testChest4=true;

	ArrayList<String> itemDesc=new ArrayList<String>();

	private  Set<Integer> pressed = new HashSet<Integer>();
	Object[] pressArray;
	Object[] releaseArray;
	int keyCode;
	int keyCode2;
	int numHold;
	int numHold2;
	int numHold3;
	int numHold4;
	int keysNum=0;
	static boolean spacePress=false;

	static int itemSelect=0;

	static ArrayList <String> saveGames=new ArrayList<String>();

	static String [] fight1 = {"slime","slime"};
	static String [] fight2 = {"slime","slime","slime"};
	static String [] fight3 = {"slime","slime","slime","slime"};
	static String [] fight4 = {"goldenSlime"};

	static String [] fight=fight1;
	static int counter;
	/* Method description
	 * Desc: This is the keeyPressed Method, pretty self explanatory, it detects for keys pressed on the key board
	 * Para: It requires a KeyEvent to run
	 * Return: It's a void
	*/
	public void keyPressed(KeyEvent e) 
	{
		if(State==STATE.GAME)
		{
			numHold2=e.getKeyCode();
			if(numHold2==KeyEvent.VK_I&&map!=MAP.AREA1)
			{
				State=STATE.GAMEMENU;
			}
			if(numHold2==KeyEvent.VK_A)
			{
				map=MAP.TEST;
				PlayerStats.addItemPlayer("Wooden Staff", 2);
				PlayerStats.addItemPlayer("Practice Sword", 1);
				PlayerStats.addItemPlayer("Leather Armour", 1);
				PlayerStats.addItemPlayer("Tattered Robes", 2);
			}
			if(numHold2==37||numHold2==38||numHold2==39||numHold2==40)
			{
				animation=true;
				pressed.add(numHold2);
				keysNum=pressed.size();
				pressArray=pressed.toArray();
				keyCode=(Integer)pressArray[0];
				if (pressed.size()== 2&&((pressed.contains(37)&&pressed.contains(38))||((pressed.contains(38)&&pressed.contains(39))||(pressed.contains(39)&&pressed.contains(40))||(pressed.contains(40)&&pressed.contains(37)))))
				{			
					pressArray=pressed.toArray();
					if((Integer)pressArray[0]==38||(Integer)pressArray[1]==38)
					{
						if((Integer)pressArray[0]==37||(Integer)pressArray[1]==37)
						{
							Movement.direction=Movement.UPLEFT;
							Movement.face=Movement.LEFT;
						}
						else if((Integer)pressArray[0]==39||(Integer)pressArray[1]==39)
						{
							Movement.direction=Movement.UPRIGHT;
							Movement.face=Movement.RIGHT;
						}
					}
					else if((Integer)pressArray[1]==40||(Integer)pressArray[0]==40)
					{
						if((Integer)pressArray[0]==37||(Integer)pressArray[1]==37)
						{
							Movement.direction=Movement.DOWNLEFT;
							Movement.face=Movement.LEFT;
						}
						else if((Integer)pressArray[0]==39||(Integer)pressArray[1]==39)
						{
							Movement.direction=Movement.DOWNRIGHT;
							Movement.face=Movement.RIGHT;
						}
					}
				}
				else if(keyCode==KeyEvent.VK_UP)
				{
					Movement.direction=Movement.UP;
					Movement.face=Movement.UP;
				}	
				else if(keyCode==KeyEvent.VK_DOWN)
				{
					Movement.direction=Movement.DOWN;	
					Movement.face=Movement.DOWN;
				}	
				else if(keyCode==KeyEvent.VK_LEFT)
				{
					Movement.direction=Movement.LEFT;	
					Movement.face=Movement.LEFT;
				}		
				else if(keyCode==KeyEvent.VK_RIGHT)
				{
					Movement.direction=Movement.RIGHT;
					Movement.face=Movement.RIGHT;
				}
				pressArray=null;	
			}
			if(Text==TEXT.FALSE)
			{
				if(numHold2==32)
				{
					if(map==MAP.AREA1)
					{
						try {
							maps.objInteract(Movement.face, 1);
						} catch (IOException e1) {
							e1.printStackTrace();
						} 
					}
					else if(map==MAP.AREA2)
					{
						try {
							maps.objInteract(Movement.face, 2);
						} catch (IOException e1) {
							e1.printStackTrace();
						} 
					}
					else if(map==MAP.AREA3)
					{
						try {
							maps.objInteract(Movement.face, 3);
						} catch (IOException e1) {
							e1.printStackTrace();
						} 
					}
					else if(map==MAP.AREA4)
					{
						try {
							maps.objInteract(Movement.face, 4);
						} catch (IOException e1) {
							e1.printStackTrace();
						} 
					}
					else if(map==MAP.TEST)
					{
						try {
							maps.objInteract(Movement.face, 5);
						} catch (IOException e1) {
							e1.printStackTrace();
						} 
					}
				}
			}
			else if(Text==TEXT.TRUE)
			{
				if(numHold2==32)
				{
					if(Speach==SPEACH.INTROTEXT||Speach==SPEACH.SCENE1TEXT||Speach==SPEACH.SCENE2TEXT||Speach==SPEACH.SCENE3TEXT||Speach==SPEACH.SCENE4TEXT||Speach==SPEACH.SCENE5TEXT||Speach==SPEACH.SCENE6TEXT)
						switchPage=true;
					else
						Text=TEXT.FALSE;
				}
			}
		}
		if(State==STATE.BATTLE)
		{
			numHold2=e.getKeyCode();
			if(numHold2==KeyEvent.VK_D)
			{
				State=STATE.GAME;
			}
			else if(Phase==BATTLEPHASE.ACTION)
			{
				if(Battle.animation);
				else
				{
					if(numHold2==37||numHold2==38||numHold2==39||numHold2==40)
					{
						pressed.add(numHold2);
						pressArray=pressed.toArray();
						keyCode=(Integer)pressArray[0];
						if(keyCode==KeyEvent.VK_UP)
						{
							if(selectAct>0)
								selectAct--;
						}	
						else if(keyCode==KeyEvent.VK_DOWN)
						{
							if(selectAct!=2)
								selectAct++;	
						}
					}
					if(numHold2==KeyEvent.VK_SPACE&&selectAct==0)
					{
						Phase=BATTLEPHASE.ATTACK;
						pressed.clear();
						skip=0;
					}
					if(numHold2==KeyEvent.VK_SPACE&&selectAct==1)
					{
						Phase=BATTLEPHASE.SKILLS;
						pressed.clear();
						skip=0;
					}
					if(numHold2==KeyEvent.VK_SPACE&&selectAct==2)
					{
						Phase=BATTLEPHASE.ITEM;
						pressed.clear();
						skip=0;
					}
				}
			}
			else if(Phase==BATTLEPHASE.SKILLS)
			{
				if(numHold2==37||numHold2==38||numHold2==39||numHold2==40)
				{
					pressed.add(numHold2);
					pressArray=pressed.toArray();
					keyCode=(Integer)pressArray[0];
					if(keyCode==KeyEvent.VK_UP)
					{
						if(selectAct2>0)
							selectAct2--;
					}	
					else if(keyCode==KeyEvent.VK_DOWN)
					{
						if(selectAct2!=3)
							selectAct2++;	
					}
				}
				if(numHold2==KeyEvent.VK_SPACE&&Battle.spNote)
					Battle.spNote=false;
				else if(numHold2==KeyEvent.VK_SPACE&&selectAct2==0)
				{
					if(PlayerStats.checkSP(5+PlayerStats.player1Level, p1turn))
					{
						Phase=BATTLEPHASE.BUFF;
						pressed.clear();
						skip=0;
					}
					else
					{
						Battle.spNote=true;
					}
				}
				else if(numHold2==KeyEvent.VK_SPACE&&selectAct2==1)
				{
					if(PlayerStats.checkSP(3+PlayerStats.player1Level, p1turn))
					{
						if(p1turn)
							Battle.p1Hit=true;
						else
							Battle.p2Hit=true;
						Phase=BATTLEPHASE.ATTACK;
						pressed.clear();
						skip=0;
					}
					else
					{
						Battle.spNote=true;
					}
				}
				else if(numHold2==KeyEvent.VK_SPACE&&selectAct2==2)
				{
					if(PlayerStats.checkSP(7+PlayerStats.player1Level, p1turn))
					{
						if(p1turn)
						{
							Battle.p1AOE=true;
							player2Att=selectAtt;
							if(!PlayerStats.p2KO)
							{
								Phase=BATTLEPHASE.ACTION;
								p1turn=false;
							}
							else
							{
								Phase=BATTLEPHASE.FIGHTP1;
							}
						}
						else
						{
							Battle.p2AOE=true;
							player2Att=selectAtt;
							if(!PlayerStats.p1KO)
								Phase=BATTLEPHASE.FIGHTP1;
							p1turn=true;
						}


					}
					else
					{
						Battle.spNote=true;
					}
				}
				else if(numHold2==KeyEvent.VK_SPACE&&selectAct2==3)
				{
					Phase=BATTLEPHASE.ACTION;
					pressed.clear();
					skip=0;
				}
			}

			else if(Phase==BATTLEPHASE.ITEM)
			{
				if(numHold2==37||numHold2==38||numHold2==39||numHold2==40||numHold2==32)
				{
					pressed.clear();
					pressed.add(numHold2);
					pressArray=pressed.toArray();
					keyCode=(Integer)pressArray[0];
					if(keyCode==KeyEvent.VK_UP)
					{
						if(battleItemSelect!=0)
							battleItemSelect--;
					}	
					if(keyCode==KeyEvent.VK_DOWN)
					{
						if(battleItemSelect!=2)
							battleItemSelect++;	
					}
					if(keyCode==KeyEvent.VK_SPACE)
					{
						if(battleItemSelect==0)
						{
							if(ItemSkillList.HPPotion!=0)
							{
								ItemSkillList.HPPotion--;
								Phase=BATTLEPHASE.BUFF;
								if(p1turn)
									itemP1SelHP=true;
								else
									itemP2SelHP=true;
							}
						}
						if(battleItemSelect==1)						
						{
							if(ItemSkillList.SPPotion!=0)
							{
								ItemSkillList.SPPotion--;
								Phase=BATTLEPHASE.BUFF;
								if(p1turn)
									itemP1SelSP=true;
								else
									itemP2SelSP=true;
							}
						}
						if(battleItemSelect==2)
						{
							Phase=BATTLEPHASE.ACTION;
						}
					}
				}
			}
			else if(Phase==BATTLEPHASE.BUFF)
			{
				if(numHold2==37||numHold2==38||numHold2==39||numHold2==40)
				{
					pressed.add(numHold2);
					pressArray=pressed.toArray();
					keyCode=(Integer)pressArray[0];
					if(keyCode==KeyEvent.VK_LEFT)
					{
						if(selectSec!=1)
							selectSec--;
					}	
					else if(keyCode==KeyEvent.VK_RIGHT)
					{
						if(selectSec!=2)
							selectSec++;	
					}
				}
				if(numHold2==KeyEvent.VK_SPACE)
				{
					if(itemP1SelHP||itemP1SelSP||itemP2SelHP||itemP2SelSP)
					{
						if(itemP1SelHP||itemP2SelHP)
						{
							if(selectSec==1)
							{
								if(15+PlayerStats.player1Health>=PlayerStats.player1MaxHealth)
									PlayerStats.player1Health=PlayerStats.player1MaxHealth;
								else
									PlayerStats.player1Health+=15;
							}
							else if(selectSec==2)
							{
								if(15+PlayerStats.player2Health>=PlayerStats.player2MaxHealth)
									PlayerStats.player2Health=PlayerStats.player2MaxHealth;
								else
									PlayerStats.player2Health+=15;
							}
						}
						else if(itemP1SelSP||itemP2SelSP)
						{
							if(selectSec==1)
							{
								if(15+PlayerStats.player1SP>=PlayerStats.player1MaxSP)
									PlayerStats.player1SP=PlayerStats.player1MaxSP;
								else
									PlayerStats.player1SP+=15;
							}
							else if(selectSec==2)
							{
								if(15+PlayerStats.player2SP>=PlayerStats.player2MaxSP)
									PlayerStats.player2SP=PlayerStats.player2MaxSP;
								else
									PlayerStats.player2SP+=15;
							}
						}
						if(p1turn)
						{
							p1turn=false;
							Phase=BATTLEPHASE.ACTION;
						}
						else
							Phase=BATTLEPHASE.FIGHTP1;
					}
					else
					{
						if(p1turn)
						{
							Battle.p1Buff=true;
							player1Sec=selectSec;
							p1turn=false;
							Phase=BATTLEPHASE.ACTION;
						}
						else
						{
							Battle.p2Buff=true;
							player2Sec=selectSec;
							Phase=BATTLEPHASE.FIGHTP1;
							p1turn=true;
						}
					}
				}
			}
			else if(Phase==BATTLEPHASE.ATTACK)
			{
				numHold2=e.getKeyCode(); 
				pressed.clear();
				pressed.add(numHold2);
				pressArray=pressed.toArray();
				keyCode=(Integer)pressArray[0];
				if(keyCode==KeyEvent.VK_LEFT)
				{
					if(selectAtt-1==1)
					{
						if(Battle.enemies.get(0).getHP()>0)
							selectAtt--;
					}
					else if(selectAtt-1==2)
					{
						if(Battle.enemies.get(1).getHP()>0)
							selectAtt--;
						else if(Battle.enemies.get(0).getHP()>0)
							selectAtt-=2;
					}
					else if(selectAtt-1==3)
					{
						if(Battle.enemies.get(2).getHP()>0)
							selectAtt--;
						else if(Battle.enemies.get(1).getHP()>0)
							selectAtt-=2;
						else if(Battle.enemies.get(0).getHP()>0)
							selectAtt-=3;
					}
					else if(selectAtt-1==4)
					{
						if(Battle.enemies.get(3).getHP()>0)						
							selectAtt--;
						else if(Battle.enemies.get(2).getHP()>0)
							selectAtt-=2;
						else if(Battle.enemies.get(1).getHP()>0)
							selectAtt-=3;
						else if(Battle.enemies.get(0).getHP()>0)
							selectAtt-=4;
					}
				}


				else if(keyCode==KeyEvent.VK_RIGHT)
				{
					if(selectAtt+1>Battle.numEnemy);
					else
					{
						if(selectAtt+1==1)
						{
							if(Battle.enemies.get(0).getHP()>0)
								selectAtt++;
							else
							{
								if(selectAtt+2>Battle.numEnemy);
								else
								{
									if(Battle.enemies.get(1).getHP()>0)
										selectAtt+=2;
									else
									{
										if(selectAtt+3>Battle.numEnemy);
										else
										{
											if(Battle.enemies.get(2).getHP()>0)
												selectAtt+=3;
											else
											{
												if(selectAtt+4>Battle.numEnemy);
												else
												{
													if(Battle.enemies.get(3).getHP()>0)
														selectAtt+=4;
													else
													{
														if(Battle.enemies.get(4).getHP()>0)
															selectAtt+=5;
													}
												}
											}
										}
									}
								}
							}

						}
						try
						{
							if(selectAtt+1==2&&selectAtt+1<=Battle.numEnemy)
							{
								if(selectAtt+1<=Battle.numEnemy)
									if(Battle.enemies.get(1).getHP()>0)
										selectAtt++;
								if(selectAtt+2<=Battle.numEnemy)
									if(Battle.enemies.get(2).getHP()>0)
										selectAtt+=2;
								if(selectAtt+3<=Battle.numEnemy)
									if(Battle.enemies.get(3).getHP()>0)
										selectAtt+=3;
								if(selectAtt+4<=Battle.numEnemy)
									if(Battle.enemies.get(4).getHP()>0)
										selectAtt+=4;
							}
							else if(selectAtt+1==3&&selectAtt+1<=Battle.numEnemy)
							{
								if(Battle.enemies.get(2).getHP()>0)
									selectAtt++;
								else if(Battle.enemies.get(3).getHP()>0)
									selectAtt+=2;
								else if(Battle.enemies.get(4).getHP()>0)
									selectAtt+=3;
							}
							else if(selectAtt+1==4&&selectAtt+1<=Battle.numEnemy)
							{
								if(Battle.enemies.get(3).getHP()>0)
									selectAtt++;
								else if(Battle.enemies.get(4).getHP()>0)
									selectAtt+=2;
							}
							else if(selectAtt+1==5&&selectAtt+1<=Battle.numEnemy)
							{
								if(Battle.enemies.get(4).getHP()>0)						
									selectAtt++;
							}
						}
						catch(IndexOutOfBoundsException e1)
						{

						}
					}
				}
				if(keyCode==KeyEvent.VK_SPACE&&skip>0)
				{
					if(selectAtt!=0)
					{
						if(p1turn)
						{
							player1Att=selectAtt;
							Phase=BATTLEPHASE.FIGHTP1;
							if(!PlayerStats.p2KO)
							{
								p1turn=false;
								Phase=BATTLEPHASE.ACTION;
							}
						}
						else
						{
							player2Att=selectAtt;
							if(!PlayerStats.p1KO)
								Phase=BATTLEPHASE.FIGHTP1;
							else
								Phase=BATTLEPHASE.FIGHTP2;
							p1turn=true;
						}
					}
				}
				skip++;
			}
			else if(Phase==BATTLEPHASE.FIGHTP1)
			{
				if(numHold2==32)
				{
					if(!PlayerStats.p2KO)
						Phase=BATTLEPHASE.FIGHTP2;
					else
					{
						Battle.once=true;
						Phase=BATTLEPHASE.FIGHTMOB;
					}
					if(!PlayerStats.p1KO)
					{
						Battle.startFightP1();
					}
				}
			}
			else if(Phase==BATTLEPHASE.FIGHTP2)
			{
				if(numHold2==32)
				{
					Phase=BATTLEPHASE.FIGHTMOB;
					if(!PlayerStats.p2KO)
						Battle.startFightP2();
					Battle.once=true;
				}
			}
			else if(Phase==BATTLEPHASE.FIGHTMOB)
			{ 
				if(numHold2==32)
				{
					if(Battle.mobNum<Battle.numEnemy)
					{
						Battle.cycle=true;
						Battle.startFightMobs(Battle.mobNum);
					}
					else
					{
						Battle.startFightMobs(Battle.mobNum);
						Battle.winCheck();
						Battle.once=true;
						Battle.mobNum=1;
					}	
				}
			}
			else if(Phase==BATTLEPHASE.FINISH)
			{
				numHold2=e.getKeyCode();
				pressed.add(numHold2);
				pressArray=pressed.toArray();
				keyCode=(Integer)pressArray[0];
				if(keyCode==KeyEvent.VK_SPACE)
				{
					pressed.clear();
					Phase=BATTLEPHASE.ACTION;
					State=STATE.GAME;
					counter=0;
					selectAtt=0;
					Battle.totalExp=0;
					Battle.count=0;
					if(scenePlay)
					{
						Text=TEXT.TRUE;
						Speach=SPEACH.SCENE4TEXT;
						scenePlay=false;
					}
				}
			}
		}
		if(State==STATE.MENU)
		{
			numHold3=e.getKeyCode();
			if(numHold3==37||numHold3==38||numHold3==39||numHold3==40)
			{
				pressed.add(numHold3);
				pressArray=pressed.toArray();
				keyCode=(Integer)pressArray[0];
				if(keyCode==KeyEvent.VK_UP)
				{
					if(menuSelect!=0)
						menuSelect--;
				}	
				else if(keyCode==KeyEvent.VK_DOWN)
				{
					if(menuSelect!=2)
						menuSelect++;	
				}
			}
			if(numHold3==KeyEvent.VK_SPACE&&menuSelect==0)
			{
				State=STATE.GAME;
				load=true;
				Text=TEXT.TRUE;
			}
			if(numHold3==KeyEvent.VK_SPACE&&menuSelect==1)
			{
				State=STATE.LOADMENU;
			}
			if(numHold3==KeyEvent.VK_SPACE&&menuSelect==2)
			{
				System.exit(1);
			}
		}
		else if(State==STATE.LOADMENU)
		{
			numHold3=e.getKeyCode();
			if(numHold3==37||numHold3==38||numHold3==39||numHold3==40)
			{
				pressed.add(numHold3);
				pressArray=pressed.toArray();
				keyCode=(Integer)pressArray[0];
				if(keyCode==KeyEvent.VK_UP)
				{
					if(!focusSaves)
					{
						if(loadMenuSelect!=0)
							loadMenuSelect--;
					}
					else
					{
						page=(loadMenuSaveSelect-1)/5;
						if(loadMenuSaveSelect>0)
							loadMenuSaveSelect--;
					}
				}	
				else if(keyCode==KeyEvent.VK_DOWN)
				{
					if(!focusSaves)
					{
						if(loadMenuSelect!=1)
							loadMenuSelect++;	
					}
					else
					{
						page=(loadMenuSaveSelect+1)/5;
						if(loadMenuSaveSelect!=saveGames.size()-1)
							loadMenuSaveSelect++;
					}
				}
				else if(keyCode==KeyEvent.VK_LEFT)
				{
					if(!focusSaves)
						focusSaves=true;	
				}
				else if(keyCode==KeyEvent.VK_RIGHT)
				{
					if(focusSaves)
						focusSaves=false;
				}
				pressed.clear();
			}
			if(numHold3==KeyEvent.VK_SPACE&&loadMenuSelect==0&&loadMenuSaveSelect>=0)
			{
				State=STATE.GAME;
				load=true;
				try {
					loadSave("save"+loadMenuSaveSelect+".txt");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			if(numHold3==KeyEvent.VK_SPACE&&loadMenuSelect==1)
			{
				State=STATE.MENU;
				page=0;
				loadMenuSaveSelect=-1;
			}
		}
		if(State==STATE.GAMEMENU)
		{
			numHold4=e.getKeyCode();
			if(numHold4==37||numHold4==38||numHold4==39||numHold4==40)
			{
				pressed.add(numHold4);
				pressArray=pressed.toArray();
				keyCode=(Integer)pressArray[0];
				if(keyCode==KeyEvent.VK_UP)
				{
					if(gameMenuSelect!=0)
						gameMenuSelect--;
				}	
				if(keyCode==KeyEvent.VK_DOWN)
				{
					if(gameMenuSelect!=3)
						gameMenuSelect++;	
				}
				pressed.clear();
			}
			if(numHold4==KeyEvent.VK_SPACE&&gameMenuSelect==0)
			{
				State=STATE.GAMEMENUP1;
			}
			if(numHold4==KeyEvent.VK_SPACE&&gameMenuSelect==1)
			{
				State=STATE.GAMEMENUP2;
			}
			if(numHold4==KeyEvent.VK_SPACE&&gameMenuSelect==2)
			{
				State=STATE.GAMEMENUITEMS;
			}
			if(numHold4==KeyEvent.VK_SPACE&&gameMenuSelect==3)
			{
				State=STATE.GAME;
			}
		}
		else if(State==STATE.GAMEMENUP1||State==STATE.GAMEMENUP2)
		{
			numHold4=e.getKeyCode();
			if(numHold4==37||numHold4==38||numHold4==39||numHold4==40)
			{
				pressed.add(numHold4);
				pressArray=pressed.toArray();
				keyCode=(Integer)pressArray[0];
				if(keyCode==KeyEvent.VK_LEFT)
				{
					if(State==STATE.GAMEMENUP1)
						if(player1InfoSelect!=0)
							player1InfoSelect--;
					if(State==STATE.GAMEMENUP2)
						if(player2InfoSelect!=0)
							player2InfoSelect--;
				}	
				if(keyCode==KeyEvent.VK_RIGHT)
				{
					if(State==STATE.GAMEMENUP1)
						if(player1InfoSelect!=4)
							player1InfoSelect++;
					if(State==STATE.GAMEMENUP2)
						if(player2InfoSelect!=4)
							player2InfoSelect++;	
				}
				pressed.clear();
			}
			if(numHold4==KeyEvent.VK_SPACE)
			{
				State=STATE.GAMEMENU;
			}
		}
		else if(State==STATE.GAMEMENUITEMS)
		{
			numHold4=e.getKeyCode();
			if(numHold4==37||numHold4==38||numHold4==39||numHold4==40)
			{
				pressed.add(numHold4);
				pressArray=pressed.toArray();
				keyCode=(Integer)pressArray[0];
				if(keyCode==KeyEvent.VK_UP)
				{
					if(gameItemSelect!=0)
						gameItemSelect--;
				}	
				if(keyCode==KeyEvent.VK_DOWN)
				{
					if(gameItemSelect!=3)
						gameItemSelect++;	
				}
				if(keyCode==KeyEvent.VK_LEFT)
				{
					if(gameItemSelect==2&&gameItemSelectEquip!=0)
					{
						gameItemSelectEquip--;
					}
				}
				if(keyCode==KeyEvent.VK_RIGHT)
				{
					if(gameItemSelect==2&&gameItemSelectEquip!=3)
					{
						gameItemSelectEquip++;
					}
				}

				pressed.clear();
			}
			Iterator<String> i=PlayerStats.inventory.keySet().iterator();
			while(i.hasNext())
				itemDesc.add(i.next());
			Collections.sort(itemDesc);
			if(numHold4==KeyEvent.VK_SPACE&&gameItemSelect==3)
			{
				State=STATE.GAMEMENU;
			}
			if(numHold4==KeyEvent.VK_SPACE&&gameItemSelect==2)
			{
				if(itemDesc.get(gameItemSelectEquip).equals("Practice Sword"))
				{
					PlayerStats.addItem(PlayerStats.p1Weapon);
					PlayerStats.removeItemPlayer(PlayerStats.p1Weapon, 1);
					PlayerStats.p1Weapon="Practice Sword";
					PlayerStats.addItemPlayer(PlayerStats.p1Weapon,1);
				}
				else if(itemDesc.get(gameItemSelectEquip).equals("Iron Sword"))
				{
					PlayerStats.addItem(PlayerStats.p1Weapon);
					PlayerStats.removeItemPlayer(PlayerStats.p1Weapon, 1);
					PlayerStats.p1Weapon="Iron Sword";
					PlayerStats.addItemPlayer(PlayerStats.p1Weapon,1);
				}
				else if(itemDesc.get(gameItemSelectEquip).equals("Legendary Sword"))
				{
					PlayerStats.addItem(PlayerStats.p1Weapon);
					PlayerStats.removeItemPlayer(PlayerStats.p1Weapon, 1);
					PlayerStats.p1Weapon="Legendary Sword";
					PlayerStats.addItemPlayer(PlayerStats.p1Weapon,1);
				}
				else if(itemDesc.get(gameItemSelectEquip).equals("Wooden Staff"))
				{
					PlayerStats.addItem(PlayerStats.p2Weapon);
					PlayerStats.removeItemPlayer(PlayerStats.p2Weapon, 2);
					PlayerStats.p2Weapon="Wooden Staff";
					PlayerStats.addItemPlayer(PlayerStats.p2Weapon,2);
				}
				else if(itemDesc.get(gameItemSelectEquip).equals("Mythical Staff"))
				{
					PlayerStats.addItem(PlayerStats.p2Weapon);
					PlayerStats.removeItemPlayer(PlayerStats.p2Weapon, 2);
					PlayerStats.p2Weapon="Mythical Staff";
					PlayerStats.addItemPlayer(PlayerStats.p2Weapon,2);
				}
				else if(itemDesc.get(gameItemSelectEquip).equals("Legendary Staff"))
				{
					PlayerStats.addItem(PlayerStats.p2Weapon);
					PlayerStats.removeItemPlayer(PlayerStats.p2Weapon, 2);
					PlayerStats.p2Weapon="Legendary Staff";
					PlayerStats.addItemPlayer(PlayerStats.p2Weapon,2);
				}
				if(itemDesc.get(gameItemSelectEquip).equals("Leather Armour"))
				{
					PlayerStats.addItem(PlayerStats.p1Armour);
					PlayerStats.removeItemPlayer(PlayerStats.p1Armour, 1);
					PlayerStats.p1Armour="Leather Armour";
					PlayerStats.addItemPlayer(PlayerStats.p1Armour,1);
				}
				else if(itemDesc.get(gameItemSelectEquip).equals("Iron Armour"))
				{
					PlayerStats.addItem(PlayerStats.p1Armour);
					PlayerStats.removeItemPlayer(PlayerStats.p1Armour, 1);
					PlayerStats.p1Armour="Iron Armour";
					PlayerStats.addItemPlayer(PlayerStats.p1Armour,1);
				}
				else if(itemDesc.get(gameItemSelectEquip).equals("Legendary Armour"))
				{
					PlayerStats.addItem(PlayerStats.p1Armour);
					PlayerStats.removeItemPlayer(PlayerStats.p1Armour, 1);
					PlayerStats.p1Armour="Legendary Armour";
					PlayerStats.addItemPlayer(PlayerStats.p1Armour,1);
				}
				else if(itemDesc.get(gameItemSelectEquip).equals("Tattered Robes"))
				{
					PlayerStats.addItem(PlayerStats.p2Armour);
					PlayerStats.removeItemPlayer(PlayerStats.p2Armour, 2);
					PlayerStats.p2Armour="Tattered Robes";
					PlayerStats.addItemPlayer(PlayerStats.p2Armour,2);
				}
				else if(itemDesc.get(gameItemSelectEquip).equals("Reinforced Robes"))
				{
					PlayerStats.addItem(PlayerStats.p2Armour);
					PlayerStats.removeItemPlayer(PlayerStats.p2Armour, 2);
					PlayerStats.p2Armour="Reinforced Robes";
					PlayerStats.addItemPlayer(PlayerStats.p2Armour,2);
				}
				else if(itemDesc.get(gameItemSelectEquip).equals("Legendary Robes"))
				{
					PlayerStats.addItem(PlayerStats.p2Armour);
					PlayerStats.removeItemPlayer(PlayerStats.p2Armour, 2);
					PlayerStats.p2Armour="Legendary Robes";
					PlayerStats.addItemPlayer(PlayerStats.p2Armour,2);
				}
				PlayerStats.removeItem(itemDesc.get(gameItemSelectEquip));
			}
		}
		else if(State==STATE.GAMEOVER)
		{
			numHold4=e.getKeyCode();
			if(numHold4==37||numHold4==38||numHold4==39||numHold4==40||numHold4==32)
			{
				pressed.clear();
				pressed.add(numHold4);
				pressArray=pressed.toArray();
				keyCode=(Integer)pressArray[0];
				if(keyCode==KeyEvent.VK_UP)
				{
					if(gameOverSelect>0)
						gameOverSelect--;
				}	
				if(keyCode==KeyEvent.VK_DOWN)
				{
					if(gameOverSelect!=1)
						gameOverSelect++;	
				}
				if(keyCode==KeyEvent.VK_SPACE)
				{
					if(gameOverSelect==0)
					{
						State=STATE.MENU;
						PlayerStats.gameOver();
						Speach= SPEACH.SCENE1TEXT;
						map = MAP.AREA1;
						Text=TEXT.TRUE;
						gameOverSelect=-1;
						selectAct=0;
						p1turn=true;
						PlayerStats.player1TempRed=0;
						PlayerStats.player2TempRed=0;
						PlayerStats.player1TempStrenght=0;
						PlayerStats.player2TempStrenght=0;

					}
					if(gameOverSelect==1)
					{
						System.exit(1);
					}
				}
			}
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		if(State==STATE.GAME)
		{	
			numHold=e.getKeyCode();
			if(numHold==37||numHold==38||numHold==39||numHold==40)
			{
				pressed.remove(numHold);
				if(pressed.size()==1)
				{
					if(pressed.contains(37))
					{
						Movement.direction=Movement.LEFT;
					}
					else if(pressed.contains(38))
					{
						Movement.direction=Movement.UP;
					}
					else if(pressed.contains(39))
					{
						Movement.direction=Movement.RIGHT;
					}
					else if(pressed.contains(40))
					{
						Movement.direction=Movement.DOWN;
					}
				}
				else if(pressed.size()==0)
				{
					Movement.direction=0;
					animation=false;
				}
			}
		}
		if(State==STATE.BATTLE)
		{
			pressed.clear();
		}
		if(State==STATE.MENU)
		{
			pressed.clear();
		}

	}
	/* Thread Description
	 *  This thread continuously checks for whether the players have leveled up.
	 */
	public class DetectLevelChange extends Thread
	{
		public void run ()
		{
			while (true)
			{
				if(PlayerStats.player1EXP>=PlayerStats.player1MaxEXP)
				{
					PlayerStats.statChangeLevel(PlayerStats.player1Level, 1);
				}
				else if(PlayerStats.player2EXP>=PlayerStats.player2MaxEXP)
				{
					PlayerStats.statChangeLevel(PlayerStats.player2Level, 2);
				}
				try
				{
					sleep (25);
				}
				catch (Exception e)
				{
				}
			}
		}
	}
	/* Thread Description
	 *  This thread moves the player and the world around them.
	 */
	public class MoveRect1 extends Thread
	{
		public void run ()
		{
			while (true)
			{
				if(Main.State==STATE.GAME)
				{
					if(Text==TEXT.TRUE);
					else
					{
						move.colisionDetect();
						if (Movement.direction == Movement.UP)
						{
							aniDirect=Movement.UP;
							if(!move.up)
							{
								Movement.backgroundMoveY+=5;
								Movement.playerMoveY-=5;
							}
						}	
						else if (Movement.direction == Movement.DOWN)
						{
							aniDirect=Movement.DOWN;
							if(!move.down)
							{
								Movement.backgroundMoveY-=5;
								Movement.playerMoveY+=5;
							}					
						}
						else if (Movement.direction == Movement.LEFT)
						{
							aniDirect=Movement.LEFT;
							if(!move.left)
							{
								Movement.backgroundMoveX+=5;
								Movement.playerMoveX-=5;
							}
						}			
						else if (Movement.direction == Movement.RIGHT)
						{
							aniDirect=Movement.RIGHT;
							if(!move.right)
							{
								Movement.backgroundMoveX-=5;
								Movement.playerMoveX+=5;
							}
						}
						else if (Movement.direction == Movement.UPRIGHT)
						{
							aniDirect=Movement.UPRIGHT;
							if(!move.upRight)
							{
								Movement.backgroundMoveX-=5;
								Movement.backgroundMoveY+=5;
								Movement.playerMoveX+=5;
								Movement.playerMoveY-=5;
							}
						}
						else if (Movement.direction == Movement.UPLEFT)
						{
							aniDirect=Movement.UPLEFT;
							if(!move.upLeft)
							{
								Movement.backgroundMoveX+=5;
								Movement.backgroundMoveY+=5;
								Movement.playerMoveX-=5;
								Movement.playerMoveY-=5;
							}
						}
						else if (Movement.direction == Movement.DOWNRIGHT)
						{
							aniDirect=Movement.DOWNRIGHT;
							if(!move.downRight)
							{
								Movement.backgroundMoveX-=5;
								Movement.backgroundMoveY-=5;
								Movement.playerMoveX+=5;
								Movement.playerMoveY+=5;
							}
						}
						else if (Movement.direction == Movement.DOWNLEFT)
						{
							aniDirect=Movement.DOWNLEFT;
							if(!move.downLeft)
							{
								Movement.backgroundMoveX+=5;
								Movement.backgroundMoveY-=5;
								Movement.playerMoveX-=5;
								Movement.playerMoveY+=5;
							}				
						}
					}
				}
				repaint ();
				try
				{
					sleep (25);
				}
				catch (Exception e)
				{
				}

			}
		}
	}
	/* Thread Description
	 *  This thread animates the walking animation.
	 */
	public class AnimateMotion extends Thread
	{
		public void run ()
		{
			while (true)
			{
				if(Main.State==STATE.GAME)
				{
					if(Text==TEXT.TRUE);
					else
					{
						if(animation&&aniSwitch!=1)
							aniSwitch=1;
						else if(animation&&aniSwitch!=-1)
							aniSwitch=-1;
						else
							aniSwitch=0;
					}
				}
				try
				{
					sleep (250);
				}
				catch (Exception e)
				{
				}
			}
		}
	}
	/* Thread Description
	 *  This thread makes an artificial loading time between maps
	 */
	public class Loading extends Thread
	{
		public void run ()
		{
			int count=1;
			while (true)
			{	
				if(load&&count==1)
				{
					count++;
				}
				else
				{
					count=1;
					load=false;
				}
				repaint();
				try
				{
					sleep (1000);
				}
				catch (Exception e)
				{
				}
			}
		}
	}
	/* Thread Description
	 *  This thread plays music
	 */
	public class music extends Thread 
	{
		public void run ()
		{
			int timePlayedMain=0;
			int timePlayedBattle=0;
			int timePlayedGame=0;
			while (true)
			{		
				if((State!=STATE.MENU&&State!=STATE.LOADMENU))
				{
					mainMenuMusic.stop();
					timePlayedMain=0;
				}
				else if(((State==STATE.MENU||State==STATE.LOADMENU)&&timePlayedMain==0))
				{
					mainMenuMusic.play();
					timePlayedMain++;
				}
				else
					timePlayedMain++;
				if(timePlayedMain==65)
					timePlayedMain=0;
				if((State!=STATE.BATTLE))
				{
					battleMusic.stop();
					timePlayedBattle=0;
				}
				else if((State==STATE.BATTLE&&timePlayedBattle==0))
				{
					battleMusic.play();
					timePlayedBattle++;
				}
				else
					timePlayedBattle++;
				if(timePlayedGame==65)
					timePlayedGame=0;
				if(timePlayedGame==65)
					timePlayedGame=0;
				if((State!=STATE.GAME))
				{
					gameMusic.stop();
					timePlayedGame=0;
				}
				else if((State==STATE.GAME&&timePlayedGame==0))
				{
					gameMusic.play();
					timePlayedGame++;
				}
				else
					timePlayedGame++;
				if(timePlayedGame==65)
					timePlayedGame=0;
				try
				{
					sleep (1000);
				}
				catch (Exception e)
				{
				}
			}
		}
	}
	public URL getCompleteURL (String fileName)
	{
		try
		{
			return new URL ("file:" + System.getProperty ("user.dir") + "/" + fileName);
		}
		catch (MalformedURLException e)
		{
			System.err.println (e.getMessage ());
		}
		return null;
	}
	/* Method Description
	 *  Desc: This method saves the game
	 *  Para:None
	 *  Return: it's a void
	 */
	public static void saveSave() throws IOException
	{
		saveCounter=saveGames.size();
		saveGames.add("save"+saveCounter+".txt");
		BufferedWriter writeToSaves = new BufferedWriter(new FileWriter("Saves.txt",true));
		writeToSaves.write("save"+saveCounter+".txt");
		writeToSaves.newLine();
		writeToSaves.close();
		BufferedWriter writeSave = new BufferedWriter(new FileWriter("save"+saveCounter+".txt"));
		if(map==MAP.AREA3)
			writeSave.write("AREA3");
		writeSave.newLine();
		writeSave.write("LVL");
		writeSave.newLine();
		writeSave.write(PlayerStats.player1Level+"");
		writeSave.newLine();
		writeSave.write("EXP");
		writeSave.newLine();
		writeSave.write(PlayerStats.player1EXP+"");
		writeSave.newLine();
		writeSave.write("EQUIP1");
		writeSave.newLine();
		writeSave.write(PlayerStats.p1Weapon);
		writeSave.newLine();
		writeSave.write(PlayerStats.p1Armour);
		writeSave.newLine();
		writeSave.write("EQUIP2");
		writeSave.newLine();
		writeSave.write(PlayerStats.p2Weapon);
		writeSave.newLine();
		writeSave.write(PlayerStats.p2Armour);
		writeSave.newLine();
		writeSave.write("ITEMS");
		Iterator <String> inv=PlayerStats.inventory.keySet().iterator();
		writeSave.newLine();
		while(inv.hasNext())
		{
			writeSave.write(inv.next());
			writeSave.newLine();
		}
		writeSave.write("----");
		writeSave.newLine();
		writeSave.write("POTIONS");
		writeSave.newLine();
		if(ItemSkillList.HPPotion==0)
			writeSave.write(0+"");
		else
			writeSave.write(ItemSkillList.HPPotion+"");
		writeSave.newLine();
		if(ItemSkillList.SPPotion==0)
			writeSave.write(0+"");
		else
			writeSave.write(ItemSkillList.SPPotion+"");
		writeSave.close();
		saves=new Scanner(new File("saves.txt"));
	}
	/* Method Description
	 *  Desc: This method loads a saved game
	 *  Para: It takes in a string which is the txt file where the game is stored
	 *  Return: it's a void
	 */
	public static void loadSave(String file) throws FileNotFoundException
	{
		Scanner save=new Scanner(new File(file));
		String str;
		Text=TEXT.FALSE;
		str=save.nextLine();
		if(str.equals("AREA3"))
			map=MAP.AREA3;
		while(save.hasNextLine())
		{
			str=save.nextLine();
			if(str.equals(null)||str.equals(""));
			else
			{
				if(str.equals("LVL"))
				{
					PlayerStats.player1Level=save.nextInt()-1;
					PlayerStats.player2Level=PlayerStats.player1Level;
					PlayerStats.statChangeLevel(PlayerStats.player1Level,1);
					PlayerStats.statChangeLevel(PlayerStats.player2Level,2);
				}
				else if(str.equals("EXP"))
				{
					PlayerStats.player1EXP=save.nextInt();
					PlayerStats.player2EXP=PlayerStats.player1EXP;	
				}
				else if(str.equals("EQUIP1"))
				{
					str=save.nextLine();
					PlayerStats.addItemPlayer(str,1);
					str=save.nextLine();
					PlayerStats.addItemPlayer(str,1);	
				}
				else if(str.equals("EQUIP2"))
				{
					str=save.nextLine();
					PlayerStats.addItemPlayer(str,2);
					str=save.nextLine();
					PlayerStats.addItemPlayer(str,2);
				}
				else if(str.equals("ITEMS"))
				{
					str=save.nextLine();
					while(!str.equals("----"))
					{
						PlayerStats.addItem(str);
						str=save.nextLine();
					}
				}
				else if(str.equals("POTIONS"))
				{
					ItemSkillList.HPPotion=save.nextInt();
					ItemSkillList.SPPotion=save.nextInt();
				}
			}
		}
		save.close();
	}
	//CONSTRUCTOR
	public Main() throws FileNotFoundException
	{
		saves = new Scanner(new File("Saves.txt"));
		while(saves.hasNextLine())
		{
			str=saves.nextLine();
			if(!str.equals(null)||!str.equals(""))
				saveGames.add(str+".txt");
		}
		mainMenuMusic=Applet.newAudioClip (getCompleteURL ("mainMenuMusic.wav"));
		battleMusic=Applet.newAudioClip (getCompleteURL ("battleMusic.wav"));
		gameMusic=Applet.newAudioClip (getCompleteURL ("gameMusic.wav"));
		setPreferredSize(new Dimension(650, 650));
		setLayout (new BoxLayout (this, BoxLayout.PAGE_AXIS));
		setBackground(Color.ORANGE);
		MoveRect1 move = new MoveRect1();
		AnimateMotion animate = new AnimateMotion();
		DetectLevelChange lvlChange = new DetectLevelChange();
		Loading l=new Loading();
		music menuMusic = new music();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		move.start ();
		lvlChange.start();
		animate.start();
		l.start();
		menuMusic.start();
		inText1 = new Scanner(new File("Intro.txt"));
		inText2 = new Scanner(new File("cutScene1.txt"));
		inText3 = new Scanner(new File("cutScene2.txt"));
		inText4 = new Scanner(new File("cutScene3.txt"));
		inText5 = new Scanner(new File("cutScene4.txt"));
		inText6 = new Scanner(new File("Outro.txt"));
	}
	/* Method Description
	 *  Desc: This is the paintComponent and it is responsible for displaying all graphics on screen
	 *  Para: A graphics component
	 *  Return: it's a void
	 */
	public void paintComponent(Graphics g) 
	{
		if(load)
		{
			g.setColor(Color.BLACK);
			g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
		}
		else
		{
			if(State==STATE.GAME)
			{
				g.setColor(Color.WHITE);
				g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
				if(map==MAP.FOREST)
				{
					maps.drawMap(g, 1);
				}
				if(map==MAP.AREA1)
				{
					maps.drawMap(g, 2);
				}
				if(map==MAP.AREA2)
				{
					maps.drawMap(g, 3);
				}
				if(map==MAP.AREA3)
				{
					maps.drawMap(g, 4);
				}
				if(map==MAP.AREA4)
				{
					maps.drawMap(g, 5);
				}
				if(map==MAP.TEST)
				{
					maps.drawMap(g, 6);
				}
				if(aniDirect==Movement.UP)
				{
					if(aniSwitch==1)
						g.drawImage(image.up1, 300, 300, 50, 50, this);
					else if(aniSwitch==-1)
						g.drawImage(image.up2, 300, 300, 50, 50, this);
					else
						g.drawImage(image.up, 300, 300, 50, 50, this);
				}
				else if(aniDirect==Movement.DOWN||aniDirect==0)
				{
					if(aniSwitch==1)
						g.drawImage(image.down1, 300, 300, 50, 50, this);
					else if(aniSwitch==-1)
						g.drawImage(image.down2, 300, 300, 50, 50, this);
					else
						g.drawImage(image.down, 300, 300, 50, 50, this);
				}
				else if(aniDirect==Movement.LEFT)
				{
					if(aniSwitch==1)
						g.drawImage(image.left1, 300, 300, 50, 50, this);
					else if(aniSwitch==-1)
						g.drawImage(image.left2, 300, 300, 50, 50, this);
					else
						g.drawImage(image.left, 300, 300, 50, 50, this);
				}
				else if(aniDirect==Movement.RIGHT)
				{
					if(aniSwitch==1)
						g.drawImage(image.right1, 300, 300, 50, 50, this);
					else if(aniSwitch==-1)
						g.drawImage(image.right2, 300, 300, 50, 50, this);
					else
						g.drawImage(image.right, 300, 300, 50, 50, this);
				}
				else if(aniDirect==Movement.UPRIGHT)
				{
					if(aniSwitch==1)
						g.drawImage(image.right1, 300, 300, 50, 50, this);
					else if(aniSwitch==-1)
						g.drawImage(image.right2, 300, 300, 50, 50, this);
					else
						g.drawImage(image.right, 300, 300, 50, 50, this);
				}
				else if(aniDirect==Movement.UPLEFT)
				{
					if(aniSwitch==1)
						g.drawImage(image.left1, 300, 300, 50, 50, this);
					else if(aniSwitch==-1)
						g.drawImage(image.left2, 300, 300, 50, 50, this);
					else
						g.drawImage(image.left, 300, 300, 50, 50, this);
				}
				else if(aniDirect==Movement.DOWNRIGHT)
				{
					if(aniSwitch==1)
						g.drawImage(image.right1, 300, 300, 50, 50, this);
					else if(aniSwitch==-1)
						g.drawImage(image.right2, 300, 300, 50, 50, this);
					else
						g.drawImage(image.right, 300, 300, 50, 50, this);
				}
				else if(aniDirect==Movement.DOWNLEFT)
				{
					if(aniSwitch==1)
						g.drawImage(image.left1, 300, 300, 50, 50, this);
					else if(aniSwitch==-1)
						g.drawImage(image.left2, 300, 300, 50, 50, this);
					else
						g.drawImage(image.left, 300, 300, 50, 50, this);
				}

				Movement.clearMap();
				if(map==MAP.FOREST)
				{
					move.createObject(rect.largeTreeVerti2.x+Movement.backgroundMoveX, rect.largeTreeVerti2.y+Movement.backgroundMoveY, rect.largeTreeVerti2.width, rect.largeTreeVerti2.height,1);
					move.createObject(rect.largeTreeHori5.x+Movement.backgroundMoveX, rect.largeTreeHori5.y+Movement.backgroundMoveY, rect.largeTreeHori5.width, rect.largeTreeHori5.height,1);
					move.createObject(rect.largeTreeHori6.x+Movement.backgroundMoveX, rect.largeTreeHori6.y+Movement.backgroundMoveY, rect.largeTreeHori6.width, rect.largeTreeHori6.height,1);
					move.createObject(rect.doggo1.x+Movement.backgroundMoveX, rect.doggo1.y+Movement.backgroundMoveY, rect.doggo1.width, rect.doggo1.height,2);

				}
				if(map==MAP.AREA1)
				{
					move.createObject(rect.woodenWall1.x+Movement.backgroundMoveX, rect.woodenWall1.y+Movement.backgroundMoveY, rect.woodenWall1.width, rect.woodenWall1.height,1);
					move.createObject(rect.woodenWall2.x+Movement.backgroundMoveX, rect.woodenWall2.y+Movement.backgroundMoveY, rect.woodenWall2.width, rect.woodenWall2.height,1);
					move.createObject(rect.woodenWall3.x+Movement.backgroundMoveX, rect.woodenWall3.y+Movement.backgroundMoveY, rect.woodenWall3.width, rect.woodenWall3.height,1);
					move.createObject(rect.woodenWall4.x+Movement.backgroundMoveX, rect.woodenWall4.y+Movement.backgroundMoveY, rect.woodenWall4.width, rect.woodenWall4.height,1);
					move.createObject(rect.woodenWall5.x+Movement.backgroundMoveX, rect.woodenWall5.y+Movement.backgroundMoveY, rect.woodenWall5.width, rect.woodenWall5.height,1);
					move.createObject(rect.woodenWall6.x+Movement.backgroundMoveX, rect.woodenWall6.y+Movement.backgroundMoveY, rect.woodenWall6.width, rect.woodenWall6.height,1);
					move.createObject(rect.woodenWall6.x+Movement.backgroundMoveX, rect.woodenWall6.y+Movement.backgroundMoveY, rect.woodenWall6.width, rect.woodenWall6.height,1);
					move.createObject(rect.black1.x+Movement.backgroundMoveX, rect.black1.y+Movement.backgroundMoveY, rect.black1.width, rect.black1.height,1);
					move.createObject(rect.black2.x+Movement.backgroundMoveX, rect.black2.y+Movement.backgroundMoveY, rect.black2.width, rect.black2.height,1);
					move.createObject(rect.black4.x+Movement.backgroundMoveX, rect.black4.y+Movement.backgroundMoveY, rect.black4.width, rect.black4.height,1);
					move.createObject(rect.door1.x+Movement.backgroundMoveX, rect.door1.y+Movement.backgroundMoveY, rect.door1.width, rect.door1.height,2);
					move.createObject(rect.bkshelf1.x+Movement.backgroundMoveX, rect.bkshelf1.y+Movement.backgroundMoveY, rect.bkshelf1.width, rect.bkshelf1.height,3);
					move.createObject(rect.bedGreen.x+Movement.backgroundMoveX, rect.bedGreen.y+Movement.backgroundMoveY, rect.bedGreen.width, rect.bedGreen.height,4);
					if(!Maps.doorOpen)
						move.createObject(rect.magicRock.x+Movement.backgroundMoveX, rect.magicRock.y+Movement.backgroundMoveY, rect.magicRock.width, rect.magicRock.height,5);
				}
				if(map==MAP.AREA2)
				{
					move.createObject(rect.map1House.x+Movement.backgroundMoveX, rect.map1House.y+Movement.backgroundMoveY, rect.map1House.width, rect.map1House.height, 1);
					move.createObject(rect.map1House2.x+Movement.backgroundMoveX, rect.map1House2.y+Movement.backgroundMoveY, rect.map1House2.width, rect.map1House2.height, 1);
					move.createObject(rect.map1House3.x+Movement.backgroundMoveX, rect.map1House3.y+Movement.backgroundMoveY, rect.map1House3.width, rect.map1House3.height, 1);
					move.createObject(rect.map1House4.x+Movement.backgroundMoveX, rect.map1House4.y+Movement.backgroundMoveY, rect.map1House4.width, rect.map1House4.height, 1);
					move.createObject(rect.map1House5.x+Movement.backgroundMoveX, rect.map1House5.y+Movement.backgroundMoveY, rect.map1House5.width, rect.map1House5.height, 1);
					move.createObject(rect.map1House6.x+Movement.backgroundMoveX, rect.map1House6.y+Movement.backgroundMoveY, rect.map1House6.width, rect.map1House6.height, 1);
					move.createObject(rect.map1House7.x+Movement.backgroundMoveX, rect.map1House7.y+Movement.backgroundMoveY, rect.map1House7.width, rect.map1House7.height, 1);

					move.createObject(rect.treeRow1.x+Movement.backgroundMoveX, rect.treeRow1.y+Movement.backgroundMoveY, rect.treeRow1.width, rect.treeRow1.height, 1);
					move.createObject(rect.treeRow2.x+Movement.backgroundMoveX, rect.treeRow2.y+Movement.backgroundMoveY, rect.treeRow2.width, rect.treeRow2.height, 1);
					move.createObject(rect.tree1.x+Movement.backgroundMoveX, rect.tree1.y+Movement.backgroundMoveY, rect.tree1.width, rect.tree1.height, 1);
					move.createObject(rect.tree2.x+Movement.backgroundMoveX, rect.tree2.y+Movement.backgroundMoveY, rect.tree2.width, rect.tree2.height, 1);
					move.createObject(rect.tree3.x+Movement.backgroundMoveX, rect.tree3.y+Movement.backgroundMoveY, rect.tree3.width, rect.tree3.height, 1);
					move.createObject(rect.tree4.x+Movement.backgroundMoveX, rect.tree4.y+Movement.backgroundMoveY, rect.tree4.width, rect.tree4.height, 1);
					move.createObject(rect.tree5.x+Movement.backgroundMoveX, rect.tree5.y+Movement.backgroundMoveY, rect.tree5.width, rect.tree5.height, 1);
					move.createObject(rect.tree6.x+Movement.backgroundMoveX, rect.tree6.y+Movement.backgroundMoveY, rect.tree6.width, rect.tree6.height, 1);
					move.createObject(rect.tree7.x+Movement.backgroundMoveX, rect.tree7.y+Movement.backgroundMoveY, rect.tree7.width, rect.tree7.height, 1);
					move.createObject(rect.tree8.x+Movement.backgroundMoveX, rect.tree8.y+Movement.backgroundMoveY, rect.tree8.width, rect.tree8.height, 1);
					move.createObject(rect.tree9.x+Movement.backgroundMoveX, rect.tree9.y+Movement.backgroundMoveY, rect.tree9.width, rect.tree9.height, 1);
					move.createObject(rect.tree10.x+Movement.backgroundMoveX, rect.tree10.y+Movement.backgroundMoveY, rect.tree10.width, rect.tree10.height, 1);
					move.createObject(rect.tree11.x+Movement.backgroundMoveX, rect.tree11.y+Movement.backgroundMoveY, rect.tree11.width, rect.tree11.height, 1);
					move.createObject(rect.tree12.x+Movement.backgroundMoveX, rect.tree12.y+Movement.backgroundMoveY, rect.tree12.width, rect.tree12.height, 1);
					move.createObject(rect.tree13.x+Movement.backgroundMoveX, rect.tree13.y+Movement.backgroundMoveY, rect.tree13.width, rect.tree13.height, 1);
					move.createObject(rect.tree14.x+Movement.backgroundMoveX, rect.tree14.y+Movement.backgroundMoveY, rect.tree14.width, rect.tree14.height, 1);
					move.createObject(rect.tree15.x+Movement.backgroundMoveX, rect.tree15.y+Movement.backgroundMoveY, rect.tree15.width, rect.tree15.height, 1);
					move.createObject(rect.tree16.x+Movement.backgroundMoveX, rect.tree16.y+Movement.backgroundMoveY, rect.tree16.width, rect.tree16.height, 1);
					move.createObject(rect.tree17.x+Movement.backgroundMoveX, rect.tree17.y+Movement.backgroundMoveY, rect.tree17.width, rect.tree17.height, 1);
					move.createObject(rect.tree18.x+Movement.backgroundMoveX, rect.tree18.y+Movement.backgroundMoveY, rect.tree18.width, rect.tree18.height, 1);
					move.createObject(rect.grassPath.x+Movement.backgroundMoveX, rect.grassPath.y+Movement.backgroundMoveY, rect.grassPath.width, rect.grassPath.height, 0);
					move.createObject(rect.invWall1.x+Movement.backgroundMoveX, rect.invWall1.y+Movement.backgroundMoveY, rect.invWall1.width, rect.invWall1.height, 1);
					move.createObject(rect.invWall2.x+Movement.backgroundMoveX, rect.invWall2.y+Movement.backgroundMoveY, rect.invWall2.width, rect.invWall2.height, 1);
					move.createObject(rect.invWall3.x+Movement.backgroundMoveX, rect.invWall3.y+Movement.backgroundMoveY, rect.invWall3.width, rect.invWall3.height, 6);
					if(Maps.group1)
						move.createObject(rect.slime1.x+Movement.backgroundMoveX, rect.slime1.y+Movement.backgroundMoveY, rect.slime1.width, rect.slime1.height, 3);
					if(Maps.group2)
						move.createObject(rect.slime2.x+Movement.backgroundMoveX, rect.slime2.y+Movement.backgroundMoveY, rect.slime2.width, rect.slime2.height, 4);
					if(Maps.group3)
						move.createObject(rect.slime3.x+Movement.backgroundMoveX, rect.slime3.y+Movement.backgroundMoveY, rect.slime3.width, rect.slime3.height, 5);
				}
				if(map==MAP.AREA3)
				{
					move.createObject(rect.trees1.x+Movement.backgroundMoveX, rect.trees1.y+Movement.backgroundMoveY, rect.trees1.width, rect.trees1.height, 1);
					move.createObject(rect.trees2.x+Movement.backgroundMoveX, rect.trees2.y+Movement.backgroundMoveY, rect.trees2.width, rect.trees2.height, 1);
					move.createObject(rect.trees3.x+Movement.backgroundMoveX, rect.trees3.y+Movement.backgroundMoveY, rect.trees3.width, rect.trees3.height, 1);
					move.createObject(rect.trees4.x+Movement.backgroundMoveX, rect.trees4.y+Movement.backgroundMoveY, rect.trees4.width, rect.trees4.height, 1);
					move.createObject(rect.saveBed1.x+Movement.backgroundMoveX, rect.saveBed1.y+Movement.backgroundMoveY, rect.saveBed1.width, rect.saveBed1.height, 2);
					move.createObject(rect.chest1.x+Movement.backgroundMoveX, rect.chest1.y+Movement.backgroundMoveY, rect.chest1.width, rect.chest1.height, 3);
					move.createObject(rect.chest2.x+Movement.backgroundMoveX, rect.chest2.y+Movement.backgroundMoveY, rect.chest2.width, rect.chest2.height, 4);
					move.createObject(rect.chest2.x+Movement.backgroundMoveX, rect.chest2.y+Movement.backgroundMoveY, rect.chest2.width, rect.chest2.height, 4);
					move.createObject(rect.invsWall1.x+Movement.backgroundMoveX, rect.invsWall1.y+Movement.backgroundMoveY, rect.invsWall1.width, rect.invsWall1.height, 5);
					move.createObject(rect.invsWall2.x+Movement.backgroundMoveX, rect.invsWall2.y+Movement.backgroundMoveY, rect.invsWall2.width, rect.invsWall2.height, 6);
				}			
				if(map==MAP.AREA4)
				{
					move.createObject(rect.cobbleWall1.x+Movement.backgroundMoveX, rect.cobbleWall1.y+Movement.backgroundMoveY, rect.cobbleWall1.width, rect.cobbleWall1.height, 1);
					move.createObject(rect.cobbleWall2.x+Movement.backgroundMoveX, rect.cobbleWall2.y+Movement.backgroundMoveY, rect.cobbleWall2.width, rect.cobbleWall2.height, 1);
					move.createObject(rect.cobbleWall3.x+Movement.backgroundMoveX, rect.cobbleWall3.y+Movement.backgroundMoveY, rect.cobbleWall3.width, rect.cobbleWall3.height, 1);
					move.createObject(rect.cobbleWall4.x+Movement.backgroundMoveX, rect.cobbleWall4.y+Movement.backgroundMoveY, rect.cobbleWall4.width, rect.cobbleWall4.height, 1);
					move.createObject(rect.cobbleWall5.x+Movement.backgroundMoveX, rect.cobbleWall5.y+Movement.backgroundMoveY, rect.cobbleWall5.width, rect.cobbleWall5.height, 1);
					move.createObject(rect.cobbleWall6.x+Movement.backgroundMoveX, rect.cobbleWall6.y+Movement.backgroundMoveY, rect.cobbleWall6.width, rect.cobbleWall6.height, 1);
					move.createObject(rect.cobbleWall7.x+Movement.backgroundMoveX, rect.cobbleWall7.y+Movement.backgroundMoveY, rect.cobbleWall7.width, rect.cobbleWall7.height, 1);
					move.createObject(rect.blackTop1.x+Movement.backgroundMoveX, rect.blackTop1.y+Movement.backgroundMoveY, rect.blackTop1.width, rect.blackTop1.height, 1);
					move.createObject(rect.blackTop2.x+Movement.backgroundMoveX, rect.blackTop2.y+Movement.backgroundMoveY, rect.blackTop2.width, rect.blackTop2.height, 1);
					move.createObject(rect.blackWall1.x+Movement.backgroundMoveX, rect.blackWall1.y+Movement.backgroundMoveY, rect.blackWall1.width, rect.blackWall1.height, 1);
					move.createObject(rect.blackWall2.x+Movement.backgroundMoveX, rect.blackWall2.y+Movement.backgroundMoveY, rect.blackWall2.width, rect.blackWall2.height, 1);
					move.createObject(rect.blackWall3.x+Movement.backgroundMoveX, rect.blackWall3.y+Movement.backgroundMoveY, rect.blackWall3.width, rect.blackWall3.height, 1);
					move.createObject(rect.blackWall4.x+Movement.backgroundMoveX, rect.blackWall4.y+Movement.backgroundMoveY, rect.blackWall4.width, rect.blackWall4.height, 1);
					move.createObject(rect.blackWall5.x+Movement.backgroundMoveX, rect.blackWall5.y+Movement.backgroundMoveY, rect.blackWall5.width, rect.blackWall5.height, 6);
					move.createObject(rect.treess1.x+Movement.backgroundMoveX, rect.treess1.y+Movement.backgroundMoveY, rect.treess1.width, rect.treess1.height, 1);
					move.createObject(rect.treess2.x+Movement.backgroundMoveX, rect.treess2.y+Movement.backgroundMoveY, rect.treess2.width, rect.treess2.height, 1);
					move.createObject(rect.treess3.x+Movement.backgroundMoveX, rect.treess3.y+Movement.backgroundMoveY, rect.treess3.width, rect.treess3.height, 1);
					//					move.createObject(rect.chest3.x+Movement.backgroundMoveX, rect.chest3.y+Movement.backgroundMoveY, rect.chest3.width, rect.chest3.height, 2);
					move.createObject(rect.chest4.x+Movement.backgroundMoveX, rect.chest4.y+Movement.backgroundMoveY, rect.chest4.width, rect.chest4.height, 3);
					//					move.createObject(rect.chest5.x+Movement.backgroundMoveX, rect.chest5.y+Movement.backgroundMoveY, rect.chest5.width, rect.chest5.height, 4);
					move.createObject(rect.chest6.x+Movement.backgroundMoveX, rect.chest6.y+Movement.backgroundMoveY, rect.chest6.width, rect.chest6.height, 5);
					if(Maps.group1)
						move.createObject(rect.slimes1.x+Movement.backgroundMoveX, rect.slimes1.y+Movement.backgroundMoveY, rect.slimes1.width, rect.slimes1.height, 7);
					if(Maps.group2)
						move.createObject(rect.slimes2.x+Movement.backgroundMoveX, rect.slimes2.y+Movement.backgroundMoveY, rect.slimes2.width, rect.slimes2.height, 8);
					if(Maps.group3)
						move.createObject(rect.slimes3.x+Movement.backgroundMoveX, rect.slimes3.y+Movement.backgroundMoveY, rect.slimes3.width, rect.slimes3.height, 9);
					if(Maps.golden)
					{
						move.createObject(rect.goldenSlime.x+Movement.backgroundMoveX, rect.goldenSlime.y+Movement.backgroundMoveY, rect.goldenSlime.width, rect.goldenSlime.height, 10);
						move.createObject(rect.invis.x+Movement.backgroundMoveX, rect.invis.y+Movement.backgroundMoveY, rect.invis.width, rect.invis.height, 1);
					}
					move.createObject(rect.rock.x+Movement.backgroundMoveX, rect.rock.y+Movement.backgroundMoveY, rect.rock.width, rect.rock.height, 11);
				}
				if(map==MAP.TEST)
				{
					move.createObject(200+Movement.backgroundMoveX, 200+Movement.backgroundMoveY, 50, 50, 2);
					move.createObject(400+Movement.backgroundMoveX, 400+Movement.backgroundMoveY, 50, 50, 3);
					move.createObject(200+Movement.backgroundMoveX, 400+Movement.backgroundMoveY, 50, 50, 4);
					move.createObject(400+Movement.backgroundMoveX, 200+Movement.backgroundMoveY, 50, 50, 5);
				}
				if(Text==TEXT.TRUE)
				{
					if(Speach==SPEACH.SCENE1TEXT)
					{
						g.setColor(Color.BLACK);
						g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
						if(inText1.hasNextLine())
						{
							if(switchPage)
							{
								str=inText1.nextLine();
								imageCount++;
								switchPage=false;
							}
						}
						else
						{
							Text=TEXT.FALSE;
							imageCount=0;
						}
						g.setColor(Color.BLACK);
						g.fillRect(0, 0, 650, 650);
						if(imageCount==1)
							g.drawImage(image.town, 0, 0, 650, 450, null);
						else if(imageCount==2||imageCount==3	||imageCount==4||imageCount==5)
							g.drawImage(image.burn, 0, 0, 650, 450, null);
						else if(imageCount==6||imageCount==7)
							g.drawImage(image.comet, 0, 0, 650, 450, null);
						else if(imageCount==8)
							g.drawImage(image.cutScene1, 0, 0, 650, 650, null);
						text.writeText(g,str);
					}
					if(Speach==SPEACH.TEXTDOOR)
					{
						text.writeText(g,"Scarlet-I should probably check the suspicious rock before leaving.");
					}
					if(Speach==SPEACH.TEXTSHELF)
					{
						text.writeText(g," -It is an empty bookshelf.");
					}
					if(Speach==SPEACH.TEXTBED)
					{
						text.writeText(g,"Scarlet-Probably not the best time to sleep.");
					}
					if(Speach==SPEACH.GAMESAVE)
					{
						text.writeText(g, " -You have saved the game!");
					}
					if(Speach==SPEACH.SCENE2TEXT)
					{
						g.setColor(Color.BLACK);
						g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
						if(inText2.hasNextLine())
						{
							if(switchPage)
							{
								str=inText2.nextLine();
								imageCount++;
								switchPage=false;
							}
						}
						else
						{
							Text=TEXT.FALSE;
							imageCount=0;
						}
						g.setColor(Color.BLACK);
						g.fillRect(0, 0, 650, 650);
						text.writeText(g,str);
					}
					if(Speach==SPEACH.SCENE3TEXT)
					{
						g.setColor(Color.BLACK);
						g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
						if(inText3.hasNextLine())
						{
							if(switchPage)
							{
								str=inText3.nextLine();
								imageCount++;
								switchPage=false;
							}
						}
						else
						{
							Text=TEXT.FALSE;
							imageCount=0;
							State=STATE.BATTLE;
						}
						g.setColor(Color.BLACK);
						g.fillRect(0, 0, 650, 650);
						g.drawImage(image.cutScene2, 0, 0, 650, 650, null);
						text.writeText(g,str);
					}
					if(Speach==SPEACH.SCENE4TEXT)
					{
						g.setColor(Color.BLACK);
						g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
						if(inText4.hasNextLine())
						{
							if(switchPage)
							{
								str=inText4.nextLine();
								imageCount++;
								switchPage=false;
							}
						}
						else
						{
							Text=TEXT.FALSE;
							imageCount=0;
						}
						g.setColor(Color.BLACK);
						g.fillRect(0, 0, 650, 650);
						g.drawImage(image.cutScene3, 0, 0, 650, 650, null);
						text.writeText(g,str);
					}
					if(Speach==SPEACH.SCENE5TEXT)
					{
						g.setColor(Color.BLACK);
						g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
						if(inText5.hasNextLine())
						{
							if(switchPage)
							{
								str=inText5.nextLine();
								imageCount++;
								switchPage=false;
							}
						}
						else
						{
							Text=TEXT.FALSE;
							Main.fight=Main.fight4;
							Main.State=Main.STATE.BATTLE;
							imageCount=0;
						}
						g.setColor(Color.BLACK);
						g.fillRect(0, 0, 650, 650);
						g.drawImage(image.cutScene4, 0, 0, 650, 650, null);
						text.writeText(g,str);
					}
					if(Speach==SPEACH.SCENE6TEXT)
					{
						g.setColor(Color.BLACK);
						g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
						if(inText6.hasNextLine())
						{
							if(switchPage)
							{
								str=inText6.nextLine();
								imageCount++;
								switchPage=false;
							}
						}
						else
						{
							Text=TEXT.FALSE;
							System.exit(1);
							imageCount=0;
						}
						g.setColor(Color.BLACK);
						g.fillRect(0, 0, 650, 650);
						//						g.drawImage(image.Thanks, 0, 0, 650, 650, null);
						text.writeText(g,str);
					}
					if(Speach==SPEACH.ITEMHPPOTION)
					{
						text.writeText(g,"Inventory-You have found a health potion!");
					}
					if(Speach==SPEACH.ITEMSPPOTION)
					{
						text.writeText(g,"Inventory-You have found a skill point potion!");
					}
					if(Speach==SPEACH.CHESTEMPTY)
					{
						text.writeText(g,"Inventory-The chest is empty.");
					}
					if(Speach==SPEACH.ITEMIRONSWORD)
					{
						text.writeText(g,"Inventory-You have found an Iron Sword! Go to the inventory to equip it.");
					}
					if(Speach==SPEACH.ITEMMYTHICALSTAFF)
					{
						text.writeText(g,"Inventory-You have found a Mythical Staff! Go to the inventory to equip it.");
					}
					if(Speach==SPEACH.ITEMLEGENDARYSTAFF)
					{
						text.writeText(g,"Inventory-You have found a Legendary Staff! Go to the inventory to equip it.");
					}
					if(Speach==SPEACH.ITEMLEGENDARYSWORD)
					{
						text.writeText(g,"Inventory-You have found a Legendary Sword! Go to the inventory to equip it.");
					}
				}
			}
			if(State==STATE.BATTLE)
			{
				if(counter==0)
				{
					Battle.mobCreator(fight);
				}
				counter++;
				Battle.createBattle(g,fight);

			}
			if(State==STATE.MENU)
			{
				g.setColor(Color.WHITE);
				g.drawImage(image.menu,rect.background.x, rect.background.y, rect.background.width, rect.background.height, null);
				//				g.setColor(Color.gray);
				//				g.fillRect(150,250,350,375);
				g.setColor(Color.black);
				g.drawRect(225, 300, 200, 75);
				g.drawRect(225, 400, 200, 75);
				g.drawRect(225, 500, 200, 75);
				g.setFont(Game.Text.fnt2);
				g.drawString("New Game",250,350);
				g.drawString("Load Game",250,450);
				g.drawString("Exit",250,550);
				g.setFont(Game.Text.fnt3);
				g.drawString("The", 220,100 );
				g.drawString("Forgotten", 190,150 );
				g.drawString("Azure", 280, 200);
				if(menuSelect==0)
					g.drawRect(230, 305, 190, 65);
				else if(menuSelect==1)
					g.drawRect(230, 405, 190, 65);
				else if(menuSelect==2)
					g.drawRect(230, 505, 190, 65);
			}
			if(State==STATE.LOADMENU)
			{
				g.setColor(Color.GRAY);
				g.drawImage(image.loadMenu,rect.background.x, rect.background.y, rect.background.width, rect.background.height, null);
				g.drawImage(image.loadWood,0, 100, 450, 500, null);
				g.fillRect(50, 120, 350, 75);
				g.setFont(Game.Text.fnt3);
				g.setColor(Color.BLACK);
				g.drawString("Saved Games",55,170 );
				g.setColor(Color.CYAN);

				if(!focusSaves)
					g.setColor(Color.GRAY);
				if(loadMenuSaveSelect%5==0)
					g.fillRect(85, 280, 150, 50);
				else if(loadMenuSaveSelect%5==1)
					g.fillRect(165, 320, 150, 50);
				else if(loadMenuSaveSelect%5==2)
					g.fillRect(245, 370, 150, 50);
				else if(loadMenuSaveSelect%5==3)
					g.fillRect(165, 410, 150, 50);
				else if(loadMenuSaveSelect%5==4)
					g.fillRect(85, 460, 150, 50);

				if(focusSaves)
					g.setColor(Color.GRAY);
				else
					g.setColor(Color.CYAN);
				if(loadMenuSelect==0)
					g.fillRect(450, 300, 150, 50);
				else if(loadMenuSelect==1)
					g.fillRect(450, 400, 150, 50);

				g.setFont(Game.Text.fnt5);
				g.setColor(Color.BLACK);
				g.drawString("LOAD",475,340);
				g.drawString("BACK",475,440);
				if(page*5+0<saveGames.size())
					g.drawString("Save "+(page*5+0), 90, 320);
				if(page*5+1<saveGames.size())
					g.drawString("Save "+(page*5+1), 170, 360);
				if(page*5+2<saveGames.size())
					g.drawString("Save "+(page*5+2), 250, 410);
				if(page*5+3<saveGames.size())
					g.drawString("Save "+(page*5+3), 170, 450);
				if(page*5+4<saveGames.size())
					g.drawString("Save "+(page*5+4), 90, 500);
			}
			if(State==STATE.GAMEMENU)
			{
				g.setColor(Color.DARK_GRAY);
				g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
				g.drawImage(image.redProtagonist, 50, 50, 100, 100, null);
				g.drawImage(image.blueProtagonist, 50, 200, 100, 100, null);
				g.setColor(Color.BLACK);
				g.drawRect(25, 25, 600, 150);
				g.drawRect(25, 175, 600, 150);
				g.drawRect(50, 350, 200, 75);
				g.drawRect(50, 425, 200, 75);
				g.drawRect(50, 500, 200, 75);
				g.setFont(Game.Text.fnt2);
				g.drawString("HP:", 200, 75);
				g.drawString("HP:", 200, 225);
				g.drawString("MP:", 200, 125);
				g.drawString("MP:", 200, 275);
				g.drawString("LVL:", 425, 75);
				g.drawString("LVL:", 425, 225);
				g.drawString("EXP:", 425, 125);
				g.drawString("EXP:", 425, 275);
				if((PlayerStats.player1Health/PlayerStats.player1MaxHealth)*100<25)
					g.setColor(Color.RED);
				else
					g.setColor(Color.GREEN);
				g.drawString(PlayerStats.player1Health+"/"+PlayerStats.player1MaxHealth,275,75);
				if((PlayerStats.player2Health/PlayerStats.player2MaxHealth)*100<25)
					g.setColor(Color.RED);
				else
					g.setColor(Color.GREEN);
				g.drawString(PlayerStats.player2Health+"/"+PlayerStats.player2MaxHealth,275,225);
				if((PlayerStats.player1SP/PlayerStats.player1MaxSP)*100<25)
					g.setColor(Color.WHITE);
				else
					g.setColor(Color.BLUE);
				g.drawString(PlayerStats.player1SP+"/"+PlayerStats.player1MaxSP,275,125);
				if((PlayerStats.player2SP/PlayerStats.player2MaxSP)*100<25)
					g.setColor(Color.WHITE);
				else
					g.setColor(Color.BLUE);
				g.drawString(PlayerStats.player2SP+"/"+PlayerStats.player2MaxSP,275,275);
				g.setColor(Color.black);
				g.drawString(PlayerStats.player1Level+"",500,75);
				g.drawString(PlayerStats.player2Level+"",500,225);
				g.drawString(PlayerStats.player1EXP+"/"+PlayerStats.player1MaxEXP,500,125);
				g.drawString(PlayerStats.player2EXP+"/"+PlayerStats.player2MaxEXP,500,275);
				g.drawString("ITEMS", 70, 400);
				g.drawString("BACK", 70, 475);
				if(gameMenuSelect==0)
					g.drawRect(30, 30, 140, 140);
				if(gameMenuSelect==1)
					g.drawRect(30, 180, 140, 140);
				if(gameMenuSelect==2)
					g.drawRect(60, 360, 180, 55);
				if(gameMenuSelect==3)
					g.drawRect(60, 435, 180, 55);
			}
			if(State==STATE.GAMEMENUP1)
			{
				g.setColor(Color.DARK_GRAY);
				g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
				g.drawImage(image.redProtagonist, 50, 50, 100, 100, null);
				g.setColor(Color.black);
				g.setFont(Game.Text.fnt2);
				g.drawString("STATS", 100, 200);
				g.drawString("HP:", 100, 250);
				g.drawString("MP:", 100, 300);
				g.drawString("LVL:", 100, 350);
				g.drawString("EXP:", 100, 400);
				g.drawString("ATK:", 100, 450);
				g.drawString("DEF:", 100, 500);
				if((PlayerStats.player1Health/PlayerStats.player1MaxHealth)*100<25)
					g.setColor(Color.RED);
				else
					g.setColor(Color.GREEN);
				g.drawString(PlayerStats.player1Health+"/"+PlayerStats.player1MaxHealth,200,250);
				if((PlayerStats.player1SP/PlayerStats.player1MaxSP)*100<25)
					g.setColor(Color.WHITE);
				else
					g.setColor(Color.BLUE);
				g.drawString(PlayerStats.player1SP+"/"+PlayerStats.player1MaxSP,200,300);
				g.setColor(Color.BLACK);
				g.drawString(PlayerStats.player1Level+"",200,350);
				g.drawString(PlayerStats.player1EXP+"/"+PlayerStats.player1MaxEXP,200,400);
				g.drawString(PlayerStats.player1AttackStrenght+"",200,450);
				g.drawString(PlayerStats.player1DamageRed+"",200,500);
				g.drawString("EQUIPMENT", 300, 200);
				g.drawImage(ItemSkillList.items.get(PlayerStats.p1Weapon).image, 325, 225, 50, 50, null);
				g.drawRect(325, 225, 50, 50);
				g.drawImage(ItemSkillList.items.get(PlayerStats.p1Armour).image, 375, 225, 50, 50, null);
				g.drawRect(375, 225, 50, 50);
				g.drawString("SKILLS", 75, 550);
				g.drawRect(100, 575, 50, 50);
				g.drawImage(image.strengthen, 100, 575, 50, 50, null);
				g.drawRect(150, 575, 50, 50);
				g.drawImage(image.slash, 150, 575, 50, 50, null);
				g.drawRect(200, 575, 50, 50);
				g.drawImage(image.fireStorm, 200, 575, 50, 50, null);
				if(player1InfoSelect==2)
				{
					g.drawString("Strengthen", 300, 400);
					g.setFont(Game.Text.fnt1);
					g.drawString("Buffs attack and defense stats of a player", 300, 450);

				}
				if(player1InfoSelect==3)
				{
					g.drawString("Slash", 300, 400);
					g.setFont(Game.Text.fnt1);
					g.drawString("Does heavy damage to one target", 300, 450);

				}
				if(player1InfoSelect==4)
				{
					g.drawString("Fire Strom", 300, 400);
					g.setFont(Game.Text.fnt1);
					g.drawString("Does small damage to all targets", 300, 450);
				}
				g.setFont(Game.Text.fnt2);
				try
				{
					if((player1InfoSelect==0)&&PlayerStats.p1Weapon.equals("Practice Sword"))
					{
						g.drawString("Practice Sword", 300, 350);
						g.setFont(Game.Text.fnt1);
						g.drawString("The Practice Sword adds 3 additional", 300, 400);
						g.drawString("damage to Scarlet", 300, 450);
					}
					if((player1InfoSelect==0)&&PlayerStats.p1Weapon.equals("Iron Sword"))
					{
						g.drawString("Iron Sword", 300, 350);
						g.setFont(Game.Text.fnt1);
						g.drawString("The Iron Sword adds 6 additional", 300, 400);
						g.drawString("damage to Scarlet", 300, 450);
					}
					if((player1InfoSelect==0)&&PlayerStats.p1Weapon.equals("Legendary Sword"))
					{
						g.drawString("Legendary Sword", 300, 350);
						g.setFont(Game.Text.fnt1);
						g.drawString("The Legendary Sword adds 15 additional", 300, 400);
						g.drawString("damage to Scarlet", 300, 450);
					}
					if((player1InfoSelect==1)&&PlayerStats.p1Armour.equals("Leather Armour"))
					{
						g.drawString("Leather Armour", 300, 350);
						g.setFont(Game.Text.fnt1);
						g.drawString("The Leather Armour gives 2 additional", 300, 400);
						g.drawString("health to Scarlet", 300, 450);
					}
					if((player1InfoSelect==1)&&PlayerStats.p1Armour.equals("Iron Armour"))
					{
						g.drawString("Iron Armour", 300, 350);
						g.setFont(Game.Text.fnt1);
						g.drawString("The Iron Armour gives 5 additional", 300, 400);
						g.drawString("health to Scarlet", 300, 450);
					}
					if((player1InfoSelect==1)&&PlayerStats.p1Armour.equals("Legendary Armour"))
					{
						g.drawString("Legendary Armour", 300, 350);
						g.setFont(Game.Text.fnt1);
						g.drawString("The Legendary Armour adds 10 health", 300, 400);
						g.drawString("health to Scarlet", 300, 450);
					}
				}
				catch(IndexOutOfBoundsException e)
				{
				}
				itemDesc.clear();
			}
			if(State==STATE.GAMEMENUP2)
			{
				g.setColor(Color.DARK_GRAY);
				g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
				g.drawImage(image.blueProtagonist, 50, 50, 100, 100, null);
				g.setColor(Color.black);
				g.setFont(Game.Text.fnt2);
				g.drawString("STATS", 75, 200);
				g.drawString("HP:", 100, 250);
				g.drawString("MP:", 100, 300);
				g.drawString("LVL:", 100, 350);
				g.drawString("EXP:", 100, 400);
				g.drawString("ATK:", 100, 450);
				g.drawString("DEF:", 100, 500);
				if((PlayerStats.player2Health/PlayerStats.player2MaxHealth)*100<25)
					g.setColor(Color.RED);
				else
					g.setColor(Color.GREEN);
				g.drawString(PlayerStats.player2Health+"/"+PlayerStats.player2MaxHealth,200,250);
				if((PlayerStats.player2SP/PlayerStats.player2MaxSP)*100<25)
					g.setColor(Color.WHITE);
				else
					g.setColor(Color.BLUE);
				g.drawString(PlayerStats.player2SP+"/"+PlayerStats.player2MaxSP,200,300);
				g.setColor(Color.BLACK);
				g.drawString(PlayerStats.player2Level+"",200,350);
				g.drawString(PlayerStats.player2EXP+"/"+PlayerStats.player2MaxEXP,200,400);
				g.drawString(PlayerStats.player2AttackStrenght+"",200,450);
				g.drawString(PlayerStats.player2DamageRed+"",200,500);
				g.drawString("EQUIPMENT", 300, 200);
				g.drawRect(325, 225, 50, 50);
				g.drawRect(375, 225, 50, 50);
				g.drawImage(ItemSkillList.items.get(PlayerStats.p2Weapon).image, 325, 225, 50, 50, null);
				g.drawImage(ItemSkillList.items.get(PlayerStats.p2Armour).image, 375, 225, 50, 50, null);
				g.drawString("SKILLS", 75, 550);
				g.drawRect(100, 575, 50, 50);
				g.drawImage(image.heal, 100, 575, 50, 50, null);
				g.drawRect(150, 575, 50, 50);
				g.drawImage(image.hydroPump, 150, 575, 50, 50, null);
				g.drawRect(200, 575, 50, 50);
				g.drawImage(image.blizzard, 200, 575, 50, 50, null);
				if(player2InfoSelect==2)
				{
					g.drawString("Heal", 300, 400);
					g.setFont(Game.Text.fnt1);
					g.drawString("Increases HP of a player", 300, 450);
				}
				if(player2InfoSelect==3)
				{
					g.drawString("Hydropump", 300, 400);
					g.setFont(Game.Text.fnt1);
					g.drawString("Does heavy damage to one target", 300, 450);
				}
				if(player2InfoSelect==4)
				{
					g.drawString("Blizzard", 300, 400);
					g.setFont(Game.Text.fnt1);
					g.drawString("Does small damage to all targets", 300, 450);
				}
				g.setFont(Game.Text.fnt2);
				try
				{
					if((player2InfoSelect==0)&&(PlayerStats.p2Weapon).equals("Wooden Staff"))
					{
						g.drawString("Wooden Staff", 300, 350);
						g.setFont(Game.Text.fnt1);
						g.drawString("The Wooden Staff adds 4 additional", 300, 400);
						g.drawString("damage to Aqus", 300, 450);
					}
					if((player2InfoSelect==0)&&PlayerStats.p2Weapon.equals("Mythical Staff"))
					{
						g.drawString("Mythical Staff", 300, 350);
						g.setFont(Game.Text.fnt1);
						g.drawString("The Mythical Staff adds 7 additional", 300, 400);
						g.drawString("damage to Aqus", 300, 450);
					}
					if((player2InfoSelect==0)&&PlayerStats.p2Weapon.equals("Legendary Staff"))
					{
						g.drawString("Legendary Staff", 300, 350);
						g.setFont(Game.Text.fnt1);
						g.drawString("The Legendary Staff adds 18 additional", 300, 400);
						g.drawString("damage to Aqus", 300, 450);
					}
					if((player2InfoSelect==1)&&PlayerStats.p2Armour.equals("Tattered Robes"))
					{
						g.drawString("Tattered Robes", 300, 350);
						g.setFont(Game.Text.fnt1);
						g.drawString("The Tattered Robes adds 1 additional", 300, 400);
						g.drawString("health to Aqus", 300, 450);
					}
					if((player2InfoSelect==1)&&PlayerStats.p2Armour.equals("Reinforced Robes"))
					{
						g.drawString("Reinforced Robes", 300, 350);
						g.setFont(Game.Text.fnt1);
						g.drawString("The Reinforced adds 4 additional", 300, 400);
						g.drawString("health to Aqus", 300, 450);
					}
					if((player2InfoSelect==1)&&PlayerStats.p2Armour.equals("Legendary Robes"))
					{
						g.drawString("Legendary Robes", 300, 350);
						g.setFont(Game.Text.fnt1);
						g.drawString("The Legendary Robes adds 18 additional", 300, 400);
						g.drawString("health to Aqus", 300, 450);
					}
				}
				catch(IndexOutOfBoundsException e)
				{
				}
				itemDesc.clear();
			}
			else if(State==STATE.GAMEMENUITEMS)
			{
				g.setFont(Game.Text.fnt2);
				g.setColor(Color.DARK_GRAY);
				g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
				g.drawImage(ItemSkillList.items.get("Health Potion").image, 50, 50, 100, 100, null);
				g.drawImage(ItemSkillList.items.get("Skill Potion").image, 50, 150, 100, 100, null);
				g.setColor(Color.BLACK);
				g.drawString("Health Potion: "+ItemSkillList.HPPotion, 150, 80);
				g.drawString("Skill Potion: "+ItemSkillList.SPPotion, 150, 180);
				g.drawString("Equipment: ", 150, 280);

				if(gameItemSelect==0)
					g.drawRect(50, 50, 100, 100);
				else if(gameItemSelect==1)				
					g.drawRect(50, 150, 100, 100);
				else if(gameItemSelect==2)
				{
					if(gameItemSelectEquip==0)
						g.drawRect(100, 300, 100, 100);
					if(gameItemSelectEquip==1)
						g.drawRect(200, 300, 100, 100);
					if(gameItemSelectEquip==2)
						g.drawRect(300, 300, 100, 100);
					if(gameItemSelectEquip==3)
						g.drawRect(400, 300, 100, 100);
				}
				else if(gameItemSelect==3)
				{
					g.drawRect(500, 575, 75, 50);
				}
				g.setColor(Color.BLACK);
				g.drawString("BACK", 500, 600);
				g.drawRect(25, 25, 575, 400);
				Iterator<String> i=PlayerStats.inventory.keySet().iterator();
				while(i.hasNext())
					itemDesc.add(i.next());
				Collections.sort(itemDesc);
				try
				{
					if(PlayerStats.inventory.size()>0)
						g.drawImage(PlayerStats.inventory.get(itemDesc.get(0)).image, 100, 300, 100, 100, null);
					if(PlayerStats.inventory.size()>1)
						g.drawImage(PlayerStats.inventory.get(itemDesc.get(1)).image, 200, 300, 100, 100, null);
					if(PlayerStats.inventory.size()>2)
						g.drawImage(PlayerStats.inventory.get(itemDesc.get(2)).image, 300, 300, 100, 100, null);
					if(PlayerStats.inventory.size()>3)
						g.drawImage(PlayerStats.inventory.get(itemDesc.get(3)).image, 400, 300, 100, 100, null);
				}
				catch(NullPointerException e)
				{
				}
				if(gameItemSelect==0)
					g.drawString("The Health Potion retores 15 HP", 100, 500);
				if(gameItemSelect==1)
					g.drawString("The Skill Potion retores 15 SP", 100, 500);
				try
				{
					if(gameItemSelect==2&&itemDesc.get(gameItemSelectEquip).equals("Practice Sword"))
					{
						g.drawString("The Practice Sword adds 3 additional", 100, 500);
						g.drawString("damage to Scarlet", 100, 530);
					}
					if(gameItemSelect==2&&itemDesc.get(gameItemSelectEquip).equals("Iron Sword"))
					{
						g.drawString("The Iron Sword adds 6 additional", 100, 500);
						g.drawString("damage to Scarlet", 100, 530);
					}
					if(gameItemSelect==2&&itemDesc.get(gameItemSelectEquip).equals("Legendary Sword"))
					{
						g.drawString("The Legendary Sword adds 15 additional", 100, 500);
						g.drawString("damage to Scarlet", 100, 530);
					}
					if(gameItemSelect==2&&itemDesc.get(gameItemSelectEquip).equals("Wooden Staff"))
					{
						g.drawString("The Wooden Staff adds 4 additional", 100, 500);
						g.drawString("damage to Aqus", 100, 530);
					}
					if(gameItemSelect==2&&itemDesc.get(gameItemSelectEquip).equals("Mythical Staff"))
					{
						g.drawString("The Mythical Staff adds 7 additional", 100, 500);
						g.drawString("damage to Aqus", 100, 530);
					}
					if(gameItemSelect==2&&itemDesc.get(gameItemSelectEquip).equals("Legendary Staff"))
					{
						g.drawString("The Legendary Staff adds 18 additional", 100, 500);
						g.drawString("damage to Aqus", 100, 530);
					}
				}
				catch(IndexOutOfBoundsException e)
				{
				}
				itemDesc.clear();
			}
			else if(State==STATE.GAMEOVER)
			{
				g.setFont(Game.Text.fnt2);
				g.setColor(Color.DARK_GRAY);
				g.fillRect(rect.background.x,rect.background.y,rect.background.width,rect.background.height);
				g.setColor(Color.LIGHT_GRAY);
				g.fillRect(250, 250, 150, 150);
				g.setColor(Color.BLACK);
				g.drawString("Main Menu", 255, 300);
				g.drawString("Quit", 300, 370);
				if(gameOverSelect==0)
					g.drawRect(255, 265, 140, 50);
				if(gameOverSelect==1)
					g.drawRect(300, 340, 50, 50);
			}
		}
	}
	//MAIN
	public static void main (String [] args) throws FileNotFoundException
	{
		JFrame frame = new JFrame ("RPG");
		Main myPanel = new Main ();
		frame.add(myPanel);
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	/* Method Description
	 *  Desc: The compareTo for Collections.sort
	 *  Para: a String
	 *  Return: it's a void
	 */
	public int compareTo(String it) {
		if(PlayerStats.inventory.get(this).getType()>PlayerStats.inventory.get(it).getType())
			return 1;
		else if(PlayerStats.inventory.get(this).getType()==PlayerStats.inventory.get(it).getType())
			return 0;
		else
			return -1;
	}
}