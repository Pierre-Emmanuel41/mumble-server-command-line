package fr.pederobien.mumble.commandline.server.impl;

import java.util.List;
import java.util.function.Predicate;

import fr.pederobien.mumble.server.exceptions.MumbleServerTypeDismatchException;
import fr.pederobien.mumble.server.impl.SimpleMumbleServer;
import fr.pederobien.mumble.server.impl.StandaloneMumbleServer;
import fr.pederobien.mumble.server.interfaces.IMumbleServer;

public class OpenServerNode extends MumbleServerNode {
	private static final String SIMPLE = "simple";
	private static final String STANDALONE = "standalone";

	private MumbleServerCommandTree tree;

	/**
	 * Creates a server in order to open a simple mumble server or a stand-alone mumble server.
	 * 
	 * @param tree The command tree associated to this node.
	 */
	protected OpenServerNode(MumbleServerCommandTree tree) {
		super(() -> tree.getServer(), "open", EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__EXPLANATION, s -> true);
		this.tree = tree;
	}

	@Override
	public List<String> onTabComplete(String[] args) {
		switch (args.length) {
		case 1:
			return asList(getMessage(EMumbleServerCode.MUMBLE_SERVER_CL__NAME__COMPLETION));
		case 2:
			Predicate<String> isNameValid = name -> !name.equals("");
			return check(args[0], isNameValid, asList(SIMPLE, STANDALONE));
		case 3:
			Predicate<String> isTypeValid = type -> type.equals(SIMPLE) || type.equals(STANDALONE);
			return check(args[1], isTypeValid, asList(getMessage(EMumbleServerCode.MUMBLE_SERVER_CL__CONFIGURATION_PORT__COMPLETION)));
		case 4:
			Predicate<String> isConfigurationPortValid = configurationPort -> {
				try {
					getInt(configurationPort);
					return true;
				} catch (NumberFormatException e) {
					return false;
				}
			};
			return check(args[2], isConfigurationPortValid, asList(getMessage(EMumbleServerCode.MUMBLE_SERVER_CL__VOCAL_PORT__COMPLETION)));
		case 5:
			if (args[1].equals(SIMPLE))
				return emptyList();
			int configurationPort = getInt(args[3]);
			Predicate<String> isVocalPortValid = vocalPort -> {
				try {
					return configurationPort != getInt(vocalPort);
				} catch (NumberFormatException e) {
					return false;
				}
			};
			return check(args[3], isVocalPortValid, asList(getMessage(EMumbleServerCode.MUMBLE_SERVER_CL__GAME_PORT__COMPLETION)));
		default:
			return emptyList();
		}
	}

	@Override
	public boolean onCommand(String[] args) {
		String name;
		try {
			name = args[0];
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__NAME_IS_MISSING);
			return false;
		}

		String type;
		try {
			if (!args[1].equals(SIMPLE) && !args[1].equals(STANDALONE)) {
				send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__TYPE_NOT_FOUND, name);
				return false;
			}
			type = args[1];
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__TYPE_IS_MISSING, name);
			return false;
		}

		int configurationPort;
		try {
			configurationPort = getInt(args[2]);
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__CONFIGURATION_PORT_IS_MISSING, name);
			return false;
		} catch (NumberFormatException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__CONFIGURATION_PORT_BAD_FORMAT, name);
			return false;
		}

		int vocalPort;
		try {
			vocalPort = getInt(args[3]);
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__VOCAL_PORT_IS_MISSING, name);
			return false;
		} catch (NumberFormatException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__VOCAL_PORT_BAD_FORMAT, name);
			return false;
		}

		if (vocalPort == configurationPort) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__VOCAL_PORT_ALREADY_USED, name);
			return false;
		}

		if (type.equals(SIMPLE)) {
			if (tree.getServer() != null)
				tree.getServer().close();

			try {
				IMumbleServer server = new SimpleMumbleServer(name, configurationPort, vocalPort, ".");
				server.open();
				tree.setServer(server);
				send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__SIMPLE_SERVER_OPENED, name, configurationPort, vocalPort);
				return true;
			} catch (MumbleServerTypeDismatchException e) {
				send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__SERVER_TYPE_DISMATCH, name, e.getExpected(), e.getActual());
				return false;
			}
		}

		int gamePort;
		try {
			gamePort = getInt(args[4]);
		} catch (IndexOutOfBoundsException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__GAME_PORT_IS_MISSING, name);
			return false;
		} catch (NumberFormatException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__GAME_PORT_BAD_FORMAT, name);
			return false;
		}

		if (gamePort == configurationPort || gamePort == vocalPort) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__GAME_PORT_ALREADY_USED, name);
			return false;
		}

		try {
			IMumbleServer server = new StandaloneMumbleServer(name, configurationPort, vocalPort, gamePort, ".");
			server.open();
			tree.setServer(server);
			send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__STANDALONE_SERVER_OPENED, name, configurationPort, vocalPort, gamePort);
			return true;
		} catch (MumbleServerTypeDismatchException e) {
			send(EMumbleServerCode.MUMBLE_SERVER_CL__OPEN__SERVER_TYPE_DISMATCH, name, e.getExpected(), e.getActual());
			return false;
		}
	}
}
