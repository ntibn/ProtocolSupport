package protocolsupport.protocol.utils.networkentity;

public class NetworkEntityDataCacheFactory {

	public static NetworkEntityDataCache create(NetworkEntityType type) {
		switch (type) {
			case ITEM: {
				return new NetworkEntityItemDataCache();
			}
			default: {
				return new NetworkEntityDataCache();
			}
		}
	}

}
