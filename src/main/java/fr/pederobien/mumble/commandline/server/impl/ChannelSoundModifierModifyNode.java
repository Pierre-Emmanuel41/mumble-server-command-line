package fr.pederobien.mumble.commandline.server.impl;

import java.util.Optional;
import java.util.function.Supplier;

import fr.pederobien.mumble.server.interfaces.IChannel;
import fr.pederobien.mumble.server.interfaces.IMumbleServer;
import fr.pederobien.mumble.server.interfaces.IParameter;

public class ChannelSoundModifierModifyNode extends MumbleServerNode {
	private ParameterCommandTree parameterTree;

	/**
	 * Creates a node in order to modify the properties of a sound modifier.
	 * 
	 * @param server The server associated to this node.
	 */
	protected ChannelSoundModifierModifyNode(Supplier<IMumbleServer> server) {
		super(server, "modify", EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__MODIFY__EXPLANATION, s -> s != null);

		parameterTree = new ParameterCommandTree();
		parameterTree.getRoot().export(this);
	}

	@Override
	public boolean onCommand(String[] args) {
		IChannel channel;
		try {
			Optional<IChannel> optChannel = getServer().getChannels().get(args[0]);
			if (!optChannel.isPresent()) {
				send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__MODIFY__CHANNEL_NOT_FOUND, args[0]);
				return false;
			}

			channel = optChannel.get();
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__MODIFY__CHANNEL_NAME_IS_MISSING);
			return false;
		}

		IParameter<?> parameter;
		try {
			Optional<IParameter<?>> optParameter = channel.getSoundModifier().getParameters().get(args[1]);
			if (!optParameter.isPresent()) {
				send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__MODIFY__PARAMETER_NOT_FOUND, args[1], channel.getName());
				return false;
			}

			parameter = optParameter.get();
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__MODIFY__PARAMETER_NAME_IS_MISSING, channel.getName());
			return false;
		}

		parameterTree.setParameter(parameter);
		return super.onCommand(extract(args, 2));
	}
}
