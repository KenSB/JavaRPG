package Game;
import java.awt.Rectangle;

/* Class Description
 * This class creates all the positions of images and objects on the screen as rectangles.
 */
public class Rect 
{
	//forest
	Rectangle player = new Rectangle (300, 300, 30, 30);
	Rectangle background = new Rectangle (0, 0, 650, 650);
	Rectangle largeTreeHori1 = new Rectangle (-49,-49,600,150);
	Rectangle largeTreeHori2 = new Rectangle (550,-49,600,150);
	Rectangle largeTreeHori3 = new Rectangle (-49,550,600,150);
	Rectangle largeTreeHori4 = new Rectangle (550,550,600,150);

	Rectangle largeTreeHori5 = new Rectangle (250,100,600,150);
	Rectangle largeTreeHori6 = new Rectangle (250,400,600,150);

	Rectangle largeTreeVerti1 = new Rectangle (-49,100,150,600);
	Rectangle largeTreeVerti2 = new Rectangle (100,100,150,600);

	Rectangle cobbleFloor1 = new Rectangle (250,250,150,150);

	Rectangle cobble1 = new Rectangle (325,249,150,151);
	Rectangle cobble2 = new Rectangle (475,249,150,151);
	Rectangle cobble3 = new Rectangle (625,249,150,151);
	Rectangle cobble4 = new Rectangle (775,249,150,151);
	Rectangle cobble5 = new Rectangle (850,249,150,151);
	Rectangle cobble6 = new Rectangle (850,100,150,151);
	Rectangle cobble7 = new Rectangle (850,400,150,151);
	Rectangle vertiCobble1 = new Rectangle (998,100,150,450);
	Rectangle doggo1 = new Rectangle (1400,300,75,50);

	//Cliff
	Rectangle dirtTile1 = new Rectangle(225,225,200,200);
	Rectangle dirtTile2 = new Rectangle(25,225,200,200);
	Rectangle dirtTile3 = new Rectangle(425,225,200,200);

	Rectangle dirtCliff1 = new Rectangle(225,25,200,200);
	Rectangle dirtCliff2 = new Rectangle(25,25,200,200);
	Rectangle dirtCliff3 = new Rectangle(425,25,200,200);
	Rectangle dirtCliff4 = new Rectangle(225,425,200,200);
	Rectangle dirtCliff5 = new Rectangle(25,425,200,200);
	Rectangle dirtCliff6 = new Rectangle(425,425,200,200);

	//Town
	Rectangle cobbleGround1 = new Rectangle(425,425,600,600);
	Rectangle cobbleGround2 = new Rectangle(-175,-175,600,600);
	Rectangle cobbleGround3 = new Rectangle(-175,425,600,600);
	Rectangle cobbleGround4 = new Rectangle(-175,1025,600,600);
	Rectangle cobbleGround5 = new Rectangle(425,-175,600,600);
	Rectangle cobbleGround6 = new Rectangle(425,1025,600,600);
	Rectangle cobbleGround7 = new Rectangle(1025,-175,600,600);
	Rectangle cobbleGround8 = new Rectangle(1025,425,600,600);
	Rectangle cobbleGround9 = new Rectangle(1025,1025,600,600);

	Rectangle house1 = new Rectangle(0,0,200,200);
	Rectangle house2 = new Rectangle(400,400,200,200);
	Rectangle house3 = new Rectangle(0,400,200,200);
	Rectangle house4 = new Rectangle(400,0,200,200);



	Rectangle slimeObj = new Rectangle (0,0,200,200);
	Rectangle doggoObj = new Rectangle (0,0,200,200);
	Rectangle quackoObj = new Rectangle (0,0,200,200);
	Rectangle marioObj= new Rectangle (50,400,100,100);
	Rectangle unicornObj= new Rectangle (450,500,100,100);
	Rectangle town= new Rectangle (-550,-600,3000,3000);




	//house/AREA1
	Rectangle woodenTile1 = new Rectangle(225,225,200,200);
	Rectangle woodenTile2 = new Rectangle(25,25,200,200);
	Rectangle woodenTile3 = new Rectangle(225,25,200,200);
	Rectangle woodenTile4 = new Rectangle(25,225,200,200);
	Rectangle woodenTile5 = new Rectangle(25,425,200,200);
	Rectangle woodenTile6 = new Rectangle(425,25,200,200);
	Rectangle woodenTile7 = new Rectangle(425,425,200,200);
	Rectangle woodenTile8 = new Rectangle(225,425,200,200);
	Rectangle woodenTile9 = new Rectangle(425,225,200,200);

	Rectangle woodenWall1 = new Rectangle(25,-75,100,100);
	Rectangle woodenWall2 = new Rectangle(125,-75,100,100);
	Rectangle woodenWall3 = new Rectangle(225,-75,100,100);
	Rectangle woodenWall4 = new Rectangle(325,-75,100,100);
	Rectangle woodenWall5 = new Rectangle(425,-75,100,100);
	Rectangle woodenWall6 = new Rectangle(525,-75,100,100);
	Rectangle black1 = new Rectangle(-300,-280,326,1400);
	Rectangle black2 = new Rectangle(624,-276,326,1200);
	Rectangle black3 = new Rectangle(20,-276,700,201);
	Rectangle black4 = new Rectangle(20,624,700,326);
	Rectangle door1 = new Rectangle(305,-50,50,75);
	Rectangle bkshelf1 = new Rectangle(100,-25,125,100);
	Rectangle magicRock = new Rectangle( 200,200,50,50);
	Rectangle bedGreen = new Rectangle( 500,50,75,100);
	//AREA2
	Rectangle map1House = new Rectangle(220,-150,200,200);
	Rectangle map1House2 = new Rectangle(20,300,200,200);
	Rectangle map1House3 = new Rectangle(420,300,200,200);
	Rectangle map1House4 = new Rectangle(620,-150,200,200);
	Rectangle map1House5 = new Rectangle(-180,-150,200,200);
	Rectangle map1House6 = new Rectangle(220,300,200,200);
	Rectangle map1House7 = new Rectangle(-350,200,200,200);

	Rectangle pathVerti1 = new Rectangle(300,50,50,250);
	Rectangle pathVerti2 = new Rectangle(-100,300,50,250);
	Rectangle pathVerti3 = new Rectangle(700,300,50,250);
	Rectangle pathVerti4 = new Rectangle(700,50,50,250);
	Rectangle pathVerti5 = new Rectangle(-100,50,50,250);
	Rectangle pathVerti6 = new Rectangle(300,50,50,250);
	Rectangle pathVerti7 = new Rectangle(600,500,50,250);
	Rectangle pathVerti8 = new Rectangle(600,750,50,250);

	Rectangle pathHori1 = new Rectangle(350,250,250,50);
	Rectangle pathHori2 = new Rectangle(500,250,250,50);
	Rectangle pathHori3 = new Rectangle(50,250,250,50);
	Rectangle pathHori4 = new Rectangle(-100,250,250,50);
	Rectangle pathHori5 = new Rectangle(-100,500,250,50);
	Rectangle pathHori6 = new Rectangle(500,500,250,50);
	Rectangle pathHori7 = new Rectangle(100,500,250,50);
	Rectangle pathHori8 = new Rectangle(250,500,250,50);
	Rectangle pathHori9 = new Rectangle(-350,400,250,50);

	Rectangle grass1 = new Rectangle(-150,-150,305,305);
	Rectangle grass2 = new Rectangle(150,-150,305,305);
	Rectangle grass3 = new Rectangle(-150,150,305,305);
	Rectangle grass4 = new Rectangle(150,150,305,305);
	Rectangle grass5 = new Rectangle(450,-150,305,305);
	Rectangle grass6 = new Rectangle(-150,450,305,305);
	Rectangle grass7 = new Rectangle(150,450,305,305);
	Rectangle grass8 = new Rectangle(450,150,305,305);
	Rectangle grass9 = new Rectangle(450,450,305,305);
	Rectangle grass10 = new Rectangle(-450,-150,310,305);
	Rectangle grass11 = new Rectangle(-450,150,310,305);
	Rectangle grass12 = new Rectangle(-450,450,310,305);
	Rectangle grass13 = new Rectangle(600,-150,305,305);
	Rectangle grass14 = new Rectangle(600,150,305,305);
	Rectangle grass15 = new Rectangle(600,450,305,305);
	Rectangle grassPath = new Rectangle(450,675,355,305);

	Rectangle treeRow1 = new Rectangle(-450,-300,1355,150);	
	Rectangle treeRow2 = new Rectangle(-450,750,1355,150);	
	Rectangle tree1 = new Rectangle(-600,-450,150,150);	
	Rectangle tree2 = new Rectangle(-600,-300,150,150);	
	Rectangle tree3 = new Rectangle(-600,-150,150,150);	
	Rectangle tree4 = new Rectangle(-600,0,150,150);	
	Rectangle tree5 = new Rectangle(-600,150,150,150);	
	Rectangle tree6 = new Rectangle(-600,300,150,150);	
	Rectangle tree7 = new Rectangle(-600,450,150,150);	
	Rectangle tree8 = new Rectangle(-600,600,150,150);	
	Rectangle tree9 = new Rectangle(-600,750,150,150);	
	Rectangle tree10 = new Rectangle(900,-450,150,150);	
	Rectangle tree11 = new Rectangle(900,-300,150,150);	
	Rectangle tree12 = new Rectangle(900,-150,150,150);	
	Rectangle tree13 = new Rectangle(900,0,150,150);	
	Rectangle tree14 = new Rectangle(900,150,150,150);	
	Rectangle tree15 = new Rectangle(900,300,150,150);	
	Rectangle tree16 = new Rectangle(900,450,150,150);	
	Rectangle tree17 = new Rectangle(900,600,150,150);	
	Rectangle tree18 = new Rectangle(900,750,150,150);

	Rectangle invWall1 = new Rectangle(400,900,50,150);
	Rectangle invWall2 = new Rectangle(810,900,150,150);
	Rectangle invWall3 = new Rectangle(450,990,400,150);

	Rectangle player2 = new Rectangle (100, 100, 50, 50);
	Rectangle slime1 = new Rectangle (-150, 400, 100, 100);
	Rectangle slime2 = new Rectangle (500, 500, 100, 100);
	Rectangle slime3 = new Rectangle (-200, 600, 100, 100);
	//AREA3
	Rectangle grasss1 = new Rectangle(175,250,305,305);
	Rectangle grasss2 = new Rectangle(175,550,305,305);
	Rectangle grasss3 = new Rectangle(175,850,305,305);
	Rectangle trees1 = new Rectangle(475,250,155,450);
	Rectangle trees2 = new Rectangle(475,700,155,450);
	Rectangle trees3 = new Rectangle(25,250,155,450);
	Rectangle trees4 = new Rectangle(25,700,155,450);
	Rectangle saveBed1 = new Rectangle(400,400,50,100);
	Rectangle chest1 = new Rectangle(400,500,50,50);
	Rectangle chest2 = new Rectangle(400,600,50,50);
	Rectangle invsWall1 = new Rectangle(0,50,650,200);
	Rectangle invsWall2 = new Rectangle(0,1150,650,200);
	Rectangle invsWall3 = new Rectangle(0,0,650,200);
	
	Rectangle grassss1 = new Rectangle(175,250,305,305);
	Rectangle grassss2 = new Rectangle(175,550,305,305);
	Rectangle grassss3 = new Rectangle(175,850,305,305);
	Rectangle cob1 = new Rectangle(-130,250,305,305);
	Rectangle cob2 = new Rectangle(-130,400,305,305);
	Rectangle cob3 = new Rectangle(-130,650,305,305);
	Rectangle cob4 = new Rectangle(-130,800,305,305);
	Rectangle cob5 = new Rectangle(-430,250,305,305);
	Rectangle cob6 = new Rectangle(-430,400,305,305);
	Rectangle cob7 = new Rectangle(-430,650,305,305);
	Rectangle cob8 = new Rectangle(-430,800,305,305);
	Rectangle cob9 = new Rectangle(-730,250,305,305);
	Rectangle cob10 = new Rectangle(-730,400,305,305);
	Rectangle cob11 = new Rectangle(-730,650,305,305);
	Rectangle cob12 = new Rectangle(-730,800,305,305);
	Rectangle cob13 = new Rectangle(-1030,400,305,305);
	Rectangle cob14 = new Rectangle(-1030,650,305,305);
	Rectangle cob15 = new Rectangle(-1330,400,305,305);
	Rectangle cob16 = new Rectangle(-1330,650,305,305);
	Rectangle cob17 = new Rectangle(-1630,400,305,305);
	Rectangle cob18 = new Rectangle(-1630,650,305,305);

	Rectangle cobbleWall1=new Rectangle(-225,100,400,200);
	Rectangle cobbleWall2=new Rectangle(-225,650,400,200);
	Rectangle cobbleWall3=new Rectangle(-625,100,400,200);
	Rectangle cobbleWall4=new Rectangle(-625,650,400,200);
	Rectangle cobbleWall5=new Rectangle(-1025,100,400,200);
	Rectangle cobbleWall6=new Rectangle(-1125,250,400,200);
	Rectangle cobbleWall7=new Rectangle(-1525,250,400,200);
	Rectangle cobbleWall8=new Rectangle(-1025,250,400,200);

	Rectangle blackTop1=new Rectangle(-625,0,800,100);
	Rectangle blackTop2=new Rectangle(-625,550,800,100);
	Rectangle chest3 = new Rectangle(-1500,500,50,50);
	Rectangle chest4 = new Rectangle(-700,300,50,50);
	Rectangle chest5 = new Rectangle(-1500,700,50,50);
	Rectangle chest6 = new Rectangle(-700,1000,50,50);
	Rectangle blackWall1 = new Rectangle(-1700,250,175,800);
	Rectangle blackWall2 = new Rectangle(100,1150,800,400);
	Rectangle blackWall3 = new Rectangle(-730,1100,925,200);
	Rectangle blackWall4 = new Rectangle(-1630,800,900,400);
	Rectangle blackWall5 = new Rectangle(175,100,300,150);
	Rectangle treess1= new Rectangle(475,225,155,400);
	Rectangle treess2= new Rectangle(475,625,155,400);
	Rectangle treess3= new Rectangle(475,1025,155,400);
	Rectangle slimes1 = new Rectangle (-500, 400, 100, 100);
	Rectangle slimes2 = new Rectangle (-500, 900, 100, 100);
	Rectangle slimes3 = new Rectangle (-1000, 600, 100, 100);
	Rectangle goldenSlime = new Rectangle (-1400, 550, 100, 100);
	Rectangle rock = new Rectangle (-1500, 550, 100, 100);
	Rectangle invis= new Rectangle(-1450,100,100,800);
}