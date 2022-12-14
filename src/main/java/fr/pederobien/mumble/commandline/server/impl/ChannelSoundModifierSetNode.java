package fr.pederobien.mumble.commandline.server.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

import fr.pederobien.mumble.server.impl.SoundManager;
import fr.pederobien.mumble.server.interfaces.IChannel;
import fr.pederobien.mumble.server.interfaces.IMumbleServer;
import fr.pederobien.mumble.server.interfaces.ISoundModifier;

public class ChannelSoundModifierSetNode extends MumbleServerNode {

	/**
	 * Creates a node in order to set the sound modifier of a channel.
	 * 
	 * @param server The server associated to this node.
	 */
	protected ChannelSoundModifierSetNode(Supplier<IMumbleServer> server) {
		super(server, "set", EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__SET__EXPLANATION, s -> s != null);
	}

	@Override
	public List<String> onTabComplete(String[] args) {
		switch (args.length) {
		case 1:
			return filter(getServer().getChannels().stream().map(channel -> channel.getName()), args);
		case 2:
			Predicate<String> nameValid = name -> getServer().getChannels().get(name).isPresent();
			return filter(check(args[0], nameValid, SoundManager.toStream().map(modifier -> modifier.getName())), args);
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
				send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__SET__CHANNEL_NOT_FOUND, args[0]);
				return false;
			}

			channel = optChannel.get();
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__SET__CHANNEL_NAME_IS_MISSING);
			return false;
		}

		ISoundModifier soundModifier;
		try {
			Optional<ISoundModifier> optSoundModifier = SoundManager.getByName(args[1]);
			if (!optSoundModifier.isPresent()) {
				send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__SET__SOUND_MODIFIER_NOT_FOUND, args[1], channel.getName());
				return false;
			}

			soundModifier = optSoundModifier.get();
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__SET__SOUND_MODIFIER_NAME_IS_MISSING, channel.getName());
			return false;
		}

		channel.setSoundModifier(soundModifier);
		send(EMumbleServerCode.MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__SET__SOUND_MODIFIER_SET, channel.getName(), soundModifier.getName());
		return true;
	}
}
