package fr.pederobien.mumble.commandline.server;

import fr.pederobien.commandline.CommandLine;
import fr.pederobien.commandline.CommandLine.CommandLineBuilder;
import fr.pederobien.commandtree.events.NodeEvent;
import fr.pederobien.communication.event.ConnectionEvent;
import fr.pederobien.dictionary.event.DictionaryEvent;
import fr.pederobien.mumble.commandline.server.impl.EMumbleServerCode;
import fr.pederobien.mumble.commandline.server.impl.MumbleServerCommandTree;
import fr.pederobien.utils.event.EventLogger;
import fr.pederobien.vocal.server.event.VocalPlayerSpeakEvent;

public class MumbleServerCommandLine {
	private static final String DEV_DICTIONARY_FOLDER = "src/main/resources/dictionaries/";
	private static final String PROD_DICTIONARY_FOLDER = "resources/dictionaries/mumble/server/";

	private static MumbleServerCommandTree tree;
	private static CommandLine commandLine;

	public static void main(String[] args) {
		tree = new MumbleServerCommandTree();

		CommandLineBuilder builder = new CommandLineBuilder(root -> {
			EventLogger.instance().newLine(true).timeStamp(true).register();

			EventLogger.instance().ignore(DictionaryEvent.class);
			EventLogger.instance().ignore(ConnectionEvent.class);
			EventLogger.instance().ignore(NodeEvent.class);
			EventLogger.instance().ignore(VocalPlayerSpeakEvent.class);

			String dictionaryFolder = commandLine.getEnvironment() == CommandLine.DEVELOPMENT_ENVIRONMENT ? DEV_DICTIONARY_FOLDER : PROD_DICTIONARY_FOLDER;
			commandLine.registerDictionaries(dictionaryFolder, new String[] { "English.xml", "French.xml" });
			return true;
		});

		builder.onStart((root, arguments) -> {
			commandLine.send(EMumbleServerCode.MUMBLE_SERVER_CL__STARTING);
			if (arguments.length == 0)
				return true;

			if (arguments.length < 4) {
				commandLine.send(EMumbleServerCode.MUMBLE_SERVER_CL__STARTING__IGNORING_ARGUMENTS__NOT_ENOUGH_ARGUMENT);
				return true;
			}

			String[] commands = new String[arguments.length + 1];
			commands[0] = "open";
			for (int i = 0; i < arguments.length; i++)
				commands[i + 1] = arguments[i];

			root.onCommand(commands);
			return true;
		});

		builder.onStop(root -> {
			if (tree.getServer() != null)
				tree.getServer().close();
			commandLine.send(EMumbleServerCode.MUMBLE_SERVER_CL__STOPPING);
		});

		commandLine = builder.build(tree.getRoot(), args);
		commandLine.start();
	}
}
