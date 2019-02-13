package Practica1;

import Practica1.ByteCode.ENUM_BYTECODE;

public class CPU 
{
	private Memory memory = new Memory();
	private OperandStack stack = new OperandStack();
	private boolean halt = false;
	
	public boolean isHalted()
	{
		this.halt = true;
		return this.halt;
	}
	
	public String toString()
	{
		String s = System.getProperty("line.separator") +
		"Estado de la CPU: " + System.getProperty("line.separator") +
		" Memoria: " + this.memory + System.getProperty("line.separator") +
		" Pila: " + this.stack + System.getProperty("line.separator");
		return s;
	}
	
	public boolean execute(ByteCode bc)
	{
		if (bc.getOpcode().equals(ENUM_BYTECODE.PUSH))
			{
				return this.stack.push(bc.getParam());
			}
		else if (bc.getOpcode().equals(ENUM_BYTECODE.LOAD))
		{
			int pos = bc.getParam();
			return this.stack.push(memory.read(pos));
		}
		else if (bc.getOpcode().equals(ENUM_BYTECODE.ADD))
		{
			int num1 = this.stack.pop();
			int num2 = this.stack.pop();
			int resul;
			
			resul = num1 + num2;
			this.stack.push(resul);
			return true;
		}
		else if (bc.getOpcode().equals(ENUM_BYTECODE.SUB))
		{
			int num1 = this.stack.pop();
			int num2 = this.stack.pop();
			int resul;
			
			resul = num2 - num1;
			this.stack.push(resul);
			return true;
		}
		else if (bc.getOpcode().equals(ENUM_BYTECODE.DIV))
		{
			int num1 = this.stack.pop();
			int num2 = this.stack.pop();
			int resul;
			
			resul = (num1/num2);
			this.stack.push(resul);
			return true;
		}
		else if (bc.getOpcode().equals(ENUM_BYTECODE.MUL))
		{
			int num1 = this.stack.pop();
			int num2 = this.stack.pop();
			int resul;
			
			resul = num1 * num2;
			this.stack.push(resul);
			return true;
		}
		else if (bc.getOpcode().equals(ENUM_BYTECODE.STORE))
		{
			int last = this.stack.pop();
			
			this.memory.write(bc.getParam(), last);
			return true;
		}
		else if (bc.getOpcode().equals(ENUM_BYTECODE.OUT))
		{
			System.out.println("Ultimo elemento de la pila: " + this.stack.pop());
			return true;
		}
		else if (bc.getOpcode().equals(ENUM_BYTECODE.HALT))
		{
			isHalted();
			return false;
		}
		else
		{
			return false;
		}
	}
}
