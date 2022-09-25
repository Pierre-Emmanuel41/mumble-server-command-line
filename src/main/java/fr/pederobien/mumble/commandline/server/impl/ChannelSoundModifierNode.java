package fr.pederobien.mumble.commandline.server.impl;

import java.util.function.Supplier;

import fr.pederobien.mumble.server.interfaces.IMumbleServer;

public class ChannelSoundModifierNode extends MumbleServerNode {
	private ChannelSoundModifierDetailsNode detailsNode;

	/**
	 * Creates a node in order to modify the sound modifier of a channel or the parameters of a sound modifier.
	 * 
	 * @param server The server associated to this node.
	 */
	protected ChannelSoundModifierNode(Supplier<IMumbleServer> server) {
		super(server, "soundModifier", EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__SOUNDMODIFIER__EXPLANATION, s -> s != null);

		add(detailsNode = new ChannelSoundModifierDetailsNode(server));
	}

	/**
	 * @return The node that display the characteristics of the sound modifier of a channel.
	 */
	public ChannelSoundModifierDetailsNode getDetailsNode() {
		return detailsNode;
	}
}
