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

	// Code for the parameter value completion
	MUMBLE_SERVER_CL__VALUE__COMPLETION,

	// Code for the parameter minimum value completion
	MUMBLE_SERVER_CL__MIN_VALUE__COMPLETION,

	// Code for the parameter maximum value completion
	MUMBLE_SERVER_CL__MAX_VALUE__COMPLETION,

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

	// Code for the "channel add player" command --------------------------------------------------
	MUMBLE_SERVER_CL__CHANNEL__ADD__PLAYER__EXPLANATION,

	// Code when the channel name is missing
	MUMBLE_SERVER_CL__CHANNEL__ADD__PLAYER__CHANNEL_NAME_IS_MISSING,

	// Code when the channel does not exist
	MUMBLE_SERVER_CL__CHANNEL__ADD__PLAYER__CHANNEL_NOT_FOUND,

	// Code when the player does not exist
	MUMBLE_SERVER_CL__CHANNEL__ADD__PLAYER__PLAYER_NOT_FOUND,

	// Code when the player is already registered in a channel
	MUMBLE_SERVER_CL__CHANNEL__ADD__PLAYER__PLAYER_ALREADY_REGISTERED,

	// Code when the player has not joined the mumble server
	MUMBLE_SERVER_CL__CHANNEL__ADD__PLAYER__PLAYER_NOT_JOINED,

	// Code when no player has been added to a channel
	MUMBLE_SERVER_CL__CHANNEL__ADD__PLAYER__NO_PLAYER_ADDED,

	// Code when one player has been added to a channel
	MUMBLE_SERVER_CL__CHANNEL__ADD__PLAYER__ONE_PLAYER_ADDED,

	// Code when several players have been added to a channel
	MUMBLE_SERVER_CL__CHANNEL__ADD__PLAYER__SEVERAL_PLAYERS_ADDED,

	// Code for the "channel remove" command ------------------------------------------------------
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__EXPLANATION,

	// Code for the "channel remove channel" command ----------------------------------------------
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__CHANNEL__EXPLANATION,

	// Code when the channel to remove does not exist
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__CHANNEL__CHANNEL_NOT_FOUND,

	// Code when no channel has been removed
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__CHANNEL__NO_CHANNEL_REMOVED,

	// Code when one channel has been removed
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__CHANNEL__ONE_CHANNEL_REMOVED,

	// Code when several channels have been removed
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__CHANNEL__SEVERAL_CHANNELS_REMOVED,

	// Code for the "channel remove player" command --------------------------------------------------
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__EXPLANATION,

	// Code when the channel name is missing
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__CHANNEL_NAME_IS_MISSING,

	// Code when the channel does not exist
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__CHANNEL_NOT_FOUND,

	// Code when the player does not exist
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__PLAYER_NOT_FOUND,

	// Code when no player has been removed to a channel
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__NO_PLAYER_REMOVED,

	// Code when one player has been removed to a channel
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__ONE_PLAYER_REMOVED,

	// Code when several players have been removed to a channel
	MUMBLE_SERVER_CL__CHANNEL__REMOVE__PLAYER__SEVERAL_PLAYERS_REMOVED,

	// Code for the "channel rename" command ------------------------------------------------------
	MUMBLE_SERVER_CL__CHANNEL__RENAME__EXPLANATION,

	// Code when the name of the channel to rename is missing
	MUMBLE_SERVER_CL__CHANNEL__RENAME__NAME_IS_MISSING,

	// Code when the channel to rename does not exist
	MUMBLE_SERVER_CL__CHANNEL__RENAME__CHANNEL_NOT_FOUND,

	// Code when the channel to rename does not exist
	MUMBLE_SERVER_CL__CHANNEL__RENAME__NEW_NAME_IS_MISSING,

	// Code when a channel is already registered
	MUMBLE_SERVER_CL__CHANNEL__RENAME__CHANNEL_ALREADY_REGISTERED,

	// Code when a channel has been renamed
	MUMBLE_SERVER_CL__CHANNEL__RENAME__CHANNEL_RENAMED,

	// Code for the "channel soundModifier" command -----------------------------------------------
	MUMBLE_SERVER_CL__CHANNEL__SOUNDMODIFIER__EXPLANATION,

	// Code for the "channel soundModifier details" command ---------------------------------------
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__DETAILS__EXPLANATION,

	// Code the name of the channel is missing
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__DETAILS__CHANNEL_NAME_IS_MISSING,

	// Code when the channel does not exist
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__DETAILS__CHANNEL_NOT_FOUND,

	// Code to display the name of the sound modifier
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__DETAILS__SOUND_MODIFIER_NAME,

	// Code to display the parameters of a sound modifier
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__DETAILS__SOUND_MODIFIER_PARAMETERS,

	// Code to display the name of a parameter
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__DETAILS__PARAMETER_NAME,

	// Code to display the value of a parameter
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__DETAILS__PARAMETER_VALUE,

	// Code to display the default value of a parameter
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__DETAILS__PARAMETER_DEFAULT_VALUE,

	// Code to display the minimum value of a parameter
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__DETAILS__PARAMETER_MINIMUM_VALUE,

	// Code to display the maximum value of a parameter
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__DETAILS__PARAMETER_MAXIMUM_VALUE,

	// Code to display the details of a sound modifier associated to a channel
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__DETAILS__SOUND_MODIFIER_DETAILS,

	// Code for the "channel soundModifier set" command -------------------------------------------
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__SET__EXPLANATION,

	// Code when the channel name is missing
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__SET__CHANNEL_NAME_IS_MISSING,

	// Code when the channel does not exist
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__SET__CHANNEL_NOT_FOUND,

	// Code when the sound modifier name is missing
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__SET__SOUND_MODIFIER_NAME_IS_MISSING,

	// Code when the sound modifier does not exist
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__SET__SOUND_MODIFIER_NOT_FOUND,

	// Code when the sound modifier has been set
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__SET__SOUND_MODIFIER_SET,

	// Code for the "channel soundModifier modify" command ----------------------------------------
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__MODIFY__EXPLANATION,

	// Code when the name of the channel is missing
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__MODIFY__CHANNEL_NAME_IS_MISSING,

	// Code when the channel does not exist
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__MODIFY__CHANNEL_NOT_FOUND,

	// Code when the name of the parameter is missing
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__MODIFY__PARAMETER_NAME_IS_MISSING,

	// Code when the parameter does not exist
	MUMBLE_SERVER_CL__CHANNEL__SOUND_MODIFIER__MODIFY__PARAMETER_NOT_FOUND,

	// Code for the "parameter" command -----------------------------------------------------------
	MUMBLE_SERVER_CL__PARAMETER__ROOT__EXPLANATION,

	// Code for the "parameter value" command -----------------------------------------------------
	MUMBLE_SERVER_CL__PARAMETER__VALUE__EXPLANATION,

	// Code when the value is missing
	MUMBLE_SERVER_CL__PARAMETER__VALUE__VALUE_IS_MISSING,

	// Code when the value has a bad format
	MUMBLE_SERVER_CL__PARAMETER__VALUE__VALUE_BAD_FORMAT,

	// Code when the value is out of range
	MUMBLE_SERVER_CL__PARAMETER__VALUE__VALUE_OUT_OF_RANGE,

	// Code when the parameter has been set
	MUMBLE_SERVER_CL__PARAMETER__VALUE__VALUE_SET,

	// Code for the "parameter minValue" command -----------------------------------------------------
	MUMBLE_SERVER_CL__PARAMETER__MIN_VALUE__EXPLANATION,

	// Code when the minimum value is missing
	MUMBLE_SERVER_CL__PARAMETER__MIN_VALUE__VALUE_IS_MISSING,

	// Code when the minimum value has a bad format
	MUMBLE_SERVER_CL__PARAMETER__MIN_VALUE__VALUE_BAD_FORMAT,

	// Code when the minimum value is greater than the maximum value
	MUMBLE_SERVER_CL__PARAMETER__MIN_VALUE__VALUE_OUT_OF_RANGE,

	// Code when the minimum value has been set
	MUMBLE_SERVER_CL__PARAMETER__MIN_VALUE__VALUE_SET,

	// Code for the "parameter maxValue" command -----------------------------------------------------
	MUMBLE_SERVER_CL__PARAMETER__MAX_VALUE__EXPLANATION,

	// Code when the maximum value is missing
	MUMBLE_SERVER_CL__PARAMETER__MAX_VALUE__VALUE_IS_MISSING,

	// Code when the maximum value has a bad format
	MUMBLE_SERVER_CL__PARAMETER__MAX_VALUE__VALUE_BAD_FORMAT,

	// Code when the maximum value is less than the minimum value
	MUMBLE_SERVER_CL__PARAMETER__MAX_VALUE__VALUE_OUT_OF_RANGE,

	// Code when the maximum value has been set
	MUMBLE_SERVER_CL__PARAMETER__MAX_VALUE__VALUE_SET,

	// Code for the "mumble details" command ------------------------------------------------------
	MUMBLE_SERVER_CL__DETAILS__EXPLANATION,

	// Code for the server name
	MUMBLE_SERVER_CL__DETAILS__SERVER_NAME,

	// Code for the details of sound modifiers
	MUMBLE_SERVER_CL__DETAILS__SOUND_MODIFIERS,

	// Code for the sound modifier's name
	MUMBLE_SERVER_CL__DETAILS__SOUND_MODIFIER_NAME,

	// Code for the details of a sound modifier's parameters
	MUMBLE_SERVER_CL__DETAILS__SOUND_MODIFIER_PARAMETERS,

	// Code for the parameter's name
	MUMBLE_SERVER_CL__DETAILS__PARAMETER_NAME,

	// Code for the parameter's value
	MUMBLE_SERVER_CL__DETAILS__PARAMETER_VALUE,

	// Code for the parameter's default value
	MUMBLE_SERVER_CL__DETAILS__PARAMETER_DEFAULT_VALUE,

	// Code for the parameter's minimum value
	MUMBLE_SERVER_CL__DETAILS__PARAMETER_MINIMUM_VALUE,

	// Code for the parameter's maximum value
	MUMBLE_SERVER_CL__DETAILS__PARAMETER_MAXIMUM_VALUE,

	// Code for the details of players
	MUMBLE_SERVER_CL__DETAILS__PLAYERS,

	// Code for the player's name
	MUMBLE_SERVER_CL__DETAILS__PLAYER_NAME,

	// Code for the player's identifier
	MUMBLE_SERVER_CL__DETAILS__PLAYER_IDENTIFIER,

	// Code for the player's online status
	MUMBLE_SERVER_CL__DETAILS__PLAYER_ONLINE_STATUS,

	// Code when the player is not connected in game
	MUMBLE_SERVER_CL__DETAILS__PLAYER_OFFLINE,

	// Code when the player is connected in game
	MUMBLE_SERVER_CL__DETAILS__PLAYER_ONLINE,

	// Code for the player's game address
	MUMBLE_SERVER_CL__DETAILS__PLAYER_GAME_ADDRESS,

	// Code for the player's administrator status
	MUMBLE_SERVER_CL__DETAILS__PLAYER_ADMIN_STATUS,

	// Code when the player is an administrator
	MUMBLE_SERVER_CL__DETAILS__PLAYER_ADMIN,

	// Code when the player is not an administrator
	MUMBLE_SERVER_CL__DETAILS__PLAYER_NOT_ADMIN,

	// Code for the player's mute status
	MUMBLE_SERVER_CL__DETAILS__PLAYER_MUTE_STATUS,

	// Code when the player is mute
	MUMBLE_SERVER_CL__DETAILS__PLAYER_MUTE,

	// Code when the player is not mute
	MUMBLE_SERVER_CL__DETAILS__PLAYER_NOT_MUTE,

	// Code for the player's mute by status
	MUMBLE_SERVER_CL__DETAILS__PLAYER_MUTE_BY,

	// Code for the player's deafen status
	MUMBLE_SERVER_CL__DETAILS__PLAYER_DEAFEN_STATUS,

	// Code when the player is deafen
	MUMBLE_SERVER_CL__DETAILS__PLAYER_DEAFEN,

	// Code when the player is not deafen
	MUMBLE_SERVER_CL__DETAILS__PLAYER_NOT_DEAFEN,

	// Code for the player's position
	MUMBLE_SERVER_CL__DETAILS__PLAYER_POSITION,

	// Code for the details of channels
	MUMBLE_SERVER_CL__DETAILS__CHANNELS,

	// Code for the channel's name
	MUMBLE_SERVER_CL__DETAILS__CHANNEL_NAME,

	// Code for the details of the channel's sound modifier
	MUMBLE_SERVER_CL__DETAILS__CHANNEL_SOUND_MODIFIER,

	// Code for the server configuration
	MUMBLE_SERVER_CL__DETAILS__SERVER,

	;

	@Override
	public String getCode() {
		return name();
	}
}
