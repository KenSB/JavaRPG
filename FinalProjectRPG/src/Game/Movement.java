package Game;
/* Class Description
 * This class manages the movement of objects on the screen.
 */
public class Movement 
{
	//variables that make movement possible
	static int backgroundMoveX=0;
	static int backgroundMoveY=0;
	static int playerMoveX=0;
	static int playerMoveY=0;
	static int pArrayX;
	static int pArrayY;
	int useY;
	int useX;
	static int direction = 0;
	static int face=2;
	final static int UP=1;
	final static int DOWN=2;
	final static int LEFT=3;
	final static int RIGHT=4;
	final static int UPRIGHT=5;
	final static int UPLEFT=6;
	final static int DOWNRIGHT=7;
	final static int DOWNLEFT=8;
	boolean up=false;
	boolean down=false;
	boolean left=false;
	boolean right=false;
	boolean upRight=false;
	boolean upLeft=false;
	boolean downRight=false;
	boolean downLeft=false;
	boolean colide=false;
	boolean checker=false;
	//This array makes the map 
	static int[][]mapObjArray= new int[130][130];
	static int arrayX;
	static int arrayY;
	static int arrayX2;
	static int arrayY2;
	/* Method Description
	 *  Desc: This method creates an object by changing its value on the map array
	 *  Para: It takes in the position and the size of the object
	 *  Return: it's a void
	 */
	public void createObject(int x, int y, int width, int height, int objectID)
	{
		arrayX=0;
		arrayY=0;
		arrayX2=0;
		arrayY2=0;
		if(x+width>=0)
		{
			if(x<650)
			{
				if(y+height>=0)
				{
					if(y<650)
					{
						arrayX=x/5;
						arrayY=y/5;
						arrayX2=(x/5)+(width/5)-1;
						arrayY2=(y/5)+(height/5)-1;
						if(x<0)
						{
							arrayX=0;
						}
						if(x+width>=650)
						{
							arrayX2=129;
						}
						if(y<0)
						{
							arrayY=0;
						}
						if(y+height>=650)
						{
							arrayY2=129;
						}
					}
				}	
			}
		}
		for(int indexX=arrayX;indexX<=(arrayX2);indexX++)
			for(int indexY=arrayY;indexY<=(arrayY2);indexY++)
				mapObjArray[indexX][indexY]=objectID;
	}
	/* Method Description
	 *  Desc: This method sets all values to 0 on the map array
	 *  Para: None
	 *  Return: it's a void
	 */
	public static void clearMap()
	{
		for(int indexX=0;indexX<=129;indexX++)
		{
			for(int indexY=0;indexY<=129;indexY++)
				mapObjArray[indexX][indexY]=0;
		}
	}
	/* Method Description
	 *  Desc: This method detects if the player has collided with an object
	 *  Para: None
	 *  Return: it's a void
	 */
	public void colisionDetect()
	{
		checker=true;
		for(int inX=60;inX<=69;inX++)
		{
			if(mapObjArray[inX][59]>=1)
			{
				up=true;
				checker=false;
			}
			else if(checker)
			{
				up=false;
			}
		}
		for(int inX=60;inX<=69;inX++)
		{
			if(mapObjArray[inX][71]>=1)
			{
				down=true;
				checker=false;
			}
			else if(checker)
			{
				down=false;
			}
		}
		for(int inY=60;inY<=69;inY++)
		{
			if(mapObjArray[59][inY]>=1)
			{
				left=true;
				checker=false;
			}
			else if(checker)
			{
				left=false;
			}
		}
		for(int inY=60;inY<=69;inY++)
		{
			if(mapObjArray[71][inY]>=1)
			{
				right=true;
				checker=false;
			}
			else if(checker)
			{
				right=false;
			}
		}
		if(mapObjArray[59][59]>=1)
		{
			upLeft=true;
			checker=false;
		}
		else if(checker)
		{
			upLeft=false;
		}
		if(mapObjArray[71][59]>=1)
		{
			upRight=true;
			checker=false;
		}
		else if(checker)
		{
			upRight=false;
		}
		if(mapObjArray[59][71]>=1)
		{
			downLeft=true;
			checker=false;
		}
		else if(checker)
		{
			downLeft=false;
		}
		if(mapObjArray[71][71]>=1)
		{
			downRight=true;
			checker=false;
		}
		else if(checker)
		{
			downRight=false;
		}	
	}	
}