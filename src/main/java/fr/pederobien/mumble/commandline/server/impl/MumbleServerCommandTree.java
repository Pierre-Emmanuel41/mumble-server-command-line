package fr.pederobien.mumble.commandline.server.impl;

import java.util.Locale;
import java.util.function.Consumer;

import fr.pederobien.commandline.impl.CommandLineDictionaryContext;
import fr.pederobien.commandtree.impl.CommandRootNode;
import fr.pederobien.commandtree.interfaces.ICommandRootNode;
import fr.pederobien.commandtree.interfaces.INode;
import fr.pederobien.dictionary.impl.MessageEvent;
import fr.pederobien.dictionary.interfaces.ICode;
import fr.pederobien.mumble.server.interfaces.IMumbleServer;
import fr.pederobien.utils.AsyncConsole;

public class MumbleServerCommandTree {
	private IMumbleServer server;
	private ICommandRootNode<ICode> root;
	private OpenServerNode openNode;
	private CloseServerNode closeNode;
	private ChannelNode channelNode;
	private DetailsNode detailsNode;

	public MumbleServerCommandTree() {
		Consumer<INode<ICode>> displayer = node -> {
			String label = node.getLabel();
			String explanation = CommandLineDictionaryContext.instance().getMessage(new MessageEvent(Locale.getDefault(), node.getExplanation()));
			AsyncConsole.println(String.format("%s - %s", label, explanation));
		};

		root = new CommandRootNode<ICode>("vocal", EMumbleServerCode.MUMBLE_SERVER_CL__ROOT__EXPLANATION, () -> true, displayer);
		root.add(openNode = new OpenServerNode(this));
		root.add(closeNode = new CloseServerNode(this));
		root.add(channelNode = new ChannelNode(() -> getServer()));
		root.add(detailsNode = new DetailsNode(() -> getServer()));
	}

	/**
	 * @return The underlying mumble server managed by this command tree.
	 */
	public IMumbleServer getServer() {
		return server;
	}

	/**
	 * Set the underlying mumble server managed by this command tree.
	 * 
	 * @param server The new mumble server managed by this command tree.
	 */
	public void setServer(IMumbleServer server) {
		this.server = server;
	}

	/**
	 * @return The root of this command tree.
	 */
	public ICommandRootNode<ICode> getRoot() {
		return root;
	}

	/**
	 * @return The node that opens a mumble server.
	 */
	public OpenServerNode getOpenNode() {
		return openNode;
	}

	/**
	 * @return The node that closes a mumble server.
	 */
	public CloseServerNode getCloseNode() {
		return closeNode;
	}

	/**
	 * @return The node that adds or removes channel from a mumble server or adds/removes players from a channel.
	 */
	public ChannelNode getChannelNode() {
		return channelNode;
	}

	/**
	 * @return The node that displays the configuration of the mumble server
	 */
	public DetailsNode getDetailsNode() {
		return detailsNode;
	}
}
