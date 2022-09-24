package fr.pederobien.mumble.commandline.server.impl;

import java.util.function.Supplier;

import fr.pederobien.mumble.server.interfaces.IMumbleServer;

public class ChannelAddNode extends MumbleServerNode {
	private ChannelAddChannelNode channelNode;

	/**
	 * Creates a node in order to add a channel to a mumble server or players to a channel.
	 * 
	 * @param server The server associated to this node.
	 */
	protected ChannelAddNode(Supplier<IMumbleServer> server) {
		super(server, "add", EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__ADD__EXPLANATION, s -> s != null);

		add(channelNode = new ChannelAddChannelNode(server));
	}

	/**
	 * @return The node that adds a channel to a mumble server.
	 */
	public ChannelAddChannelNode getChannelNode() {
		return channelNode;
	}
}
