package fr.pederobien.mumble.commandline.server.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

import fr.pederobien.mumble.server.interfaces.IChannel;
import fr.pederobien.mumble.server.interfaces.IMumbleServer;

public class ChannelRemoveChannelNode extends MumbleServerNode {

	/**
	 * Creates a node in order to remove channels from a mumble server.
	 * 
	 * @param server The server associated to this node.
	 */
	protected ChannelRemoveChannelNode(Supplier<IMumbleServer> server) {
		super(server, "channel", EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__CHANNEL__EXPLANATION, s -> s != null);
	}

	@Override
	public List<String> onTabComplete(String[] args) {
		Predicate<String> filter = name -> !asList(args).contains(name);
		return filter(getServer().getChannels().stream().map(channel -> channel.getName()).filter(filter), args);
	}

	@Override
	public boolean onCommand(String[] args) {
		List<IChannel> channels = emptyList();
		for (String name : args) {
			Optional<IChannel> optChannel = getServer().getChannels().get(name);
			if (!optChannel.isPresent()) {
				send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__CHANNEL__CHANNEL_NOT_FOUND, name, getServer().getName());
				return false;
			}

			channels.add(optChannel.get());
		}

		String channelNames = concat(args, ", ");
		for (IChannel channel : channels)
			getServer().getChannels().remove(channel);

		switch (channels.size()) {
		case 0:
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__CHANNEL__NO_CHANNEL_REMOVED, getServer().getName());
			break;
		case 1:
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__CHANNEL__ONE_CHANNEL_REMOVED, channelNames, getServer().getName());
			break;
		default:
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__CHANNEL__SEVERAL_CHANNELS_REMOVED, channelNames, getServer().getName());
		}
		return true;
	}
}
