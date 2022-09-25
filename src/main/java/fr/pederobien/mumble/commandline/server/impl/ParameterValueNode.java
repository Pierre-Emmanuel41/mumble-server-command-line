package fr.pederobien.mumble.commandline.server.impl;

import java.util.List;
import java.util.function.Supplier;

import fr.pederobien.mumble.server.interfaces.IChannel;
import fr.pederobien.mumble.server.interfaces.IParameter;
import fr.pederobien.mumble.server.interfaces.ISoundModifier;

public class ParameterValueNode extends ParameterNode {

	/**
	 * Creates a node in order to update the current value of a parameter.
	 * 
	 * @param parameter The parameter associated to this node.
	 */
	protected ParameterValueNode(Supplier<IParameter<?>> parameter) {
		super(parameter, "value", EMumbleServerCode.MUMBLE_SERVER_CL__PARAMETER__VALUE__EXPLANATION, p -> p != null);
	}

	@Override
	public List<String> onTabComplete(String[] args) {
		switch (args.length) {
		case 1:
			return asList(getMessage(EMumbleServerCode.MUMBLE_SERVER_CL__VALUE__COMPLETION));
		default:
			return emptyList();
		}
	}

	@Override
	public boolean onCommand(String[] args) {
		Object value;
		try {
			value = getParameter().getType().getValue(args[0]);

		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__PARAMETER__VALUE__VALUE_IS_MISSING, getParameter().getName());
			return false;
		} catch (Exception e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__PARAMETER__VALUE__VALUE_BAD_FORMAT, getParameter().getName());
			return false;
		}

		try {
			ISoundModifier soundModifier = getParameter().getSoundModifier();
			IChannel channel = soundModifier.getChannel();
			getParameter().setValue(value);
			send(EMumbleServerCode.MUMBLE_SERVER_CL__PARAMETER__VALUE__VALUE_SET, getParameter().getName(), soundModifier.getName(), channel.getName(), value);
		} catch (IllegalArgumentException e) {
			// When the parameter as a range
			send(EMumbleServerCode.MUMBLE_SERVER_CL__PARAMETER__VALUE__VALUE_OUT_OF_RANGE, getRangeParameter().getMin(), getRangeParameter().getMax());
		}
		return true;
	}
}
