package protocolsupport.protocol.pipeline.version.v_beta;

import protocolsupport.api.utils.NetworkState;
import protocolsupport.protocol.ConnectionImpl;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middleimpl.clientbound.login.noop.NoopLoginSuccess;
import protocolsupport.protocol.packet.middleimpl.clientbound.login.noop.NoopSetCompression;
import protocolsupport.protocol.packet.middleimpl.clientbound.login.v_beta.LoginDisconnect;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopAdvancements;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopAdvanementsTab;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopBlockBreakAnimation;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopBlockOpenSignEditor;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopBossBar;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopCamera;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopCombatEvent;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopCraftRecipeConfirm;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopCustomPayload;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopDeclareCommands;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopDeclareRecipes;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopDeclareTags;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopEntityEffectAdd;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopEntityEffectRemove;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopEntityHeadRotation;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopEntityLeash;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopEntitySetAttributes;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopHeldSlot;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopLookAt;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopPlayerAbilities;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopPlayerListHeaderFooter;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopPlayerListSetEntry;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopResourcePack;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopScoreboardDisplay;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopScoreboardObjective;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopScoreboardScore;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopScoreboardTeam;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopServerDifficulty;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopSetCooldown;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopSetExperience;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopStatistics;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopStopSound;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopTabComplete;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopTitle;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopUnlockRecipes;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopVehicleMove;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopWorldBorder;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopWorldCustomSound;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopWorldParticle;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.noop.NoopWorldSound;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.BlockAction;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.BlockChangeMulti;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.BlockChangeSingle;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.ChangeDimension;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.Chat;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.Chunk;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.CollectEffect;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.EncryptionRequest;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.EntityAnimation;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.EntityDestroy;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.EntityEquipment;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.EntityLook;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.EntityMetadata;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.EntityStatus;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.EntityTeleport;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.EntityVelocity;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.GameStateChange;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.InventoryClose;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.InventoryConfirmTransaction;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.InventoryOpen;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.InventorySetItems;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.InventorySetSlot;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.KeepAlive;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.KickDisconnect;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.SetHealth;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.SetPosition;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.SpawnExpOrb;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.SpawnLiving;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.SpawnNamed;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.SpawnObject;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.SpawnPainting;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.SpawnPosition;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.StartGame;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.TimeUpdate;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.UnloadChunk;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.UseBed;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta.WorldEvent;
import protocolsupport.protocol.pipeline.version.util.encoder.AbstractLegacyPacketEncoder;
import protocolsupport.protocol.utils.registry.PacketIdTransformerRegistry;

public class PacketEncoder extends AbstractLegacyPacketEncoder {

	protected static final PacketIdTransformerRegistry packetIdRegistry = new PacketIdTransformerRegistry();
	static {
		packetIdRegistry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_DISCONNECT_ID, 0xFF);
		packetIdRegistry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_ENCRYPTION_BEGIN_ID, 0x02);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_KEEP_ALIVE_ID, 0x00);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_LOGIN_ID, 0x01);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CHAT_ID, 0x03);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UPDATE_TIME_ID, 0x04);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_EQUIPMENT_ID, 0x05);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_POSITION_ID, 0x06);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UPDATE_HEALTH_ID, 0x08);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_RESPAWN_ID, 0x09);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_POSITION_ID, 0x0D);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BED_ID, 0x11);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ANIMATION_ID, 0x12);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_NAMED_ID, 0x14);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.LEGACY_PLAY_SPAWN_ITEM, 0x15);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_COLLECT_EFFECT_ID, 0x16);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_OBJECT_ID, 0x17);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_LIVING_ID, 0x18);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_PAINTING_ID, 0x19);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_VELOCITY_ID, 0x1C);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_DESTROY_ID, 0x1D);
//		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_ID, 0x1E);
//		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_REL_MOVE_ID, 0x1F);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_LOOK_ID, 0x20);
//		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_REL_MOVE_LOOK_ID, 0x21);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_TELEPORT_ID, 0x22);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_STATUS_ID, 0x26);
//		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_LEASH_ID, 0x27);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_METADATA_ID, 0x28);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CHUNK_UNLOAD_ID, 0x32);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CHUNK_SINGLE_ID, 0x33);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_CHANGE_MULTI_ID, 0x34);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_CHANGE_SINGLE_ID, 0x35);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_ACTION_ID, 0x36);
//		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_EXPLOSION_ID, 0x3C);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_EVENT_ID, 0x3D);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_GAME_STATE_CHANGE_ID, 0x46);
//		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_WEATHER_ID, 0x47);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_OPEN_ID, 0x64);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_CLOSE_ID, 0x65);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_SET_SLOT_ID, 0x67);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_SET_ITEMS_ID, 0x68);
//		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_DATA_ID, 0x69);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_TRANSACTION_ID, 0x6A);
//		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.LEGACY_PLAY_UPDATE_SIGN_ID, 0x82);
//		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_MAP_ID, 0x83);
		packetIdRegistry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_KICK_DISCONNECT_ID, 0xFF);
	}

	@Override
	protected int getNewPacketId(NetworkState currentProtocol, int oldPacketId) {
		return packetIdRegistry.getNewPacketId(currentProtocol, oldPacketId);
	}

	{
		registry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_DISCONNECT_ID, LoginDisconnect::new);
		registry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_ENCRYPTION_BEGIN_ID, EncryptionRequest::new);
		registry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_SET_COMPRESSION_ID, NoopSetCompression::new);
		registry.register(NetworkState.LOGIN, ClientBoundPacket.LOGIN_SUCCESS_ID, NoopLoginSuccess::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_KEEP_ALIVE_ID, KeepAlive::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_LOGIN_ID, StartGame::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CHAT_ID, Chat::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UPDATE_TIME_ID, TimeUpdate::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_EQUIPMENT_ID, EntityEquipment::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_POSITION_ID, SpawnPosition::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UPDATE_HEALTH_ID, SetHealth::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_RESPAWN_ID, ChangeDimension::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_POSITION_ID, SetPosition::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BED_ID, UseBed::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ANIMATION_ID, EntityAnimation::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_NAMED_ID, SpawnNamed::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_COLLECT_EFFECT_ID, CollectEffect::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_OBJECT_ID, SpawnObject::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_LIVING_ID, SpawnLiving::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_PAINTING_ID, SpawnPainting::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_EXP_ORB_ID, SpawnExpOrb::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_VELOCITY_ID, EntityVelocity::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_DESTROY_ID, EntityDestroy::new);
//		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_ID, Entity::new);
//		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_REL_MOVE_ID, EntityRelMove::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_LOOK_ID, EntityLook::new);
//		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_REL_MOVE_LOOK_ID, EntityRelMoveLook::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_TELEPORT_ID, EntityTeleport::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_STATUS_ID, EntityStatus::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_METADATA_ID, EntityMetadata::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CHUNK_SINGLE_ID, Chunk::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_CHANGE_MULTI_ID, BlockChangeMulti::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_CHANGE_SINGLE_ID, BlockChangeSingle::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_ACTION_ID, BlockAction::new);
//		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_EXPLOSION_ID, Explosion::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_EVENT_ID, WorldEvent::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_GAME_STATE_CHANGE_ID, GameStateChange::new);
//		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SPAWN_WEATHER_ID, SpawnGlobal::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_OPEN_ID, InventoryOpen::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_CLOSE_ID, InventoryClose::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_SET_SLOT_ID, InventorySetSlot::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_SET_ITEMS_ID, InventorySetItems::new);
//		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_DATA_ID, InventoryData::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WINDOW_TRANSACTION_ID, InventoryConfirmTransaction::new);
//		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_MAP_ID, Map::new);
//		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UPDATE_TILE_ID, BlockTileUpdate::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_KICK_DISCONNECT_ID, KickDisconnect::new);
//		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SET_PASSENGERS_ID, VehiclePassengers::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CHUNK_UNLOAD_ID, UnloadChunk::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_EFFECT_ADD_ID, NoopEntityEffectAdd::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_EFFECT_REMOVE_ID, NoopEntityEffectRemove::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BLOCK_BREAK_ANIMATION_ID, NoopBlockBreakAnimation::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_HEAD_ROTATION_ID, NoopEntityHeadRotation::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_PLAYER_INFO_ID, NoopPlayerListSetEntry::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_TAB_COMPLETE_ID, NoopTabComplete::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_SOUND_ID, NoopWorldSound::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_CUSTOM_SOUND_ID, NoopWorldCustomSound::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_EXPERIENCE_ID, NoopSetExperience::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_LEASH_ID, NoopEntityLeash::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_HELD_SLOT_ID, NoopHeldSlot::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ABILITIES_ID, NoopPlayerAbilities::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CUSTOM_PAYLOAD_ID, NoopCustomPayload::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SERVER_DIFFICULTY_ID, NoopServerDifficulty::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_COMBAT_EVENT_ID, NoopCombatEvent::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_BORDER_ID, NoopWorldBorder::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_TITLE_ID, NoopTitle::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_PLAYER_LIST_HEADER_FOOTER_ID, NoopPlayerListHeaderFooter::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CAMERA_ID, NoopCamera::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SET_COOLDOWN_ID, NoopSetCooldown::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_BOSS_BAR_ID, NoopBossBar::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_VEHICLE_MOVE_ID, NoopVehicleMove::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_STATISTICS_ID, NoopStatistics::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_RESOURCE_PACK_ID, NoopResourcePack::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SIGN_EDITOR_ID, NoopBlockOpenSignEditor::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ENTITY_ATTRIBUTES_ID, NoopEntitySetAttributes::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_WORLD_PARTICLES_ID, NoopWorldParticle::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SCOREBOARD_DISPLAY_SLOT_ID, NoopScoreboardDisplay::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SCOREBOARD_SCORE_ID, NoopScoreboardScore::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SCOREBOARD_OBJECTIVE_ID, NoopScoreboardObjective::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_SCOREBOARD_TEAM_ID, NoopScoreboardTeam::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_UNLOCK_RECIPES, NoopUnlockRecipes::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ADVANCEMENTS, NoopAdvancements::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_ADVANCEMENTS_TAB, NoopAdvanementsTab::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_CRAFT_RECIPE_CONFIRM, NoopCraftRecipeConfirm::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_DECLARE_COMMANDS, NoopDeclareCommands::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_DECLARE_RECIPES, NoopDeclareRecipes::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_DECLARE_TAGS, NoopDeclareTags::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_STOP_SOUND, NoopStopSound::new);
		registry.register(NetworkState.PLAY, ClientBoundPacket.PLAY_LOOK_AT, NoopLookAt::new);
	}

	public PacketEncoder(ConnectionImpl connection) {
		super(connection);
	}

}
