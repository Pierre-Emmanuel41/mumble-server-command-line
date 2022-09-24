package fr.pederobien.mumble.commandline.server.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

import fr.pederobien.mumble.server.interfaces.IChannel;
import fr.pederobien.mumble.server.interfaces.IMumbleServer;

public class ChannelRenameNode extends MumbleServerNode {

	/**
	 * Creates a node in order to rename a channel.
	 * 
	 * @param server The server associated to this node.
	 */
	protected ChannelRenameNode(Supplier<IMumbleServer> server) {
		super(server, "rename", EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__RENAME__EXPLANATION, s -> s != null);
	}

	@Override
	public List<String> onTabComplete(String[] args) {
		switch (args.length) {
		case 1:
			return filter(getServer().getChannels().stream().map(channel -> channel.getName()), args);
		case 2:
			Predicate<String> isNameValid = name -> getServer().getChannels().get(name).isPresent();
			return check(args[0], isNameValid, asList(getMessage(EMumbleServerCode.MUMBLE_SERVER_CL__NAME__COMPLETION)));
		default:
			return emptyList();
		}
	}

	@Override
	public boolean onCommand(String[] args) {
		IChannel channel;
		try {
			Optional<IChannel> optChannel = getServer().getChannels().get(args[0]);
			if (!optChannel.isPresent()) {
				send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__RENAME__CHANNEL_NOT_FOUND, args[0]);
				return false;
			}
			channel = optChannel.get();
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__RENAME__NAME_IS_MISSING);
			return false;
		}

		String name;
		try {
			Optional<IChannel> optChannel = getServer().getChannels().get(name = args[1]);
			if (optChannel.isPresent()) {
				send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__RENAME__CHANNEL_ALREADY_REGISTERED, channel.getName(), name);
				return false;
			}
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__RENAME__NEW_NAME_IS_MISSING, channel.getName());
			return false;
		}

		String oldName = channel.getName();
		channel.setName(name);
		send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__RENAME__CHANNEL_RENAMED, oldName, name);
		return true;
	}
}
