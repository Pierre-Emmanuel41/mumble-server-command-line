package fr.pederobien.mumble.commandline.server.impl;

import java.util.function.Supplier;

import fr.pederobien.mumble.server.interfaces.IMumbleServer;

public class ChannelNode extends MumbleServerNode {

	/**
	 * Creates a node that adds or removes channel from a mumble server or adds/removes players from a channel.
	 * 
	 * @param server The server associated to this node.
	 */
	protected ChannelNode(Supplier<IMumbleServer> server) {
		super(server, "channel", EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__EXPLANATION, s -> s != null);
	}
}
