package fr.pederobien.mumble.commandline.server.impl;

import fr.pederobien.commandline.ICode;

public enum EMumbleServerCode implements ICode {

	// Starting application -----------------------------------------------------------------------
	MUMBLE_SERVER_CL__STARTING,

	// Code when the arguments are ignored
	MUMBLE_SERVER_CL__STARTING__IGNORING_ARGUMENTS__NOT_ENOUGH_ARGUMENT,

	// Stopping application -----------------------------------------------------------------------
	MUMBLE_SERVER_CL__STOPPING,

	// Code for the name completion
	MUMBLE_SERVER_CL__NAME__COMPLETION,

	// Code for the configuration port number completion
	MUMBLE_SERVER_CL__CONFIGURATION_PORT__COMPLETION,

	// Code for the vocal port number completion
	MUMBLE_SERVER_CL__VOCAL_PORT__COMPLETION,

	// Code for the game port number completion
	MUMBLE_SERVER_CL__GAME_PORT__COMPLETION,

	// Code for the "mumble" command --------------------------------------------------------------
	MUMBLE_SERVER_CL__ROOT__EXPLANATION,

	// Code for the "open" command ----------------------------------------------------------------
	MUMBLE_SERVER_CL__OPEN__EXPLANATION,

	// Code when the server name is missing
	MUMBLE_SERVER_CL__OPEN__NAME_IS_MISSING,

	// Code when the server type is missing
	MUMBLE_SERVER_CL__OPEN__TYPE_IS_MISSING,

	// Code when the server type does not exist
	MUMBLE_SERVER_CL__OPEN__TYPE_NOT_FOUND,

	// Code when the configuration port number is missing
	MUMBLE_SERVER_CL__OPEN__CONFIGURATION_PORT_IS_MISSING,

	// Code when the configuration port number has a bad format
	MUMBLE_SERVER_CL__OPEN__CONFIGURATION_PORT_BAD_FORMAT,

	// Code when the vocal port number is missing
	MUMBLE_SERVER_CL__OPEN__VOCAL_PORT_IS_MISSING,

	// Code when the vocal port number has a bad format
	MUMBLE_SERVER_CL__OPEN__VOCAL_PORT_BAD_FORMAT,

	// Code when the vocal port equals the configuration port
	MUMBLE_SERVER_CL__OPEN__VOCAL_PORT_ALREADY_USED,

	// Code when the vocal port equals the configuration port
	MUMBLE_SERVER_CL__OPEN__SERVER_TYPE_DISMATCH,

	// Code when the vocal port equals the configuration port
	MUMBLE_SERVER_CL__OPEN__SIMPLE_SERVER_OPENED,

	// Code when the game port number is missing
	MUMBLE_SERVER_CL__OPEN__GAME_PORT_IS_MISSING,

	// Code when the game port number has a bad format
	MUMBLE_SERVER_CL__OPEN__GAME_PORT_BAD_FORMAT,

	// Code when the game port equals the configuration port or the vocal port
	MUMBLE_SERVER_CL__OPEN__GAME_PORT_ALREADY_USED,

	// Code when the vocal port equals the configuration port
	MUMBLE_SERVER_CL__OPEN__STANDALONE_SERVER_OPENED,

	// Code for the "close" command ---------------------------------------------------------------
	MUMBLE_SERVER_CL__CLOSE__EXPLANATION,

	// Code when the server has been closed
	MUMBLE_SERVER_CL__CLOSE__SERVER_CLOSED,

	// Code for the "channel" command -------------------------------------------------------------
	MUMBLE_SERVER_CL__CHANNEL__EXPLANATION,

	// Code for the "channel add" command ---------------------------------------------------------
	MUMBLE_SERVER_CL__CHANNEL__ADD__EXPLANATION,

	// Code for the "channel add channel" command -------------------------------------------------
	MUMBLE_SERVER_CL__CHANNEL__ADD__CHANNEL__EXPLANATION,

	// Code when the name of the channel to add is missing
	MUMBLE_SERVER_CL__CHANNEL__ADD__CHANNEL__NAME_IS_MISSING,

	// Code when the channel name is already registered
	MUMBLE_SERVER_CL__CHANNEL__ADD__CHANNEL__CHANNEL_ALREADY_REGISTERED,

	// Code when the sound modifier of the channel to add is missing
	MUMBLE_SERVER_CL__CHANNEL__ADD__CHANNEL__SOUND_MODIFIER_IS_MISSING,

	// Code when the sound modifier does not exist
	MUMBLE_SERVER_CL__CHANNEL__ADD__CHANNEL__SOUND_MODIFIER_NOT_FOUND,

	// Code when a channel has been added to a mumble server
	MUMBLE_SERVER_CL__CHANNEL__ADD__CHANNEL__CHANNEL_ADDED,

	;

	@Override
	public String getCode() {
		return name();
	}
}
