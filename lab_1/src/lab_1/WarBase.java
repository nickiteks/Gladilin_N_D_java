package lab_1;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WarBase <T extends Object&ITransport , W extends Object&IGuns> {
	
		//private T[] _places;
		
		private W[] gunsForm;
	
	    private int PictureWidth;

	    private int PictureHeight;
	    
	    Map<Integer , T> _places = new HashMap< Integer , T>();
	
	    
	    
	    private final int _placeSizeWidth = 270;

	    private final int _placeSizeHeight = 135;
	    
	    int type;
	    
	    private  Color mainColor;
	    
	    private  Color dopColor;
	    
	
	    public WarBase(int sizes, int pictureWidth, int pictureHeight)
	    {
	    	
	    	_places = new HashMap<Integer, T>();
	    	gunsForm = (W[]) new Object[sizes];
	    	PictureWidth = pictureWidth;	    	
	    	 PictureHeight = pictureHeight;
	    	
	    	 
	    		    
	    }
	    
	    public void clone(Color mainColor ,Color dopColor,int type)
	    {
	    	
	    	
	    	 this.mainColor =mainColor;
	    	 this.dopColor= dopColor;
	    	 this.type=type;
	    	 
	    		    
	    }
	
	    
	    
	    public int add (T _transport)
	    {
	        for (int i = 0; i < this._places.size(); i++)
	        {
	            if (this.CheckFreePlace(i))
	            {
	            	_places.put(i, _transport);
	                _places.get(i).SetPosition(30 + i / 5 * _placeSizeWidth + 5,
	                                             i % 5 * _placeSizeHeight + 15,
	                                             this.PictureWidth,
	                                             this.PictureHeight);
	                return i;
	            }
	        }
	        return -1;
	    }
	    
	    
	    public int add(T transport, W gunsForm)
	    {
	        for (int i = 0; i < this._places.size(); i++)
	        {
	            if (this.CheckFreePlace(i))
	            {
	            	_places.put(i, transport);
	            	_places.get(i).SetPosition(30 + i / 5 * _placeSizeWidth + 5,
	                                             i % 5 * _placeSizeHeight + 15,
	                                             this.PictureWidth,
	                                             this.PictureHeight);
	            	this.gunsForm[i] = gunsForm;
	                return i;
	            }
	        }
	        return -1;
	    }
	    
	
	    
	    
	    
	    public T sub (int index)
	    {
	        if (index < 0 || index > this._places.size())
	        {
	            return null;
	        }
	        if (!this.CheckFreePlace(index))
	        {
	            T machine = this._places.get(index);
	            _places.remove(index);

	         
	            return machine;
	        }
	        
	        return null;
	    }
	    
	    
	    
	    public  int   mylty(int num) 
	    {
	    	Random rnd = new Random();
	    	
	    	 int score=0;
	    	 int k = -1;
	    
	    	for (int i = 0; i < this._places.size(); i++)
	        {
	            if (!this.CheckFreePlace(i))
	            {
	            	score++;
	            }
	        }
	    	
	    	num = (num*score)-score;
	    	
	    	for (int j = 0; j < num; j++) 
	    	{
	    				    	
		    	ITransport _transport =null;
		    	
		    	if(type==0) 
		    	{
		    		
		    		_transport = new WarCar(rnd.nextInt(20)+100, rnd.nextInt(1000)+1000, mainColor);
		    		
		    			    		
		    	}
		    			    	
		    	if(type==1) 
		    	{
		    		
		    		_transport = new tank(rnd.nextInt(20)+100,
							guns.superGun, 
							rnd.nextInt(1000)+1000, 
							mainColor,
							dopColor,
					        false, 
					        false, 
					        false);	
		    			    		
		    	}
	    		
	    		
	    			
	    		
				add(_transport);
	    		
	    			
	         }
	    	
	    	
	    	return k;
	    		 
		}
	    
	    
	    public  void   del (int num) 
	    {
	    	
	    	 int score=0;
	    	 
	    
	    	for (int i = 0; i < this._places.size(); i++)
	        {
	            if (!this.CheckFreePlace(i))
	            {
	            	score++;
	            }
	        }
	    		num = (score/num)-1;
	    	
	    	for (int i = _places.size()-1; i > num; i--) 
	    	{
	    		 if(_places.get(i)!=null)
		          _places.remove(i);

		         
		            
		     }
	    					
	     }
	    	
	    	
	   
	    	
    
	    
	    
	    private boolean CheckFreePlace(int index)
	    {
	        return _places.get(index) == null;
	    }
	    
	    
	    
	    public void Draw(Graphics g)
	    {
	        DrawMarking(g); 
	        for (int i = 0; i < _places.size(); i++)
	        {
	            if (!CheckFreePlace(i))
	            {  
	                _places.get(i).DrawTransport(g);
	                
	            }
	        }
	     }
	    
	    
	    private void DrawMarking(Graphics g)
	    {
	        g.setColor(Color.BLACK);
	       
	        g.drawRect(0, 0, (_places.size() / 5) * _placeSizeWidth, 700);
	        for (int i = 0; i < _places.size() / 5; i++)
	        {
	            for (int j = 0; j < 6; ++j)
	            {            
	                g.drawLine(i * _placeSizeWidth, j * _placeSizeHeight-7,
	                i * _placeSizeWidth + 110, j * _placeSizeHeight-7);
	            }
	            g.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth, 700);
	        }
	    }
	    
	    
	    
	   
		
}
	    

