package fr.pederobien.mumble.commandline.server.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

import fr.pederobien.mumble.server.interfaces.IChannel;
import fr.pederobien.mumble.server.interfaces.IMumbleServer;
import fr.pederobien.mumble.server.interfaces.IPlayer;

public class ChannelRemovePlayerNode extends MumbleServerNode {

	/**
	 * Creates a node in order to remove players from a channel.
	 * 
	 * @param server The server associated to this node.
	 */
	protected ChannelRemovePlayerNode(Supplier<IMumbleServer> server) {
		super(server, "player", EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__EXPLANATION, s -> s != null);
	}

	@Override
	public List<String> onTabComplete(String[] args) {
		switch (args.length) {
		case 1:
			return filter(getServer().getChannels().stream().map(channel -> channel.getName()), args);
		case 2:
			Predicate<String> isChannelValid = name -> getServer().getChannels().get(name).isPresent();
			Predicate<String> filter = name -> !asList(extract(args, 1)).contains(name);
			return filter(check(args[0], isChannelValid, getServer().getPlayers().stream().map(player -> player.getName()).filter(filter)), args);
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
				send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__CHANNEL_NOT_FOUND, args[0]);
				return false;
			}

			channel = optChannel.get();
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__CHANNEL_NAME_IS_MISSING);
			return false;
		}

		List<IPlayer> players = emptyList();
		for (String name : extract(args, 1)) {
			Optional<IPlayer> optPlayer = getServer().getPlayers().get(name);
			if (!optPlayer.isPresent()) {
				send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__PLAYER_NOT_FOUND, name, channel.getName());
				return false;
			}

			players.remove(optPlayer.get());
		}

		String playerNames = concat(extract(args, 1), ", ");
		for (IPlayer player : players)
			channel.getPlayers().remove(player);

		switch (players.size()) {
		case 0:
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__NO_PLAYER_REMOVED, channel.getName());
			break;
		case 1:
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__ONE_PLAYER_REMOVED, playerNames, channel.getName());
			break;
		default:
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__SEVERAL_PLAYERS_REMOVED, playerNames, channel.getName());
		}
		return true;
	}
}
