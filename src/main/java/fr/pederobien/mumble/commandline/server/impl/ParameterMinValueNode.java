package fr.pederobien.mumble.commandline.server.impl;

import java.util.List;
import java.util.function.Supplier;

import fr.pederobien.mumble.server.interfaces.IChannel;
import fr.pederobien.mumble.server.interfaces.IParameter;
import fr.pederobien.mumble.server.interfaces.IRangeParameter;
import fr.pederobien.mumble.server.interfaces.ISoundModifier;

public class ParameterMinValueNode extends ParameterNode {

	/**
	 * Creates a node in order to update the minimum value of the range of a parameter.
	 * 
	 * @param parameter The parameter associated to this node.
	 */
	protected ParameterMinValueNode(Supplier<IParameter<?>> parameter) {
		super(parameter, "minValue", EMumbleServerCode.MUMBLE_SERVER_CL__PARAMETER__MIN_VALUE__EXPLANATION, p -> p instanceof IRangeParameter<?>);
	}

	@Override
	public List<String> onTabComplete(String[] args) {
		switch (args.length) {
		case 1:
			return asList(getMessage(EMumbleServerCode.MUMBLE_SERVER_CL__MIN_VALUE__COMPLETION));
		default:
			return emptyList();
		}
	}

	@Override
	public boolean onCommand(String[] args) {
		Object min;
		try {
			min = getParameter().getType().getValue(args[0]);
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__PARAMETER__MIN_VALUE__VALUE_IS_MISSING, getParameter().getName());
			return false;
		} catch (Exception e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__PARAMETER__MIN_VALUE__VALUE_BAD_FORMAT, getParameter().getName());
			return false;
		}

		ISoundModifier soundModifier = getParameter().getSoundModifier();
		IChannel channel = soundModifier.getChannel();
		getRangeParameter().setMin(min);
		send(EMumbleServerCode.MUMBLE_SERVER_CL__PARAMETER__MIN_VALUE__VALUE_SET, getParameter().getName(), soundModifier.getName(), channel.getName(), min);
		return true;
	}
}
