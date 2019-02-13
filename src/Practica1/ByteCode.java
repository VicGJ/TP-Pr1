package Practica1;

public class ByteCode {

	public enum ENUM_BYTECODE {
		ADD, SUB, MUL, DIV,
		PUSH(1), LOAD(1), STORE(1),
		OUT, HALT;
		private int numArgs;
		ENUM_BYTECODE() { this(0); }
		ENUM_BYTECODE(int n) {
		numArgs = n;
		}
		public int getNumArgs() { return numArgs; }
		}
	private ENUM_BYTECODE name;
	private int param;
	
	public ByteCode(ENUM_BYTECODE op)
	{
		this.name = op;
	}
	public ByteCode(ENUM_BYTECODE mnemo, int param)
	{
		this.name = mnemo;
		this.param = param;
	}
	
	public ENUM_BYTECODE getOpcode() 
	{
		return this.name;
	}
	
	public int getParam()
	{
		return this.param; 
	}
	
	public String toString()
	{
		return this.name + (name.getNumArgs() > 0 ? (" " + param) : "");
	}
}
