package fr.pederobien.mumble.commandline.server.impl;

public class CloseServerNode extends MumbleServerNode {
	private MumbleServerCommandTree tree;

	/**
	 * Creates a node to close a mumble server.
	 * 
	 * @param server The server associated to this node.
	 */
	protected CloseServerNode(MumbleServerCommandTree tree) {
		super(() -> tree.getServer(), "close", EMumbleServerCode.MUMBLE_SERVER_CL__CLOSE__EXPLANATION, s -> s != null);
		this.tree = tree;
	}

	@Override
	public boolean onCommand(String[] args) {
		String name = tree.getServer().getName();
		tree.getServer().close();
		tree.setServer(null);
		send(EMumbleServerCode.MUMBLE_SERVER_CL__CLOSE__SERVER_CLOSED, name);
		return true;
	}
}
