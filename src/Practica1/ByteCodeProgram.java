package Practica1;

public class ByteCodeProgram 
{
	private static final int MAX_INSTR = 100;
	private ByteCode[] bcprogram;
	private int numBc;
	
	public ByteCodeProgram()
	{
		this.bcprogram = new ByteCode[ByteCodeProgram.MAX_INSTR];
		this.numBc = 0;
	}
	public boolean addBCInstruction(ByteCode instr)
	{
		boolean add = false;
		
		if(this.numBc < MAX_INSTR)
		{
			this.bcprogram[this.numBc] = instr;
			add = true;
			this.numBc++;
		}
		return add;
	}
	public int getNumberOfByteCodes()
	{
		return this.numBc;
	}
	public ByteCode getByteCode(int i)
	{ 
		return this.bcprogram[i];
	}
	public String toString()
	{
		if (this.numBc == 0) return "<vacia>";
		else 
		{
		String s="";
		for (int i=0; i < this.numBc; i++)
			{
			s = s + " "+ i + " " + this.bcprogram[i] + " \n";
			}
		return s;
		}
	}
	public void reset()
	{
		for(int i = 0; i <= this.numBc; i++)
		{
			this.bcprogram[i] = null;
		}
		this.numBc = 0;
		
	}
	public void replace(int replace, ByteCode bc)
	{
		this.bcprogram[replace] = bc;
	}
}