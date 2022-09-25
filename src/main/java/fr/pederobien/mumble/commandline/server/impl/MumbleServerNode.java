package fr.pederobien.mumble.commandline.server.impl;

import java.util.function.Function;
import java.util.function.Supplier;

import fr.pederobien.commandline.CommandLineNode;
import fr.pederobien.commandline.ICode;
import fr.pederobien.mumble.server.interfaces.IMumbleServer;

public class MumbleServerNode extends CommandLineNode {
	private Supplier<IMumbleServer> server;

	/**
	 * Creates a node specified by the given parameters.
	 * 
	 * @param server      The server associated to this node.
	 * @param label       The primary node name.
	 * @param explanation The explanation associated to this node.
	 * @param isAvailable True if this node is available, false otherwise.
	 */
	protected MumbleServerNode(Supplier<IMumbleServer> server, String label, ICode explanation, Function<IMumbleServer, Boolean> isAvailable) {
		super(label, explanation, () -> isAvailable.apply(server == null ? null : server.get()));
		this.server = server;
	}

	/**
	 * @return The server associated to this node.
	 */
	public IMumbleServer getServer() {
		return server == null ? null : server.get();
	}
}
