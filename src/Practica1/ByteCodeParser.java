package Practica1;

public class ByteCodeParser {

	
	public static ByteCode parse(String s)
	{
		String[] par;
		par = s.split(" ");
		
		if(par.length == 1)
		{
			if(par[0].equalsIgnoreCase("ADD"))
			{
				return new ByteCode(ByteCode.ENUM_BYTECODE.ADD);
			}
			else if (par[0].equalsIgnoreCase("SUB"))
			{
				return new ByteCode(ByteCode.ENUM_BYTECODE.SUB);
			}
			else if (par[0].equalsIgnoreCase("MUL"))
			{
				return new ByteCode(ByteCode.ENUM_BYTECODE.MUL);
			}
			else if (par[0].equalsIgnoreCase("DIV"))
			{
				return new ByteCode(ByteCode.ENUM_BYTECODE.DIV);
			}
			else if (par[0].equalsIgnoreCase("OUT"))
			{
				return new ByteCode(ByteCode.ENUM_BYTECODE.OUT);
			}
			else if (par[0].equalsIgnoreCase("HALT"))
			{
				return new ByteCode(ByteCode.ENUM_BYTECODE.HALT);
			}
			else
			{
				return null;
			}
		}
		else if(par.length == 2)
		{
			if(par[0].equalsIgnoreCase("PUSH"))
			{
				return new ByteCode(ByteCode.ENUM_BYTECODE.PUSH, Integer.parseInt(par[1]));
			}
			else if(par[0].equalsIgnoreCase("LOAD"))
			{
				return new ByteCode(ByteCode.ENUM_BYTECODE.LOAD, Integer.parseInt(par[1]));
			}
			else if(par[0].equalsIgnoreCase("STORE"))
			{
				return new ByteCode(ByteCode.ENUM_BYTECODE.STORE, Integer.parseInt(par[1]));
			}
			else
			{
				return null;
			}
		}
	
		else
		{
			return null;
		}
	}
}
