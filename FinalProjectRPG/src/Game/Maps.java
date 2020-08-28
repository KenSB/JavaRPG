package Game;
import Game.Main.MAP;
import Game.Main.SPEACH;
import Game.Main.TEXT;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
/* Class Description
 * This class draws each map according to the map that is called.
 */
public class Maps 
{
	Images image = new Images();
	Rect rect= new Rect();
	Movement move= Main.move;
	int objectID;
	static boolean doorOpen=false;
	static boolean group1=true;
	static boolean group2=true;
	static boolean group3=true;
	static boolean golden=true;
	/* Method Description
	 *  Desc: This method draws each map
	 *  Para: It takes in a graphics component and the current map
	 *  Return: it's a void
	 */
	public void drawMap(Graphics g, int map)
	{
		if(map==1)
		{
			g.drawImage (image.treeRowHori, rect.largeTreeHori1.x+Movement.backgroundMoveX, rect.largeTreeHori1.y+Movement.backgroundMoveY, rect.largeTreeHori1.width, rect.largeTreeHori1.height, null);
			g.drawImage (image.treeRowHori, rect.largeTreeHori2.x+Movement.backgroundMoveX, rect.largeTreeHori2.y+Movement.backgroundMoveY, rect.largeTreeHori2.width, rect.largeTreeHori2.height, null);
			g.drawImage (image.treeRowHori, rect.largeTreeHori3.x+Movement.backgroundMoveX, rect.largeTreeHori3.y+Movement.backgroundMoveY, rect.largeTreeHori3.width, rect.largeTreeHori3.height, null);
			g.drawImage (image.treeRowHori, rect.largeTreeHori4.x+Movement.backgroundMoveX, rect.largeTreeHori4.y+Movement.backgroundMoveY, rect.largeTreeHori4.width, rect.largeTreeHori4.height, null);

			g.drawImage (image.treeRowHori, rect.largeTreeHori5.x+Movement.backgroundMoveX, rect.largeTreeHori5.y+Movement.backgroundMoveY, rect.largeTreeHori5.width, rect.largeTreeHori5.height, null);
			g.drawImage (image.treeRowHori, rect.largeTreeHori6.x+Movement.backgroundMoveX, rect.largeTreeHori6.y+Movement.backgroundMoveY, rect.largeTreeHori6.width, rect.largeTreeHori6.height, null);

			g.drawImage (image.treeRowVerti, rect.largeTreeVerti1.x+Movement.backgroundMoveX, rect.largeTreeVerti1.y+Movement.backgroundMoveY, rect.largeTreeVerti1.width, rect.largeTreeVerti1.height, null);
			g.drawImage (image.treeRowVerti, rect.largeTreeVerti2.x+Movement.backgroundMoveX, rect.largeTreeVerti2.y+Movement.backgroundMoveY, rect.largeTreeVerti2.width, rect.largeTreeVerti2.height, null);

			g.drawImage (image.cobbleFloor1, rect.cobbleFloor1.x+Movement.backgroundMoveX, rect.cobbleFloor1.y+Movement.backgroundMoveY, rect.cobbleFloor1.width, rect.cobbleFloor1.height, null);
			g.drawImage (image.cobble, rect.cobble1.x+Movement.backgroundMoveX, rect.cobble1.y+Movement.backgroundMoveY, rect.cobble1.width, rect.cobble1.height, null);
			g.drawImage (image.cobble, rect.cobble2.x+Movement.backgroundMoveX, rect.cobble2.y+Movement.backgroundMoveY, rect.cobble2.width, rect.cobble2.height, null);
			g.drawImage (image.cobble, rect.cobble3.x+Movement.backgroundMoveX, rect.cobble3.y+Movement.backgroundMoveY, rect.cobble3.width, rect.cobble3.height, null);
			g.drawImage (image.cobble, rect.cobble4.x+Movement.backgroundMoveX, rect.cobble4.y+Movement.backgroundMoveY, rect.cobble4.width, rect.cobble4.height, null);
			g.drawImage (image.cobble2, rect.cobble5.x+Movement.backgroundMoveX, rect.cobble5.y+Movement.backgroundMoveY, rect.cobble5.width, rect.cobble5.height, null);
			g.drawImage (image.cobble2, rect.cobble6.x+Movement.backgroundMoveX, rect.cobble6.y+Movement.backgroundMoveY, rect.cobble6.width, rect.cobble6.height, null);
			g.drawImage (image.cobble2, rect.cobble7.x+Movement.backgroundMoveX, rect.cobble7.y+Movement.backgroundMoveY, rect.cobble7.width, rect.cobble7.height, null);
			g.drawImage (image.vertiCobb, rect.vertiCobble1.x+Movement.backgroundMoveX, rect.vertiCobble1.y+Movement.backgroundMoveY, rect.vertiCobble1.width, rect.vertiCobble1.height, null);
		
			g.drawImage (Images.doggo, rect.doggo1.x+Movement.backgroundMoveX, rect.doggo1.y+Movement.backgroundMoveY, rect.doggo1.width, rect.doggo1.height, null);
		}
		else if(map==2)
		{
			g.drawImage (image.woodenTileSquare, rect.woodenTile1.x+Movement.backgroundMoveX, rect.woodenTile1.y+Movement.backgroundMoveY, rect.woodenTile1.width, rect.woodenTile1.height, null);
			g.drawImage (image.woodenTileSquare, rect.woodenTile2.x+Movement.backgroundMoveX, rect.woodenTile2.y+Movement.backgroundMoveY, rect.woodenTile2.width, rect.woodenTile2.height, null);
			g.drawImage (image.woodenTileSquare, rect.woodenTile3.x+Movement.backgroundMoveX, rect.woodenTile3.y+Movement.backgroundMoveY, rect.woodenTile3.width, rect.woodenTile3.height, null);
			g.drawImage (image.woodenTileSquare, rect.woodenTile4.x+Movement.backgroundMoveX, rect.woodenTile4.y+Movement.backgroundMoveY, rect.woodenTile4.width, rect.woodenTile4.height, null);
			g.drawImage (image.woodenTileSquare, rect.woodenTile5.x+Movement.backgroundMoveX, rect.woodenTile5.y+Movement.backgroundMoveY, rect.woodenTile5.width, rect.woodenTile5.height, null);
			g.drawImage (image.woodenTileSquare, rect.woodenTile6.x+Movement.backgroundMoveX, rect.woodenTile6.y+Movement.backgroundMoveY, rect.woodenTile6.width, rect.woodenTile6.height, null);
			g.drawImage (image.woodenTileSquare, rect.woodenTile7.x+Movement.backgroundMoveX, rect.woodenTile7.y+Movement.backgroundMoveY, rect.woodenTile7.width, rect.woodenTile7.height, null);
			g.drawImage (image.woodenTileSquare, rect.woodenTile8.x+Movement.backgroundMoveX, rect.woodenTile8.y+Movement.backgroundMoveY, rect.woodenTile8.width, rect.woodenTile8.height, null);
			g.drawImage (image.woodenTileSquare, rect.woodenTile9.x+Movement.backgroundMoveX, rect.woodenTile9.y+Movement.backgroundMoveY, rect.woodenTile9.width, rect.woodenTile9.height, null);
			g.drawImage (image.woodenWall, rect.woodenWall1.x+Movement.backgroundMoveX, rect.woodenWall1.y+Movement.backgroundMoveY, rect.woodenWall1.width, rect.woodenWall1.height, null);
			g.drawImage (image.woodenWall, rect.woodenWall2.x+Movement.backgroundMoveX, rect.woodenWall2.y+Movement.backgroundMoveY, rect.woodenWall2.width, rect.woodenWall2.height, null);
			g.drawImage (image.woodenWall, rect.woodenWall3.x+Movement.backgroundMoveX, rect.woodenWall3.y+Movement.backgroundMoveY, rect.woodenWall3.width, rect.woodenWall3.height, null);
			g.drawImage (image.woodenWall, rect.woodenWall4.x+Movement.backgroundMoveX, rect.woodenWall4.y+Movement.backgroundMoveY, rect.woodenWall4.width, rect.woodenWall4.height, null);
			g.drawImage (image.woodenWall, rect.woodenWall5.x+Movement.backgroundMoveX, rect.woodenWall5.y+Movement.backgroundMoveY, rect.woodenWall5.width, rect.woodenWall5.height, null);
			g.drawImage (image.woodenWall, rect.woodenWall6.x+Movement.backgroundMoveX, rect.woodenWall6.y+Movement.backgroundMoveY, rect.woodenWall6.width, rect.woodenWall6.height, null);
			g.drawImage (image.black, rect.black1.x+Movement.backgroundMoveX, rect.black1.y+Movement.backgroundMoveY, rect.black1.width, rect.black1.height, null);
			g.drawImage (image.black, rect.black2.x+Movement.backgroundMoveX, rect.black2.y+Movement.backgroundMoveY, rect.black2.width, rect.black2.height, null);
			g.drawImage (image.black, rect.black3.x+Movement.backgroundMoveX, rect.black3.y+Movement.backgroundMoveY, rect.black3.width, rect.black3.height, null);
			g.drawImage (image.black, rect.black4.x+Movement.backgroundMoveX, rect.black4.y+Movement.backgroundMoveY, rect.black4.width, rect.black4.height, null);
			g.drawImage (image.door, rect.door1.x+Movement.backgroundMoveX, rect.door1.y+Movement.backgroundMoveY, rect.door1.width, rect.door1.height, null);
			g.drawImage (image.bookShelf, rect.bkshelf1.x+Movement.backgroundMoveX, rect.bkshelf1.y+Movement.backgroundMoveY, rect.bkshelf1.width, rect.bkshelf1.height, null);
			if(!Maps.doorOpen)
				g.drawImage (image.magicRock, rect.magicRock.x+Movement.backgroundMoveX, rect.magicRock.y+Movement.backgroundMoveY, rect.magicRock.width, rect.magicRock.height, null);
			g.drawImage (image.bedGreen, rect.bedGreen.x+Movement.backgroundMoveX, rect.bedGreen.y+Movement.backgroundMoveY, rect.bedGreen.width, rect.bedGreen.height, null);
		}
		else if(map==3)
		{
			g.setColor(Color.BLACK);
			g.fillRect(-1000, -1000, 3000, 3000);
			g.drawImage (image.grass, rect.grass10.x+Movement.backgroundMoveX, rect.grass10.y+Movement.backgroundMoveY, rect.grass10.width, rect.grass10.height, null);
			g.drawImage (image.grass, rect.grass11.x+Movement.backgroundMoveX, rect.grass11.y+Movement.backgroundMoveY, rect.grass11.width, rect.grass11.height, null);
			g.drawImage (image.grass, rect.grass12.x+Movement.backgroundMoveX, rect.grass12.y+Movement.backgroundMoveY, rect.grass12.width, rect.grass12.height, null);
			g.drawImage (image.grass, rect.grass1.x+Movement.backgroundMoveX, rect.grass1.y+Movement.backgroundMoveY, rect.grass1.width, rect.grass1.height, null);
			g.drawImage (image.grass, rect.grass2.x+Movement.backgroundMoveX, rect.grass2.y+Movement.backgroundMoveY, rect.grass2.width, rect.grass2.height, null);
			g.drawImage (image.grass, rect.grass3.x+Movement.backgroundMoveX, rect.grass3.y+Movement.backgroundMoveY, rect.grass3.width, rect.grass3.height, null);
			g.drawImage (image.grass, rect.grass4.x+Movement.backgroundMoveX, rect.grass4.y+Movement.backgroundMoveY, rect.grass4.width, rect.grass4.height, null);
			g.drawImage (image.grass, rect.grass5.x+Movement.backgroundMoveX, rect.grass5.y+Movement.backgroundMoveY, rect.grass5.width, rect.grass5.height, null);
			g.drawImage (image.grass, rect.grass6.x+Movement.backgroundMoveX, rect.grass6.y+Movement.backgroundMoveY, rect.grass6.width, rect.grass6.height, null);
			g.drawImage (image.grass, rect.grass7.x+Movement.backgroundMoveX, rect.grass7.y+Movement.backgroundMoveY, rect.grass7.width, rect.grass7.height, null);
			g.drawImage (image.grass, rect.grass8.x+Movement.backgroundMoveX, rect.grass8.y+Movement.backgroundMoveY, rect.grass8.width, rect.grass8.height, null);
			g.drawImage (image.grass, rect.grass9.x+Movement.backgroundMoveX, rect.grass9.y+Movement.backgroundMoveY, rect.grass9.width, rect.grass9.height, null);
			g.drawImage (image.grass, rect.grass13.x+Movement.backgroundMoveX, rect.grass13.y+Movement.backgroundMoveY, rect.grass13.width, rect.grass13.height, null);
			g.drawImage (image.grass, rect.grass14.x+Movement.backgroundMoveX, rect.grass14.y+Movement.backgroundMoveY, rect.grass14.width, rect.grass14.height, null);
			g.drawImage (image.grass, rect.grass15.x+Movement.backgroundMoveX, rect.grass15.y+Movement.backgroundMoveY, rect.grass15.width, rect.grass15.height, null);

			g.drawImage (image.house, rect.map1House.x+Movement.backgroundMoveX, rect.map1House.y+Movement.backgroundMoveY, rect.map1House.width, rect.map1House.height, null);
			g.drawImage (image.house, rect.map1House2.x+Movement.backgroundMoveX, rect.map1House2.y+Movement.backgroundMoveY, rect.map1House2.width, rect.map1House2.height, null);
			g.drawImage (image.house, rect.map1House3.x+Movement.backgroundMoveX, rect.map1House3.y+Movement.backgroundMoveY, rect.map1House3.width, rect.map1House3.height, null);
			g.drawImage (image.house, rect.map1House4.x+Movement.backgroundMoveX, rect.map1House4.y+Movement.backgroundMoveY, rect.map1House4.width, rect.map1House4.height, null);
			g.drawImage (image.house, rect.map1House5.x+Movement.backgroundMoveX, rect.map1House5.y+Movement.backgroundMoveY, rect.map1House5.width, rect.map1House5.height, null);
			g.drawImage (image.house, rect.map1House6.x+Movement.backgroundMoveX, rect.map1House6.y+Movement.backgroundMoveY, rect.map1House6.width, rect.map1House6.height, null);
			g.drawImage (image.house, rect.map1House7.x+Movement.backgroundMoveX, rect.map1House7.y+Movement.backgroundMoveY, rect.map1House7.width, rect.map1House7.height, null);

			g.drawImage (image.pathVerti, rect.pathVerti1.x+Movement.backgroundMoveX, rect.pathVerti1.y+Movement.backgroundMoveY, rect.pathVerti1.width, rect.pathVerti1.height, null);
			g.drawImage (image.pathVerti, rect.pathVerti2.x+Movement.backgroundMoveX, rect.pathVerti2.y+Movement.backgroundMoveY, rect.pathVerti2.width, rect.pathVerti2.height, null);
			g.drawImage (image.pathVerti, rect.pathVerti3.x+Movement.backgroundMoveX, rect.pathVerti3.y+Movement.backgroundMoveY, rect.pathVerti3.width, rect.pathVerti3.height, null);
			g.drawImage (image.pathVerti, rect.pathVerti4.x+Movement.backgroundMoveX, rect.pathVerti4.y+Movement.backgroundMoveY, rect.pathVerti4.width, rect.pathVerti4.height, null);
			g.drawImage (image.pathVerti, rect.pathVerti5.x+Movement.backgroundMoveX, rect.pathVerti5.y+Movement.backgroundMoveY, rect.pathVerti5.width, rect.pathVerti5.height, null);

			g.drawImage (image.pathHori, rect.pathHori1.x+Movement.backgroundMoveX, rect.pathHori1.y+Movement.backgroundMoveY, rect.pathHori1.width, rect.pathHori1.height, null);
			g.drawImage (image.pathHori, rect.pathHori2.x+Movement.backgroundMoveX, rect.pathHori2.y+Movement.backgroundMoveY, rect.pathHori2.width, rect.pathHori2.height, null);
			g.drawImage (image.pathHori, rect.pathHori3.x+Movement.backgroundMoveX, rect.pathHori3.y+Movement.backgroundMoveY, rect.pathHori3.width, rect.pathHori3.height, null);
			g.drawImage (image.pathHori, rect.pathHori4.x+Movement.backgroundMoveX, rect.pathHori4.y+Movement.backgroundMoveY, rect.pathHori4.width, rect.pathHori4.height, null);
			g.drawImage (image.pathHori, rect.pathHori5.x+Movement.backgroundMoveX, rect.pathHori5.y+Movement.backgroundMoveY, rect.pathHori5.width, rect.pathHori5.height, null);
			g.drawImage (image.pathHori, rect.pathHori6.x+Movement.backgroundMoveX, rect.pathHori6.y+Movement.backgroundMoveY, rect.pathHori6.width, rect.pathHori6.height, null);
			g.drawImage (image.pathHori, rect.pathHori7.x+Movement.backgroundMoveX, rect.pathHori7.y+Movement.backgroundMoveY, rect.pathHori7.width, rect.pathHori7.height, null);
			g.drawImage (image.pathHori, rect.pathHori8.x+Movement.backgroundMoveX, rect.pathHori8.y+Movement.backgroundMoveY, rect.pathHori8.width, rect.pathHori8.height, null);
			g.drawImage (image.pathHori, rect.pathHori9.x+Movement.backgroundMoveX, rect.pathHori9.y+Movement.backgroundMoveY, rect.pathHori9.width, rect.pathHori9.height, null);

			g.drawImage (image.trees9, rect.treeRow2.x+Movement.backgroundMoveX, rect.treeRow2.y+Movement.backgroundMoveY, rect.treeRow2.width, rect.treeRow2.height, null);
			g.drawImage (image.trees9, rect.treeRow1.x+Movement.backgroundMoveX, rect.treeRow1.y+Movement.backgroundMoveY, rect.treeRow1.width, rect.treeRow1.height, null);

			g.drawImage (image.trees, rect.tree2.x+Movement.backgroundMoveX, rect.tree2.y+Movement.backgroundMoveY, rect.tree2.width, rect.tree2.height, null);
			g.drawImage (image.trees, rect.tree3.x+Movement.backgroundMoveX, rect.tree3.y+Movement.backgroundMoveY, rect.tree3.width, rect.tree3.height, null);
			g.drawImage (image.trees, rect.tree4.x+Movement.backgroundMoveX, rect.tree4.y+Movement.backgroundMoveY, rect.tree4.width, rect.tree4.height, null);
			g.drawImage (image.trees, rect.tree5.x+Movement.backgroundMoveX, rect.tree5.y+Movement.backgroundMoveY, rect.tree5.width, rect.tree5.height, null);
			g.drawImage (image.trees, rect.tree6.x+Movement.backgroundMoveX, rect.tree6.y+Movement.backgroundMoveY, rect.tree6.width, rect.tree6.height, null);
			g.drawImage (image.trees, rect.tree7.x+Movement.backgroundMoveX, rect.tree7.y+Movement.backgroundMoveY, rect.tree7.width, rect.tree7.height, null);
			g.drawImage (image.trees, rect.tree8.x+Movement.backgroundMoveX, rect.tree8.y+Movement.backgroundMoveY, rect.tree8.width, rect.tree8.height, null);
			g.drawImage (image.trees, rect.tree9.x+Movement.backgroundMoveX, rect.tree9.y+Movement.backgroundMoveY, rect.tree9.width, rect.tree9.height, null);
			g.drawImage (image.trees, rect.tree10.x+Movement.backgroundMoveX, rect.tree10.y+Movement.backgroundMoveY, rect.tree10.width, rect.tree10.height, null);
			g.drawImage (image.trees, rect.tree11.x+Movement.backgroundMoveX, rect.tree11.y+Movement.backgroundMoveY, rect.tree11.width, rect.tree11.height, null);
			g.drawImage (image.trees, rect.tree12.x+Movement.backgroundMoveX, rect.tree12.y+Movement.backgroundMoveY, rect.tree12.width, rect.tree12.height, null);
			g.drawImage (image.trees, rect.tree13.x+Movement.backgroundMoveX, rect.tree13.y+Movement.backgroundMoveY, rect.tree13.width, rect.tree13.height, null);
			g.drawImage (image.trees, rect.tree14.x+Movement.backgroundMoveX, rect.tree14.y+Movement.backgroundMoveY, rect.tree14.width, rect.tree14.height, null);
			g.drawImage (image.trees, rect.tree15.x+Movement.backgroundMoveX, rect.tree15.y+Movement.backgroundMoveY, rect.tree15.width, rect.tree15.height, null);
			g.drawImage (image.trees, rect.tree16.x+Movement.backgroundMoveX, rect.tree16.y+Movement.backgroundMoveY, rect.tree16.width, rect.tree16.height, null);
			g.drawImage (image.trees, rect.tree17.x+Movement.backgroundMoveX, rect.tree17.y+Movement.backgroundMoveY, rect.tree17.width, rect.tree17.height, null);
			g.drawImage (image.trees, rect.tree18.x+Movement.backgroundMoveX, rect.tree18.y+Movement.backgroundMoveY, rect.tree18.width, rect.tree18.height, null);
			g.drawImage (image.grass, rect.grassPath.x+Movement.backgroundMoveX, rect.grassPath.y+Movement.backgroundMoveY, rect.grassPath.width, rect.grassPath.height, null);
			g.drawImage (image.pathVerti, rect.pathVerti7.x+Movement.backgroundMoveX, rect.pathVerti7.y+Movement.backgroundMoveY, rect.pathVerti7.width, rect.pathVerti7.height, null);
			g.drawImage (image.pathVerti, rect.pathVerti8.x+Movement.backgroundMoveX, rect.pathVerti8.y+Movement.backgroundMoveY, rect.pathVerti8.width, rect.pathVerti8.height, null);

			if(group1)
				g.drawImage (Images.slime, rect.slime1.x+Movement.backgroundMoveX, rect.slime1.y+Movement.backgroundMoveY, rect.slime1.width, rect.slime1.height, null);
			if(group2)
				g.drawImage (Images.slime, rect.slime2.x+Movement.backgroundMoveX, rect.slime2.y+Movement.backgroundMoveY, rect.slime2.width, rect.slime2.height, null);
			if(group3)
				g.drawImage (Images.slime, rect.slime3.x+Movement.backgroundMoveX, rect.slime3.y+Movement.backgroundMoveY, rect.slime3.width, rect.slime3.height, null);
			
		}
		else  if(map==4)
		{
			g.setColor(Color.BLACK);
			g.fillRect(-400, -400, 2000, 2000);
			g.drawImage (image.grass, rect.grasss1.x+Movement.backgroundMoveX, rect.grasss1.y+Movement.backgroundMoveY, rect.grasss1.width, rect.grasss1.height, null);
			g.drawImage (image.grass, rect.grasss2.x+Movement.backgroundMoveX, rect.grasss2.y+Movement.backgroundMoveY, rect.grasss2.width, rect.grasss2.height, null);
			g.drawImage (image.grass, rect.grasss3.x+Movement.backgroundMoveX, rect.grasss3.y+Movement.backgroundMoveY, rect.grasss3.width, rect.grasss3.height, null);
			g.drawImage (image.treesDown, rect.trees1.x+Movement.backgroundMoveX, rect.trees1.y+Movement.backgroundMoveY, rect.trees1.width, rect.trees1.height, null);
			g.drawImage (image.treesDown, rect.trees2.x+Movement.backgroundMoveX, rect.trees2.y+Movement.backgroundMoveY, rect.trees2.width, rect.trees2.height, null);
			g.drawImage (image.treesDown, rect.trees3.x+Movement.backgroundMoveX, rect.trees3.y+Movement.backgroundMoveY, rect.trees3.width, rect.trees3.height, null);
			g.drawImage (image.treesDown, rect.trees4.x+Movement.backgroundMoveX, rect.trees4.y+Movement.backgroundMoveY, rect.trees4.width, rect.trees4.height, null);
			g.drawImage (image.bedGreen, rect.saveBed1.x+Movement.backgroundMoveX, rect.saveBed1.y+Movement.backgroundMoveY, rect.saveBed1.width, rect.saveBed1.height, null);
			g.drawImage (image.chest, rect.chest1.x+Movement.backgroundMoveX, rect.chest1.y+Movement.backgroundMoveY, rect.chest1.width, rect.chest1.height, null);
			g.drawImage (image.chest, rect.chest2.x+Movement.backgroundMoveX, rect.chest2.y+Movement.backgroundMoveY, rect.chest2.width, rect.chest2.height, null);
		}
		else if(map==5)
		{
			g.drawImage (image.black, -2000+Movement.backgroundMoveX, -2000+Movement.backgroundMoveY, 3000, 4000, null);

			g.drawImage (image.grass, rect.grassss1.x+Movement.backgroundMoveX, rect.grassss1.y+Movement.backgroundMoveY, rect.grassss1.width, rect.grassss1.height, null);
			g.drawImage (image.grass, rect.grassss2.x+Movement.backgroundMoveX, rect.grassss2.y+Movement.backgroundMoveY, rect.grassss2.width, rect.grassss2.height, null);
			g.drawImage (image.grass, rect.grassss3.x+Movement.backgroundMoveX, rect.grassss3.y+Movement.backgroundMoveY, rect.grassss3.width, rect.grassss3.height, null);
			g.drawImage (image.cobble3, rect.cob3.x+Movement.backgroundMoveX, rect.cob3.y+Movement.backgroundMoveY, rect.cob3.width, rect.cob3.height, null);
			g.drawImage (image.cobble3, rect.cob4.x+Movement.backgroundMoveX, rect.cob4.y+Movement.backgroundMoveY, rect.cob4.width, rect.cob4.height, null);
			g.drawImage (image.cobble3, rect.cob1.x+Movement.backgroundMoveX, rect.cob1.y+Movement.backgroundMoveY, rect.cob1.width, rect.cob1.height, null);
			g.drawImage (image.cobble3, rect.cob2.x+Movement.backgroundMoveX, rect.cob2.y+Movement.backgroundMoveY, rect.cob2.width, rect.cob2.height, null);
			g.drawImage (image.cobble3, rect.cob5.x+Movement.backgroundMoveX, rect.cob5.y+Movement.backgroundMoveY, rect.cob5.width, rect.cob5.height, null);
			g.drawImage (image.cobble3, rect.cob6.x+Movement.backgroundMoveX, rect.cob6.y+Movement.backgroundMoveY, rect.cob6.width, rect.cob6.height, null);
			g.drawImage (image.cobble3, rect.cob7.x+Movement.backgroundMoveX, rect.cob7.y+Movement.backgroundMoveY, rect.cob7.width, rect.cob7.height, null);
			g.drawImage (image.cobble3, rect.cob8.x+Movement.backgroundMoveX, rect.cob8.y+Movement.backgroundMoveY, rect.cob8.width, rect.cob8.height, null);
			g.drawImage (image.cobble3, rect.cob9.x+Movement.backgroundMoveX, rect.cob9.y+Movement.backgroundMoveY, rect.cob9.width, rect.cob9.height, null);
			g.drawImage (image.cobble3, rect.cob10.x+Movement.backgroundMoveX, rect.cob10.y+Movement.backgroundMoveY, rect.cob10.width, rect.cob10.height, null);
			g.drawImage (image.cobble3, rect.cob11.x+Movement.backgroundMoveX, rect.cob11.y+Movement.backgroundMoveY, rect.cob11.width, rect.cob11.height, null);
			g.drawImage (image.cobble3, rect.cob12.x+Movement.backgroundMoveX, rect.cob12.y+Movement.backgroundMoveY, rect.cob12.width, rect.cob12.height, null);
			g.drawImage (image.cobble3, rect.cob13.x+Movement.backgroundMoveX, rect.cob13.y+Movement.backgroundMoveY, rect.cob13.width, rect.cob13.height, null);
			g.drawImage (image.cobble3, rect.cob14.x+Movement.backgroundMoveX, rect.cob14.y+Movement.backgroundMoveY, rect.cob14.width, rect.cob14.height, null);
			g.drawImage (image.cobble3, rect.cob15.x+Movement.backgroundMoveX, rect.cob15.y+Movement.backgroundMoveY, rect.cob15.width, rect.cob15.height, null);
			g.drawImage (image.cobble3, rect.cob16.x+Movement.backgroundMoveX, rect.cob16.y+Movement.backgroundMoveY, rect.cob16.width, rect.cob16.height, null);
			g.drawImage (image.cobble3, rect.cob17.x+Movement.backgroundMoveX, rect.cob17.y+Movement.backgroundMoveY, rect.cob17.width, rect.cob17.height, null);
			g.drawImage (image.cobble3, rect.cob18.x+Movement.backgroundMoveX, rect.cob18.y+Movement.backgroundMoveY, rect.cob18.width, rect.cob18.height, null);
			g.drawImage (image.cobbleWall, rect.cobbleWall1.x+Movement.backgroundMoveX, rect.cobbleWall1.y+Movement.backgroundMoveY, rect.cobbleWall1.width, rect.cobbleWall1.height, null);
			g.drawImage (image.cobbleWall, rect.cobbleWall2.x+Movement.backgroundMoveX, rect.cobbleWall2.y+Movement.backgroundMoveY, rect.cobbleWall2.width, rect.cobbleWall2.height, null);
			g.drawImage (image.cobbleWall, rect.cobbleWall3.x+Movement.backgroundMoveX, rect.cobbleWall3.y+Movement.backgroundMoveY, rect.cobbleWall3.width, rect.cobbleWall3.height, null);
			g.drawImage (image.cobbleWall, rect.cobbleWall4.x+Movement.backgroundMoveX, rect.cobbleWall4.y+Movement.backgroundMoveY, rect.cobbleWall4.width, rect.cobbleWall4.height, null);
			g.drawImage (image.cobbleWall, rect.cobbleWall5.x+Movement.backgroundMoveX, rect.cobbleWall5.y+Movement.backgroundMoveY, rect.cobbleWall5.width, rect.cobbleWall5.height, null);
			g.drawImage (image.black, rect.cobbleWall5.x+Movement.backgroundMoveX-10, rect.cobbleWall5.y+Movement.backgroundMoveY-10,310, 210, null);
			g.drawImage (image.cobbleWall, rect.cobbleWall6.x+Movement.backgroundMoveX, rect.cobbleWall6.y+Movement.backgroundMoveY, rect.cobbleWall6.width, rect.cobbleWall6.height, null);
			g.drawImage (image.cobbleWall, rect.cobbleWall7.x+Movement.backgroundMoveX, rect.cobbleWall7.y+Movement.backgroundMoveY, rect.cobbleWall7.width, rect.cobbleWall7.height, null);
			g.drawImage (image.black, rect.blackTop1.x+Movement.backgroundMoveX, rect.blackTop1.y+Movement.backgroundMoveY, rect.blackTop1.width, rect.blackTop1.height, null);
			g.drawImage (image.black, rect.blackTop2.x+Movement.backgroundMoveX, rect.blackTop2.y+Movement.backgroundMoveY, rect.blackTop2.width, rect.blackTop2.height, null);
			g.drawImage (image.treesDown, rect.treess1.x+Movement.backgroundMoveX, rect.treess1.y+Movement.backgroundMoveY, rect.treess1.width, rect.treess1.height, null);
			g.drawImage (image.treesDown, rect.treess2.x+Movement.backgroundMoveX, rect.treess2.y+Movement.backgroundMoveY, rect.treess2.width, rect.treess2.height, null);
			g.drawImage (image.treesDown, rect.treess3.x+Movement.backgroundMoveX, rect.treess3.y+Movement.backgroundMoveY, rect.treess3.width, rect.treess3.height, null);

			g.drawImage (image.black, rect.blackWall1.x+Movement.backgroundMoveX, rect.blackWall1.y+Movement.backgroundMoveY, rect.blackWall1.width, rect.blackWall1.height, null);
			g.drawImage (image.black, rect.blackWall2.x+Movement.backgroundMoveX, rect.blackWall2.y+Movement.backgroundMoveY, rect.blackWall2.width, rect.blackWall2.height, null);
			g.drawImage (image.black, rect.blackWall3.x+Movement.backgroundMoveX, rect.blackWall3.y+Movement.backgroundMoveY, rect.blackWall3.width, rect.blackWall3.height, null);
			g.drawImage (image.black, rect.blackWall4.x+Movement.backgroundMoveX, rect.blackWall4.y+Movement.backgroundMoveY, rect.blackWall4.width, rect.blackWall4.height, null);
			g.drawImage (image.black, rect.blackWall5.x+Movement.backgroundMoveX, rect.blackWall5.y+Movement.backgroundMoveY, rect.blackWall5.width, rect.blackWall5.height, null);
//			g.drawImage (image.chest, rect.chest3.x+Movement.backgroundMoveX, rect.chest3.y+Movement.backgroundMoveY, rect.chest3.width, rect.chest3.height, null);
			g.drawImage (image.chest, rect.chest4.x+Movement.backgroundMoveX, rect.chest4.y+Movement.backgroundMoveY, rect.chest4.width, rect.chest3.height, null);
//			g.drawImage (image.chest, rect.chest5.x+Movement.backgroundMoveX, rect.chest5.y+Movement.backgroundMoveY, rect.chest5.width, rect.chest3.height, null);
			g.drawImage (image.chest, rect.chest6.x+Movement.backgroundMoveX, rect.chest6.y+Movement.backgroundMoveY, rect.chest6.width, rect.chest3.height, null);
			if(group1)
				g.drawImage (Images.slime, rect.slimes1.x+Movement.backgroundMoveX, rect.slimes1.y+Movement.backgroundMoveY, rect.slimes1.width, rect.slimes1.height, null);
			if(group2)
				g.drawImage (Images.slime, rect.slimes2.x+Movement.backgroundMoveX, rect.slimes2.y+Movement.backgroundMoveY, rect.slimes2.width, rect.slimes2.height, null);
			if(group3)
				g.drawImage (Images.slime, rect.slimes3.x+Movement.backgroundMoveX, rect.slimes3.y+Movement.backgroundMoveY, rect.slimes3.width, rect.slimes3.height, null);
			if(golden)
				g.drawImage (Images.goldenSlime, rect.goldenSlime.x+Movement.backgroundMoveX, rect.goldenSlime.y+Movement.backgroundMoveY, rect.goldenSlime.width, rect.goldenSlime.height, null);
			g.drawImage (image.magicRock, rect.rock.x+Movement.backgroundMoveX, rect.rock.y+Movement.backgroundMoveY, rect.rock.width, rect.rock.height, null);
		}
		else if(map==6)
		{
			g.drawImage (image.black, -2000+Movement.backgroundMoveX, -2000+Movement.backgroundMoveY, 3000, 4000, null);
			g.drawImage (image.chest, 200+Movement.backgroundMoveX, 200+Movement.backgroundMoveY, 50, 50, null);
			g.drawImage (image.chest, 400+Movement.backgroundMoveX, 400+Movement.backgroundMoveY, 50, 50, null);
			g.drawImage (image.chest, 200+Movement.backgroundMoveX, 400+Movement.backgroundMoveY, 50, 50, null);
			g.drawImage (image.chest, 400+Movement.backgroundMoveX, 200+Movement.backgroundMoveY, 50, 50, null);
		}
	}
	/* Method Description
	 *  Desc: This method allows for the player to interact with objects
	 *  Para: It takes the direction the player is looking at and the map they are currently in
	 *  Return: it's a void
	 */
	public void objInteract(int direction, int map) throws IOException
	{
		if(direction==1)
		{
			System.out.println("Checking up");
			for(int inX=64;inX<=66;inX++)
			{
				objectID=Movement.mapObjArray[inX][59];
			}
		}
		else if(direction==2)
		{
			System.out.println("Checking down");
			for(int inX=64;inX<=66;inX++)
			{
				objectID=Movement.mapObjArray[inX][71];
			}
		}
		else if(direction==3)
		{
			System.out.println("Checking left");
			for(int inY=64;inY<=66;inY++)
			{
				objectID=Movement.mapObjArray[59][inY];
			}
		}
		else if(direction==4)
		{
			System.out.println("Checking right");
			for(int inY=64;inY<=66;inY++)
			{
				objectID=Movement.mapObjArray[71][inY];
			}
		}
		System.out.println(objectID);
		if(map==1)
		{
			if(objectID==2)
			{
				if(!doorOpen)
				{
				Main.Text=Main.TEXT.TRUE;
				Main.Speach=SPEACH.TEXTDOOR;
				}
				else
				{
					Main.map=MAP.AREA2;
					Main.load=true;
					Movement.face=Movement.DOWN;
					Main.Text=Main.TEXT.TRUE;
					Main.Speach=SPEACH.SCENE3TEXT;
					PlayerStats.addItemPlayer("Practice Sword", 1);
					PlayerStats.addItemPlayer("Wooden Staff", 2);
					PlayerStats.addItemPlayer("Leather Armour", 1);
					PlayerStats.addItemPlayer("Tattered Robes", 2);
					Movement.backgroundMoveX+=150;
					Movement.backgroundMoveY-=100;
					Movement.playerMoveX+=150;
					Movement.playerMoveY-=100;
					Movement.clearMap();
				}
			}
			else if(objectID==3)
			{
				Main.Text=Main.TEXT.TRUE;
				Main.Speach=SPEACH.TEXTSHELF;
			}
			else if(objectID==4)
			{
				Main.Text=Main.TEXT.TRUE;
				Main.Speach=SPEACH.TEXTBED;
			}
			else if(objectID==5)
			{
				Main.Text=Main.TEXT.TRUE;
				Main.Speach=SPEACH.SCENE2TEXT;
				doorOpen=true;
			}
		}
		else if(map==2)
		{
//			for(int count=0;count<Movement.mapObjArray.length;count++)
//			{
//				System.out.println();
//				for(int count2=0;count2<Movement.mapObjArray.length;count2++)
//					System.out.print(Movement.mapObjArray[count2][count]);
//			}
					
			if(objectID==3||objectID==4||objectID==5)
			{
				if(objectID==3)
					group1=false;
				else if(objectID==4)
					group2=false;
				else if(objectID==5)
					group3=false;
				Main.fight=Main.fight2;
				Main.State=Main.STATE.BATTLE;
			}
			if(objectID==6)
			{
				Main.load=true;
				Main.map=MAP.AREA3;
				Movement.backgroundMoveX=0;
				Movement.backgroundMoveY=0;
				Movement.playerMoveX=0;
				Movement.playerMoveY=0;
			}
		}
		else if(map==3)
		{
			if(objectID==2)
			{
				Main.saveSave();
				Main.Speach=SPEACH.GAMESAVE;
				Main.Text=TEXT.TRUE;
			}
			if(objectID==3&&Main.chest1)
			{
				Main.Text=TEXT.TRUE;
				Main.Speach=SPEACH.ITEMHPPOTION;
				Main.chest1=false;
				ItemSkillList.HPPotion++;
			}
			else if(objectID==3)
			{
				Main.Text=TEXT.TRUE;
				Main.Speach=SPEACH.CHESTEMPTY;
			}
			if(objectID==4&&Main.chest2)
			{			
				Main.Text=TEXT.TRUE;
				Main.Speach=SPEACH.ITEMSPPOTION;
				Main.chest2=false;
				ItemSkillList.SPPotion++;
			}
			else if(objectID==4)
			{
				Main.Text=TEXT.TRUE;
				Main.Speach=SPEACH.CHESTEMPTY;
			}
			if(objectID==5)
			{			
				Main.load=true;
				Main.map=MAP.AREA2;
				Movement.backgroundMoveX=-305;
				Movement.backgroundMoveY=-600;
				Movement.playerMoveX=-305;
				Movement.playerMoveY=-600;
				
			}
			if(objectID==6)
			{			
				Main.load=true;
				Main.map=MAP.AREA4;
				Movement.backgroundMoveX=0;
				Movement.backgroundMoveY=0;
				Movement.playerMoveX=0;
				Movement.playerMoveY=0;
				group1=true;
				group2=true;
				group3=true;
			}
		}
		else if(map==4)
		{
			if(objectID==2)
			{
				
			}
			if(objectID==3&&Main.chest3)
			{
				Main.Text=TEXT.TRUE;
				Main.Speach=SPEACH.ITEMHPPOTION;
				Main.chest3=false;
				ItemSkillList.HPPotion++;
			}
			else if(objectID==3)
			{
				Main.Text=TEXT.TRUE;
				Main.Speach=SPEACH.CHESTEMPTY;
			}
			if(objectID==4)
			{
				
			}
			if(objectID==5&&Main.chest5)
			{
				Main.Text=TEXT.TRUE;
				Main.Speach=SPEACH.ITEMSPPOTION;
				Main.chest5=false;
				ItemSkillList.SPPotion++;
			}
			else if(objectID==5)
			{
				Main.Text=TEXT.TRUE;
				Main.Speach=SPEACH.CHESTEMPTY;
			}
			if(objectID==6)
			{
				Main.load=true;
				Main.map=MAP.AREA3;
				Movement.backgroundMoveX=0;
				Movement.backgroundMoveY=-800;
				Movement.playerMoveX=0;
				Movement.playerMoveY=-800;
			}
			if(objectID==7||objectID==8||objectID==9)
			{
				if(objectID==7)
					group1=false;
				else if(objectID==8)
					group2=false;
				else if(objectID==9)
					group3=false;
				Main.fight=Main.fight3;
				Main.State=Main.STATE.BATTLE;
			}
			if(objectID==10)
			{
				Main.Text=Main.TEXT.TRUE;
				Main.Speach=SPEACH.SCENE5TEXT;
				golden=false;
			}
			if(objectID==11)
			{
				Main.Text=Main.TEXT.TRUE;
				Main.Speach=SPEACH.SCENE6TEXT;
			}
		}
		else if(map==5)
		{
			if(objectID==2&&Main.testChest1)
			{
				Main.Text=TEXT.TRUE;
				Main.Speach=SPEACH.ITEMIRONSWORD;
				Main.testChest1=false;
				PlayerStats.addItem("Iron Sword");
			}
			if(objectID==3&&Main.testChest2)
			{
				Main.Text=TEXT.TRUE;
				Main.Speach=SPEACH.ITEMLEGENDARYSTAFF;
				Main.testChest2=false;
				PlayerStats.addItem("Legendary Sword");
			}
			if(objectID==4&&Main.testChest3)
			{
				Main.Text=TEXT.TRUE;
				Main.Speach=SPEACH.ITEMIRONSWORD;
				Main.testChest3=false;
				PlayerStats.addItem("Legendary Staff");
			}
			if(objectID==5&&Main.testChest4)
			{
				Main.Text=TEXT.TRUE;
				Main.Speach=SPEACH.ITEMMYTHICALSTAFF;
				Main.testChest4=false;
				PlayerStats.addItem("Mythical Staff");
			}
		}
	}
}