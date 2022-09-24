package fr.pederobien.mumble.commandline.server.impl;

import java.util.function.Supplier;

import fr.pederobien.mumble.server.interfaces.IMumbleServer;

public class ChannelRemoveNode extends MumbleServerNode {

	/**
	 * Creates a node in order to remove channels from a mumble server or players from a channel.
	 * 
	 * @param server The server associated to this node.
	 */
	protected ChannelRemoveNode(Supplier<IMumbleServer> server) {
		super(server, "remove", EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__EXPLANATION, s -> s != null);
	}
}
