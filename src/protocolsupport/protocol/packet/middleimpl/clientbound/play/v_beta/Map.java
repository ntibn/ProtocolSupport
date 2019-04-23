package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_beta;

import org.bukkit.Material;

import protocolsupport.protocol.ConnectionImpl;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleMap;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.typeremapper.legacy.LegacyMap;
import protocolsupport.protocol.typeremapper.legacy.LegacyMap.ColumnEntry;
import protocolsupport.protocol.typeremapper.mapcolor.MapColorRemapper;
import protocolsupport.protocol.typeremapper.utils.RemappingTable.ArrayBasedIdRemappingTable;
import protocolsupport.utils.recyclable.RecyclableArrayList;
import protocolsupport.utils.recyclable.RecyclableCollection;

public class Map extends MiddleMap {

	public Map(ConnectionImpl connection) {
		super(connection);
	}

	@SuppressWarnings("deprecation")
	protected static final int mapId = Material.LEGACY_MAP.getId();

	@Override
	public RecyclableCollection<ClientBoundPacketData> toData() {
		RecyclableCollection<ClientBoundPacketData> datas = RecyclableArrayList.create();
		if (icons.length > 0) {
			ClientBoundPacketData iconsdata = ClientBoundPacketData.create(ClientBoundPacket.PLAY_MAP_ID);
			iconsdata.writeShort(mapId);
			iconsdata.writeShort(itemData);
			iconsdata.writeByte((icons.length * 3) + 1);
			iconsdata.writeByte(1);
			for (Icon icon : icons) {
				iconsdata.writeByte((icon.direction << 4) | (icon.type <= 4 ? icon.type : 0));
				iconsdata.writeByte(icon.x);
				iconsdata.writeByte(icon.z);
			}
			datas.add(iconsdata);
		}
		if (columns > 0) {
			LegacyMap maptransformer = new LegacyMap();
			maptransformer.loadFromNewMapData(columns, rows, xstart, zstart, colors);
			ArrayBasedIdRemappingTable colorRemapper = MapColorRemapper.REMAPPER.getTable(version);
			for (ColumnEntry entry : maptransformer.toPre18MapData()) {
				ClientBoundPacketData mapdata = ClientBoundPacketData.create(ClientBoundPacket.PLAY_MAP_ID);
				mapdata.writeShort(mapId);
				mapdata.writeShort(itemData);
				mapdata.writeByte(3 + entry.getColors().length);
				mapdata.writeByte(0);
				mapdata.writeByte(entry.getX());
				mapdata.writeByte(entry.getY());
				byte[] colors = entry.getColors();
				for (int i = 0; i < colors.length; i++) {
					colors[i] = (byte) colorRemapper.getRemap(colors[i] & 0xFF);
				}
				mapdata.writeBytes(colors);
				datas.add(mapdata);
			}
		}
		return datas;
	}

}
