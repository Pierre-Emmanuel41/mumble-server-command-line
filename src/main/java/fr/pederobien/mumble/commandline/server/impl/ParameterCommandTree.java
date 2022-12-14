package fr.pederobien.mumble.commandline.server.impl;

import java.util.Locale;
import java.util.function.Consumer;

import fr.pederobien.commandline.CommandLineDictionaryContext;
import fr.pederobien.commandline.ICode;
import fr.pederobien.commandtree.impl.CommandRootNode;
import fr.pederobien.commandtree.interfaces.ICommandRootNode;
import fr.pederobien.commandtree.interfaces.INode;
import fr.pederobien.dictionary.impl.MessageEvent;
import fr.pederobien.mumble.server.interfaces.IParameter;
import fr.pederobien.utils.AsyncConsole;

public class ParameterCommandTree {
	private IParameter<?> parameter;
	private ICommandRootNode<ICode> root;
	private ParameterValueNode valueNode;
	private ParameterMinValueNode minNode;
	private ParameterMaxValueNode maxNode;

	protected ParameterCommandTree() {
		Consumer<INode<ICode>> displayer = node -> {
			String label = node.getLabel();
			String explanation = CommandLineDictionaryContext.instance().getMessage(new MessageEvent(Locale.getDefault(), node.getExplanation().toString()));
			AsyncConsole.println(String.format("%s - %s", label, explanation));
		};

		root = new CommandRootNode<ICode>("parameter", EMumbleServerCode.MUMBLE_SERVER_CL__PARAMETER__ROOT__EXPLANATION, () -> true, displayer);
		root.add(valueNode = new ParameterValueNode(() -> getParameter()));
		root.add(minNode = new ParameterMinValueNode(() -> getParameter()));
		root.add(maxNode = new ParameterMaxValueNode(() -> getParameter()));
	}

	/**
	 * @return The underlying parameter managed by this command tree.
	 */
	public IParameter<?> getParameter() {
		return parameter;
	}

	/**
	 * Set the parameter managed by this command tree.
	 * 
	 * @param parameter The new parameter managed by this command tree.
	 */
	public void setParameter(IParameter<?> parameter) {
		this.parameter = parameter;
	}

	/**
	 * @return The root of this command tree.
	 */
	public ICommandRootNode<ICode> getRoot() {
		return root;
	}

	/**
	 * @return The node that modifies the current value of a parameter.
	 */
	public ParameterValueNode getValueNode() {
		return valueNode;
	}

	/**
	 * @return The node that modifies the minimum value of a range parameter.
	 */
	public ParameterMinValueNode getMinNode() {
		return minNode;
	}

	/**
	 * @return The node that modifies the maximum value of a range parameter.
	 */
	public ParameterMaxValueNode getMaxNode() {
		return maxNode;
	}
}
