package lab_1;

import java.awt.Color;
import java.awt.Graphics;

public class WarBase <T extends Object&ITransport , W extends Object&IGuns> {
	
		private T[] _places;
		
		private W[] gunsForm;
	
	    private int PictureWidth;

	    private int PictureHeight;
	
	    
	    
	    private final int _placeSizeWidth = 270;

	    private final int _placeSizeHeight = 135;
	
	    public WarBase(int sizes, int pictureWidth, int pictureHeight)
	    {
	    	
	    	_places = (T[]) new Object[sizes];
	    	gunsForm = (W[]) new Object[sizes];
	    	PictureWidth = pictureWidth;	    	
	    	 PictureHeight = pictureHeight;
	    	
	    	 for (int i = 0; i < _places.length; i++)
	         {
	             _places[i] = null;
	         }
	    		    
	    }
	
	    
	    
	    public int add (T transport)
	    {
	        for (int i = 0; i < this._places.length; i++)
	        {
	            if (this.CheckFreePlace(i))
	            {
	            	this._places[i] = transport;
	                this._places[i].SetPosition(30 + i / 5 * _placeSizeWidth + 5,
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
	        for (int i = 0; i < this._places.length; i++)
	        {
	            if (this.CheckFreePlace(i))
	            {
	            	this._places[i] = transport;
	            	this._places[i].SetPosition(30 + i / 5 * _placeSizeWidth + 5,
	                                             i % 5 * _placeSizeHeight + 15,
	                                             this.PictureWidth,
	                                             this.PictureHeight);
	            	this.gunsForm[i] = gunsForm;
	                return i;
	            }
	        }
	        return -1;
	    }
	    
	
	    
	    
	    
	    public T sub(int index)
	    {
	        if (index < 0 || index > this._places.length)
	        {
	            return null;
	        }
	        if (!this.CheckFreePlace(index))
	        {
	            T machine = this._places[index];
	            this._places[index] = null;

	         
	            return machine;
	        }
	        
	        return null;
	    }
	    
	    
	    private boolean CheckFreePlace(int index)
	    {
	        return _places[index] == null;
	    }
	    
	    public void Draw(Graphics g)
	    {
	        DrawMarking(g); 
	        for (int i = 0; i < _places.length; i++)
	        {
	            if (!CheckFreePlace(i))
	            {  
	                _places[i].DrawTransport(g);
	                
	            }
	        }
	     }
	    
	    
	    private void DrawMarking(Graphics g)
	    {
	        g.setColor(Color.BLACK);
	        g.drawRect(0, 0, (_places.length / 5) * _placeSizeWidth, 600);
	        for (int i = 0; i < _places.length / 5; i++)
	        {
	            for (int j = 0; j < 6; ++j)
	            {            
	                g.drawLine(i * _placeSizeWidth, j * _placeSizeHeight-7,
	                i * _placeSizeWidth + 110, j * _placeSizeHeight-7);
	            }
	            g.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth, 400);
	        }
	    }

}
