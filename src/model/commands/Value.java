package model.commands;

import java.util.LinkedList;
import java.util.List;

import model.instructions.Instruction;

public class Value extends Command {
	public double val;

	@Override
	public List<Instruction> execute() {
		validate();
		return new LinkedList<Instruction>();
	}

	@Override
	public double getReturnValue() {
		return val;
	}

	@Override
	public void validate() {
	}

}