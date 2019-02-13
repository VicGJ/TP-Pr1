package Practica1;
public class Memory {
	public static final int Capacidad = 100;
	private Integer[] memory;
	private int dimension;
	private boolean estado;
	
	
	public Memory()
	{
		this.dimension = Capacidad;
		this.estado = true;
		this.memory = new Integer[Memory.Capacidad];
		for(int i = 0; i < this.dimension; i++)
		{
			memory[i] = null;
		}
	}
	public boolean write(int pos, int value)
	{
		this.estado = false;
		if(pos < 0)
		{
			return false;
		}
		else
		{
			redimensionar(pos);
			this.memory[pos] = value;
			return true;
		}
	}
	public int read(int pos)
	{
		return this.memory[pos];
	}
	private void redimensionar(int pos)
	{
		if(pos >= this.dimension)
		{
			Integer[] memoryAux = new Integer[2*pos];
			for(int i = 0; i < pos*2; i++)
			{
				memoryAux[i] = null;
			}
			for(int i = 0; i < this.dimension; i++)
			{
				memoryAux[i] = this.memory[i];
			}
			
			this.memory = memoryAux;
			this.dimension = pos * 2;
		}
		
	}
	public String toString()
	{
		if(this.estado)
		{
			return "Memoria: <vacia>";
		}
		else
		{
			String text = "";
			int i = 0;
			while(i < this.dimension)
			{
				if(this.memory[i] != null)
				{
					text = text + "[" + i + "] :" + this.memory[i] + "  ";
				}
				i++;
			}
			return "Memoria: " + text;
		}
	}
}
